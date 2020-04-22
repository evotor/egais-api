package ru.evotor.egais.api.provider.stock_commodity

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object StockCommodityContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.stockcommodity"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    val PATH = "StockCommodity"
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * Регистрационный номер раздела справки 1
     */
    const val COLUMN_INFORM_F1_REG_ID = "INFORM_F1_REG_ID"

    /**
     * Регистрационный номер раздела справки 2
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"

    /**
     * Количество
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * Количество c дополнительным разрядом
     */
    const val COLUMN_QUANTITY_DAL = "QUANTITY_DAL"

    /**
     * Алкокод информации о продукции
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"
}