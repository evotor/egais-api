package ru.evotor.egais.api.query

import ru.evotor.egais.api.DictionaryApi
import ru.evotor.egais.api.model.dictionary.ProductInfo
import ru.evotor.egais.api.model.dictionary.ProductType
import ru.evotor.egais.api.provider.dictionary.ProductInfoContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder

class ProductInfoQuery : FilterBuilder<ProductInfoQuery, ProductInfoQuery.SortOrder, ProductInfo>(ProductInfoContract.URI) {

    val type = addFieldFilter<ProductType>(ProductInfoContract.COLUMN_TYPE)
    val fullName = addFieldFilter<String?>(ProductInfoContract.COLUMN_FULL_NAME)
    val shortName = addFieldFilter<String?>(ProductInfoContract.COLUMN_SHORT_NAME)
    val alcCode = addFieldFilter<String?>(ProductInfoContract.COLUMN_ALC_CODE)
    val capacity = addFieldFilter<String?>(ProductInfoContract.COLUMN_CAPACITY)
    val alcVolume = addFieldFilter<String?>(ProductInfoContract.COLUMN_ALC_VOLUME)
    val producerId = addFieldFilter<String?>(ProductInfoContract.COLUMN_PRODUCER_CLIENT_REG_ID)
    val importerId = addFieldFilter<String?>(ProductInfoContract.COLUMN_IMPORTER_CLIENT_REG_ID)
    val productVCode = addFieldFilter<String?>(ProductInfoContract.COLUMN_PRODUCT_V_CODE)

    override val currentQuery: ProductInfoQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val type = addFieldSorter(ProductInfoContract.COLUMN_TYPE)
        val fullName = addFieldSorter(ProductInfoContract.COLUMN_FULL_NAME)
        val shortName = addFieldSorter(ProductInfoContract.COLUMN_SHORT_NAME)
        val alcCode = addFieldSorter(ProductInfoContract.COLUMN_ALC_CODE)
        val capacity = addFieldSorter(ProductInfoContract.COLUMN_CAPACITY)
        val alcVolume = addFieldSorter(ProductInfoContract.COLUMN_ALC_VOLUME)
        val producerId = addFieldSorter(ProductInfoContract.COLUMN_PRODUCER_CLIENT_REG_ID)
        val importerId = addFieldSorter(ProductInfoContract.COLUMN_IMPORTER_CLIENT_REG_ID)
        val productVCode = addFieldSorter(ProductInfoContract.COLUMN_PRODUCT_V_CODE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ProductInfo>): ProductInfo {
        return DictionaryApi.createProductInfo(cursor)
    }

}