package com.example.rawgame.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.rawgame.R
import com.example.rawgame.databinding.FragmentHomeBinding
import com.example.rawgame.model.GameThinItem
import com.example.rawgame.model.GameWideItem
import com.example.rawgame.model.GamesHorizontalItem
import com.example.rawgame.ui.fragments.adapter.HomeAdapter
import com.example.rawgame.ui.fragments.adapter.HomeDelegates
import com.example.rawgame.ui.fragments.viewmodel.HomeViewModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

/**
 * @author : Mingaleev D
 * @data : 25/10/2022
 */

class HomeFragment : Fragment(R.layout.fragment_home) {

   private var mBinding: FragmentHomeBinding? = null
   private val binding get() = mBinding!!

   private val viewModel by viewModels<HomeViewModel>()

   private val adapter = HomeAdapter()

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

         viewModel.data.observe(viewLifecycleOwner) {
            adapter.items = it
         }
      }
   }

   override fun onDestroy() {
      super.onDestroy()
      mBinding = null
   }

}
