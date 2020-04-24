package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.ProductRest
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.dictionary.ProductRestContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal

class ProductRestQuery : FilterBuilder<ProductRestQuery, ProductRestQuery.SortOrder, ProductRest>(ProductRestContract.URI) {

    /**
     * Количество продукции на складе
     */
    @JvmField
    val stockQuantity = addFieldFilter<BigDecimal, Long>(
            ProductRestContract.COLUMN_STOCK_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Количество продукции в торговом зале
     */
    @JvmField
    val shopQuantity = addFieldFilter<BigDecimal, Long>(
            ProductRestContract.COLUMN_SHOP_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Общее количество продукции в торговом зале
     */
    @JvmField
    val totalQuantity = addFieldFilter<BigDecimal, Long>(
            ProductRestContract.COLUMN_TOTAL_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Информация о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<ProductRestQuery, ProductRestQuery.SortOrder, ProductRest>())

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        /**
         * Количество продукции на складе
         */
        @JvmField
        val stockQuantity = addFieldSorter(ProductRestContract.COLUMN_STOCK_QUANTITY)

        /**
         * Количество продукции в торговом зале
         */
        @JvmField
        val shopQuantity = addFieldSorter(ProductRestContract.COLUMN_SHOP_QUANTITY)

        /**
         * Общее количество продукции в торговом зале
         */
        @JvmField
        val totalQuantity = addFieldSorter(ProductRestContract.COLUMN_TOTAL_QUANTITY)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<ProductRestQuery.SortOrder>())

        override val currentSortOrder: SortOrder
            get() = this

    }

    override val currentQuery: ProductRestQuery
        get() = this

    override fun getValue(cursor: Cursor<ProductRest>): ProductRest {
        val productInfo = cursor.createProductInfo()
        return ProductRest(
                productInfo,
                cursor.getQuantity(ProductRestContract.COLUMN_STOCK_QUANTITY, ProductRestContract.COLUMN_STOCK_QUANTITY_DAL),
                cursor.getQuantity(ProductRestContract.COLUMN_SHOP_QUANTITY, ProductRestContract.COLUMN_SHOP_QUANTITY_DAL)
        )
    }
}