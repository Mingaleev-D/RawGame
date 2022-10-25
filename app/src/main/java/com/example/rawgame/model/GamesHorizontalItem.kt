package com.example.rawgame.model

import com.example.rawgame.ui.fragments.adapter.ListItem

data class GamesHorizontalItem(
   val title: String,
   val games: List<ListItem>
) : ListItem
