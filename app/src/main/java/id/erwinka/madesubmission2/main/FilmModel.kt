package id.erwinka.madesubmission2.main

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilmModel(
    val title: String,
    val description: String,
    val poster: Int,
    val releaseDate: String,
    val runningTime: String,
    val distributedBy: String
) : Parcelable