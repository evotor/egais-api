package ru.evotor.egais.api.provider.client_settings

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ClientSettingsContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.clientsettings"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmField
    val PATH = "ClientSettings"

    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * Название колонки настроек
     */
    const val COLUMN_SETTING_NAME = "SETTING_NAME"
}