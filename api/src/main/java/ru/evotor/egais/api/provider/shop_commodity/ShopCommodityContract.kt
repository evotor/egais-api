package ru.evotor.egais.api.provider.shop_commodity

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ShopCommodityContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.shopcommodity"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    val PATH = "ShopCommodity"
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

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