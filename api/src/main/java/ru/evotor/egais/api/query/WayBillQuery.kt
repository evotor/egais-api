package ru.evotor.egais.api.query

import ru.evotor.egais.api.WayBillApi
import ru.evotor.egais.api.model.document.waybill.*
import ru.evotor.egais.api.provider.waybill.WayBillContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class WayBillQuery : FilterBuilder<WayBillQuery, WayBillQuery.SortOrder, WayBill>(WayBillContract.URI){

    val uuid = addFieldFilter<UUID>(WayBillContract.COLUMN_UUID)
    val docOwner = addFieldFilter<String>(WayBillContract.COLUMN_OWNER)
    val identity = addFieldFilter<String?>(WayBillContract.COLUMN_IDENTITY)
    val type = addFieldFilter<Type>(WayBillContract.COLUMN_TYPE)
    val unitType = addFieldFilter<UnitType?>(WayBillContract.COLUMN_UNIT_TYPE)
    val number = addFieldFilter<String>(WayBillContract.COLUMN_NUMBER)
    val date = addFieldFilter<Date>(WayBillContract.COLUMN_DATE)
    val shippingDate = addFieldFilter<Date>(WayBillContract.COLUMN_SHIPPING_DATE)
    val shipperId = addFieldFilter<String>(WayBillContract.COLUMN_SHIPPER_ID)
    val consigneeId = addFieldFilter<String>(WayBillContract.COLUMN_CONSIGNEE_ID)
    val supplierId = addFieldFilter<String?>(WayBillContract.COLUMN_SUPPLIER_ID)
    val base = addFieldFilter<String?>(WayBillContract.COLUMN_BASE)
    val note = addFieldFilter<String?>(WayBillContract.COLUMN_NOTE)
    val status = addFieldFilter<Status>(WayBillContract.COLUMN_STATUS)
    val resolution = addFieldFilter<Resolution>(WayBillContract.COLUMN_RESOLUTION)
    val ttnInformBRegUuid = addFieldFilter<UUID?>(WayBillContract.COLUMN_TTN_INFORM_B_REG_UUID)
    val wbRegId = addFieldFilter<String?>(WayBillContract.COLUMN_WB_REG_ID)

    override val currentQuery: WayBillQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val uuid = addFieldSorter(WayBillContract.COLUMN_UUID)
        val docOwner = addFieldSorter(WayBillContract.COLUMN_OWNER)
        val identity = addFieldSorter(WayBillContract.COLUMN_IDENTITY)
        val type = addFieldSorter(WayBillContract.COLUMN_TYPE)
        val unitType = addFieldSorter(WayBillContract.COLUMN_UNIT_TYPE)
        val number = addFieldSorter(WayBillContract.COLUMN_NUMBER)
        val date = addFieldSorter(WayBillContract.COLUMN_DATE)
        val shippingDate = addFieldSorter(WayBillContract.COLUMN_SHIPPING_DATE)
        val shipperId = addFieldSorter(WayBillContract.COLUMN_SHIPPER_ID)
        val consigneeId = addFieldSorter(WayBillContract.COLUMN_CONSIGNEE_ID)
        val supplierId = addFieldSorter(WayBillContract.COLUMN_SUPPLIER_ID)
        val base = addFieldSorter(WayBillContract.COLUMN_BASE)
        val note = addFieldSorter(WayBillContract.COLUMN_NOTE)
        val status = addFieldSorter(WayBillContract.COLUMN_STATUS)
        val resolution = addFieldSorter(WayBillContract.COLUMN_RESOLUTION)
        val ttnInformBRegUuid = addFieldSorter(WayBillContract.COLUMN_TTN_INFORM_B_REG_UUID)
        val wbRegId = addFieldSorter(WayBillContract.COLUMN_WB_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBill>): WayBill {
        return WayBillApi.createWayBill(cursor)
    }

}