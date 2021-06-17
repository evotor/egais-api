package ru.evotor.egais.api.provider.lastutmdocumentdate

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object UtmDocumentContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.lastutmdocumentdate"
    const val CREATION_DATE_COLUMN_NAME = "CREATION_DATE"
    val LAST_UTM_DOCUMENT_PATH = "LastUtmDocumentDate"
    val BASE_URI = Uri.parse("content://$AUTHORITY")
    val LAST_UTM_DOCUMENT_URI = Uri.withAppendedPath(BASE_URI, LAST_UTM_DOCUMENT_PATH)
    const val DATE_FORMAT_CREATION_DATE = "yyyy-MM-dd HH:mm:ss"
}