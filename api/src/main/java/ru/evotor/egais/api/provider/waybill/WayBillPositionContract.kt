package ru.evotor.egais.api.provider.waybill

import android.net.Uri
import ru.evotor.egais.api.provider.api.WayBillApi

object WayBillPositionContract {
    @JvmField
    val PATH = "WayBillPosition"
    @JvmField
    val URI = Uri.withAppendedPath(WayBillApi.BASE_URI, PATH)

    /**
     * UUID позиции накладной. Не может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_UUID = "UUID"

    /**
     * UUID накладной. Не может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_WAYBILL_UUID = "WAY_BILL_ID"

    /**
     * Идентификатор внутри файла. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PRODUCT_INFO_IDENTITY = "PRODUCT_INFO_IDENTITY"

    /**
     * Алко код продукции. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PRODUCT_INFO_ALC_CODE = "PRODUCT_INFO_ALC_CODE"

    /**
     * Идентификатор упаковки. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PACKID = "PACK_ID"

    /**
     * Количество. Не может быть null
     *
     * Тип: LONG
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * Цена за единицу товара. Не может быть null
     *
     * Тип: LONG
     */
    const val COLUMN_PRICE = "PRICE"

    /**
     * Номер партии. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PARTY = "PARTY"

    /**
     * Идентификатор позиции внутри накладной. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Справка A. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_INFORM_INFORM_A_REG_ID = "INFORM_A_REG_ID"

    /**
     * Регистрационный номер раздела справки B, по которому продукция была получена отправителем. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_INFORM_B_REG_ID = "INFORM_B_REG_ID"

    /**
     * Регистрационный номер раздела справки B. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_INFORM_B_MARK_INFO_JSON = "INFORM_B_MARK_INFO_JSON"
}