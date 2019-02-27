package ru.evotor.egais.api.query.settings

import android.content.Context
import ru.evotor.egais.api.model.AlcoholControlType
import ru.evotor.egais.api.provider.settings.SettingsContract

class SettingsQuery {

    fun getAlcoholControlType(context: Context): AlcoholControlType? {
        return context.contentResolver.query(SettingsContract.ALCOHOL_CONTROL_TYPE_URI, null, null, null, null)
                ?.use { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(SettingsContract.ALCOHOL_CONTROL_TYPE_COLUMN_NAME))?.let {
                        AlcoholControlType.valueOf(it)
                    }
                }
    }

    fun isAlcoholEnabled(context: Context): Boolean {
        return context.contentResolver.query(SettingsContract.ALCOHOL_ENABLED_URI, null, null, null, null)
                ?.use { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(SettingsContract.ALCOHOL_ENABLED_COLUMN_NAME))?.toBoolean()
                } ?: true
    }

    fun isLinkEgaisCommodity(context: Context): Boolean {
        return context.contentResolver.query(SettingsContract.LINK_EGAIS_COMMODITY_URI, null, null, null, null)
                ?.use { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(SettingsContract.LINK_EGAIS_COMMODITY_COLUMN_NAME))?.toBoolean()
                } ?: true
    }
}