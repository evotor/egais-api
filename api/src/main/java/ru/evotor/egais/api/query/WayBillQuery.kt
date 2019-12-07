package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.dictionary.UnitType
import ru.evotor.egais.api.model.document.Direction
import ru.evotor.egais.api.model.document.waybill.*
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.waybill.WayBillContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение ТТН
 */
class WayBillQuery : FilterBuilder<WayBillQuery, WayBillQuery.SortOrder, WayBill>(WayBillContract.URI) {

    /**
     * UUID накладной.
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(WayBillContract.COLUMN_UUID)

    /**
     * Отправитель накладной.
     */
    @JvmField
    val docOwner = addFieldFilter<String>(WayBillContract.COLUMN_OWNER)

    /**
     * Идентификатор накладной (клиентский, к заполнению необязательный).
     */
    @JvmField
    val identity = addFieldFilter<String?>(WayBillContract.COLUMN_IDENTITY)

    /**
     * Тип накладной.
     */
    @JvmField
    val type = addFieldFilter<Type>(WayBillContract.COLUMN_TYPE)

    /**
     * Тип упаковки.
     */
    @Deprecated("Use unitType of each position ProductInfo")
    @JvmField
    val unitType = addFieldFilter<UnitType?>(WayBillContract.COLUMN_UNIT_TYPE)

    /**
     * Номер документа.
     */
    @JvmField
    val number = addFieldFilter<String>(WayBillContract.COLUMN_NUMBER)

    /**
     * Дата составления.
     */
    @JvmField
    val date = addFieldFilter<Date, String>(WayBillContract.COLUMN_DATE, { DateConverter.toString(it) })

    /**
     * Дата отгрузки продукции.
     */
    @JvmField
    val shippingDate = addFieldFilter<Date, String>(WayBillContract.COLUMN_SHIPPING_DATE, { DateConverter.toString(it) })

    /**
     * Грузоотправитель.
     */
    @JvmField
    val shipperId = addFieldFilter<String>(WayBillContract.COLUMN_SHIPPER_ID)

    /**
     * Грузополучатель.
     */
    @JvmField
    val consigneeId = addFieldFilter<String>(WayBillContract.COLUMN_CONSIGNEE_ID)

    /**
     * Поставщик.
     */
    @JvmField
    val supplierId = addFieldFilter<String?>(WayBillContract.COLUMN_SUPPLIER_ID)

    /**
     * Основание.
     */
    @JvmField
    val base = addFieldFilter<String?>(WayBillContract.COLUMN_BASE)

    /**
     * Заметки.
     */
    @JvmField
    val note = addFieldFilter<String?>(WayBillContract.COLUMN_NOTE)

    /**
     * Текущий статус накладной.
     */
    @JvmField
    val status = addFieldFilter<Status>(WayBillContract.COLUMN_STATUS)

    /**
     * Резолюция накладной.
     */
    @JvmField
    val resolution = addFieldFilter<Resolution>(WayBillContract.COLUMN_RESOLUTION)

    /**
     * uuid справки 2 для накладной.
     */
    @JvmField
    val ttnInformF2RegUuid = addFieldFilter<UUID?>(WayBillContract.COLUMN_TTN_INFORM_F2_REG_UUID)

    /**
     * ИД накладной в системе ЕГАИС.
     */
    @JvmField
    val wbRegId = addFieldFilter<String?>(WayBillContract.COLUMN_WB_REG_ID)

    /**
     * Направление документа в представлении УТМ (входящий/исходящий)
     */
    @JvmField
    val direction = addFieldFilter<Direction>(UtmDocumentContract.COLUMN_DIRECTION)

    /**
     * Версия протокола ЕГАИС, по которому отправлена накладная
     */
    @JvmField
    val version = addFieldFilter<Version>(WayBillContract.COLUMN_VERSION)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    override val currentQuery: WayBillQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * UUID накладной.
         */
        @JvmField
        val uuid = addFieldSorter(WayBillContract.COLUMN_UUID)

        /**
         * Отправитель накладной.
         */
        @JvmField
        val docOwner = addFieldSorter(WayBillContract.COLUMN_OWNER)

        /**
         * Идентификатор накладной (клиентский, к заполнению необязательный).
         */
        @JvmField
        val identity = addFieldSorter(WayBillContract.COLUMN_IDENTITY)

