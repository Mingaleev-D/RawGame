package com.example.rawgame.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rawgame.R
import com.example.rawgame.databinding.FragmentHomeBinding

/**
 * @author : Mingaleev D
 * @data : 25/10/2022
 */

class HomeFragment : Fragment() {

   private var mBinding:FragmentHomeBinding? = null
   private val binding get() = mBinding!!

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentHomeBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
   }

   override fun onDestroy() {
      super.onDestroy()
      mBinding = null
   }

}
