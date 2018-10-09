package ru.evotor.egais.api.provider.settings

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ClientSettingsContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.clientsettings"

    const val FSRAR_ID_COLUMN_NAME = "FSRAR_ID"
    const val FSRAR_ID_PATH = "FsRarId"

    val BASE_URI = Uri.parse("content://$AUTHORITY")
    val FSRAR_ID_URI = Uri.withAppendedPath(BASE_URI, FSRAR_ID_PATH)
}