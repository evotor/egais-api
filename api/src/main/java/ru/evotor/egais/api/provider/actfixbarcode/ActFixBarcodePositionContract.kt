package ru.evotor.egais.api.provider.actfixbarcode

import android.net.Uri

internal object ActFixBarcodePositionContract {

    @JvmField
    val PATH = "ActFixBarcodePosition"

    @JvmField
    val URI = Uri.withAppendedPath(ActFixBarcodeContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор акта привязки, содержащего позицию
     */
    const val COLUMN_ACT_FIX_BARCODE_UUID = "ACT_FIX_BARCODE_UUID"

    /**
     * Идентификатор позиции внутри накладной
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Регистрационный номер раздела справки 2
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"
}