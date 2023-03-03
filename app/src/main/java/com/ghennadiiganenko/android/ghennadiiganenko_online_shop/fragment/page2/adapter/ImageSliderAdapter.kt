package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.ItemImageDetailsBinding
import com.smarteist.autoimageslider.SliderViewAdapter


class ImageSliderAdapter(
    private val view: View
    ) : SliderViewAdapter<ImageSliderAdapter.SliderAdapterViewHolder>() {

    private var _mSliderItems: MutableList<String>  = mutableListOf()

    fun renewItems(sliderItems: MutableList<String>) {
        _mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        _mSliderItems.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: String) {
        _mSliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    inner class SliderAdapterViewHolder(private val binding: ItemImageDetailsBinding) :
        SliderViewAdapter.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.apply {
                Glide
                    .with(view)
                    .load(item)
                    .into(ivProductImages)
            }
        }
    }

    override fun getCount(): Int {
        return _mSliderItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ImageSliderAdapter.SliderAdapterViewHolder =
        SliderAdapterViewHolder(
            ItemImageDetailsBinding.inflate(
                LayoutInflater.from(parent?.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(viewHolder: SliderAdapterViewHolder?, position: Int) {
        val item = _mSliderItems[position]
        val packHolder = viewHolder as ImageSliderAdapter.SliderAdapterViewHolder
        packHolder.bind(item)

        viewHolder.itemView.setOnClickListener {

        }
    }
}