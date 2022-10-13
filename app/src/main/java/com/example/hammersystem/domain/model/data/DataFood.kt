package com.example.hammersystem.domain.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataFood(
    val description: String?,
    val id: Int?,
    val image: String?,
    val ingredients: List<String?>?,
    val title: String?
): Parcelable