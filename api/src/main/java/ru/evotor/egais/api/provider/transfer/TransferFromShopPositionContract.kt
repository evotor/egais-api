package ru.evotor.egais.api.provider.transfer

import android.net.Uri

internal object TransferFromShopPositionContract {
    val PATH = "TransferFromShopPosition"
    val URI = Uri.withAppendedPath(TransferFromShopContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор документа передачи
     */
    const val COLUMN_TRANSFER_FROM_SHOP_ID = "TRANSFER_FROM_SHOP_ID"

    /**
     * Идентификатор позиции внутри акта
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
     * Регистрационный номер раздела справки 2
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"

    /**
     * Алкокод информации о продукции
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"
}