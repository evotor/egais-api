package ru.evotor.egais.api.provider.waybillact

import android.net.Uri
import ru.evotor.egais.api.provider.EgaisApi

object WayBillActContract {
    @JvmField
    val PATH = "WayBillAct"
    @JvmField
    val URI = Uri.withAppendedPath(EgaisApi.BASE_URI, PATH)

    /**
     * UUID Акта. Не может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_UUID = "UUID"

    /**
     * UUID накладной. Может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_WAY_BILL_UUID = "WAY_BILL_UUID"

    /**
     * ИД Акта (клиентский). Может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Тип подтверждения: Принимаем/отказываем. Не может быть null.
     *
     * Возможные значения:
     * - ACCEPTED - Принимаем
     * - DIFFERENCES - Принимаем частично
     * - REJECTED - Отказываем
     *
     * Тип: STRING
     */
    const val COLUMN_ACCEPT_TYPE = "ACCEPT_TYPE"

    /**
     * Номер акта. Не может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата составления акта. Не может быть null.
     *
     * Тип: LONG
     */
    const val COLUMN_CREATION_DATE = "CREATION_DATE"

    /**
     * ИД накладной в системе. Не может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_WB_REG_ID = "WB_REG_ID"

    /**
     * Заметки. Может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_NOTE = "NOTE"
}