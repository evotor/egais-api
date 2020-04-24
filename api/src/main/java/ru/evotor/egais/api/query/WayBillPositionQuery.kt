package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.waybill.WayBillPosition
import ru.evotor.egais.api.provider.converter.MoneyBigDecimalConverter
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.waybill.WayBillPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

/**
 * Класс для формирования запроса на получение позиций ТТН
 */
class WayBillPositionQuery : FilterBuilder<WayBillPositionQuery, WayBillPositionQuery.SortOrder, WayBillPosition>(WayBillPositionContract.URI) {

    /**
     * UUID позиции накладной.
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(WayBillPositionContract.COLUMN_UUID)

    /**
     * UUID накладной.
     */
    @JvmField
    val wayBillUuid = addFieldFilter<UUID>(WayBillPositionContract.COLUMN_WAYBILL_UUID)

    /**
     * Идентификатор внутри файла.
     */
    @JvmField
    val productIdentity = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PRODUCT_INFO_IDENTITY)

    /**
     * Алко код продукции.
     */
    @JvmField
    val productAlcoCode = addFieldFilter<String>(WayBillPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

    /**
     * Идентификатор упаковки.
     */
    @JvmField
    val packId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PACKID)

    /**
     * Количество.
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(
            WayBillPositionContract.COLUMN_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Цена за единицу товара.
     */
    @JvmField
    val price = addFieldFilter<BigDecimal, Long>(
            WayBillPositionContract.COLUMN_PRICE,
            { MoneyBigDecimalConverter.toLong(it) }
    )

    /**
     * Номер партии.
     */
    @JvmField
    val party = addFieldFilter<String?>(WayBillPositionContract.COLUMN_PARTY)

    /**
     * Идентификатор позиции внутри накладной.
     */
    @JvmField
    val identity = addFieldFilter<String?>(WayBillPositionContract.COLUMN_IDENTITY)

    /**
     * Справка 1. Не может быть null
     */
    @JvmField
    val informF1RegId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_INFORM_INFORM_F1_REG_ID)

    /**
     * Регистрационный номер раздела справки 2, по которому продукция была получена отправителем.
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(WayBillPositionContract.COLUMN_INFORM_F2_REG_ID)

    /**
     * Информация о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<WayBillPositionQuery, WayBillPositionQuery.SortOrder, WayBillPosition>())

    override val currentQuery: WayBillPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * UUID позиции накладной.
         */
        @JvmField
        val uuid = addFieldSorter(WayBillPositionContract.COLUMN_UUID)

        /**
         * UUID накладной.
         */
        @JvmField
        val wayBillUuid = addFieldSorter(WayBillPositionContract.COLUMN_WAYBILL_UUID)

        /**
         * Идентификатор внутри файла.
         */
        @JvmField
        val productIdentity = addFieldSorter(WayBillPositionContract.COLUMN_PRODUCT_INFO_IDENTITY)

        /**
         * Алко код продукции.
         */
        @JvmField
        val productAlcoCode = addFieldSorter(WayBillPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        /**
         * Идентификатор упаковки.
         */
        @JvmField
        val packId = addFieldSorter(WayBillPositionContract.COLUMN_PACKID)

        /**
         * Количество.
         */
        @JvmField
        val quantity = addFieldSorter(WayBillPositionContract.COLUMN_QUANTITY)

        /**
         * Цена за единицу товара.
         */
        @JvmField
        val price = addFieldSorter(WayBillPositionContract.COLUMN_PRICE)

        /**
         * Номер партии.
         */
        @JvmField
        val party = addFieldSorter(WayBillPositionContract.COLUMN_PARTY)

        /**
         * Идентификатор позиции внутри накладной.
         */
        @JvmField
        val identity = addFieldSorter(WayBillPositionContract.COLUMN_IDENTITY)

        /**
         * Справка 1. Не может быть null
         */
        @JvmField
        val informF1RegId = addFieldSorter(WayBillPositionContract.COLUMN_INFORM_INFORM_F1_REG_ID)

        /**
         * Регистрационный номер раздела справки 2, по которому продукция была получена отправителем.
         */
        @JvmField
        val informF2RegId = addFieldSorter(WayBillPositionContract.COLUMN_INFORM_F2_REG_ID)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<WayBillPositionQuery.SortOrder>())

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBillPosition>): WayBillPosition {
        return createWayBillPosition(cursor)
    }

    private fun createWayBillPosition(cursor: android.database.Cursor): WayBillPosition {
        val columnUuid = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_UUID)
        val columnWayBillUuid = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_WAYBILL_UUID)
        val columnProductIdentity = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PRODUCT_INFO_IDENTITY)
        val columnPackId = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PACKID)
        val columnPrice = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PRICE)
        val columnParty = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_PARTY)
        val columnIdentity = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_IDENTITY)
        val columnInformF1RegId = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_INFORM_INFORM_F1_REG_ID)
        val columnInformF2RegId = cursor.getColumnIndexOrThrow(WayBillPositionContract.COLUMN_INFORM_F2_REG_ID)
        return WayBillPosition(
                uuid = UUID.fromString(cursor.getString(columnUuid)),
                wayBillUuid = UUID.fromString(cursor.getString(columnWayBillUuid)),
                productIdentity = cursor.getString(columnProductIdentity),
                productInfo = cursor.createProductInfo(),
                packId = cursor.getString(columnPackId),
                quantity = cursor.getQuantity(WayBillPositionContract.COLUMN_QUANTITY, WayBillPositionContract.COLUMN_QUANTITY_DAL),
                price = MoneyBigDecimalConverter.toBigDecimal(cursor.getLong(columnPrice)),
                party = cursor.getString(columnParty),
                identity = cursor.getString(columnIdentity),
                informF1RegId = cursor.getString(columnInformF1RegId),
                informF2RegId = cursor.getString(columnInformF2RegId)
        )
    }
}