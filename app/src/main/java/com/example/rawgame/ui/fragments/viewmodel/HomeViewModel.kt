package com.example.rawgame.ui.fragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawgame.model.GameThinItem
import com.example.rawgame.model.GameWideItem
import com.example.rawgame.model.GamesHorizontalItem
import com.example.rawgame.model.base.ListItem
import com.example.rawgame.model.progress.ProgressThinItem
import com.example.rawgame.model.progress.ProgressWideItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author : Mingaleev D
 * @data : 26/10/2022
 */

class HomeViewModel : ViewModel() {
   private val _data = MutableLiveData<List<ListItem>>()
   val data: LiveData<List<ListItem>> = _data

   init {
      viewModelScope.launch(Dispatchers.IO) {
         _data.postValue(getLoaders())
         val items = getItems()
         _data.postValue(items)
      }
   }

   private suspend fun getItems(): List<ListItem> {
      delay(2000L)
      return listOf(
         GamesHorizontalItem(
            title = "Wide title",
            games = IntRange(1, 20).map { GameWideItem(it.toLong(), "Game title $it") }
         ),
         GamesHorizontalItem(
            title = "Thin title",
            games = IntRange(1, 20).map { GameThinItem(it.toLong(), "Game title $it") }
         ),
         GamesHorizontalItem(
            title = "Wide title",
            games = IntRange(1, 20).map { GameWideItem(it.toLong(), "Game title $it") }
         )
      )
   }


   private fun getLoaders(): List<ListItem> {
      return     listOf(
         GamesHorizontalItem(
            title = "Wide title",
            games = IntRange(1, 3).map { ProgressWideItem }
         ),
         GamesHorizontalItem(
            title = "Thin title",
            games = IntRange(1, 4).map { ProgressThinItem }
         ),
         GamesHorizontalItem(
            title = "Wide title",
            games = IntRange(1, 3).map { ProgressWideItem }
         )
      )
   }

}
