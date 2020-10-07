package ru.evotor.egais.api.provider.waybillact

import android.net.Uri

internal object WayBillActPositionContract {
    @JvmField
    val PATH = "WayBillActPosition"
    @JvmField
    val URI = Uri.withAppendedPath(WayBillActContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Уникальный идентификатор акта, содержащего позицию
     */
    const val COLUMN_WAY_BILL_ACT_UUID = "WAY_BILL_ACT_UUID"

    /**
     * Идентификатор позиции внутри накладной
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Количество
     */
    const val COLUMN_REAL_QUANTITY = "REAL_QUANTITY"

    /**
     * Количество c дополнительным разрядом
     */
    const val COLUMN_REAL_QUANTITY_DAL = "REAL_QUANTITY_DAL"

    /**
     * Регистрационный номер раздела справки 2
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"
}