package com.genius.wasylews.beersuggestion.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Beer(
    val name: String,
    val tagLine: String,
    val logo: String,
    val description: String
) : Parcelable