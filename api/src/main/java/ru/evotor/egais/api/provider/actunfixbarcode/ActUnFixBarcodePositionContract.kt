package ru.evotor.egais.api.provider.actunfixbarcode

import android.net.Uri

internal object ActUnFixBarcodePositionContract {

    @JvmField
    val PATH = "ActUnFixBarcodePosition"

    @JvmField
    val URI = Uri.withAppendedPath(ActUnFixBarcodeContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор акта отвязки, содержащего позицию
     */
    const val COLUMN_ACT_UNFIX_BARCODE_UUID = "ACT_UNFIX_BARCODE_UUID"

    /**
     * Идентификатор позиции внутри накладной
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Регистрационный номер раздела справки 2
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"
}