package ru.evotor.egais.api.provider.waybillact

import android.net.Uri

internal object ConfirmTicketContract {
    val PATH = "ConfirmTicket"
    val URI = Uri.withAppendedPath(WayBillActContract.BASE_URI, PATH)

    /**
     * UUID подтверждения.
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор документа (клиентский, к заполнению необязательный).
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Тип подтверждения: Принимаем/отказываем.
     */
    const val COLUMN_IS_CONFIRM = "IS_CONFIRM"

    /**
     * Номер подтверждения.
     */
    const val COLUMN_NUMBER = "NUMBER"
    /**
     * Дата составления подтверждения.
     */
    const val COLUMN_DATE = "DATE"
    /**
     * ИД накладной в системе.
     */
    const val COLUMN_WB_REG_ID = "WB_REG_ID"
    /**
     * Заметки.
     */
    const val COLUMN_NOTE = "NOTE"
}