package com.myanmaritc.newsapi.api

import com.myanmaritc.newsapi.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {

    private val BASE_URL = "http://newsapi.org/v2/"

    val apiInterface: NewsApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(NewsApiInterface::class.java)
    }

    fun getEverything(keyword : String) : Call<News> {
        return apiInterface.getEverything(
            keyword,
            "2a28bf068eb042d58913c32c0da7cd28"
        )
    }
}