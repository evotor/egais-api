package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.transfer.TransferFromShopPosition
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.transfer.TransferFromShopPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class TransferFromShopPositionQuery : FilterBuilder<TransferFromShopPositionQuery, TransferFromShopPositionQuery.SortOrder, TransferFromShopPosition>(TransferFromShopPositionContract.URI) {

    /**
     * Уникальный идентификатор документа передачи
     */
    @JvmField
    val transferFromShopUuid = addFieldFilter<UUID>(TransferFromShopPositionContract.COLUMN_TRANSFER_FROM_SHOP_ID)

    /**
     * Идентификатор позиции внутри акта
     */
    @JvmField
    val identity = addFieldFilter<String?>(TransferFromShopPositionContract.COLUMN_IDENTITY)

    /**
     * Регистрационный код продукции
     */
    @JvmField
    val productCode = addFieldFilter<String>(TransferFromShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

    /**
     * Количество
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(
            TransferFromShopPositionContract.COLUMN_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Регистрационный номер раздела справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(TransferFromShopPositionContract.COLUMN_INFORM_F2_REG_ID)

    /**
     * Алкокод информации о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<TransferFromShopPositionQuery, TransferFromShopPositionQuery.SortOrder, TransferFromShopPosition>())

    override val currentQuery: TransferFromShopPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор документа передачи
         */
        @JvmField
        val transferFromShopUuid = addFieldSorter(TransferFromShopPositionContract.COLUMN_TRANSFER_FROM_SHOP_ID)

        /**
         * Идентификатор позиции внутри акта
         */
        @JvmField
        val identity = addFieldSorter(TransferFromShopPositionContract.COLUMN_IDENTITY)

        /**
         * Регистрационный код продукции
         */
        @JvmField
        val productCode = addFieldSorter(TransferFromShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        /**
         * Количество
         */
        @JvmField
        val quantity = addFieldSorter(TransferFromShopPositionContract.COLUMN_QUANTITY)

        /**
         * Регистрационный номер раздела справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(TransferFromShopPositionContract.COLUMN_INFORM_F2_REG_ID)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<TransferFromShopPositionQuery.SortOrder>())

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<TransferFromShopPosition>): TransferFromShopPosition {
        val columnIndexTransferFromShopUuid = cursor.getColumnIndexOrThrow(TransferFromShopPositionContract.COLUMN_TRANSFER_FROM_SHOP_ID)
        val columnIndexIdentity = cursor.getColumnIndexOrThrow(TransferFromShopPositionContract.COLUMN_IDENTITY)
        val columnIndexProductCode = cursor.getColumnIndexOrThrow(TransferFromShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val columnIndexInformF2RegId = cursor.getColumnIndexOrThrow(TransferFromShopPositionContract.COLUMN_INFORM_F2_REG_ID)

        return TransferFromShopPosition(
                UUID.fromString(cursor.getString(columnIndexTransferFromShopUuid)),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexProductCode),
                cursor.getQuantity(TransferFromShopPositionContract.COLUMN_QUANTITY, TransferFromShopPositionContract.COLUMN_QUANTITY_DAL),
                cursor.getString(columnIndexInformF2RegId),
                cursor.createProductInfo()
        )
    }
}