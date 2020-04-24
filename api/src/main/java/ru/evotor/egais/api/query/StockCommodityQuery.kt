package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.StockCommodity
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.stock_commodity.StockCommodityContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal

/**
 * Класс для формирования запроса на получение информации о биржевых товарах
 */
class StockCommodityQuery : FilterBuilder<StockCommodityQuery, StockCommodityQuery.SortOrder, StockCommodity>(StockCommodityContract.URI) {

    /**
     * Регистрационный номер раздела справки 1
     */
    @JvmField
    val informF1RegId = addFieldFilter<String>(StockCommodityContract.COLUMN_INFORM_F1_REG_ID)

    /**
     * Регистрационный номер раздела справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String>(StockCommodityContract.COLUMN_INFORM_F2_REG_ID)

    /**
     * Количество
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(
            StockCommodityContract.COLUMN_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    /**
     * Информация о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<StockCommodityQuery, StockCommodityQuery.SortOrder, StockCommodity>())

    override val currentQuery: StockCommodityQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Регистрационный номер раздела справки 1
         */
        @JvmField
        val informF1RegId = addFieldSorter(StockCommodityContract.COLUMN_INFORM_F1_REG_ID)

        /**
         * Регистрационный номер раздела справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(StockCommodityContract.COLUMN_INFORM_F2_REG_ID)

        /**
         * Количество
         */
        @JvmField
        val quantity = addFieldSorter(StockCommodityContract.COLUMN_QUANTITY)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<StockCommodityQuery.SortOrder>())

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<StockCommodity>): StockCommodity {
        return createStockCommodity(cursor)
    }

    private fun createStockCommodity(cursor: android.database.Cursor): StockCommodity {
        val columnInformF1RegId = cursor.getColumnIndex(StockCommodityContract.COLUMN_INFORM_F1_REG_ID)
        val columnInformF2RegId = cursor.getColumnIndex(StockCommodityContract.COLUMN_INFORM_F2_REG_ID)

        return StockCommodity(
                cursor.getString(columnInformF1RegId),
                cursor.getString(columnInformF2RegId),
                cursor.getQuantity(StockCommodityContract.COLUMN_QUANTITY, StockCommodityContract.COLUMN_QUANTITY_DAL),
                cursor.createProductInfo()
        )
    }
}
