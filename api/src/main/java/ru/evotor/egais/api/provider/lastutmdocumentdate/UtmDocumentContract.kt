package ru.evotor.egais.api.provider.lastutmdocumentdate

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object UtmDocumentContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.utmdocument"
    const val CREATION_DATE_COLUMN_NAME = "CREATION_DATE"
    val UTM_DOCUMENT_PATH = "UtmDocument"
    val BASE_URI = Uri.parse("content://$AUTHORITY")
    val UTM_DOCUMENT_URI = Uri.withAppendedPath(BASE_URI, UTM_DOCUMENT_PATH)
    const val DATE_FORMAT_CREATION_DATE = "yyyy-MM-dd HH:mm:ss"
}