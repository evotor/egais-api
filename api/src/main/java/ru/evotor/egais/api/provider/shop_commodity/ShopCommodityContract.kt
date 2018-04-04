package ru.evotor.egais.api.provider.waybill

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ShopCommodityContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.shopcommodity"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    val PATH = "ShopCommodity"
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * UUID товарного остатка.
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Тип накладной.
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * тип упаковки.
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"
}