package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.transfer.TransferToShopPosition
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.transfer.TransferToShopPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class TransferToShopPositionQuery : FilterBuilder<TransferToShopPositionQuery, TransferToShopPositionQuery.SortOrder, TransferToShopPosition>(TransferToShopPositionContract.URI) {

    /**
     * Уникальный идентификатор документа передачи
     */
    @JvmField
    val transferToShopUuid = addFieldFilter<UUID>(TransferToShopPositionContract.COLUMN_TRANSFER_TO_SHOP_ID)

    /**
     * Идентификатор позиции внутри акта
     */
    @JvmField
    val identity = addFieldFilter<String?>(TransferToShopPositionContract.COLUMN_IDENTITY)

    /**
     * Регистрационный код продукции
     */
    @JvmField
    val productCode = addFieldFilter<String>(TransferToShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

    /**
     * Количество
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(
            TransferToShopPositionContract.COLUMN_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Регистрационный номер раздела справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(TransferToShopPositionContract.COLUMN_INFORM_F2_REG_ID)

    /**
     * Информация о марках в формате JSON
     */
    @JvmField
    val informF2MarkInfoJson = addFieldFilter<String?>(TransferToShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)

    /**
     * Алкокод информации о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter())

    override val currentQuery: TransferToShopPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор документа передачи
         */
        @JvmField
        val transferToShopUuid = addFieldSorter(TransferToShopPositionContract.COLUMN_TRANSFER_TO_SHOP_ID)

        /**
         * Идентификатор позиции внутри акта
         */
        @JvmField
        val identity = addFieldSorter(TransferToShopPositionContract.COLUMN_IDENTITY)

        /**
         * Регистрационный код продукции
         */
        @JvmField
        val productCode = addFieldSorter(TransferToShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        /**
         * Количество
         */
        @JvmField
        val quantity = addFieldSorter(TransferToShopPositionContract.COLUMN_QUANTITY)

        /**
         * Регистрационный номер раздела справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(TransferToShopPositionContract.COLUMN_INFORM_F2_REG_ID)

        /**
         * Информация о марках в формате JSON
         */
        @JvmField
        val informF2MarkInfoJson = addFieldSorter(TransferToShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<TransferToShopPositionQuery.SortOrder>())

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<TransferToShopPosition>): TransferToShopPosition {
        val columnIndexTransferToShopUuid = cursor.getColumnIndexOrThrow(TransferToShopPositionContract.COLUMN_TRANSFER_TO_SHOP_ID)
        val columnIndexIdentity = cursor.getColumnIndexOrThrow(TransferToShopPositionContract.COLUMN_IDENTITY)
        val columnIndexProductCode = cursor.getColumnIndexOrThrow(TransferToShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val columnIndexInformF2RegId = cursor.getColumnIndexOrThrow(TransferToShopPositionContract.COLUMN_INFORM_F2_REG_ID)
        val columnIndexInformF2MarkInfoJson = cursor.getColumnIndexOrThrow(TransferToShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)

        return TransferToShopPosition(
                UUID.fromString(cursor.getString(columnIndexTransferToShopUuid)),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexProductCode),
                cursor.getQuantity(TransferToShopPositionContract.COLUMN_QUANTITY, TransferToShopPositionContract.COLUMN_QUANTITY_DAL),
                cursor.getString(columnIndexInformF2RegId),
                cursor.getString(columnIndexInformF2MarkInfoJson),
                cursor.createProductInfo()
        )
    }
}