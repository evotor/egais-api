package ru.evotor.egais.api.provider.waybillact

import android.net.Uri
import ru.evotor.egais.api.provider.EgaisApi

object ConfirmTicketContract {
    @JvmField
    val URI = Uri.withAppendedPath(EgaisApi.BASE_URI, "ConfirmTicket")

    /**
     * UUID подтверждения. Не может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор документа (клиентский, к заполнению необязательный). Может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Тип подтверждения: Принимаем/отказываем. Не может быть null.
     *
     * Возможные значения:
     * - ACCEPTED - Принимаем
     * - REJECTED - отказываем
     *
     * Тип: STRING
     */
    const val COLUMN_IS_CONFIRM = "IS_CONFIRM"

    /**
     * Номер подтверждения. Не может быть null.
     *
     * Тип: STRING
     */
    const val COLUMN_NUMBER = "NUMBER"
    /**
     * Дата составления подтверждения. Не может быть null.
     *
     * Тип: LONG
     */
    const val COLUMN_DATE = "DATE"
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