package com.tariqul.friendsdemoproject.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tariqul.friendsdemoproject.databinding.GridItemBinding
import com.tariqul.friendsdemoproject.data.model.UsersDataModel
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject


@FragmentScoped
class UsersListAdapter @Inject constructor(val clickListener: ClickListener) :
    ListAdapter<UsersDataModel, UsersListAdapter.ViewHolder>(UsersListDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: GridItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UsersDataModel, clickListener: ClickListener) {
            binding.userData = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GridItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class UsersListDiffCallback : DiffUtil.ItemCallback<UsersDataModel>() {

    override fun areItemsTheSame(oldItem: UsersDataModel, newItem: UsersDataModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: UsersDataModel, newItem: UsersDataModel): Boolean {
        return oldItem == newItem
    }

}
//
class ClickListener @Inject constructor() {

    var onItemClick: ((UsersDataModel) -> Unit)? = null

    fun onClick(data: UsersDataModel) {
        onItemClick?.invoke(data)
    }
}