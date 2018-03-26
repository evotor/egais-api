package ru.evotor.egais.api.provider.waybill

import android.net.Uri

internal object WayBillPositionContract {
    val PATH = "WayBillPosition"
    val URI = Uri.withAppendedPath(WayBillContract.BASE_URI, PATH)

    /**
     * UUID позиции накладной.
     */
    const val COLUMN_UUID = "UUID"

    /**
     * UUID накладной.
     */
    const val COLUMN_WAYBILL_UUID = "WAY_BILL_UUID"

    /**
     * Идентификатор внутри файла.
     */
    const val COLUMN_PRODUCT_INFO_IDENTITY = "PRODUCT_INFO_IDENTITY"

    /**
     * Алко код продукции.
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"

    /**
     * Идентификатор упаковки.
     */
    const val COLUMN_PACKID = "PACK_ID"

    /**
     * Количество.
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * Цена за единицу товара.
     */
    const val COLUMN_PRICE = "PRICE"

    /**
     * Номер партии.
     */
    const val COLUMN_PARTY = "PARTY"

    /**
     * Идентификатор позиции внутри накладной.
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Справка A. Не может быть null
     */
    const val COLUMN_INFORM_INFORM_A_REG_ID = "INFORM_A_REG_ID"

    /**
     * Регистрационный номер раздела справки B, по которому продукция была получена отправителем.
     */
    const val COLUMN_INFORM_B_REG_ID = "INFORM_B_REG_ID"
}