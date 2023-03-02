package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.R
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentProfileBinding
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.profile.viewmodel.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import kotlin.properties.Delegates


class ProfileFragment : Fragment() {
    private var binding: FragmentProfileBinding by Delegates.notNull()
    private val viewModel by viewModel<ProfileViewModel>()
    private val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.apply {

            viewModel.user.observe(viewLifecycleOwner) { result ->
                Glide
                    .with(this@ProfileFragment)
                    .load(result.picture)
                    .centerCrop()
                    .placeholder(R.drawable.user_placeholder_photo)
                    .into(ivUserPhoto)
            }

            viewModel.getUser(args.firstName)


            // Registers a photo picker activity launcher in single-select mode.
            val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                if (uri != null) {
                    Timber.tag("PhotoPicker").d("Selected URI: $uri")
                    // Loading profile photo into ImageView
                    Glide
                        .with(this@ProfileFragment)
                        .load(uri)
                        .centerCrop()
                        .placeholder(R.drawable.user_placeholder_photo)
                        .into(ivUserPhoto)
                    viewModel.updatePicture(uri.toString(), args.firstName)
                } else {
                    Timber.tag("PhotoPicker").d("No media selected")
                }
            }

            ivBack.setOnClickListener{
                activity?.onBackPressedDispatcher?.onBackPressed()
            }

            llLogOut.setOnClickListener{
                actionToSignInFragment()
            }

            bnvMenu.setOnItemSelectedListener{
                when(it.itemId) {
                    R.id.action_home -> {
                        activity?.onBackPressedDispatcher?.onBackPressed()
                    }
                }

                return@setOnItemSelectedListener true
            }

            tvChangePhoto.setOnClickListener {
                // Launch the photo picker and allow the user to choose only images.
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.bnvMenu.selectedItemId = R.id.action_profile
    }

    private fun actionToSignInFragment() {
        val action = ProfileFragmentDirections.actionProfileFragmentToSignInFragment()

        findNavController().navigate(action)
    }
}