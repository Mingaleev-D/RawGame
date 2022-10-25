package com.example.rawgame.ui.fragments.adapter

import com.example.rawgame.databinding.ItemGameThinBinding
import com.example.rawgame.databinding.ItemGameWideBinding
import com.example.rawgame.databinding.ItemGamesHorizontalBinding
import com.example.rawgame.model.GameThinItem
import com.example.rawgame.model.GameWideItem
import com.example.rawgame.model.GamesHorizontalItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

/**
 * @author : Mingaleev D
 * @data : 25/10/2022
 */

object HomeDelegates {

   val gamesHorizontalDelegate =
      adapterDelegateViewBinding<GamesHorizontalItem, ListItem, ItemGamesHorizontalBinding>({ layoutInflater, root ->
         ItemGamesHorizontalBinding.inflate(layoutInflater, root, false).apply {
            recyclerView.adapter = ListDelegationAdapter(
               wideGameDelegate,
               thinGameDelegate
            )
         }
      }) {
         bind {
            binding.titleTextView.text = item.title
            (binding.recyclerView.adapter as ListDelegationAdapter<List<ListItem>>).apply {
               items = item.games
               notifyDataSetChanged()
            }
         }
      }

   private val wideGameDelegate =
      adapterDelegateViewBinding<GameWideItem, ListItem, ItemGameWideBinding>({ layoutInflater, root ->
         ItemGameWideBinding.inflate(layoutInflater, root, false)
      }) {
         bind {
            binding.imageView.setBackgroundColor(item.hashCode())
            binding.title = item.title
            binding.executePendingBindings()
         }
      }
   private val thinGameDelegate =
      adapterDelegateViewBinding<GameThinItem, ListItem, ItemGameThinBinding>({ layoutInflater, root ->
         ItemGameThinBinding.inflate(layoutInflater, root, false)
      }) {
         bind {
            binding.imageView.setBackgroundColor(item.hashCode())
            binding.title = item.title
            binding.executePendingBindings()
         }
      }

}