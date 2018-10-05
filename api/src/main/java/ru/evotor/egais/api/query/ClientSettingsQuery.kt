package ru.evotor.egais.api.query

import android.content.Context
import ru.evotor.egais.api.model.AlcoholControlType
import ru.evotor.egais.api.provider.client_settings.ClientSettingsContract

class ClientSettingsQuery {

    fun getFsRarId(context: Context): String? {
        return context.contentResolver.query(ClientSettingsContract.FSRAR_ID_URI, null, null, null, null)
                ?.let { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(ClientSettingsContract.FSRAR_ID_COLUMN_NAME))
                }
    }

    fun getAlcoholControlType(context: Context): AlcoholControlType? {
        return context.contentResolver.query(ClientSettingsContract.ALCOHOL_CONTROL_TYPE_URI, null, null, null, null)
                ?.let { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(ClientSettingsContract.ALCOHOL_CONTROL_TYPE_COLUMN_NAME))?.let {
                        AlcoholControlType.valueOf(it)
                    }
                }
    }

    fun isAlcoholEnabled(context: Context): Boolean {
        return context.contentResolver.query(ClientSettingsContract.ALCOHOL_ENABLED_URI, null, null, null, null)
                ?.let { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(ClientSettingsContract.ALCOHOL_ENABLED_COLUMN_NAME))?.let {
                        it.toBoolean()
                    }
                } ?: true
    }
}