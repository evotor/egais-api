package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.reply.UnprocessedDocument
import ru.evotor.egais.api.provider.unprocessed_documents.UnprocessedDocumentsContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.text.SimpleDateFormat
import java.util.*


/**
 * Класс для формирования запроса на получение результата отправки
 * повторного запроса ТТН
 */
class UnprocessedDocumentsQuery :
    FilterBuilder<UnprocessedDocumentsQuery, UnprocessedDocumentsQuery.SortOrder, List<UnprocessedDocument>>(
        UnprocessedDocumentsContract.URI
    ) {

    private val dateFormat by lazy(LazyThreadSafetyMode.NONE) {
        SimpleDateFormat(DATE_PATTERN, Locale.getDefault())
    }

    @JvmField
    val id = addFieldFilter<String>(UnprocessedDocumentsContract.COLUMN_ID)

    @JvmField
    val number = addFieldFilter<String>(UnprocessedDocumentsContract.COLUMN_NUMBER)

    @JvmField
    val date = addFieldFilter<String>(UnprocessedDocumentsContract.COLUMN_DATE)

    @JvmField
    val sender = addFieldFilter<String>(UnprocessedDocumentsContract.COLUMN_SENDER)

    override val currentQuery: UnprocessedDocumentsQuery
        get() = this


    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        override val currentSortOrder: SortOrder
            get() = this

        @JvmField
        val id = addFieldSorter(UnprocessedDocumentsContract.COLUMN_ID)

        @JvmField
        val number = addFieldSorter(UnprocessedDocumentsContract.COLUMN_NUMBER)

        @JvmField
        val date = addFieldSorter(UnprocessedDocumentsContract.COLUMN_DATE)

        @JvmField
        val sender = addFieldSorter(UnprocessedDocumentsContract.COLUMN_SENDER)
    }

    override fun getValue(cursor: Cursor<List<UnprocessedDocument>>): List<UnprocessedDocument> {
        return createUnprocessedDocuments(cursor)
    }

    private fun createUnprocessedDocuments(cursor: Cursor<List<UnprocessedDocument>>): List<UnprocessedDocument> {
        val unprocessedDocuments = mutableListOf<UnprocessedDocument>()
        while (cursor.moveToNext()) {
            val columnIndexId = cursor.getColumnIndexOrThrow(UnprocessedDocumentsContract.COLUMN_ID)
            val columnIndexNumber =
                cursor.getColumnIndexOrThrow(UnprocessedDocumentsContract.COLUMN_NUMBER)
            val columnIndexDate =
                cursor.getColumnIndexOrThrow(UnprocessedDocumentsContract.COLUMN_DATE)
            val columnIndexSender =
                cursor.getColumnIndexOrThrow(UnprocessedDocumentsContract.COLUMN_SENDER)
            unprocessedDocuments.add(
                UnprocessedDocument(
                    cursor.getString(columnIndexId),
                    cursor.getString(columnIndexNumber),
                    dateFormat.parse(cursor.getString(columnIndexDate)) ?: Date(),
                    cursor.getString(columnIndexSender)
                )
            )
        }
        return unprocessedDocuments
    }

    companion object {
        private const val DATE_PATTERN = "dd.MM.yyyy"
    }
}