package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.ProductRest
import ru.evotor.egais.api.model.dictionary.ProductType
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.dictionary.ProductInfoContract
import ru.evotor.egais.api.provider.dictionary.ProductRestContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal

class ProductRestQuery : FilterBuilder<ProductRestQuery, ProductRestQuery.SortOrder, ProductRest>(ProductRestContract.URI) {

    /**
     * Количество продукции на складе
     */
    @JvmField
    val stockQuantity = addFieldFilter<BigDecimal, Long>(ProductRestContract.COLUMN_STOCK_QUANTITY, { QuantityBigDecimalConverter.toLong(it)})

    /**
     * Количество продукции в торговом зале
     */
    @JvmField
    val shopQuantity = addFieldFilter<BigDecimal, Long>(ProductRestContract.COLUMN_SHOP_QUANTITY, { QuantityBigDecimalConverter.toLong(it)})

    /**
     * Общее количество продукции в торговом зале
     */
    @JvmField
    val totalQuantity = addFieldFilter<BigDecimal, Long>(ProductRestContract.COLUMN_TOTAL_QUANTITY, { QuantityBigDecimalConverter.toLong(it)})

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

        override val currentSortOrder: SortOrder
            get() = this

        /**
         * Тип продукции (АП | ССП | ССНП | Спирт).
         */
        @JvmField
        val type = addFieldSorter(ProductInfoContract.COLUMN_TYPE)

        /**
         * Наименование продукции полное.
         */
        @JvmField
        val fullName = addFieldSorter(ProductInfoContract.COLUMN_FULL_NAME)

        /**
         * Наименование продукции краткое.
         */
        @JvmField
        val shortName = addFieldSorter(ProductInfoContract.COLUMN_SHORT_NAME)

        /**
         * Код продукции согласно ЕГАИС.
         */
        @JvmField
        val alcCode = addFieldSorter(ProductInfoContract.COLUMN_ALC_CODE)

        /**
         * Емкость упаковки продукции согласно ЕГАИС.
         */
        @JvmField
        val capacity = addFieldSorter(ProductInfoContract.COLUMN_CAPACITY)

        /**
         * Содержание этилового спирта, %.
         */
        @JvmField
        val alcVolume = addFieldSorter(ProductInfoContract.COLUMN_ALC_VOLUME)

        /**
         * Производитель.
         */
        @JvmField
        val producerId = addFieldSorter(ProductInfoContract.COLUMN_PRODUCER_CLIENT_REG_ID)

        /**
         * Импортер.
         */
        @JvmField
        val importerId = addFieldSorter(ProductInfoContract.COLUMN_IMPORTER_CLIENT_REG_ID)

        /**
         * Код вида продукции.
         */
        @JvmField
        val productVCode = addFieldSorter(ProductInfoContract.COLUMN_PRODUCT_V_CODE)

    }

    /**
     * Тип продукции (АП | ССП | ССНП | Спирт).
     */
    @JvmField
    val type = addFieldFilter<ProductType>(ProductInfoContract.COLUMN_TYPE)

    /**
     * Наименование продукции полное.
     */
    @JvmField
    val fullName = addFieldFilter<String?>(ProductInfoContract.COLUMN_FULL_NAME_UPPER_CASE)

    /**
     * Наименование продукции краткое.
     */
    @JvmField
    val shortName = addFieldFilter<String?>(ProductInfoContract.COLUMN_SHORT_NAME_UPPER_CASE)

    /**
     * Код продукции согласно ЕГАИС.
     */
    @JvmField
    val alcCode = addFieldFilter<String?>(ProductInfoContract.COLUMN_ALC_CODE)

    /**
     * Емкость упаковки продукции согласно ЕГАИС.
     */
    @JvmField
    val capacity = addFieldFilter<String?>(ProductInfoContract.COLUMN_CAPACITY)

    /**
     * Содержание этилового спирта, %.
     */
    @JvmField
    val alcVolume = addFieldFilter<String?>(ProductInfoContract.COLUMN_ALC_VOLUME)

    /**
     * Производитель.
     */
    @JvmField
    val producerId = addFieldFilter<String?>(ProductInfoContract.COLUMN_PRODUCER_CLIENT_REG_ID)

    /**
     * Импортер.
     */
    @JvmField
    val importerId = addFieldFilter<String?>(ProductInfoContract.COLUMN_IMPORTER_CLIENT_REG_ID)

    /**
     * Код вида продукции.
     */
    @JvmField
    val productVCode = addFieldFilter<String?>(ProductInfoContract.COLUMN_PRODUCT_V_CODE)

    override val currentQuery: ProductRestQuery
        get() = this

    override fun getValue(cursor: Cursor<ProductRest>): ProductRest {
        val productInfo = cursor.createProductInfo()
        val columnStockQuantity = cursor.getColumnIndex(ProductRestContract.COLUMN_STOCK_QUANTITY)
        val columnShopQuantity = cursor.getColumnIndex(ProductRestContract.COLUMN_SHOP_QUANTITY)
        return ProductRest(
                productInfo,
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnStockQuantity)),
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnShopQuantity))
        )
    }
}