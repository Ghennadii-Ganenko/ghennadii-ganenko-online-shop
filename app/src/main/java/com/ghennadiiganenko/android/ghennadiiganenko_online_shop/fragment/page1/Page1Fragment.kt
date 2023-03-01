package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
                        actionToProfileFragment()
                    }
                }
                return@setOnItemSelectedListener true
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        latestAdapter = LatestAdapter(this, requireContext(), view)
        binding.rvLatest.adapter = latestAdapter

        flashSaleAdapter = FlashSaleAdapter(this, requireContext(), view)
        binding.rvFlashSale.adapter = flashSaleAdapter

        viewModel.latestList.observe(viewLifecycleOwner) { result ->
            latestAdapter.submitList(result.latest)
        }

        viewModel.flashSaleList.observe(viewLifecycleOwner) { result ->
            flashSaleAdapter.submitList(result.flash_sale)
        }

        viewModel.getLatestList()
        viewModel.getFlashSaleList()
    }

    override fun onResume() {
        super.onResume()

        binding.bnvMenu.selectedItemId = R.id.action_home
    }

    private fun actionToProfileFragment() {
        val action = Page1FragmentDirections.actionPage1FragmentToProfileFragment()

        findNavController().navigate(action)
    }

    override fun onItemClicked(item: LatestEntity, view: View) {

    }

    override fun onItemClicked(item: FlashSaleEntity, view: View) {

    }
}