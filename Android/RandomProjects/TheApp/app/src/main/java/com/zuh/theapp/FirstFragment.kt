package com.zuh.theapp

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
import com.zuh.theapp.adapter.RecyclerViewAdapter
import com.zuh.theapp.di.Injectable
import com.zuh.central.model.RecyclerList
import javax.inject.Inject

class FirstFragment : Fragment(), Injectable {
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
        return inflater.inflate(R.layout.fragment_first, container, false).also {
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

    private fun initViewModel() {
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
}
