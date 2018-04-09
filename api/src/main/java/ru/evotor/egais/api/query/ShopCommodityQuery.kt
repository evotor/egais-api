package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.shop_commodity.ShopCommodity
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.stock_commodity.StockCommodityContract
import ru.evotor.egais.api.provider.waybill.ShopCommodityContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal

class ShopCommodityQuery : FilterBuilder<ShopCommodityQuery, ShopCommodityQuery.SortOrder,
        ShopCommodity>(ShopCommodityContract.URI) {

    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(ShopCommodityContract.COLUMN_QUANTITY, {
        QuantityBigDecimalConverter.toLong(it)
    })

    @JvmField
    val productInfoAlcCode = addFieldFilter<String?>(ShopCommodityContract.COLUMN_PRODUCT_INFO_ALC_CODE)

    override val currentQuery: ShopCommodityQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val quantity = addFieldSorter(ShopCommodityContract.COLUMN_QUANTITY)
        @JvmField
        val productInfoAlcCode = addFieldSorter(ShopCommodityContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<ShopCommodity>): ShopCommodity {
        return createShopCommodity(cursor)
    }

    private fun createShopCommodity(cursor: android.database.Cursor): ShopCommodity {
        val columnQuantity = cursor.getColumnIndex(StockCommodityContract.COLUMN_QUANTITY)
        val columnProductInfoAlcoCode = cursor.getColumnIndex(StockCommodityContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        return ShopCommodity(
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnQuantity)),
                cursor.getString(columnProductInfoAlcoCode)
        )
    }
}
