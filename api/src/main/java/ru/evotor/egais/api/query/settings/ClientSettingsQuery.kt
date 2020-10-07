package ru.evotor.egais.api.query.settings

import android.content.Context
import ru.evotor.egais.api.provider.settings.ClientSettingsContract

class ClientSettingsQuery {

    fun getFsRarId(context: Context): String? {
        return context.contentResolver.query(ClientSettingsContract.FSRAR_ID_URI, null, null, null, null)
                ?.use { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(ClientSettingsContract.FSRAR_ID_COLUMN_NAME))
                }
    }
}