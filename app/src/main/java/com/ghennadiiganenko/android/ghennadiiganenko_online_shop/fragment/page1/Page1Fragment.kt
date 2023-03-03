package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.R
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentPage1Binding
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.FlashSaleEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.LatestEntity
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1.adapter.FlashSaleAdapter
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1.adapter.LatestAdapter
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1.viewmodel.Page1ViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates

class Page1Fragment : Fragment(), LatestAdapter.ItemClickListener, FlashSaleAdapter.ItemClickListener {
    private var binding: FragmentPage1Binding by Delegates.notNull()
    private val viewModel by viewModel<Page1ViewModel>()
    private val args: Page1FragmentArgs by navArgs()
    private lateinit var latestAdapter: LatestAdapter
    private lateinit var flashSaleAdapter: FlashSaleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage1Binding.inflate(inflater, container, false)

        binding.apply {
            bnvMenu.setOnItemSelectedListener{
                when(it.itemId) {
                    R.id.action_profile -> {
                        actionToProfileFragment(args.firstName)
                    }
                }
                return@setOnItemSelectedListener true
            }

            viewModel.user.observe(viewLifecycleOwner) { result ->
                Glide
                    .with(this@Page1Fragment)
                    .load(result.picture)
                    .centerCrop()
                    .placeholder(R.drawable.user_placeholder_photo)
                    .into(ivUserPhoto)
            }

            viewModel.getUser(args.firstName)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        latestAdapter = LatestAdapter(this, requireContext(), view)
        binding.rvLatest.adapter = latestAdapter

        flashSaleAdapter = FlashSaleAdapter(this, requireContext(), view)
        binding.rvFlashSale.adapter = flashSaleAdapter

        viewModel.productsLists.observe(viewLifecycleOwner) { result ->
            if (result.first != null && result.second != null) {
                latestAdapter.submitList(result.first?.latest)
                flashSaleAdapter.submitList(result.second?.flash_sale)
            }
        }

        viewModel.getLatestList()
        viewModel.getFlashSaleList()
    }

    override fun onResume() {
        super.onResume()

        binding.bnvMenu.selectedItemId = R.id.action_home
    }

    override fun onItemClicked(item: LatestEntity, view: View) {}

    override fun onItemClicked(item: FlashSaleEntity, view: View) {
        actionToPage2Fragment(args.firstName)
    }

    private fun actionToProfileFragment(firstName: String) {
        val action = Page1FragmentDirections.actionPage1FragmentToProfileFragment(firstName = firstName)

        findNavController().navigate(action)
    }

    private fun actionToPage2Fragment(firstName: String) {
        val action = Page1FragmentDirections.actionPage1FragmentToPage2Fragment(firstName = firstName)

        findNavController().navigate(action)
    }
}