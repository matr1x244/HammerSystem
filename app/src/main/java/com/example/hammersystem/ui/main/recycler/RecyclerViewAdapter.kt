package com.example.hammersystem.ui.main.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystem.domain.model.data.DataFood

class RecyclerViewAdapter(private val itemClick: (DataFood) -> Unit) :
    RecyclerView.Adapter<ViewHolder>() {

    private var foodList: MutableList<DataFood> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<DataFood>) {
        foodList.clear()
        foodList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.createView(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), itemClick)
    }

    private fun getItem(position: Int): DataFood = foodList[position]

    override fun getItemCount() = foodList.size
}