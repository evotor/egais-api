package ru.evotor.egais.api.provider.utmcontract

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object UtmContract {
    private const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.utmconnection"
    const val IS_UTM_ACTIVE_PATH = "IsUtmActive"
    val BASE_URI: Uri? = Uri.parse("content://$AUTHORITY")
    const val IS_UTM_ACTIVE_COLUMN_NAME = "IS_UTM_ACTIVE"
}