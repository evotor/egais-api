package ru.evotor.egais.api.provider.client_settings

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ClientSettingsContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.clientsettings"

    const val FSRAR_ID_COLUMN_NAME = "FSRAR_ID"
    const val ALCOHOL_CONTROL_TYPE_COLUMN_NAME = "ALCOHOL_CONTROL_TYPE"
    const val ALCOHOL_ENABLED_COLUMN_NAME = "ALCOHOL_ENABLED"
    const val FSRAR_ID_PATH = "FsRarId"
    const val ALCOHOL_ENABLED_PATH = "AlcoholEnabled"
    const val ALCOHOL_CONTROL_TYPE_PATH = "AlcoholControlType"

    val BASE_URI = Uri.parse("content://$AUTHORITY")
    val FSRAR_ID_URI = Uri.withAppendedPath(BASE_URI, FSRAR_ID_PATH)
    val ALCOHOL_CONTROL_TYPE_URI = Uri.withAppendedPath(BASE_URI, ALCOHOL_CONTROL_TYPE_PATH)
    val ALCOHOL_ENABLED_URI = Uri.withAppendedPath(BASE_URI, ALCOHOL_ENABLED_PATH)
}