package com.mvistudy.ui.cognizant.state

sealed class CognizantStateEvent {

    class CognizantSearchEvent : CognizantStateEvent()

    class None : CognizantStateEvent()
}