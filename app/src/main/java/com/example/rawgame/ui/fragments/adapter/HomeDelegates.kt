package com.example.rawgame.ui.fragments.adapter

import com.example.rawgame.databinding.*
import com.example.rawgame.model.GameThinItem
import com.example.rawgame.model.GameWideItem
import com.example.rawgame.model.GamesHorizontalItem
import com.example.rawgame.model.base.ListItem
import com.example.rawgame.model.progress.ProgressThinItem
import com.example.rawgame.model.progress.ProgressWideItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

/**
 * @author : Mingaleev D
 * @data : 25/10/2022
 */

object HomeDelegates {

   val gamesHorizontalDelegate =
      adapterDelegateViewBinding<GamesHorizontalItem, ListItem, ItemGamesHorizontalBinding>({ layoutInflater, root ->
         ItemGamesHorizontalBinding.inflate(layoutInflater, root, false)
      }) {

         binding.recyclerView.adapter = ListDelegationAdapter(
            wideGameDelegate,
            thinGameDelegate,
            wideProgressDelegate,
            thinProgressDelegate
         )

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

   private val wideProgressDelegate =
      adapterDelegateViewBinding<ProgressWideItem, ListItem, ItemProgressWideBinding>({ layoutInflater, root ->
         ItemProgressWideBinding.inflate(layoutInflater, root, false)
      }) { }

   private val thinProgressDelegate =
      adapterDelegateViewBinding<ProgressThinItem, ListItem, ItemProgressThinBinding>({ layoutInflater, root ->
         ItemProgressThinBinding.inflate(layoutInflater, root, false)
      }) { }

}