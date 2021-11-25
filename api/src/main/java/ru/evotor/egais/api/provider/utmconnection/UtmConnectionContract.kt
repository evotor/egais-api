package ru.evotor.egais.api.provider.utmconnection

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object UtmConnectionContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.utmconnection"
    const val IS_UTM_ACTIVE_COLUMN_NAME = "IS_UTM_ACTIVE"
    const val IS_UTM_ACTIVE_PATH = "IsUtmActive"
    val BASE_URI = Uri.parse("content://$AUTHORITY")
    val IS_UTM_ACTIVE_URI = Uri.withAppendedPath(BASE_URI, IS_UTM_ACTIVE_PATH)
}