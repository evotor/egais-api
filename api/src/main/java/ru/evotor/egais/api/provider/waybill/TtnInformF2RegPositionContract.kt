package ru.evotor.egais.api.provider.waybill

import android.net.Uri

internal object TtnInformF2RegPositionContract {
    val PATH = "TtnInformF2RegPosition"
    val URI = Uri.withAppendedPath(WayBillContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Уникальный идентификатор справки 2
     */
    const val COLUMN_TTN_INFORM_F2_REG_ID = "TTN_INFORM_F2_REG_ID"

    /**
     * Идентификатор позиции внутри накладной
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Регистрационный номер записи справки 2
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"

}