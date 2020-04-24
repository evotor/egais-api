package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.ShopCommodity
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.shop_commodity.ShopCommodityContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal

/**
 * Класс для формирования запроса на получение информации о магазинных товарах
 */
class ShopCommodityQuery : FilterBuilder<ShopCommodityQuery, ShopCommodityQuery.SortOrder,
        ShopCommodity>(ShopCommodityContract.URI) {

    /**
     * Количество
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(
            ShopCommodityContract.COLUMN_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Информация о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<ShopCommodityQuery, ShopCommodityQuery.SortOrder, ShopCommodity>())

    override val currentQuery: ShopCommodityQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Количество
         */
        @JvmField
        val quantity = addFieldSorter(ShopCommodityContract.COLUMN_QUANTITY)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<ShopCommodityQuery.SortOrder>())

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<ShopCommodity>): ShopCommodity {
        return createShopCommodity(cursor)
    }

    private fun createShopCommodity(cursor: android.database.Cursor): ShopCommodity {
        return ShopCommodity(
                cursor.getQuantity(ShopCommodityContract.COLUMN_QUANTITY, ShopCommodityContract.COLUMN_QUANTITY_DAL),
                cursor.createProductInfo()
        )
    }
}
