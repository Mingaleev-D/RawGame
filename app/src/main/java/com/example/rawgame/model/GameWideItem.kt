package com.example.rawgame.model

import com.example.rawgame.model.base.ListItem

data class GameWideItem(
   val id: Long,
   val title: String,
   val image : String
) : ListItem {
   override val itemId: Long = id
}
