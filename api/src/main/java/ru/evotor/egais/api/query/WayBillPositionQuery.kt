package ru.evotor.egais.api.query

import ru.evotor.egais.api.WayBillApi
import ru.evotor.egais.api.model.document.waybill.*
import ru.evotor.egais.api.provider.waybill.WayBillPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class WayBillPositionQuery : FilterBuilder<WayBillPositionQuery, WayBillPositionQuery.SortOrder, WayBillPosition>(WayBillPositionContract.URI){

    val uuid = addFieldFilter<UUID>(WayBillPositionContract.COLUMN_UUID)
    val wayBillUuid = addFieldFilter<UUID>(WayBillPositionContract.COLUMN_WAYBILL_UUID)
    val productIdentity = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PRODUCT_INFO_IDENTITY)
    val productAlcoCode = addFieldFilter<String>(WayBillPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
    val packId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PACKID)
    val quantity = addFieldFilter<BigDecimal>(WayBillPositionContract.COLUMN_QUANTITY)
    val price = addFieldFilter<BigDecimal>(WayBillPositionContract.COLUMN_PRICE)
    val party = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PARTY)
    val identity = addFieldFilter<String?>(WayBillPositionContract.COLUMN_IDENTITY)
    val informARegId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_INFORM_INFORM_A_REG_ID)
    val informBRegId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_INFORM_B_REG_ID)

    override val currentQuery: WayBillPositionQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val uuid = addFieldSorter(WayBillPositionContract.COLUMN_UUID)
        val wayBillUuid = addFieldSorter(WayBillPositionContract.COLUMN_WAYBILL_UUID)
        val productIdentity = addFieldSorter(WayBillPositionContract.COLUMN_PRODUCT_INFO_IDENTITY)
        val productAlcoCode = addFieldSorter(WayBillPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val packId = addFieldSorter(WayBillPositionContract.COLUMN_PACKID)
        val quantity = addFieldSorter(WayBillPositionContract.COLUMN_QUANTITY)
        val price = addFieldSorter(WayBillPositionContract.COLUMN_PRICE)
        val party = addFieldSorter(WayBillPositionContract.COLUMN_PARTY)
        val identity = addFieldSorter(WayBillPositionContract.COLUMN_IDENTITY)
        val informARegId = addFieldSorter(WayBillPositionContract.COLUMN_INFORM_INFORM_A_REG_ID)
        val informBRegId = addFieldSorter(WayBillPositionContract.COLUMN_INFORM_B_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBillPosition>): WayBillPosition {
        return WayBillApi.createWayBillPosition(cursor)
    }

}