package com.example.hammersystem.domain.model

import com.example.hammersystem.domain.model.data.DataFood

interface RepositoryFood {
    suspend fun observerListFood(): List<DataFood>
}