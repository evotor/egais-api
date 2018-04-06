package ru.evotor.egais.api

import ru.evotor.egais.api.model.document.stock_commodity.StockCommodity
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.stock_commodity.StockCommodityContract
import java.util.*

object StockCommodityApi {

    internal fun createStockCommodity(cursor: android.database.Cursor): StockCommodity {
        val columnInformF1RegId = cursor.getColumnIndex(StockCommodityContract.COLUMN_INFORM_F1_REG_ID)
        val columnInformF2RegId = cursor.getColumnIndex(StockCommodityContract.COLUMN_INFORM_F2_REG_ID)
        val columnQuantity = cursor.getColumnIndex(StockCommodityContract.COLUMN_QUANTITY)
        val columnProductInfoAlcoCode = cursor.getColumnIndex(StockCommodityContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        return StockCommodity(
                cursor.getString(columnInformF1RegId),
                cursor.getString(columnInformF2RegId),
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnQuantity)),
                cursor.getString(columnProductInfoAlcoCode)
        )
    }
}
