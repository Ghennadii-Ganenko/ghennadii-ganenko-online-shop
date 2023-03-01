package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.R
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.ItemFlashSaleBinding
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.FlashSaleEntity
import com.squareup.picasso.Picasso

class FlashSaleAdapter(
    private val clickListener: ItemClickListener,
    private val context: Context,
    private val view: View,
) : ListAdapter<FlashSaleEntity, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    private class ItemsDiffCallback : DiffUtil.ItemCallback<FlashSaleEntity>() {
        override fun areItemsTheSame(
            oldItem: FlashSaleEntity,
            newItem: FlashSaleEntity
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: FlashSaleEntity,
            newItem: FlashSaleEntity
        ): Boolean =
            oldItem == newItem
    }

    inner class FlashSaleViewHolder(private val binding: ItemFlashSaleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FlashSaleEntity) {
            binding.apply {

                root.setOnClickListener {
                    it.isClickable = false
                    it.postDelayed({ it.isClickable = true }, 1000)
                    clickListener.onItemClicked(item, view)
                }

                Picasso
                    .get()
                    .load(item.image_url)
                    .into(ivFlashSaleImage)

                tvCategory.text = item.category
                tvName.text = item.name
                tvPrice.text = context.getString(R.string.price_double, item.price)
                tvDiscount.text = context.getString(R.string.discount, item.discount)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleAdapter.FlashSaleViewHolder =
        FlashSaleViewHolder(
            ItemFlashSaleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val packHolder = holder as FlashSaleAdapter.FlashSaleViewHolder
        packHolder.bind(item)
    }

    interface ItemClickListener {
        fun onItemClicked(item: FlashSaleEntity, view: View)
    }
}