package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.sign

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentSignInBinding
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.db.model.User
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.sign.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates

class SignInFragment : Fragment() {
    private var binding: FragmentSignInBinding by Delegates.notNull()

    private val viewModel by viewModel<SignInViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.apply {

            //Observer for checkUser
            viewModel.isRegistered.observe(viewLifecycleOwner) { result ->
                if(result == true) {
                    tvAlreadyRegisteredWarning.visibility = View.VISIBLE
                } else {
                    //Adding user and then moving to Page1Fragment
                    viewModel.addUser(
                        User(
                            email = etEmail.text.toString(),
                            firstName = etFirstName.text.toString(),
                            lastName = etLastName.text.toString(),
                        )
                    )

                    actionToPage1Fragment(etFirstName.text.toString())
                }
            }

            btnSignIn.setOnClickListener {
                //Check for correct input
                tvEmptyFieldWarning.visibility = View.GONE
                tvAlreadyRegisteredWarning.visibility = View.GONE


                if (etEmail.text == null || etFirstName.text == null || etLastName.text == null) {
                    tvEmptyFieldWarning.visibility = View.VISIBLE
                    return@setOnClickListener
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.text.toString()).matches()) {
                    tvEmptyFieldWarning.visibility = View.VISIBLE
                    return@setOnClickListener
                }

                //Check if email already registered
                viewModel.checkUser(
                    User(
                    firstName = etFirstName.text.toString(),
                    lastName = etLastName.text.toString(),
                    email = etEmail.text.toString()
                )
                )
            }

            tvLogIn.setOnClickListener {
                actionToLoginFragment()
            }
        }

        return binding.root
    }

    private fun actionToLoginFragment() {
        val action = SignInFragmentDirections.actionSignInFragmentToLoginFragment()

        findNavController().navigate(action)
    }

    private fun actionToPage1Fragment(firstName: String) {
        val action = SignInFragmentDirections.actionSignInFragmentToPage1Fragment(firstName = firstName)

        findNavController().navigate(action)
    }
}