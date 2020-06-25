package com.mvistudy.ui.auth

import android.os.Bundle
import com.mvistudy.R
import com.mvistudy.ui.BaseActivity

/**
 * @author udit roy
 */

class AuthActivity : BaseActivity() {
    override fun displayProgressBar(bool: Boolean) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
