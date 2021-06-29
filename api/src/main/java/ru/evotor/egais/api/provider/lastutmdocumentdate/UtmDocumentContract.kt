package ru.evotor.egais.api.provider.lastutmdocumentdate

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object UtmDocumentContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.utmdocument"
    val BASE_URI = Uri.parse("content://$AUTHORITY")

    const val UTM_DOCUMENT_PATH = "UtmDocument"
    const val QUERY_RESTS_PATH = "QueryRests"
    const val QUERY_RESTS_SHOP_PATH = "QueryRestsShop"

    val UTM_DOCUMENT_URI = Uri.withAppendedPath(BASE_URI, UTM_DOCUMENT_PATH)
    val QUERY_RESTS_URI = Uri.withAppendedPath(BASE_URI, QUERY_RESTS_PATH)
    val QUERY_RESTS_SHOP_URI = Uri.withAppendedPath(BASE_URI, QUERY_RESTS_SHOP_PATH)

    const val CREATION_DATE_COLUMN_NAME = "CREATION_DATE"
    const val DATE_FORMAT_CREATION_DATE = "yyyy-MM-dd HH:mm:ss"
}