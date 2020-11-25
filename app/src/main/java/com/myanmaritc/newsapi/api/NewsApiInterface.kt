package com.myanmaritc.newsapi.api

import com.myanmaritc.newsapi.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("everything")
    fun getEverything(
        @Query("q")keyword : String,
        @Query("apiKey") apiKey : String
    ) : Call<News>
}