package ru.evotor.egais.api.provider.actunfixbarcode

import android.net.Uri

internal object ActUnFixBarcodePositionMarkContract {
    val PATH = "ActUnFixBarcodePositionMark"
    val URI = Uri.withAppendedPath(ActUnFixBarcodeContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта
     */
    const val COLUMN_ACT_UNFIX_BARCODE_POSITION_UUID = "ACT_UNFIX_BARCODE_POSITION_UUID"

    /**
     * Марка
     */
    const val COLUMN_MARK = "MARK"
}