package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.ticket.ConclusionType
import ru.evotor.egais.api.model.document.ticket.ConfirmTicket
import ru.evotor.egais.api.model.document.ticket.ConfirmTicketStatus
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.ticket.ConfirmTicketContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class ConfirmTicketQuery : FilterBuilder<ConfirmTicketQuery, ConfirmTicketQuery.SortOrder, ConfirmTicket>(ConfirmTicketContract.URI) {

    /**
     * Уникальный идентификатор
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ConfirmTicketContract.COLUMN_UUID)

    /**
     * Кто подает документы
     */
    @JvmField
    val owner = addFieldFilter<String>(ConfirmTicketContract.COLUMN_OWNER)

    /**
     * Идентификатор документа(исходного, клиентский из содержимого XML(может не быть))
     */
    @JvmField
    val identity = addFieldFilter<String?>(ConfirmTicketContract.COLUMN_IDENTITY)

    /**
     * Тип подтверждения: Принимаем/отказываем
     */
    @JvmField
    val isConfirm = addFieldFilter<ConclusionType?>(ConfirmTicketContract.COLUMN_IS_CONFIRM)

    /**
     * Номер подтверждения
     */
    @JvmField
    val ticketNumber = addFieldFilter<String?>(ConfirmTicketContract.COLUMN_TICKET_NUMBER)

    /**
     * Дата составления подтверждения
     */
    @JvmField
    val ticketDate = addFieldFilter<Date?, String?>(ConfirmTicketContract.COLUMN_TICKET_DATE, { DateConverter.toNullableString(it) })

    /**
     * ИД накладной в системе
     */
    @JvmField
    val wbRegId = addFieldFilter<String?>(ConfirmTicketContract.COLUMN_WB_REG_ID)

    /**
     * Примечания
     */
    @JvmField
    val note = addFieldFilter<String?>(ConfirmTicketContract.COLUMN_NOTE)

    /**
     * Статус (подтвержден/отклонен)
     */
    @JvmField
    val status = addFieldFilter<ConfirmTicketStatus>(ConfirmTicketContract.COLUMN_STATUS)

    /**
     * Комментарий для отказа
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(ConfirmTicketContract.COLUMN_REJECT_COMMENT)


    override val currentQuery: ConfirmTicketQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор
         */
        @JvmField
        val uuid = addFieldSorter(ConfirmTicketContract.COLUMN_UUID)

        /**
         * Кто подает документы
         */
        @JvmField
        val owner = addFieldSorter(ConfirmTicketContract.COLUMN_OWNER)

        /**
         * Идентификатор документа(исходного, клиентский из содержимого XML(может не быть))
         */
        @JvmField
        val identity = addFieldSorter(ConfirmTicketContract.COLUMN_IDENTITY)

        /**
         * Тип подтверждения: Принимаем/отказываем
         */
        @JvmField
        val isConfirm = addFieldSorter(ConfirmTicketContract.COLUMN_IS_CONFIRM)

        /**
         * Номер подтверждения
         */
        @JvmField
        val ticketNumber = addFieldSorter(ConfirmTicketContract.COLUMN_TICKET_NUMBER)

        /**
         * Дата составления подтверждения
         */
        @JvmField
        val ticketDate = addFieldSorter(ConfirmTicketContract.COLUMN_TICKET_DATE)

        /**
         * ИД накладной в системе
         */
        @JvmField
        val wbRegId = addFieldSorter(ConfirmTicketContract.COLUMN_WB_REG_ID)

        /**
         * Примечания
         */
        @JvmField
        val note = addFieldSorter(ConfirmTicketContract.COLUMN_NOTE)

        /**
         * Статус (подтвержден/отклонен)
         */
        @JvmField
        val status = addFieldSorter(ConfirmTicketContract.COLUMN_STATUS)

        /**
         * Комментарий для отказа
         */
        @JvmField
        val rejectComment = addFieldSorter(ConfirmTicketContract.COLUMN_REJECT_COMMENT)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<ConfirmTicket>): ConfirmTicket {
        val columnIndexUuid = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_IDENTITY)
        val columnIndexIsConfirm = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_IS_CONFIRM)
        val columnIndexTicketNumber = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_TICKET_NUMBER)
        val columnIndexTicketDate = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_TICKET_DATE)
        val columnIndexWbRegId = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_WB_REG_ID)
        val columnIndexNote = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndexOrThrow(ConfirmTicketContract.COLUMN_REJECT_COMMENT)

        return ConfirmTicket(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                ConclusionType.valueOf(cursor.getString(columnIndexIsConfirm)),
                cursor.getString(columnIndexTicketNumber),
                DateConverter.toDate(cursor.getString(columnIndexTicketDate)),
                cursor.getString(columnIndexWbRegId),
                cursor.getString(columnIndexNote),
                ConfirmTicketStatus.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment)
        )
    }
}