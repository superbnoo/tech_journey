package com.zuh.theapp

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zuh.central.datasource.ResourceState
import com.zuh.central.datasource.api.GithubServiceInterface
import com.zuh.central.datasource.model.RecyclerList
import com.zuh.theapp.repository.GithubRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragmentViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var mService: GithubServiceInterface

    @Inject
    lateinit var githubRepository: GithubRepository

    private var liveDataList: MutableLiveData<RecyclerList> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<RecyclerList> {
        return liveDataList
    }

    /** API call to get Education Content for user*/
    private val _githubListResponse: MutableLiveData<ResourceState<RecyclerList>> = MutableLiveData()
    val githubListResponse: LiveData<ResourceState<RecyclerList>> = _githubListResponse

    fun makeApiCall() {
        val call: Call<RecyclerList>?  = mService.getDataFromAPI("atl")
        call?.enqueue(object : Callback<RecyclerList> {
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if(response.isSuccessful) {
                    liveDataList.postValue(response.body())
                } else {
                    liveDataList.postValue(null)
                }
            }
        })
    }

    fun getGithubRepos(query: String) {
//        if (!CoreUtility.isInternetConnected(context)) {
//            noInternet.value = true
//        } else {
           //noInternet.value = false
//            if (CoreUtility.checkNetworkAndToast(context)) {
//                loadingVisibility.value = View.VISIBLE
//                viewModelScope.launch {
//                    githubRepository.getGithubRepos(query).collect {
//                        //_dogFunFactsResponse.value = it
//                        _githubListResponse.value = it
//                    }
//                }
//            }
        //}
        viewModelScope.launch {
            githubRepository.getGithubRepos(query).collect {
                _githubListResponse.value = it
            }
        }
    }
}
