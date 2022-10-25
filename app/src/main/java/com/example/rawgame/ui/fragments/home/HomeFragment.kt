package com.example.rawgame.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rawgame.R
import com.example.rawgame.databinding.FragmentHomeBinding
import com.example.rawgame.model.GameThinItem
import com.example.rawgame.model.GameWideItem
import com.example.rawgame.model.GamesHorizontalItem
import com.example.rawgame.ui.fragments.adapter.HomeDelegates
import com.example.rawgame.ui.fragments.adapter.ListItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

/**
 * @author : Mingaleev D
 * @data : 25/10/2022
 */

class HomeFragment : Fragment(R.layout.fragment_home) {

   private var mBinding: FragmentHomeBinding? = null
   private val binding get() = mBinding!!

   private val adapter = ListDelegationAdapter(
      HomeDelegates.gamesHorizontalDelegate
   )

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentHomeBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      with(binding) {
         recyclerViewHome.adapter = adapter

         adapter.apply {
            items = listOf(
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
            notifyDataSetChanged()
         }
      }
   }

   override fun onDestroy() {
      super.onDestroy()
      mBinding = null
   }

}
