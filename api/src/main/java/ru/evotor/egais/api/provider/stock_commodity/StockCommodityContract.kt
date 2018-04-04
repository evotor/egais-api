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
     * UUID товарного остатка.
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор накладной (клиентский, к заполнению необязательный).
     */
    const val COLUMN_INFORM_F1_REG_ID = "INFORM_F1_REG_ID"

    /**
     * Идентификатор накладной (клиентский, к заполнению необязательный).
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"

    /**
     * Тип накладной.
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * тип упаковки.
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"
}