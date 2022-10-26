package com.example.rawgame.network.model

import com.google.gson.annotations.SerializedName

data class PagedResponse(
   @SerializedName("count")
   val count: Int,
   @SerializedName("next")
   val nexPageUrl: Int,
   @SerializedName("previous")
   val previousPageUrl: Int,
   @SerializedName("results")
   val results: List<GameDto>
)
