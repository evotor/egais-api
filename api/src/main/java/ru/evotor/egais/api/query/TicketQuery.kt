package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.ticket.ConclusionType
import ru.evotor.egais.api.model.document.ticket.DocType
import ru.evotor.egais.api.model.document.ticket.OperationResult
import ru.evotor.egais.api.model.document.ticket.Ticket
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.ticket.TicketContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class TicketQuery : FilterBuilder<TicketQuery, TicketQuery.SortOrder, Ticket>(TicketContract.URI) {

    /**
     * Уникальный идентификатор
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(TicketContract.COLUMN_UUID)

    /**
     * Кто подает документы
     */
    @JvmField
    val owner = addFieldFilter<String>(TicketContract.COLUMN_OWNER)

    /**
     * Дата квитанции
     */
    @JvmField
    val ticketDate = addFieldFilter<Date?, String?>(TicketContract.COLUMN_TICKET_DATE, { DateConverter.toNullableString(it) })

    /**
     * Идентификатор документа(исходного, клиентский из содержимого XML(может не быть))
     */
    @JvmField
    val identity = addFieldFilter<String?>(TicketContract.COLUMN_IDENTITY)

    /**
     * Ид задачи из файловой базы
     */
    @JvmField
    val docId = addFieldFilter<String?>(TicketContract.COLUMN_DOC_ID)

    /**
     * Транспортный ид из файловой базы
     */
    @JvmField
    val transportId = addFieldFilter<String?>(TicketContract.COLUMN_TRANSPORT_ID)

    /**
     * Присвоенный документу номер
     */
    @JvmField
    val regId = addFieldFilter<String?>(TicketContract.COLUMN_REG_ID)

    /**
     * Хэш документа
     */
    @JvmField
    val docHash = addFieldFilter<String?>(TicketContract.COLUMN_DOC_HASH)

    /**
     * Тип исходного документа
     */
    @JvmField
    val docType = addFieldFilter<DocType?>(TicketContract.COLUMN_DOC_TYPE)

    /**
     * Результат фиксации
     */
    @JvmField
    val conclusionType = addFieldFilter<ConclusionType?>(TicketContract.COLUMN_RESULT_CONCLUSION)

    /**
     * Дата фиксации
     */
    @JvmField
    val resultDate = addFieldFilter<Date?, String?>(TicketContract.COLUMN_RESULT_DATE, { DateConverter.toNullableString(it) })

    /**
     * Описание результата фиксации, описание ошибки фиксации
     */
    @JvmField
    val resultComments = addFieldFilter<String?>(TicketContract.COLUMN_RESULT_COMMENTS)

    /**
     * Операция
     */
    @JvmField
    val operationResultName = addFieldFilter<String>(TicketContract.COLUMN_OPERATION_RESULT_NAME)

    /**
     * Результат выполнения
     */
    @JvmField
    val operationResultResult = addFieldFilter<OperationResult?>(TicketContract.COLUMN_OPERATION_RESULT_RESULT)

    /**
     * Сообщение
     */
    @JvmField
    val operationResultComment = addFieldFilter<String?>(TicketContract.COLUMN_OPERATION_RESULT_COMMENT)

    /**
     * Дата операции
     */
    @JvmField
    val operationResultDate = addFieldFilter<Date?, String?>(TicketContract.COLUMN_OPERATION_RESULT_DATE, { DateConverter.toNullableString(it) })

    override val currentQuery: TicketQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        /**
         * Уникальный идентификатор
         */
        @JvmField
        val uuid = addFieldSorter(TicketContract.COLUMN_UUID)

        /**
         * Кто подает документы
         */
        @JvmField
        val owner = addFieldSorter(TicketContract.COLUMN_OWNER)

        /**
         * Дата квитанции
         */
        @JvmField
        val ticketDate = addFieldSorter(TicketContract.COLUMN_TICKET_DATE)

        /**
         * Идентификатор документа(исходного, клиентский из содержимого XML(может не быть))
         */
        @JvmField
        val identity = addFieldSorter(TicketContract.COLUMN_IDENTITY)

        /**
         * Ид задачи из файловой базы
         */
        @JvmField
        val docId = addFieldSorter(TicketContract.COLUMN_DOC_ID)

        /**
         * Транспортный ид из файловой базы
         */
        @JvmField
        val transportId = addFieldSorter(TicketContract.COLUMN_TRANSPORT_ID)

        /**
         * Присвоенный документу номер
         */
        @JvmField
        val regId = addFieldSorter(TicketContract.COLUMN_REG_ID)

        /**
         * Хэш документа
         */
        @JvmField
        val docHash = addFieldSorter(TicketContract.COLUMN_DOC_HASH)

        /**
         * Тип исходного документа
         */
        @JvmField
        val docType = addFieldSorter(TicketContract.COLUMN_DOC_TYPE)

        /**
         * Результат фиксации
         */
        @JvmField
        val conclusionType = addFieldSorter(TicketContract.COLUMN_RESULT_CONCLUSION)

        /**
         * Дата фиксации
         */
        @JvmField
        val resultDate = addFieldSorter(TicketContract.COLUMN_RESULT_DATE)

        /**
         * Описание результата фиксации, описание ошибки фиксации
         */
        @JvmField
        val resultComments = addFieldSorter(TicketContract.COLUMN_RESULT_COMMENTS)

        /**
         * Операция
         */
        @JvmField
        val operationResultName = addFieldSorter(TicketContract.COLUMN_OPERATION_RESULT_NAME)

        /**
         * Результат выполнения
         */
        @JvmField
        val operationResultResult = addFieldSorter(TicketContract.COLUMN_OPERATION_RESULT_RESULT)

        /**
         * Сообщение
         */
        @JvmField
        val operationResultComment = addFieldSorter(TicketContract.COLUMN_OPERATION_RESULT_COMMENT)

        /**
         * Дата операции
         */
        @JvmField
        val operationResultDate = addFieldSorter(TicketContract.COLUMN_OPERATION_RESULT_DATE)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<Ticket>): Ticket {
        return cursor.createTicket()
    }
}