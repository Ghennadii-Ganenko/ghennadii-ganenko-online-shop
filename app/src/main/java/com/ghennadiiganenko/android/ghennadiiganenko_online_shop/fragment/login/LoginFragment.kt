package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentLoginBinding
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates

class LoginFragment : Fragment() {
    private var binding: FragmentLoginBinding by Delegates.notNull()

    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.apply {

            viewModel.nameIsRegistered.observe(viewLifecycleOwner) { result ->
                if (result == true) {
                    actionToPage1Fragment()
                } else {
                    tvIncorrectDataWarning.visibility = View.VISIBLE
                }
            }

            btnLogin.setOnClickListener {
                tvIncorrectDataWarning.visibility = View.GONE

                tvEmptyFirstNameWarning.visibility = View.GONE

                if (etFirstName.text == null) {
                    tvEmptyFirstNameWarning.visibility = View.VISIBLE
                    return@setOnClickListener
                }

                viewModel.checkName(etFirstName.text.toString())

            }
        }

        return binding.root
    }

    private fun actionToPage1Fragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToPage1Fragment()

        findNavController().navigate(action)
    }
}