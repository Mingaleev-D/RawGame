package com.example.rawgame.ui.fragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rawgame.di.NetworkComponent
import com.example.rawgame.model.GameThinItem
import com.example.rawgame.model.GameWideItem
import com.example.rawgame.model.GamesHorizontalItem
import com.example.rawgame.model.base.ListItem
import com.example.rawgame.model.progress.ProgressThinItem
import com.example.rawgame.model.progress.ProgressWideItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author : Mingaleev D
 * @data : 26/10/2022
 */

class HomeViewModel : ViewModel() {

   private val api = NetworkComponent.createApi()

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
      val mostAnticipatedResponse = api.getGames(
         mapOf(
            "dates" to "2019-09-01,2019-09-01",
            "ordering" to "-added"
         )
      )
      val latestReleasesResponse = api.getGames(
         mapOf("dates" to "2019-09-01,2019-09-01")
      )
      val mostRatedResponse = api.getGames(
         mapOf(
            "dates" to "2019-09-01,2019-09-01",
            "ordering" to "-rated"
         )
      )
      val mostAnticipatedItems = mostAnticipatedResponse.results.map {
         GameWideItem(
            id = it.id,
            title = it.title,
            image = it.image,
         )
      }
      val latestReleasesItems = latestReleasesResponse.results.map {
         GameThinItem(
            id = it.id,
            title = it.title,
            image = it.image,
         )
      }
      val mostRatedItems = mostRatedResponse.results.map {
         GameThinItem(
            id = it.id,
            title = it.title,
            image = it.image,
         )
      }
      return listOf(
         GamesHorizontalItem(
            title = "Wide title",
            games = mostAnticipatedItems
         ),
         GamesHorizontalItem(
            title = "Thin title",
            games = latestReleasesItems
         ),
         GamesHorizontalItem(
            title = "Wide title",
            games = mostRatedItems
         )
      )
   }


   private fun getLoaders(): List<ListItem> {
      return listOf(
         GamesHorizontalItem(
            title = "Wide title",//mostAnticipatedResponse
            games = IntRange(1, 3).map { ProgressWideItem }
         ),
         GamesHorizontalItem(
            title = "Thin title",//latest realese
            games = IntRange(1, 4).map { ProgressThinItem }
         ),
         GamesHorizontalItem(
            title = "Wide title", // most rated in ...
            games = IntRange(1, 3).map { ProgressWideItem }
         )
      )
   }

}
/*
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
 */