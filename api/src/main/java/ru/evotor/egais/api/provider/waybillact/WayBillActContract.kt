package ru.evotor.egais.api.provider.waybillact

import android.net.Uri
import ru.evotor.egais.api.provider.dictionary.DictionaryContract

internal object WayBillActContract {
    @JvmField
    val PATH = "WayBillAct"
    @JvmField
    val URI = Uri.withAppendedPath(DictionaryContract.BASE_URI, PATH)

    /**
     * UUID Акта.
     */
    const val COLUMN_UUID = "UUID"

    /**
     * UUID накладной.
     */
    const val COLUMN_WAY_BILL_UUID = "WAY_BILL_UUID"

    /**
     * ИД Акта (клиентский).
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Тип подтверждения: Принимаем/отказываем.
     */
    const val COLUMN_ACCEPT_TYPE = "ACCEPT_TYPE"

    /**
     * Номер акта.
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата составления акта.
     */
    const val COLUMN_CREATION_DATE = "CREATION_DATE"

    /**
     * ИД накладной в системе.
     */
    const val COLUMN_WB_REG_ID = "WB_REG_ID"

    /**
     * Заметки.
     */
    const val COLUMN_NOTE = "NOTE"
}