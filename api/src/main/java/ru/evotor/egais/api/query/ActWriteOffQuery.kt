package ru.evotor.egais.api.query

import ru.evotor.egais.api.ActWriteOffApi
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
        return ActWriteOffApi.createActWriteOff(cursor)
    }

}