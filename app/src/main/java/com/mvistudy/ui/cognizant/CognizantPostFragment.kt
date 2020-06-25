package com.mvistudy.ui.cognizant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.mvistudy.R
import com.mvistudy.ui.cognizant.state.CognizantStateEvent

class CognizantPostFragment : BaseCognizantFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cognizant_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        subscribeObserver()
        executeSearch()
    }

    private fun executeSearch() {
        viewModel.setQuery("")
        viewModel.setStateEvent(CognizantStateEvent.CognizantSearchEvent())
    }

    private fun subscribeObserver() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            stateChangeListener.onDataStateChange(dataState)
            dataState.data?.let {
                it.data?.let {
                    it.getContentIfNotHandled()?.let {
                        Log.d(TAG, "BlogFragment, DataState: ${it}")
                        viewModel.setCognizantPostList(it.cognizantFelds.cognizantPostList)
                    }
                }
            }
        })

        viewModel.viewState.observe(viewLifecycleOwner, Observer { viewState ->
            Log.d(TAG, "BlogFragment, ViewState: ${viewState}")

        })
    }


}