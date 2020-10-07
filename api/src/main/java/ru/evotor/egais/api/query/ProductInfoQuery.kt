package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.ProductInfo
import ru.evotor.egais.api.model.dictionary.ProductType
import ru.evotor.egais.api.provider.dictionary.ProductInfoContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder

/**
 * Класс для формирования запроса на получение информации о товарах
 */
class ProductInfoQuery : FilterBuilder<ProductInfoQuery, ProductInfoQuery.SortOrder, ProductInfo>(ProductInfoContract.URI) {

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

    /**
     * Тип поставки (упакованная или нет)
     */
    @JvmField
    val unitType = addFieldFilter<String?>(ProductInfoContract.COLUMN_UNIT_TYPE)

    override val currentQuery: ProductInfoQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Тип продукции (АП | ССП | ССНП | Спирт).
         */
        @JvmField
        val type = addFieldSorter(ProductInfoContract.COLUMN_TYPE)

        /**
         * Наименование продукции полное.
         */
        @JvmField
        val fullName = addFieldSorter(ProductInfoContract.COLUMN_FULL_NAME_UPPER_CASE)

        /**
         * Наименование продукции краткое.
         */
        @JvmField
        val shortName = addFieldSorter(ProductInfoContract.COLUMN_SHORT_NAME_UPPER_CASE)

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

        /**
         * Тип поставки (упакованная или нет)
         */
        @JvmField
        val unitType = addFieldSorter(ProductInfoContract.COLUMN_UNIT_TYPE)
        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ProductInfo>): ProductInfo {
        return cursor.createProductInfo()
    }
}