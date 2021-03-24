package br.com.applicationmfy.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    @SerializedName("id")
    val id: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("release_date")
    val date: String?,

    @SerializedName("poster_path")
    var poster: String?

) : Parcelable {

    constructor() : this("id", "title", "release_date", "poster_path")
}