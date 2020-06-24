package com.mvistudy.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.mvistudy.R
import com.mvistudy.ui.auth.state.LoginFields
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * @author udit roy
 */
class LoginFragment : BaseAuthFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "Login fragment: ${viewModel.hashCode()}")
        subscribeObserver()
    }

    fun subscribeObserver() {
        viewModel.viewState.observe(viewLifecycleOwner, Observer {
            it.loginFields?.let { loginFields ->
                loginFields.login_email?.let { input_email.setText(it) }
                loginFields.login_password?.let { input_password.setText(it) }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "Input value: ${input_email.text}")
        viewModel.setLoginFields(
            LoginFields(
                input_email.text.toString(),
                input_password.text.toString()
            )
        )
    }

}
