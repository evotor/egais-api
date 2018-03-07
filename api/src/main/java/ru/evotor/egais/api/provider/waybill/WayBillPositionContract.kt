package ru.evotor.egais.api.provider.waybill

import android.net.Uri
import ru.evotor.egais.api.provider.EgaisApi

object WayBillPositionContract {
    @JvmField
    val PATH = "WayBillPosition"
    @JvmField
    val URI = Uri.withAppendedPath(EgaisApi.BASE_URI, PATH)

    /**
     * UUID накладной. Не может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор внутри файла. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PRODUCT_IDENTITY = "PRODUCT_IDENTITY"

    /**
     * Алко код продукции. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PRODUCT_ALCO_CODE = "PRODUCT_ALCO_CODE"

    /**
     * Идентификатор упаковки. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_PACKID = "PACKID"

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
     * Справка 1. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_INFORM_F1_REG_ID = "INFORM_F1_REG_ID"

    /**
     * Регистрационный номер раздела справки 2, по которому продукция была получена отправителем. Не может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_INFORM_F2_REG_ID_INCOME = "INFORM_F2_REG_ID_INCOME"

    /**
     * Регистрационный номер раздела справки 2. Может быть null
     *
     * Тип: STRING
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"
}