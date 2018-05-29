package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.waybill.TtnInformF2Reg
import ru.evotor.egais.api.model.document.waybill.TtnInformF2RegStatus
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.waybill.TtnInformF2RegContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс формирования запроса на получение справок 2 к ТТН
 */
class TtnInformF2RegQuery : FilterBuilder<TtnInformF2RegQuery, TtnInformF2RegQuery.SortOrder, TtnInformF2Reg>(TtnInformF2RegContract.URI) {

    /**
     * Уникальный идентификатор справки 2 информации о предыдущих отгрузках
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(TtnInformF2RegContract.COLUMN_UUID)

    /**
     * Кто подает документы
     */
    @JvmField
    val owner = addFieldFilter<String>(TtnInformF2RegContract.COLUMN_OWNER)

    /**
     * ИД накладной(клиентский, исходной накладной, если заполнялся)
     */
    @JvmField
    val identity = addFieldFilter<String>(TtnInformF2RegContract.COLUMN_IDENTITY)

    /**
     * ИД накладной в системе (присвоенный)
     */
    @JvmField
    val wbRegId = addFieldFilter<String>(TtnInformF2RegContract.COLUMN_WB_REG_ID)

    /**
     * Номер фиксации накладной(отгрузки) в ЕГАИС
     */
    @JvmField
    val egaisFixNumber = addFieldFilter<String>(TtnInformF2RegContract.COLUMN_EGAIS_FIX_NUMBER)

    /**
     * Дата составления накладной(отгрузки) в ЕГАИС
     */
    @JvmField
    val egaisFixDate = addFieldFilter<Date, String>(TtnInformF2RegContract.COLUMN_EGAIS_FIX_DATE, { DateConverter.toString(it) })

    /**
     * Номер накладной
     */
    @JvmField
    val wbNumber = addFieldFilter<String>(TtnInformF2RegContract.COLUMN_WB_NUMBER)

    /**
     * Дата составления накладной
     */
    @JvmField
    val wbDate = addFieldFilter<Date, String>(TtnInformF2RegContract.COLUMN_WB_DATE, { DateConverter.toString(it) })

    /**
     * Грузоотправитель
     */
    @JvmField
    val shipper = addFieldFilter<String>(TtnInformF2RegContract.COLUMN_SHIPPER_ID)

    /**
     * Грузополучатель
     */
    @JvmField
    val consignee = addFieldFilter<String>(TtnInformF2RegContract.COLUMN_CONSIGNEE_ID)

    /**
     * Поставщик
     */
    @JvmField
    val supplier = addFieldFilter<String>(TtnInformF2RegContract.COLUMN_SUPPLIER_ID)

    /**
     * Уникальный идентификатор ТТН
     */
    @JvmField
    val wayBillUuid = addFieldFilter<UUID>(TtnInformF2RegContract.COLUMN_WAY_BILL_ID)

    /**
     * Текущий статус справки 2
     */
    @JvmField
    val status = addFieldFilter<TtnInformF2RegStatus, String>(TtnInformF2RegContract.COLUMN_STATUS, { it.toString() })

    override val currentQuery: TtnInformF2RegQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор справки 2 информации о предыдущих отгрузках
         */
        @JvmField
        val uuid = addFieldSorter(TtnInformF2RegContract.COLUMN_UUID)

        /**
         * Кто подает документы
         */
        @JvmField
        val owner = addFieldSorter(TtnInformF2RegContract.COLUMN_OWNER)

        /**
         * ИД накладной(клиентский, исходной накладной, если заполнялся)
         */
        @JvmField
        val identity = addFieldSorter(TtnInformF2RegContract.COLUMN_IDENTITY)

        /**
         * ИД накладной в системе (присвоенный)
         */
        @JvmField
        val wbRegId = addFieldSorter(TtnInformF2RegContract.COLUMN_WB_REG_ID)

        /**
         * Номер фиксации накладной(отгрузки) в ЕГАИС
         */
        @JvmField
        val egaisFixNumber = addFieldSorter(TtnInformF2RegContract.COLUMN_EGAIS_FIX_NUMBER)

        /**
         * Дата составления накладной(отгрузки) в ЕГАИС
         */
        @JvmField
        val egaisFixDate = addFieldSorter(TtnInformF2RegContract.COLUMN_EGAIS_FIX_DATE)

        /**
         * Номер накладной
         */
        @JvmField
        val wbNumber = addFieldSorter(TtnInformF2RegContract.COLUMN_WB_NUMBER)

        /**
         * Дата составления накладной
         */
        @JvmField
        val wbDate = addFieldSorter(TtnInformF2RegContract.COLUMN_WB_DATE)

        /**
         * Грузоотправитель
         */
        @JvmField
        val shipper = addFieldSorter(TtnInformF2RegContract.COLUMN_SHIPPER_ID)

        /**
         * Грузополучатель
         */
        @JvmField
        val consignee = addFieldSorter(TtnInformF2RegContract.COLUMN_CONSIGNEE_ID)

        /**
         * Поставщик
         */
        @JvmField
        val supplier = addFieldSorter(TtnInformF2RegContract.COLUMN_SUPPLIER_ID)

        /**
         * Уникальный идентификатор ТТН
         */
        @JvmField
        val wayBillUuid = addFieldSorter(TtnInformF2RegContract.COLUMN_WAY_BILL_ID)

        /**
         * Текущий статус справки 2
         */
        @JvmField
        val status = addFieldSorter(TtnInformF2RegContract.COLUMN_STATUS)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<TtnInformF2Reg>): TtnInformF2Reg {
        return createTtnInformF2Reg(cursor)
    }

    private fun createTtnInformF2Reg(cursor: Cursor<TtnInformF2Reg>): TtnInformF2Reg {
        val columnUuid = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_UUID)
        val columnOwner = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_OWNER)
        val columnIdentity = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_IDENTITY)
        val columnWbRegId = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_WB_REG_ID)
        val columnEgaisFixNumber = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_EGAIS_FIX_NUMBER)
        val columnEgaisFixDate = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_EGAIS_FIX_DATE)
        val columnWbNumber = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_WB_NUMBER)
        val columnWbDate = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_WB_DATE)
        val columnShipperId = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_SHIPPER_ID)
        val columnConsigneeId = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_CONSIGNEE_ID)
        val columnSupplierId = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_SUPPLIER_ID)
        val columnWayBillId = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_WAY_BILL_ID)
        val columnStatus = cursor.getColumnIndexOrThrow(TtnInformF2RegContract.COLUMN_STATUS)

        return TtnInformF2Reg(
                UUID.fromString(cursor.getString(columnUuid)),
                cursor.getString(columnOwner),
                cursor.getString(columnIdentity),
                cursor.getString(columnWbRegId),
                cursor.getString(columnEgaisFixNumber),
                cursor.getString(columnEgaisFixDate)?.let { DateConverter.toDate(it) },
                cursor.getString(columnWbNumber),
                cursor.getString(columnWbDate)?.let { DateConverter.toDate(it) },
                cursor.getString(columnShipperId),
                cursor.getString(columnConsigneeId),
                cursor.getString(columnSupplierId),
                cursor.getString(columnWayBillId)?.let { UUID.fromString(it) },
                TtnInformF2RegStatus.valueOf(cursor.getString(columnStatus))
        )
    }
}