        /**
         * Тип накладной.
         */
        @JvmField
        val type = addFieldSorter(WayBillContract.COLUMN_TYPE)

        /**
         * Тип упаковки.
         */
        @Deprecated("Use unitType of each position ProductInfo")
        @JvmField
        val unitType = addFieldSorter(WayBillContract.COLUMN_UNIT_TYPE)

        /**
         * Номер документа.
         */
        @JvmField
        val number = addFieldSorter(WayBillContract.COLUMN_NUMBER)

        /**
         * Дата составления.
         */
        @JvmField
        val date = addFieldSorter(WayBillContract.COLUMN_DATE)

        /**
         * Дата отгрузки продукции.
         */
        @JvmField
        val shippingDate = addFieldSorter(WayBillContract.COLUMN_SHIPPING_DATE)

        /**
         * Грузоотправитель.
         */
        @JvmField
        val shipperId = addFieldSorter(WayBillContract.COLUMN_SHIPPER_ID)

        /**
         * Грузополучатель.
         */
        @JvmField
        val consigneeId = addFieldSorter(WayBillContract.COLUMN_CONSIGNEE_ID)

        /**
         * Поставщик.
         */
        @JvmField
        val supplierId = addFieldSorter(WayBillContract.COLUMN_SUPPLIER_ID)

        /**
         * Основание.
         */
        @JvmField
        val base = addFieldSorter(WayBillContract.COLUMN_BASE)

        /**
         * Заметки.
         */
        @JvmField
        val note = addFieldSorter(WayBillContract.COLUMN_NOTE)

        /**
         * Текущий статус накладной.
         */
        @JvmField
        val status = addFieldSorter(WayBillContract.COLUMN_STATUS)

        /**
         * Резолюция накладной.
         */
        @JvmField
        val resolution = addFieldSorter(WayBillContract.COLUMN_RESOLUTION)

        /**
         * uuid справки 2 для накладной.
         */
        @JvmField
        val ttnInformF2RegUuid = addFieldSorter(WayBillContract.COLUMN_TTN_INFORM_F2_REG_UUID)

        /**
         * ИД накладной в системе ЕГАИС.
         */
        @JvmField
        val wbRegId = addFieldSorter(WayBillContract.COLUMN_WB_REG_ID)

        /**
         * Направление документа в представлении УТМ (входящий/исходящий)
         */
        @JvmField
        val direction = addFieldSorter(UtmDocumentContract.COLUMN_DIRECTION)

        /**
         * Версия протокола ЕГАИС, по которому отправлена накладная
         */
        @JvmField
        val version = addFieldSorter(WayBillContract.COLUMN_VERSION)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBill>): WayBill {
        return createWayBill(cursor)
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
        val columnTtnInformF2RegId = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_TTN_INFORM_F2_REG_UUID)
        val columnWBRegId = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_WB_REG_ID)
        val columnDirection = cursor.getColumnIndexOrThrow(UtmDocumentContract.COLUMN_DIRECTION)
        val columnVersion = cursor.getColumnIndexOrThrow(WayBillContract.COLUMN_VERSION)
        val columnReplyId = cursor.getColumnIndexOrThrow(UtmDocumentContract.COLUMN_REPLY_ID)

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
                date = DateConverter.toDate(cursor.getString(columnDate)),
                shippingDate = DateConverter.toDate(cursor.getString(columnShippingDate)),
                transport = transport,
                shipperId = cursor.getString(columnShipperId),
                consigneeId = cursor.getString(columnConsigneeId),
                supplierId = cursor.getString(columnSupplierID),
                base = cursor.getString(columnBase),
                note = cursor.getString(columnNote),
                status = Status.valueOf(cursor.getString(columnStatus)),
                resolution = Resolution.valueOf(cursor.getString(columnResolution)),
                ttnInformF2RegUuid = cursor.getString(columnTtnInformF2RegId)?.let { UUID.fromString(it) },
                wbRegId = cursor.getString(columnWBRegId),
                direction = Direction.valueOf(cursor.getString(columnDirection)),
                version = Version.valueOf(cursor.getString(columnVersion)),
                replyId = cursor.getString(columnReplyId)
        )
    }
}