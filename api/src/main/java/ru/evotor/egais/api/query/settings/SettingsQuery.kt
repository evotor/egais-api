package ru.evotor.egais.api.query.settings

import android.content.Context
import ru.evotor.egais.api.model.AlcoholControlType
import ru.evotor.egais.api.provider.settings.SettingsContract

class SettingsQuery {

    fun getAlcoholControlType(context: Context): AlcoholControlType? {
        return context.contentResolver.query(
            SettingsContract.ALCOHOL_CONTROL_TYPE_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndex(SettingsContract.ALCOHOL_CONTROL_TYPE_COLUMN_NAME))
                    ?.let {
                        AlcoholControlType.valueOf(it)
                    }
            }
    }

    fun isAlcoholEnabled(context: Context): Boolean {
        return context.contentResolver.query(
            SettingsContract.ALCOHOL_ENABLED_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndex(SettingsContract.ALCOHOL_ENABLED_COLUMN_NAME))
                    ?.toBoolean()
            } ?: true
    }

    fun isLinkEgaisCommodity(context: Context): Boolean {
        return context.contentResolver.query(
            SettingsContract.LINK_EGAIS_COMMODITY_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndex(SettingsContract.LINK_EGAIS_COMMODITY_COLUMN_NAME))
                    ?.toBoolean()
            } ?: true
    }

    fun isUtmSyncEnabled(context: Context): Boolean {
        return context.contentResolver.query(
            SettingsContract.UTM_SYNCHRONIZATION_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndex(SettingsContract.UTM_SYNCHRONIZATION_COLUMN_NAME))
                    ?.toBoolean()
            } ?: true
    }

    fun isCloudSyncEnabled(context: Context): Boolean {
        return context.contentResolver.query(
            SettingsContract.CLOUD_SYNCHRONIZATION_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndex(SettingsContract.CLOUD_SYNCHRONIZATION_COLUMN_NAME))
                    ?.toBoolean()
            } ?: true
    }

    fun isBeerTapsEnabled(context: Context): Boolean {
        return context.contentResolver.query(
            SettingsContract.BEER_TAPS_ENABLED_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndex(SettingsContract.BEER_TAPS_ENABLED_COLUMN_NAME))
                    ?.toBoolean()
            } ?: false
    }

    fun isExciseAlcoholOnTapEnabled(context: Context): Boolean {
        return context.contentResolver.query(
            SettingsContract.EXCISE_ALCOHOL_ON_TAP_ENABLED_URI,
            null,
            null,
            null,
            null
        )
            ?.use { cursor ->
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndex(SettingsContract.EXCISE_ALCOHOL_ON_TAP_ENABLED_COLUMN_NAME))
                    ?.toBoolean()
            } ?: false
    }
}