package ru.evotor.egais.api.provider.ticket

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object TicketContract {
    private const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.ticket"
    val BASE_URI = Uri.parse("content://${AUTHORITY}")
    val PATH = "Ticket"
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * Уникальный идентификатор
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Кто подает документы
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * Дата квитанции
     */
    const val COLUMN_TICKET_DATE = "TICKET_DATE"

    /**
     * Идентификатор документа(исходного, клиентский из содержимого XML(может не быть))
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Ид задачи из файловой базы
     */
    const val COLUMN_DOC_ID = "DOC_ID"

    /**
     * Транспортный ид из файловой базы
     */
    const val COLUMN_TRANSPORT_ID = "TRANSPORT_ID"

    /**
     * Присвоенный документу номер
     */
    const val COLUMN_REG_ID = "REG_ID"

    /**
     * Хэш документа
     */
    const val COLUMN_DOC_HASH = "DOC_HASH"

    /**
     * Тип исходного документа
     */
    const val COLUMN_DOC_TYPE = "DOC_TYPE"

    /**
     * Результат фиксации
     */
    const val COLUMN_RESULT_CONCLUSION = "RESULT_CONCLUSION"

    /**
     * Дата фиксации
     */
    const val COLUMN_RESULT_DATE = "RESULT_DATE"

    /**
     * Описание результата фиксации, описание ошибки фиксации
     */
    const val COLUMN_RESULT_COMMENTS = "RESULT_COMMENTS"

    /**
     * Операция
     */
    const val COLUMN_OPERATION_RESULT_NAME = "OPERATION_RESULT_NAME"

    /**
     * Результат выполнения
     */
    const val COLUMN_OPERATION_RESULT_RESULT = "OPERATION_RESULT_RESULT"

    /**
     * Сообщение
     */
    const val COLUMN_OPERATION_RESULT_COMMENT = "OPERATION_RESULT_COMMENT"

    /**
     * Дата операции
     */
    const val COLUMN_OPERATION_RESULT_DATE = "OPERATION_RESULT_DATE"
}