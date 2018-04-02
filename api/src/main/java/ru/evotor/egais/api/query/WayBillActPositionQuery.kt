package ru.evotor.egais.api.query

import ru.evotor.egais.api.WayBillActApi
import ru.evotor.egais.api.model.document.waybillact.WayBillActPosition
import ru.evotor.egais.api.provider.waybillact.WayBillActPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class WayBillActPositionQuery : FilterBuilder<WayBillActPositionQuery, WayBillActPositionQuery.SortOrder, WayBillActPosition>(WayBillActPositionContract.URI) {

    val uuid = addFieldFilter<UUID>(WayBillActPositionContract.COLUMN_UUID)
    val wayBillActUuid = addFieldFilter<UUID>(WayBillActPositionContract.COLUMN_WAY_BILL_ACT_UUID)
    val identity = addFieldFilter<String>(WayBillActPositionContract.COLUMN_IDENTITY)
    val informBRegId = addFieldFilter<String?>(WayBillActPositionContract.COLUMN_INFORM_B_REG_ID)
    val realQuantity = addFieldFilter<BigDecimal>(WayBillActPositionContract.COLUMN_REAL_QUANTITY)

    override val currentQuery: WayBillActPositionQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val uuid = addFieldSorter(WayBillActPositionContract.COLUMN_UUID)
        val wayBillActUuid = addFieldSorter(WayBillActPositionContract.COLUMN_WAY_BILL_ACT_UUID)
        val identity = addFieldSorter(WayBillActPositionContract.COLUMN_IDENTITY)
        val informBRegId = addFieldSorter(WayBillActPositionContract.COLUMN_INFORM_B_REG_ID)
        val realQuantity = addFieldSorter(WayBillActPositionContract.COLUMN_REAL_QUANTITY)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBillActPosition>): WayBillActPosition {
        return WayBillActApi.createWayBillActPosition(cursor)
    }

}