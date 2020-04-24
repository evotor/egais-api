package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actchargeonshop.ActChargeOnShopPosition
import ru.evotor.egais.api.provider.actchargeonshop.ActChargeOnShopPositionContract
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

/**
 * Класс для формирования запроса на получение позиций акта поставки
 */
class ActChargeOnShopPositionQuery : FilterBuilder<ActChargeOnShopPositionQuery, ActChargeOnShopPositionQuery.SortOrder, ActChargeOnShopPosition>(ActChargeOnShopPositionContract.URI) {

    /**
     * Уникальный идентификатор позиции акта
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActChargeOnShopPositionContract.COLUMN_UUID)

    /**
     * Идентификатор акта постановки, содержащего позицию
     */
    @JvmField
    val actChargeOnShopUuid = addFieldFilter<UUID>(ActChargeOnShopPositionContract.COLUMN_ACT_CHARGE_ON_SHOP_UUID)

    /**
     * Идентификатор позиции внутри накладной
     */
    @JvmField
    val identity = addFieldFilter<String>(ActChargeOnShopPositionContract.COLUMN_IDENTITY)

    /**
     * Количество
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(
            ActChargeOnShopPositionContract.COLUMN_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Информация о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<ActChargeOnShopPositionQuery, ActChargeOnShopPositionQuery.SortOrder, ActChargeOnShopPosition>())

    override val currentQuery: ActChargeOnShopPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции акта
         */
        @JvmField
        val uuid = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_UUID)

        /**
         * Идентификатор акта постановки, содержащего позицию
         */
        @JvmField
        val actChargeOnShopUuid = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_ACT_CHARGE_ON_SHOP_UUID)

        /**
         * Идентификатор позиции внутри накладной
         */
        @JvmField
        val identity = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_IDENTITY)

        /**
         * Количество
         */
        @JvmField
        val quantity = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_QUANTITY)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<ActChargeOnShopPositionQuery.SortOrder>())

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActChargeOnShopPosition>): ActChargeOnShopPosition {
        return createActChargeOnShopPosition(cursor)
    }

    private fun createActChargeOnShopPosition(cursor: android.database.Cursor): ActChargeOnShopPosition {
        val columnIndexUuid = cursor.getColumnIndex(ActChargeOnShopPositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActChargeOnShopPositionContract.COLUMN_ACT_CHARGE_ON_SHOP_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActChargeOnShopPositionContract.COLUMN_IDENTITY)

        return ActChargeOnShopPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                cursor.getQuantity(ActChargeOnShopPositionContract.COLUMN_QUANTITY, ActChargeOnShopPositionContract.COLUMN_QUANTITY_DAL),
                cursor.createProductInfo()
        )
    }
}