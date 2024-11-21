package com.mogun.todo

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.mogun.todo.databinding.ItemContentBinding
import com.mogun.todo.model.ContentEntity

class ListAdapter: androidx.recyclerview.widget.ListAdapter<ContentEntity, ContentViewHolder>(diffUtil) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContentViewHolder {
        return ContentViewHolder(
            ItemContentBinding.inflate(
                android.view.LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<ContentEntity>() {
            override fun areItemsTheSame(
                oldItem: ContentEntity,
                newItem: ContentEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ContentEntity,
                newItem: ContentEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}