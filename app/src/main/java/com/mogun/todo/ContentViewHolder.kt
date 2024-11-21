package com.mogun.todo

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.mogun.todo.databinding.ItemContentBinding
import com.mogun.todo.model.ContentEntity

class ContentViewHolder (
    private val binding: ItemContentBinding,
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ContentEntity) {
        binding.item = item

        binding.contentCheckBox.paintFlags = if (item.isDone) {
            binding.contentCheckBox.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            0
        }
    }
}