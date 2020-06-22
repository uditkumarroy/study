package com.mvistudy.ui

import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {
    val TAG: String = "Activity Tag"
}