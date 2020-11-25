package com.myanmaritc.newsapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myanmaritc.newsapi.api.ApiClient
import com.myanmaritc.newsapi.model.ArticlesItem
import com.myanmaritc.newsapi.model.News
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private var news: MutableLiveData<News> = MutableLiveData()

    fun getArticle(): MutableLiveData<News> = news

    fun loadArticle(keyword : String) {

        var apiClient = ApiClient()

        var apiCall = apiClient.getEverything(keyword)

        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Error>>>>>" , t.toString())
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                 news.value = response.body()
            }

        })
    }

}