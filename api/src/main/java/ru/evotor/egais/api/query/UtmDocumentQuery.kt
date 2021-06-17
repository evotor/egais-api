package ru.evotor.egais.api.query

import android.content.Context
import ru.evotor.egais.api.provider.lastutmdocumentdate.UtmDocumentContract
import java.text.SimpleDateFormat
import java.util.*

class UtmDocumentQuery {
    fun getLastSuccessfulUtmDocumentDate(context: Context): Date? {
        return context.contentResolver.query(UtmDocumentContract.LAST_UTM_DOCUMENT_URI, null, null, null, null)
                ?.use { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(UtmDocumentContract.CREATION_DATE_COLUMN_NAME))
                            .let { SimpleDateFormat(UtmDocumentContract.DATE_FORMAT_CREATION_DATE, Locale.getDefault()).parse(it) }
                }
    }
}