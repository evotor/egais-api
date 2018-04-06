package ru.evotor.egais.api.query

import ru.evotor.egais.api.StockCommodityApi
import ru.evotor.egais.api.model.document.stock_commodity.StockCommodity
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.stock_commodity.StockCommodityContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class StockCommodityQuery : FilterBuilder<StockCommodityQuery, StockCommodityQuery.SortOrder,
        StockCommodity>(StockCommodityContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(StockCommodityContract.COLUMN_UUID)
    @JvmField
    val informF1RegId = addFieldFilter<String>(StockCommodityContract.COLUMN_INFORM_F1_REG_ID)
    @JvmField
    val informF2RegId = addFieldFilter<String>(StockCommodityContract.COLUMN_INFORM_F2_REG_ID)

    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(StockCommodityContract.COLUMN_QUANTITY, {
        QuantityBigDecimalConverter.toLong(it)
    })

    @JvmField
    val productInfoAlcCode = addFieldFilter<String?>(StockCommodityContract.COLUMN_PRODUCT_INFO_ALC_CODE)

    override val currentQuery: StockCommodityQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(StockCommodityContract.COLUMN_UUID)
        @JvmField
        val informF1RegId = addFieldSorter(StockCommodityContract.COLUMN_INFORM_F1_REG_ID)
        @JvmField
        val informF2RegId = addFieldSorter(StockCommodityContract.COLUMN_INFORM_F2_REG_ID)
        @JvmField
        val quantity = addFieldSorter(StockCommodityContract.COLUMN_QUANTITY)
        @JvmField
        val productInfoAlcCode = addFieldSorter(StockCommodityContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<StockCommodity>): StockCommodity {
        return StockCommodityApi.createStockCommodity(cursor)
    }

}
