package ru.evotor.egais.api

import android.content.Context
import ru.evotor.egais.api.model.document.waybill.*
import ru.evotor.egais.api.provider.converter.MoneyBigDecimalConverter
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.waybill.WayBillContract
import ru.evotor.egais.api.provider.waybill.WayBillPositionContract
import ru.evotor.query.Cursor
import java.util.*

object WayBillApi {
    @JvmStatic
    fun getWayBillList(context: Context): Cursor<WayBill>? {
        return context.contentResolver.query(WayBillContract.URI, null, null, null, null)
                ?.let {
                    object : Cursor<WayBill>(it) {
                        override fun getValue(): WayBill {
                            return createWayBill(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getWayBillListByDate(context: Context, date: Date): Cursor<WayBill>? {
        return context.contentResolver.query(WayBillContract.URI,
                null, "${WayBillContract.COLUMN_DATE} >= ?", arrayOf(date.toString()), null, null)
                ?.let {
                    object : Cursor<WayBill>(it) {
                        override fun getValue(): WayBill {
                            return createWayBill(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getWayBillByUuid(context: Context, uuid: UUID): WayBill? {
        return context.contentResolver.query(WayBillContract.URI, null, "${WayBillContract.COLUMN_UUID} = ?", arrayOf(uuid.toString()), null)
                ?.let { cursor ->
                    cursor.use {
                        if (cursor.moveToFirst()) {
                            createWayBill(cursor)
                        } else null
                    }
                }
    }

    @JvmStatic
    fun getWayBillPositionListByUuid(context: Context, uuid: UUID): Cursor<WayBillPosition>? {
        return context.contentResolver.query(WayBillPositionContract.URI,
                null, "${WayBillPositionContract.COLUMN_WAYBILL_UUID} = ?", arrayOf(uuid.toString()), null)
                ?.let {
                    object : Cursor<WayBillPosition>(it) {
                        override fun getValue(): WayBillPosition {
                            return createWayBillPosition(this)
                        }
                    }
                }
    }

    private fun createWayBill(cursor: android.database.Cursor): WayBill {
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
        val columnStatus = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_STATUS)
        val columnResolution = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_RESOLUTION)
        val columnTtnInformBRegId = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TTN_INFORM_B_REG_UUID)
        val columnWBRegId = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_WB_REG_ID)

        val transportType = cursor.getString(columnTransportType)
        val transportCompany = cursor.getString(columnTransportCompany)
        val transportCar = cursor.getString(columnTransportCar)
        val transportTrailer = cursor.getString(columnTransportTrailer)
        val transportCustomer = cursor.getString(columnTransportCustomer)
        val transportDriver = cursor.getString(columnTransportDriver)
        val transportLoadPoint = cursor.getString(columnTransportLoadPoint)
        val transportUnloadPoint = cursor.getString(columnTransportUnloadPoint)
        val transportRedirect = cursor.getString(columnTransportRedirect)
        val transportForwarder = cursor.getString(columnTransportForwarder)

        val transport = if (
                transportType != null ||
                transportCompany != null ||
                transportCar != null ||
                transportTrailer != null ||
                transportCustomer != null ||
                transportDriver != null ||
                transportLoadPoint != null ||
                transportUnloadPoint != null ||
                transportRedirect != null ||
                transportForwarder != null
        ) {
            Transport(
                    type = transportType,
                    company = transportCompany,
                    car = transportCar,
                    trailer = transportTrailer,
                    customer = transportCustomer,
                    driver = transportDriver,
                    loadpoint = transportLoadPoint,
                    unloadpoint = transportUnloadPoint,
                    redirect = transportRedirect,
                    forwarder = transportForwarder
            )
        } else null

        return WayBill(
                uuid = UUID.fromString(cursor.getString(columnUuid)),
                docOwner = cursor.getString(columnDocOwner),
                identity = cursor.getString(columnIdentity),
                type = Type.valueOf(cursor.getString(columnType)),
                unitType = cursor.getString(columnUnitType)?.let { UnitType.valueOf(it) },
                number = cursor.getString(columnNumber),
                date = Date(cursor.getString(columnDate)),
                shippingDate = Date(cursor.getString(columnShippingDate)),
                transport = transport,
                shipperId = cursor.getString(columnShipperId),
                consigneeId = cursor.getString(columnConsigneeId),
                supplierId = cursor.getString(columnSupplierID),
                base = cursor.getString(columnBase),
                note = cursor.getString(columnNote),
                status = Status.valueOf(cursor.getString(columnStatus)),
                resolution = Resolution.valueOf(cursor.getString(columnResolution)),
                ttnInformBRegUuid = cursor.getString(columnTtnInformBRegId)?.let { UUID.fromString(it) },
                wbRegId = cursor.getString(columnWBRegId)
        )
    }

    private fun createWayBillPosition(cursor: android.database.Cursor): WayBillPosition {
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

        val wayBillPosition = WayBillPosition(
                uuid = UUID.fromString(cursor.getString(columnUuid)),
                wayBillUuid = UUID.fromString(cursor.getString(columnWayBillUuid)),
                productIdentity = cursor.getString(columnProductIdentity),
                productAlcoCode = cursor.getString(columnProductAlcoCode),
                packId = cursor.getString(columnPackId),
                quantity = QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnQuantity)),
                price = MoneyBigDecimalConverter.toBigDecimal(cursor.getLong(columnPrice)),
                party = cursor.getString(columnParty),
                identity = cursor.getString(columnIndentity),
                informARegId = cursor.getString(columnInformARegId),
                informBRegId = cursor.getString(columnInformBRegId)
        )
        return wayBillPosition
    }
}