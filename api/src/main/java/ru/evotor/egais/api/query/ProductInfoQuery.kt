package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.ProductInfo
import ru.evotor.egais.api.model.dictionary.ProductType
import ru.evotor.egais.api.provider.dictionary.ProductInfoContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder

class ProductInfoQuery : FilterBuilder<ProductInfoQuery, ProductInfoQuery.SortOrder, ProductInfo>(ProductInfoContract.URI) {

    @JvmField
    val type = addFieldFilter<ProductType>(ProductInfoContract.COLUMN_TYPE)
    @JvmField
    val fullName = addFieldFilter<String?>(ProductInfoContract.COLUMN_FULL_NAME)
    @JvmField
    val shortName = addFieldFilter<String?>(ProductInfoContract.COLUMN_SHORT_NAME)
    @JvmField
    val alcCode = addFieldFilter<String?>(ProductInfoContract.COLUMN_ALC_CODE)
    @JvmField
    val capacity = addFieldFilter<String?>(ProductInfoContract.COLUMN_CAPACITY)
    @JvmField
    val alcVolume = addFieldFilter<String?>(ProductInfoContract.COLUMN_ALC_VOLUME)
    @JvmField
    val producerId = addFieldFilter<String?>(ProductInfoContract.COLUMN_PRODUCER_CLIENT_REG_ID)
    @JvmField
    val importerId = addFieldFilter<String?>(ProductInfoContract.COLUMN_IMPORTER_CLIENT_REG_ID)
    @JvmField
    val productVCode = addFieldFilter<String?>(ProductInfoContract.COLUMN_PRODUCT_V_CODE)

    override val currentQuery: ProductInfoQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val type = addFieldSorter(ProductInfoContract.COLUMN_TYPE)
        @JvmField
        val fullName = addFieldSorter(ProductInfoContract.COLUMN_FULL_NAME)
        @JvmField
        val shortName = addFieldSorter(ProductInfoContract.COLUMN_SHORT_NAME)
        @JvmField
        val alcCode = addFieldSorter(ProductInfoContract.COLUMN_ALC_CODE)
        @JvmField
        val capacity = addFieldSorter(ProductInfoContract.COLUMN_CAPACITY)
        @JvmField
        val alcVolume = addFieldSorter(ProductInfoContract.COLUMN_ALC_VOLUME)
        @JvmField
        val producerId = addFieldSorter(ProductInfoContract.COLUMN_PRODUCER_CLIENT_REG_ID)
        @JvmField
        val importerId = addFieldSorter(ProductInfoContract.COLUMN_IMPORTER_CLIENT_REG_ID)
        @JvmField
        val productVCode = addFieldSorter(ProductInfoContract.COLUMN_PRODUCT_V_CODE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ProductInfo>): ProductInfo {
        return createProductInfo(cursor)
    }

    private fun createProductInfo(cursor: android.database.Cursor): ProductInfo {
        val columnIndexType = cursor.getColumnIndex(ProductInfoContract.COLUMN_TYPE)
        val columnIndexFullName = cursor.getColumnIndex(ProductInfoContract.COLUMN_FULL_NAME)
        val columnIndexShortName = cursor.getColumnIndex(ProductInfoContract.COLUMN_SHORT_NAME)
        val columnIndexAlcCode = cursor.getColumnIndex(ProductInfoContract.COLUMN_ALC_CODE)
        val columnIndexCapacity = cursor.getColumnIndex(ProductInfoContract.COLUMN_CAPACITY)
        val columnIndexAlcVolume = cursor.getColumnIndex(ProductInfoContract.COLUMN_ALC_VOLUME)
        val columnIndexProducerId = cursor.getColumnIndex(ProductInfoContract.COLUMN_PRODUCER_CLIENT_REG_ID)
        val columnIndexImporterId = cursor.getColumnIndex(ProductInfoContract.COLUMN_IMPORTER_CLIENT_REG_ID)
        val columnIndexProductVCode = cursor.getColumnIndex(ProductInfoContract.COLUMN_PRODUCT_V_CODE)

        return ProductInfo(
                ProductType.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexFullName),
                cursor.getString(columnIndexShortName),
                cursor.getString(columnIndexAlcCode),
                cursor.getString(columnIndexCapacity),
                cursor.getString(columnIndexAlcVolume),
                cursor.getString(columnIndexProducerId),
                cursor.getString(columnIndexImporterId),
                cursor.getString(columnIndexProductVCode)
        )
    }
}