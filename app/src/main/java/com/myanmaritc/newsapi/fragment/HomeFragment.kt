package com.myanmaritc.newsapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.myanmaritc.newsapi.R
import com.myanmaritc.newsapi.adapter.NewsAdapter
import com.myanmaritc.newsapi.api.ApiClient
import com.myanmaritc.newsapi.model.ArticlesItem
import com.myanmaritc.newsapi.model.News
import com.myanmaritc.newsapi.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       var homeViewModel = ViewModelProvider(this)
           .get(HomeViewModel::class.java)

        var newsAdapter = NewsAdapter()

        newsRecycler.layoutManager = LinearLayoutManager(context)
        newsRecycler.adapter = newsAdapter

        homeViewModel.loadArticle("apple")



        homeViewModel.getArticle().observe(
            viewLifecycleOwner, Observer { news ->
                newsAdapter.updateArticle((news.articles as List<ArticlesItem>))
            }
        )

        btnSubmit.setOnClickListener {
            homeViewModel.loadArticle(txtSearch.text.toString())
        }
    }


}
