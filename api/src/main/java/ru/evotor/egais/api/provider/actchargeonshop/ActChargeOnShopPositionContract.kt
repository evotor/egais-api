package ru.evotor.egais.api.provider.actchargeonshop

import android.net.Uri

internal object ActChargeOnShopPositionContract {
    @JvmField
    val PATH = "ActChargeOnShopPosition"

    @JvmField
    val URI = Uri.withAppendedPath(ActChargeOnShopContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор акта постановки, содержащего позицию
     */
    const val COLUMN_ACT_CHARGE_ON_SHOP_UUID = "ACT_CHARGE_ON_SHOP_UUID"

    /**
     * Идентификатор позиции внутри накладной
     */
    const val COLUMN_IDENTITY = "IDENTITY"

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
