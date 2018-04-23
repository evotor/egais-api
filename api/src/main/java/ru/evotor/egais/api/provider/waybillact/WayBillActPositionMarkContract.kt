package ru.evotor.egais.api.provider.waybillact

import android.net.Uri

internal object WayBillActPositionMarkContract {
    val PATH = "WayBillActPositionMark"
    val URI = Uri.withAppendedPath(WayBillActContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор позиции акта разногласий
     */
    const val COLUMN_WAY_BILL_ACT_POSITION_UUID = "WAY_BILL_ACT_POSITION_UUID"

    /**
     * Марка
     */
    const val COLUMN_MARK = "MARK"
}