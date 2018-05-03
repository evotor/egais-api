package ru.evotor.egais.api.query

import android.content.Context
import ru.evotor.egais.api.provider.client_settings.ClientSettingsContract

class ClientSettingsQuery {

    fun getFsRarId(context: Context): String? {
        return context.contentResolver.query(ClientSettingsContract.FSRAR_ID_URI, null, null, null, null)
                ?.let { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(ClientSettingsContract.FSRAR_ID_COLUMN_NAME))
                }
    }
}