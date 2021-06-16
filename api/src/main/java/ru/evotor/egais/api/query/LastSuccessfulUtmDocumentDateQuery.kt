package ru.evotor.egais.api.query

import android.content.Context
import ru.evotor.egais.api.provider.lastutmdocumentdate.LastSuccessfulUtmDocumentDateContract
import java.text.SimpleDateFormat
import java.util.*

class LastSuccessfulUtmDocumentDateQuery {
    fun getLastSuccessfulUtmDocumentDate(context: Context): Date? {
        return context.contentResolver.query(LastSuccessfulUtmDocumentDateContract.LAST_UTM_DOCUMENT_URI, null, null, null, null)
                ?.use { cursor ->
                    cursor.moveToFirst()
                    cursor.getString(cursor.getColumnIndex(LastSuccessfulUtmDocumentDateContract.CREATION_DATE_COLUMN_NAME))
                            .let { SimpleDateFormat(DATE_FORMAT, Locale.getDefault()).parse(it) }
                }
    }

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"
    }
}