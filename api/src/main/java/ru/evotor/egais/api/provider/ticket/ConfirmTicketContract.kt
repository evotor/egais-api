package ru.evotor.egais.api.provider.ticket

import android.net.Uri

internal object ConfirmTicketContract {
    val PATH = "ConfirmTicket"
    val URI = Uri.withAppendedPath(TicketContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Кто подает документы
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * Идентификатор документа(исходного, клиентский из содержимого XML(может не быть))
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Тип подтверждения: Принимаем/отказываем
     */
    const val COLUMN_IS_CONFIRM = "IS_CONFIRM"

    /**
     * Номер подтверждения
     */
    const val COLUMN_TICKET_NUMBER = "TICKET_NUMBER"

    /**
     * Дата составления подтверждения
     */
    const val COLUMN_TICKET_DATE = "TICKET_DATE"

    /**
     * ИД накладной в системе
     */
    const val COLUMN_WB_REG_ID = "WB_REG_ID"

    /**
     * Примечания
     */
    const val COLUMN_NOTE = "NOTE"

    /**
     * Статус (подтвержден/отклонен)
     */
    const val COLUMN_STATUS = "STATUS"

    /**
     * Комментарий для отказа
     */
    const val COLUMN_REJECT_COMMENT = "REJECT_COMMENT"
}