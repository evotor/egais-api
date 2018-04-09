package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOff
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffStatus
import ru.evotor.egais.api.model.document.actwriteoff.TypeWriteOff
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class ActWriteOffQuery : FilterBuilder<ActWriteOffQuery, ActWriteOffQuery.SortOrder, ActWriteOff>(ActWriteOffContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(ActWriteOffContract.COLUMN_UUID)
    @JvmField
    val docOwner = addFieldFilter<String>(ActWriteOffContract.COLUMN_OWNER)
    @JvmField
    val identity = addFieldFilter<String?>(ActWriteOffContract.COLUMN_IDENTITY)
    @JvmField
    val number = addFieldFilter<String?>(ActWriteOffContract.COLUMN_NUMBER)
    @JvmField
    val actDate = addFieldFilter<Date>(ActWriteOffContract.COLUMN_ACT_DATE)
    @JvmField
    val typeWriteOff = addFieldFilter<TypeWriteOff?>(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)
    @JvmField
    val note = addFieldFilter<String?>(ActWriteOffContract.COLUMN_NOTE)
    @JvmField
    val status = addFieldFilter<ActWriteOffStatus>(ActWriteOffContract.COLUMN_STATUS)
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActWriteOffContract.COLUMN_REJECT_COMMENT)
    @JvmField
    val version = addFieldFilter<Version>(ActWriteOffContract.COLUMN_VERSION)

    override val currentQuery: ActWriteOffQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(ActWriteOffContract.COLUMN_UUID)
        @JvmField
        val docOwner = addFieldSorter(ActWriteOffContract.COLUMN_OWNER)
        @JvmField
        val identity = addFieldSorter(ActWriteOffContract.COLUMN_IDENTITY)
        @JvmField
        val number = addFieldSorter(ActWriteOffContract.COLUMN_NUMBER)
        @JvmField
        val actDate = addFieldSorter(ActWriteOffContract.COLUMN_ACT_DATE)
        @JvmField
        val typeWriteOff = addFieldSorter(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)
        @JvmField
        val note = addFieldSorter(ActWriteOffContract.COLUMN_NOTE)
        @JvmField
        val status = addFieldSorter(ActWriteOffContract.COLUMN_STATUS)
        @JvmField
        val rejectComment = addFieldSorter(ActWriteOffContract.COLUMN_REJECT_COMMENT)
        @JvmField
        val version = addFieldSorter(ActWriteOffContract.COLUMN_VERSION)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOff>): ActWriteOff {
        return createActWriteOff(cursor)
    }

    private fun createActWriteOff(cursor: android.database.Cursor): ActWriteOff {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActWriteOffContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActWriteOffContract.COLUMN_NUMBER)
        val columnIndexActDate = cursor.getColumnIndex(ActWriteOffContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)
        val columnIndexNote = cursor.getColumnIndex(ActWriteOffContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActWriteOffContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActWriteOffContract.COLUMN_REJECT_COMMENT)
        val columnIndexVersion = cursor.getColumnIndex(ActWriteOffContract.COLUMN_VERSION)

        return ActWriteOff(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                Date(cursor.getString(columnIndexActDate)),
                TypeWriteOff.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexNote),
                ActWriteOffStatus.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment),
                Version.valueOf(cursor.getString(columnIndexVersion))
        )
    }
}