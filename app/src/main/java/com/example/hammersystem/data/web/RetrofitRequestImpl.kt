package com.example.hammersystem.data.web

import com.example.hammersystem.domain.model.RepositoryFood
import com.example.hammersystem.domain.model.data.DataFood

class RetrofitRequestImpl(private val api: FoodAPI) : RepositoryFood {

    override suspend fun observerListFood(): List<DataFood> {
        return api.listFood()
    }
}