package ru.evotor.egais.api.provider.api

import android.content.Context
import android.database.Cursor
import android.net.Uri
import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.waybill.Type
import ru.evotor.egais.api.model.document.waybill.UnitType
import ru.evotor.egais.api.model.document.waybill.WayBill
import ru.evotor.egais.api.model.document.waybill.WayBillPosition
import ru.evotor.egais.api.provider.waybill.WayBillContract
import ru.evotor.egais.api.provider.waybill.WayBillPositionContract
import java.math.BigDecimal
import java.util.*

object WayBillApi {
    const val AUTHORITY = "ru.evotor.egais.waybill.api"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmStatic
    fun getWayBillList(context: Context): ru.evotor.egais.api.provider.Cursor<WayBill?>? {
        return context.contentResolver.query(WayBillContract.URI, null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<WayBill?>(it) {
                        override fun getValue(): WayBill? {
                            return createWayBillInfo(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getWayBillListByDate(context: Context, date: Date): ru.evotor.egais.api.provider.Cursor<WayBill?>? {
        return context.contentResolver.query(Uri.withAppendedPath(WayBillContract.URI, date.toString()),
                null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<WayBill?>(it) {
                        override fun getValue(): WayBill? {
                            return createWayBillInfo(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getWayBillPositionListByUuid(context: Context, uuid: UUID): ru.evotor.egais.api.provider.Cursor<WayBillPosition?>? {
        return context.contentResolver.query(Uri.withAppendedPath(WayBillPositionContract.URI, uuid.toString()),
                null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<WayBillPosition?>(it) {
                        override fun getValue(): WayBillPosition? {
                            return createWayBillPositionInfo(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getWayBillPositionList(context: Context): ru.evotor.egais.api.provider.Cursor<WayBillPosition?>? {
        return context.contentResolver.query(WayBillPositionContract.URI, null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<WayBillPosition?>(it) {
                        override fun getValue(): WayBillPosition? {
                            return createWayBillPositionInfo(this)
                        }
                    }
                }
    }

    private fun createWayBillInfo(cursor: Cursor): WayBill? {
        val columnUuid = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_UUID)
        val columnDocOwner = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_OWNER)
        val columnIdentity = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_IDENTITY)
        val columnType = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TYPE)
        val columnUnitType = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_UNIT_TYPE)
        val columnNumber = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_NUMBER)
        val columnDate = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_DATE)
        val columnShippingDate = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_SHIPPING_DATE)
        val columnTransportType = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_TYPE)
        val columnTransportCompany = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_COMPANY)
        val columnTransportCar = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_CAR)
        val columnTransportTrailer = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_TRAILER)
        val columnTransportCustomer = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_CUSTOMER)
        val columnTransportDriver = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_DRIVER)
        val columnTransportLoadPoint = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_LOADPOINT)
        val columnTransportUnloadPoint = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_UNLOADPOINT)
        val columnTransportRedirect = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_REDIRECT)
        val columnTransportForwarder = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TRANSPORT_FORWARDER)
        val columnShipperId = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_SHIPPER_ID)
        val columnConsigneeId = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_CONSIGNEE_ID)
        val columnSupplierID = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_SUPPLIER_ID)
        val columnBase = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_BASE)
        val columnNote = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_NOTE)
        val columnState = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_STATE)
        val columnTtnInformBRegId = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TTN_INFORM_B_REG_ID)
        val columnWBRegId = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_WB_REG_ID)
        val columnVersion = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_VERSION)

        val wayBill = WayBill(
                uuid = UUID.fromString(cursor.getString(columnUuid)),
                docOwner = cursor.getString(columnDocOwner),
                identity = cursor.getString(columnIdentity),
                type = Type.valueOf(cursor.getString(columnType)),
                unitType = cursor.getString(columnUnitType)?.let { UnitType.valueOf(it) },
                number = cursor.getString(columnNumber),
                _date = Date(cursor.getString(columnDate)),
                _shippingDate = Date(cursor.getString(columnShippingDate)),
                transportType = cursor.getString(columnTransportType),
                transportCompany = cursor.getString(columnTransportCompany),
                transportCar = cursor.getString(columnTransportCar),
                transportTrailer = cursor.getString(columnTransportTrailer),
                transportCustomer = cursor.getString(columnTransportCustomer),
                transportDriver = cursor.getString(columnTransportDriver),
                transportLoadpoint = cursor.getString(columnTransportLoadPoint),
                transportUnloadpoint = cursor.getString(columnTransportUnloadPoint),
                transportRedirect = cursor.getString(columnTransportRedirect),
                transportForwarder = cursor.getString(columnTransportForwarder),
                shipperId = cursor.getLong(columnShipperId),
                consigneeId = cursor.getLong(columnConsigneeId),
                supplierId = cursor.getLong(columnSupplierID),
                base = cursor.getString(columnBase),
                note = cursor.getString(columnNote),
                state = WayBill.State.valueOf(cursor.getString(columnState)),
                ttnInformBRegId = cursor.getLong(columnTtnInformBRegId),
                wbRegId = cursor.getString(columnWBRegId),
                version = Version.valueOf(cursor.getString(columnVersion))
        )
        return wayBill
    }

    private fun createWayBillPositionInfo(cursor: Cursor): WayBillPosition? {
        val columnUuid = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_UUID)
        val columnWayBillUuid = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_WAYBILL_UUID)
        val columnProductIdentity = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PRODUCT_INFO_IDENTITY)
        val columnProductAlcoCode = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val columnPackId = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PACKID)
        val columnQuantity = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_QUANTITY)
        val columnPrice = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PRICE)
        val columnParty = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PARTY)
        val columnIndentity = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_IDENTITY)
        val columnInformARegId = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_INFORM_INFORM_A_REG_ID)
        val columnInformBRegId = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_INFORM_B_REG_ID)
        val columnInformBMarkInfoJson = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_INFORM_B_MARK_INFO_JSON)

        val wayBillPosition = WayBillPosition(
                uuid = UUID.fromString(cursor.getString(columnUuid)),
                wayBillId = UUID.fromString(cursor.getString(columnWayBillUuid)),
                productIdentity = cursor.getString(columnProductIdentity),
                productAlcoCode = cursor.getString(columnProductAlcoCode),
                packId = cursor.getString(columnPackId),
                quantity = BigDecimal(cursor.getLong(columnQuantity)),
                price = BigDecimal(cursor.getLong(columnPrice)),
                party = cursor.getString(columnParty),
                identity = cursor.getString(columnIndentity),
                informARegId = cursor.getString(columnInformARegId),
                informBRegId = cursor.getString(columnInformBRegId),
                informBMarkInfoJson = cursor.getString(columnInformBMarkInfoJson)
        )
        return wayBillPosition
    }
}