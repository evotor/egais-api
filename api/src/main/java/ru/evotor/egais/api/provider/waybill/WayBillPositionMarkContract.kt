package ru.evotor.egais.api.provider.waybill

import android.net.Uri

internal object WayBillPositionMarkContract {

    val PATH = "WayBillPositionMark"
    val URI = Uri.withAppendedPath(WayBillContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции в ТТН
     */
    const val COLUMN_WAYBILL_POSITION_UUID = "WAYBILL_POSITION_UUID"

    /**
     * Номер короба
     */
    const val COLUMN_BOX_NUMBER = "BOX_NUMBER"

    /**
     * Марка
     */
    const val COLUMN_MARK = "MARK"
}