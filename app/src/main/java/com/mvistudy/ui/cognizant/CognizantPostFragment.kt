package com.mvistudy.ui.cognizant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.mvistudy.R
import com.mvistudy.models.CognizantPost
import com.mvistudy.ui.cognizant.state.CognizantStateEvent
import kotlinx.android.synthetic.main.fragment_cognizant_post.*
import javax.inject.Inject

class CognizantPostFragment : BaseCognizantFragment(), CognizantListAdapter.Interaction {

    @Inject
    lateinit var requestManager: RequestManager

    private lateinit var recyclerAdapter: CognizantListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cognizant_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        subscribeObserver()
        swipe_refresh.setOnRefreshListener {   executeSearch()}

    }

    private fun executeSearch() {
        viewModel.setQuery("")
        viewModel.setStateEvent(CognizantStateEvent.CognizantSearchEvent())
    }

    private fun subscribeObserver() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            swipe_refresh.isRefreshing = false
            stateChangeListener.onDataStateChange(dataState)
            dataState.data?.let {
                it.data?.let {
                    it.getContentIfNotHandled()?.let {
                        Log.d(TAG, "CogziFragment, DataState: ${it}")
                        viewModel.setCognizantPostList(it.cognizantFelds.cognizantPostList)
                    }
                }
            }
        })

        viewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            Log.d(TAG, "CogziFragment, ViewState: ${viewState}")
            swipe_refresh.isRefreshing = false
            if(viewState != null){
                recyclerAdapter.submitList(
                    blogList = viewState.cognizantFelds.cognizantPostList,
                    isQueryExhausted = true
                )
            }
        })
    }

    private fun initRecyclerView(){
        rv_post_list.apply {
            layoutManager = LinearLayoutManager(this@CognizantPostFragment.context)
            recyclerAdapter = CognizantListAdapter(requestManager,  this@CognizantPostFragment)
            addOnScrollListener(object: RecyclerView.OnScrollListener(){

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val lastPosition = layoutManager.findLastVisibleItemPosition()
                    if (lastPosition == recyclerAdapter.itemCount.minus(1)) {
                        Log.d(TAG, "CogziFragment: attempting to load next page...")
                    }
                }
            })
            adapter = recyclerAdapter
        }
    }
    override fun onItemSelected(position: Int, item: CognizantPost) {
        Log.d(TAG, "CogziFragment, Post title: ${item.title}")
    }

    override fun onDestroy() {
        super.onDestroy()
        rv_post_list.adapter = null
    }

}