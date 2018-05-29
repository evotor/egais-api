package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.EgaisDocumentStatusRecord
import ru.evotor.egais.api.model.document.ticket.DocType
import ru.evotor.egais.api.provider.EgaisDocumentStatusRecordContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class EgaisDocumentStatusRecordQuery : FilterBuilder<EgaisDocumentStatusRecordQuery,
        EgaisDocumentStatusRecordQuery.SortOrder, EgaisDocumentStatusRecord>(EgaisDocumentStatusRecordContract.URI) {

    /**
     * Уникальный идентификатор
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(EgaisDocumentStatusRecordContract.UUID_COLUMN)

    override val currentQuery: EgaisDocumentStatusRecordQuery
        get() = this

    override fun getValue(cursor: Cursor<EgaisDocumentStatusRecord>): EgaisDocumentStatusRecord {
        val columnIndexStateOld = cursor.getColumnIndex(EgaisDocumentStatusRecordContract.STATE_OLD_COLUMN)
        val stateOld = if (columnIndexStateOld == -1) {
            null
        } else {
            cursor.getString(columnIndexStateOld)
        }

        val columnIndexStateNew = cursor.getColumnIndex(EgaisDocumentStatusRecordContract.STATE_NEW_COLUMN)
        val stateNew = if (columnIndexStateNew == -1) {
            null
        } else {
            cursor.getString(columnIndexStateNew)
        }

        val columnIndexType = cursor.getColumnIndex(EgaisDocumentStatusRecordContract.TYPE_COLUMN)
        val columnIndexDate = cursor.getColumnIndex(EgaisDocumentStatusRecordContract.DATE_COLUMN)

        return EgaisDocumentStatusRecord(
                UUID.fromString(cursor.getString(cursor.getColumnIndex(EgaisDocumentStatusRecordContract.UUID_COLUMN))),
                stateOld,
                stateNew,
                DocType.valueOf(cursor.getString(columnIndexType)),
                Date(cursor.getLong(columnIndexDate))
        )
    }

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        override val currentSortOrder: SortOrder
            get() = this
    }
}