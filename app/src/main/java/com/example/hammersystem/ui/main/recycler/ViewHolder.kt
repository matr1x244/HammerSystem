package com.example.hammersystem.ui.main.recycler

import android.annotation.SuppressLint
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.hammersystem.R
import com.example.hammersystem.databinding.RecyclerItemListFoodBinding
import com.example.hammersystem.domain.model.data.DataFood

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = RecyclerItemListFoodBinding.bind(itemView)

    companion object {
        fun createView(parent: ViewGroup): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_list_food, parent, false)
            return ViewHolder(view)
        }
    }

    @SuppressLint("ResourceAsColor")
    fun bind(item: DataFood, listener: DataFood.() -> Unit) {
        Glide.with(binding.imageFood)
            .load(item.image)
            .transform(CircleCrop(), RoundedCorners(15))
            .into(binding.imageFood)

        binding.tittleTextview.text = item.title
        if (item.description!!.isBlank() || item.description.isEmpty()) {
            return
        } else {
            if (item.description.lastIndex > 40) {
                val tempText = item.description.substring(0..40) + "..."
                val spannableStringBuilder = SpannableStringBuilder(tempText)
                binding.descriptionTextview.text = spannableStringBuilder
            } else if (item.description != "") {
                binding.descriptionTextview.text = item.description
            }
        }
        binding.root.setOnClickListener {
            listener.invoke(item)
        }
    }

}