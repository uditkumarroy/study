package com.mvistudy.ui.cognizant

import com.mvistudy.ui.DataState

interface DataStateChangeListener {

    fun onDataStateChange(dataState: DataState<*>?)

}