package com.example.rawgame.ui.fragments.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.rawgame.model.base.ListItem
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

/**
 * @author : Mingaleev D
 * @data : 26/10/2022
 */

class GameCardsAdapter : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()) {
   init {
      delegatesManager
         .addDelegate(HomeDelegates.wideGameDelegate)
         .addDelegate(HomeDelegates.thinGameDelegate)
         .addDelegate(HomeDelegates.wideProgressDelegate)
         .addDelegate(HomeDelegates.thinProgressDelegate)
   }
}

