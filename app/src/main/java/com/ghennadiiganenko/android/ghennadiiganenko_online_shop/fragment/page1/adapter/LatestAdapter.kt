package com.ghennadiiganenko.android.ghennadiiganenko_online_shop.fragment.page1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.R
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.databinding.ItemLatestBinding
import com.ghennadiiganenko.android.ghennadiiganenko_online_shop.domain.network.model.LatestEntity
import com.squareup.picasso.Picasso

class LatestAdapter(
    private val clickListener: ItemClickListener,
    private val context: Context,
    private val view: View,
) : ListAdapter<LatestEntity, RecyclerView.ViewHolder>(ItemsDiffCallback()) {

    private class ItemsDiffCallback : DiffUtil.ItemCallback<LatestEntity>() {
        override fun areItemsTheSame(
            oldItem: LatestEntity,
            newItem: LatestEntity
        ): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(
            oldItem: LatestEntity,
            newItem: LatestEntity
        ): Boolean =
            oldItem == newItem
    }

    inner class LatestViewHolder(private val binding: ItemLatestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LatestEntity) {
            binding.apply {

                root.setOnClickListener {
                    it.isClickable = false
                    it.postDelayed({ it.isClickable = true }, 1000)
                    clickListener.onItemClicked(item, view)
                }

                Picasso
                    .get()
                    .load(item.image_url)
                    .into(ivLatestImage)

                tvCategory.text = item.category
                tvName.text = item.name
                tvPrice.text = context.getString(R.string.price, item.price)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestAdapter.LatestViewHolder =
        LatestViewHolder(
            ItemLatestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val packHolder = holder as LatestAdapter.LatestViewHolder
        packHolder.bind(item)
    }

    interface ItemClickListener {
        fun onItemClicked(item: LatestEntity, view: View)
    }
}