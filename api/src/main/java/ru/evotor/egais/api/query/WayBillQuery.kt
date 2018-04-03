package ru.evotor.egais.api.query

import ru.evotor.egais.api.WayBillApi
import ru.evotor.egais.api.model.document.waybill.*
import ru.evotor.egais.api.provider.waybill.WayBillContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class WayBillQuery : FilterBuilder<WayBillQuery, WayBillQuery.SortOrder, WayBill>(WayBillContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(WayBillContract.COLUMN_UUID)
    @JvmField
    val docOwner = addFieldFilter<String>(WayBillContract.COLUMN_OWNER)
    @JvmField
    val identity = addFieldFilter<String?>(WayBillContract.COLUMN_IDENTITY)
    @JvmField
    val type = addFieldFilter<Type>(WayBillContract.COLUMN_TYPE)
    @JvmField
    val unitType = addFieldFilter<UnitType?>(WayBillContract.COLUMN_UNIT_TYPE)
    @JvmField
    val number = addFieldFilter<String>(WayBillContract.COLUMN_NUMBER)
    @JvmField
    val date = addFieldFilter<Date>(WayBillContract.COLUMN_DATE)
    @JvmField
    val shippingDate = addFieldFilter<Date>(WayBillContract.COLUMN_SHIPPING_DATE)
    @JvmField
    val shipperId = addFieldFilter<String>(WayBillContract.COLUMN_SHIPPER_ID)
    @JvmField
    val consigneeId = addFieldFilter<String>(WayBillContract.COLUMN_CONSIGNEE_ID)
    @JvmField
    val supplierId = addFieldFilter<String?>(WayBillContract.COLUMN_SUPPLIER_ID)
    @JvmField
    val base = addFieldFilter<String?>(WayBillContract.COLUMN_BASE)
    @JvmField
    val note = addFieldFilter<String?>(WayBillContract.COLUMN_NOTE)
    @JvmField
    val status = addFieldFilter<Status>(WayBillContract.COLUMN_STATUS)
    @JvmField
    val resolution = addFieldFilter<Resolution>(WayBillContract.COLUMN_RESOLUTION)
    @JvmField
    val ttnInformBRegUuid = addFieldFilter<UUID?>(WayBillContract.COLUMN_TTN_INFORM_B_REG_UUID)
    @JvmField
    val wbRegId = addFieldFilter<String?>(WayBillContract.COLUMN_WB_REG_ID)

    override val currentQuery: WayBillQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(WayBillContract.COLUMN_UUID)
        @JvmField
        val docOwner = addFieldSorter(WayBillContract.COLUMN_OWNER)
        @JvmField
        val identity = addFieldSorter(WayBillContract.COLUMN_IDENTITY)
        @JvmField
        val type = addFieldSorter(WayBillContract.COLUMN_TYPE)
        @JvmField
        val unitType = addFieldSorter(WayBillContract.COLUMN_UNIT_TYPE)
        @JvmField
        val number = addFieldSorter(WayBillContract.COLUMN_NUMBER)
        @JvmField
        val date = addFieldSorter(WayBillContract.COLUMN_DATE)
        @JvmField
        val shippingDate = addFieldSorter(WayBillContract.COLUMN_SHIPPING_DATE)
        @JvmField
        val shipperId = addFieldSorter(WayBillContract.COLUMN_SHIPPER_ID)
        @JvmField
        val consigneeId = addFieldSorter(WayBillContract.COLUMN_CONSIGNEE_ID)
        @JvmField
        val supplierId = addFieldSorter(WayBillContract.COLUMN_SUPPLIER_ID)
        @JvmField
        val base = addFieldSorter(WayBillContract.COLUMN_BASE)
        @JvmField
        val note = addFieldSorter(WayBillContract.COLUMN_NOTE)
        @JvmField
        val status = addFieldSorter(WayBillContract.COLUMN_STATUS)
        @JvmField
        val resolution = addFieldSorter(WayBillContract.COLUMN_RESOLUTION)
        @JvmField
        val ttnInformBRegUuid = addFieldSorter(WayBillContract.COLUMN_TTN_INFORM_B_REG_UUID)
        @JvmField
        val wbRegId = addFieldSorter(WayBillContract.COLUMN_WB_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBill>): WayBill {
        return WayBillApi.createWayBill(cursor)
    }

}