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

    val uuid = addFieldFilter<UUID>(ActWriteOffContract.COLUMN_UUID)
    val docOwner = addFieldFilter<String>(ActWriteOffContract.COLUMN_OWNER)
    val identity = addFieldFilter<String?>(ActWriteOffContract.COLUMN_IDENTITY)
    val number = addFieldFilter<String?>(ActWriteOffContract.COLUMN_NUMBER)
    val actDate = addFieldFilter<Date>(ActWriteOffContract.COLUMN_ACT_DATE)
    val typeWriteOff = addFieldFilter<TypeWriteOff?>(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)
    val note = addFieldFilter<String?>(ActWriteOffContract.COLUMN_NOTE)
    val status = addFieldFilter<ActWriteOffStatus>(ActWriteOffContract.COLUMN_STATUS)
    val rejectComment = addFieldFilter<String?>(ActWriteOffContract.COLUMN_REJECT_COMMENT)
    val version = addFieldFilter<Version>(ActWriteOffContract.COLUMN_VERSION)

    override val currentQuery: ActWriteOffQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val uuid = addFieldSorter(ActWriteOffContract.COLUMN_UUID)
        val docOwner = addFieldSorter(ActWriteOffContract.COLUMN_OWNER)
        val identity = addFieldSorter(ActWriteOffContract.COLUMN_IDENTITY)
        val number = addFieldSorter(ActWriteOffContract.COLUMN_NUMBER)
        val actDate = addFieldSorter(ActWriteOffContract.COLUMN_ACT_DATE)
        val typeWriteOff = addFieldSorter(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)
        val note = addFieldSorter(ActWriteOffContract.COLUMN_NOTE)
        val status = addFieldSorter(ActWriteOffContract.COLUMN_STATUS)
        val rejectComment = addFieldSorter(ActWriteOffContract.COLUMN_REJECT_COMMENT)
        val version = addFieldSorter(ActWriteOffContract.COLUMN_VERSION)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOff>): ActWriteOff {
        return ActWriteOffApi.createActWriteOff(cursor)
    }

}