package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.R
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.FragmentPage2Binding
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page2.adapter.ImageSliderAdapter
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page2.viewmodel.Page2ViewModel
import com.smarteist.autoimageslider.SliderView
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.properties.Delegates


class Page2Fragment : Fragment() {
    private var binding: FragmentPage2Binding by Delegates.notNull()
    private val viewModel by viewModel<Page2ViewModel>()
    private val args: Page2FragmentArgs by navArgs()
    private lateinit var imageSliderAdapter: ImageSliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPage2Binding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageSliderAdapter = ImageSliderAdapter(view)

        binding.apply {

            svImages.setSliderAdapter(imageSliderAdapter)

            bnvMenu.setOnItemSelectedListener{
                when(it.itemId) {
                    R.id.action_profile -> {
                        actionToProfileFragment(args.firstName)
                    }

                    R.id.action_home -> {
                        activity?.onBackPressedDispatcher?.onBackPressed()
                    }
                }
                return@setOnItemSelectedListener true
            }

            ivBack.setOnClickListener {
                activity?.onBackPressedDispatcher?.onBackPressed()
            }

            viewModel.details.observe(viewLifecycleOwner) { result ->
                imageSliderAdapter.renewItems(result.image_urls as MutableList<String>)

                tvProductName.text = result.name
                tvPrice.text = context?.resources?.getString(R.string.price, result.price)
                tvDescription.text = result.description
                tvRating.text = result.rating.toString()
                tvReviews.text = context?.resources?.getString(R.string.reviews, result.number_of_reviews)

                Picasso
                    .get()
                    .load(result.image_urls[0])
                    .into(ivFirstImage)

                Picasso
                    .get()
                    .load(result.image_urls[1])
                    .into(ivSecondImage)

                Picasso
                    .get()
                    .load(result.image_urls[2])
                    .into(ivThirdImage)

                rbFirstColor.background.setTint(Color.parseColor(result.colors[0]))
                rbSecondColor.background.setTint(Color.parseColor(result.colors[1]))
                rbThirdColor.background.setTint(Color.parseColor(result.colors[2]))
            }

            ivFirstImage.setOnClickListener {
                scrollOnClick(svImages, 0)
            }

            ivSecondImage.setOnClickListener {
                scrollOnClick(svImages, 1)
            }

            ivThirdImage.setOnClickListener {
                scrollOnClick(svImages, 2)
            }
        }

        viewModel.getDetails()
    }

    private fun actionToProfileFragment(firstName: String) {
        val action = Page2FragmentDirections.actionPage2FragmentToProfileFragment(firstName = firstName)

        findNavController().navigate(action)
    }

    private fun scrollOnClick(sliderView: SliderView, imageNumber: Int) {

        while (sliderView.currentPagePosition != imageNumber) {
            when(sliderView.currentPagePosition) {
                imageNumber + 2 -> {
                    sliderView.slideToNextPosition()
                }
                imageNumber + 1 -> {
                    sliderView.slideToPreviousPosition()
                }
                imageNumber - 1 -> {
                    sliderView.slideToNextPosition()
                }
                imageNumber - 2 -> {
                    sliderView.slideToPreviousPosition()
                }
            }
        }
    }
}