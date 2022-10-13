package com.example.hammersystem.ui.main.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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

    fun bind(item: DataFood, listener: DataFood.() -> Unit) {
        binding.tittleTextview.text = item.title
        binding.descriptionTextview.text = item.description
        binding.root.setOnClickListener {
            listener.invoke(item)
        }
    }

}