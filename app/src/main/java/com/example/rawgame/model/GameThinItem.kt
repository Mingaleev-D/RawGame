package com.example.rawgame.model

import com.example.rawgame.model.base.ListItem


data class GameThinItem(
   val id: Long,
   val title: String
) : ListItem {
   override val itemId: Long
      get() = id
}
