package ru.evotor.egais.api.provider.actfixbarcode

import android.net.Uri

internal object ActFixBarcodePositionMarkContract {
    val PATH = "ActFixBarcodePositionMark"
    val URI = Uri.withAppendedPath(ActFixBarcodeContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта
     */
    const val COLUMN_ACT_FIX_BARCODE_POSITION_UUID = "ACT_FIX_BARCODE_POSITION_UUID"

    /**
     * Марка
     */
    const val COLUMN_MARK = "MARK"
}