package com.zuh.theapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zuh.central.datasource.ResourceState
import com.zuh.theapp.adapter.RecyclerViewAdapter
import com.zuh.theapp.di.Injectable
import com.zuh.central.datasource.model.RecyclerList
import com.zuh.theapp.FirstFragmentViewModel
import com.zuh.theapp.R
import javax.inject.Inject

class GithubFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: FirstFragmentViewModel by viewModels { viewModelFactory }

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_github, container, false).also {
            recyclerView = it.findViewById(R.id.recyclerView)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun initViewModelOld() {
        viewModel.getLiveDataObserver().observe(requireActivity(), Observer<RecyclerList> { t ->
            if(t != null) {
                recyclerViewAdapter.setUpdatedData(t.items)
                recyclerViewAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(requireActivity(), "error in getting the date", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    private fun initViewModel() {
//        viewModel.githubListResponse.observe(viewLifecycleOwner, Observer {
//            when (it) {
//                is ResourceState.Success -> {
////                    CoreUtility.printLog(TAG, "Inside_dogFunFactsResponse_success ${Gson().toJson(it)}")
////                    viewModel.loadingVisibility.value = View.GONE
//                    it.data?.also { facts->
//                        setUpDogFactsRecyclerView(facts)
//                    }
//                }
//                is ResourceState.Error -> {
//                    viewModel.loadingVisibility.value = View.GONE
//                    CoreUtility.printLog(TAG, "Inside_dogFunFactsResponse_error ${it.message}")
//                    Toast.makeText(context,it.message,Toast.LENGTH_LONG).show()
//                }
//                is ResourceState.Loading -> {
//                    // viewModel.loadingVisibility.value = View.VISIBLE
//                }
//            }
//        })
        viewModel.githubListResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResourceState.Success -> {
                    it.data?.also { t ->
                        recyclerViewAdapter.setUpdatedData(t.items)
                        recyclerViewAdapter.notifyDataSetChanged()
                    }
                }
                is ResourceState.Error -> {
                    print(it)
                }
                is ResourceState.Loading -> {
                    print(it)
                }
            }
        })
        viewModel.getGithubRepos("react")
    }
}
