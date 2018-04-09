package ru.evotor.egais.api.query

import ru.evotor.egais.api.ShopCommodityApi
import ru.evotor.egais.api.model.document.shop_commodity.ShopCommodity
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
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
        return ShopCommodityApi.createShopCommodity(cursor)
    }
}
