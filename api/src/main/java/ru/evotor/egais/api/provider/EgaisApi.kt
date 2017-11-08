package ru.evotor.egais.api.provider

import android.net.Uri

object EgaisApi {
    const val AUTHORITY = "ru.evotor.egais.api"
    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")
}