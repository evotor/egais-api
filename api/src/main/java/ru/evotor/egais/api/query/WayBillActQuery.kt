package ru.evotor.egais.api.query

import ru.evotor.egais.api.WayBillActApi
import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.waybill.*
import ru.evotor.egais.api.model.document.waybillact.AcceptType
import ru.evotor.egais.api.model.document.waybillact.Type
import ru.evotor.egais.api.model.document.waybillact.WayBillAct
import ru.evotor.egais.api.provider.waybillact.WayBillActContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class WayBillActQuery : FilterBuilder<WayBillActQuery, WayBillActQuery.SortOrder, WayBillAct>(WayBillActContract.URI){

    val uuid = addFieldFilter<UUID>(WayBillActContract.COLUMN_UUID)
    val docOwner = addFieldFilter<String>(WayBillActContract.COLUMN_OWNER)
    val identity = addFieldFilter<String?>(WayBillActContract.COLUMN_IDENTITY)
    val acceptType = addFieldFilter<AcceptType?>(WayBillActContract.COLUMN_TYPE)
    val number = addFieldFilter<String>(WayBillActContract.COLUMN_NUMBER)
    val creationDate = addFieldFilter<Date>(WayBillActContract.COLUMN_CREATION_DATE)
    val wbRegId = addFieldFilter<String?>(WayBillActContract.COLUMN_WB_REG_ID)
    val note = addFieldFilter<String?>(WayBillActContract.COLUMN_NOTE)
    val type = addFieldFilter<Type?>(WayBillActContract.COLUMN_TYPE)
    val version = addFieldFilter<Version?>(WayBillActContract.COLUMN_VERSION)
    val status = addFieldFilter<Status>(WayBillActContract.COLUMN_STATUS)
    val rejectComment = addFieldFilter<String?>(WayBillActContract.COLUMN_REJECT_COMMENT)

    override val currentQuery: WayBillActQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val uuid = addFieldSorter(WayBillActContract.COLUMN_UUID)
        val docOwner = addFieldSorter(WayBillActContract.COLUMN_OWNER)
        val identity = addFieldSorter(WayBillActContract.COLUMN_IDENTITY)
        val acceptType = addFieldSorter(WayBillActContract.COLUMN_TYPE)
        val number = addFieldSorter(WayBillActContract.COLUMN_NUMBER)
        val creationDate = addFieldSorter(WayBillActContract.COLUMN_CREATION_DATE)
        val wbRegId = addFieldSorter(WayBillActContract.COLUMN_WB_REG_ID)
        val note = addFieldSorter(WayBillActContract.COLUMN_NOTE)
        val type = addFieldSorter(WayBillActContract.COLUMN_TYPE)
        val version = addFieldSorter(WayBillActContract.COLUMN_VERSION)
        val status = addFieldSorter(WayBillActContract.COLUMN_STATUS)
        val rejectComment = addFieldSorter(WayBillActContract.COLUMN_REJECT_COMMENT)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBillAct>): WayBillAct {
        return WayBillActApi.createWayBillAct(cursor)
    }

}