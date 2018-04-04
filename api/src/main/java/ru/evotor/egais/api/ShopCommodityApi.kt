package ru.evotor.egais.api

import ru.evotor.egais.api.model.document.shop_commodity.ShopCommodity
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.stock_commodity.StockCommodityContract
import java.util.*

object ShopCommodityApi {

    internal fun createShopCommodity(cursor: android.database.Cursor): ShopCommodity {
        val columnUuid = cursor.getColumnIndex(StockCommodityContract.COLUMN_UUID)
        val columnQuantity = cursor.getColumnIndex(StockCommodityContract.COLUMN_QUANTITY)
        val columnProductInfoAlcoCode = cursor.getColumnIndex(StockCommodityContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        return ShopCommodity(
                UUID.fromString(cursor.getString(columnUuid)),
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnQuantity)),
                cursor.getString(columnProductInfoAlcoCode)
        )
    }
}
