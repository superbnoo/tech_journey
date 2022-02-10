package com.example.daggerbyexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggerbyexample.di.GithubServiceInterface
import com.example.daggerbyexample.model.RecyclerList
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragmentViewModel @Inject constructor(): ViewModel() {
    @Inject
    lateinit var mService: GithubServiceInterface

    private var liveDataList: MutableLiveData<RecyclerList> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<RecyclerList> {
        return liveDataList
    }

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
}
