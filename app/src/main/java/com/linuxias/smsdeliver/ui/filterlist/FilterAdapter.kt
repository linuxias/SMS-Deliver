package com.linuxias.smsdeliver.ui.filterlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.linuxias.smsdeliver.R
import com.linuxias.smsdeliver.data.FilterEntity

class FilterAdapter: ListAdapter<FilterEntity, FilterAdapter.FilterViewHolder>(FilterDiffCallback) {

    class FilterViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val receiverTextView: TextView = itemView.findViewById(R.id.number_text)
        private val filterTextView: TextView = itemView.findViewById(R.id.filter_text)
        private var currentFilter: FilterEntity? = null

        fun bind(filter: FilterEntity) {
            currentFilter = filter

            receiverTextView.text = filter.receiverNumber
            filterTextView.text = filter.filterRegex
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.filter_item, parent, false)
        return FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object FilterDiffCallback : DiffUtil.ItemCallback<FilterEntity>() {
    override fun areItemsTheSame(oldItem: FilterEntity, newItem: FilterEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FilterEntity, newItem: FilterEntity): Boolean {
        return oldItem.id == newItem.id
    }
}