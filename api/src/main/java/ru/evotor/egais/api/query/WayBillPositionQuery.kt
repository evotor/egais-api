package ru.evotor.egais.api.query

import ru.evotor.egais.api.WayBillApi
import ru.evotor.egais.api.model.document.waybill.WayBillPosition
import ru.evotor.egais.api.provider.waybill.WayBillPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class WayBillPositionQuery : FilterBuilder<WayBillPositionQuery, WayBillPositionQuery.SortOrder, WayBillPosition>(WayBillPositionContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(WayBillPositionContract.COLUMN_UUID)
    @JvmField
    val wayBillUuid = addFieldFilter<UUID>(WayBillPositionContract.COLUMN_WAYBILL_UUID)
    @JvmField
    val productIdentity = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PRODUCT_INFO_IDENTITY)
    @JvmField
    val productAlcoCode = addFieldFilter<String>(WayBillPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
    @JvmField
    val packId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PACKID)
    @JvmField
    val quantity = addFieldFilter<BigDecimal>(WayBillPositionContract.COLUMN_QUANTITY)
    @JvmField
    val price = addFieldFilter<BigDecimal>(WayBillPositionContract.COLUMN_PRICE)
    @JvmField
    val party = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PARTY)
    @JvmField
    val identity = addFieldFilter<String?>(WayBillPositionContract.COLUMN_IDENTITY)
    @JvmField
    val informF1RegId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_INFORM_INFORM_F1_REG_ID)
    @JvmField
    val informF2RegId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_INFORM_F2_REG_ID)

    override val currentQuery: WayBillPositionQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(WayBillPositionContract.COLUMN_UUID)
        @JvmField
        val wayBillUuid = addFieldSorter(WayBillPositionContract.COLUMN_WAYBILL_UUID)
        @JvmField
        val productIdentity = addFieldSorter(WayBillPositionContract.COLUMN_PRODUCT_INFO_IDENTITY)
        @JvmField
        val productAlcoCode = addFieldSorter(WayBillPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        @JvmField
        val packId = addFieldSorter(WayBillPositionContract.COLUMN_PACKID)
        @JvmField
        val quantity = addFieldSorter(WayBillPositionContract.COLUMN_QUANTITY)
        @JvmField
        val price = addFieldSorter(WayBillPositionContract.COLUMN_PRICE)
        @JvmField
        val party = addFieldSorter(WayBillPositionContract.COLUMN_PARTY)
        @JvmField
        val identity = addFieldSorter(WayBillPositionContract.COLUMN_IDENTITY)
        @JvmField
        val informF1RegId = addFieldSorter(WayBillPositionContract.COLUMN_INFORM_INFORM_F1_REG_ID)
        @JvmField
        val informF2RegId = addFieldSorter(WayBillPositionContract.COLUMN_INFORM_F2_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBillPosition>): WayBillPosition {
        return WayBillApi.createWayBillPosition(cursor)
    }

}