package ru.evotor.egais.api.query

import android.content.Context
import ru.evotor.egais.api.provider.utmconnection.UtmConnectionContract

class UtmConnectionQuery {
    fun isUtmActive(context: Context): Boolean {
        return context.contentResolver.query(
            UtmConnectionContract.IS_UTM_ACTIVE_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndex(UtmConnectionContract.IS_UTM_ACTIVE_COLUMN_NAME))
                    ?.toBoolean()
            } ?: false
    }
}