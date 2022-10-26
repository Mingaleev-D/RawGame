package com.example.rawgame.ui.fragments.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.rawgame.model.base.ListItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

/**
 * @author : Mingaleev D
 * @data : 26/10/2022
 */

open class BaseDiffUtilItemCallback : DiffUtil.ItemCallback<ListItem>() {
   override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
      oldItem.itemId == newItem.itemId

   override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean =
      oldItem.equals(newItem)
}


