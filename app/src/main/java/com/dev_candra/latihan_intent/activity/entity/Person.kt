package com.dev_candra.latihan_intent.activity.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val nama: String?,
    val umur: Int?,
    val alamat: String?,
    val kota : String?
) : Parcelable