package ru.evotor.egais.api.provider.waybillact

import android.net.Uri
import ru.evotor.egais.api.provider.dictionary.DictionaryContract

internal object WayBillActPositionContract {
    @JvmField
    val PATH = "WayBillActPosition"
    @JvmField
    val URI = Uri.withAppendedPath(DictionaryContract.BASE_URI, PATH)

    /**
     * UUID акта.
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор позиции внутри накладной.
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Количество.
     */
    const val COLUMN_QUANTITY = "QUANTITY"

    /**
     * Регистрационный номер раздела справки 2.
     */
    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"
}