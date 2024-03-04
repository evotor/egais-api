package ru.evotor.egais.api.provider.api_version

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ApiVersionContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.api_version"

    const val MARKED_BOTTLE_PATH = "MarkedBottle"
    const val MARKED_BOTTLE_COLUMN_NAME = "MARKED_BOTTLE_API_VERSION"

    val BASE_URI = Uri.parse("content://$AUTHORITY")
    val MARKED_BOTTLE_URI = Uri.withAppendedPath(BASE_URI, MARKED_BOTTLE_PATH)
}