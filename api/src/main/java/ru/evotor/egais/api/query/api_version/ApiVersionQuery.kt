package ru.evotor.egais.api.query.api_version

import android.content.Context
import ru.evotor.egais.api.provider.api_version.ApiVersionContract

class ApiVersionQuery {

    fun getMarkedBottleApiVersion(context: Context): Int? {
        return context.contentResolver.query(
            ApiVersionContract.MARKED_BOTTLE_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getInt(cursor.getColumnIndex(ApiVersionContract.MARKED_BOTTLE_COLUMN_NAME))
            }
    }
}