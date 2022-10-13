package com.example.hammersystem.data.web

import com.example.hammersystem.domain.model.data.DataFood
import retrofit2.http.GET

interface FoodAPI {

    @GET("hot")
    suspend fun listFood(): List<DataFood>

}