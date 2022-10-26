package com.example.rawgame.network.api

import com.example.rawgame.network.model.PagedResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * @author : Mingaleev D
 * @data : 26/10/2022
 */

interface RawgApi {

   @GET("/api/games?key=9026a77bc6724b13b7b97c217d75beee")
   suspend fun getGames(
      @QueryMap params:Map<String, String>
   ): PagedResponse
}