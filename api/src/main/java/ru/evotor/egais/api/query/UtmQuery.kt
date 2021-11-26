package ru.evotor.egais.api.query

import android.content.Context
import android.net.Uri
import ru.evotor.egais.api.provider.utmcontract.UtmContract

object UtmQuery {
    /**
     * Проверяет, запущен ли на смарт-терминале УТМ.
     * Returns: true если УТМ запущен; false если УТМ не запущен.
     */
    fun isUtmActive(context: Context) =
        isFeatureActive(
            context,
            UtmContract.IS_UTM_ACTIVE_PATH,
            UtmContract.IS_UTM_ACTIVE_COLUMN_NAME
        )

    private fun isFeatureActive(
        context: Context,
        path: String,
        column: String,
        defaultValue: Boolean = false
    ): Boolean =
        context.contentResolver.query(
            Uri.withAppendedPath(UtmContract.BASE_URI, path),
            null,
            null,
            null,
            null
        )?.use { cursor ->
            cursor.moveToFirst()
            cursor.getString(cursor.getColumnIndex(column))?.toBoolean()
        } ?: defaultValue
}