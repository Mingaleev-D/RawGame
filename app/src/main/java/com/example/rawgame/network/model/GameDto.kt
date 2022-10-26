package com.example.rawgame.network.model

import com.google.gson.annotations.SerializedName

data class GameDto(
   @SerializedName("id")
   val id:Long,
   @SerializedName("name")
   val title:String,
   @SerializedName("image_background")
   val image:String,
)
