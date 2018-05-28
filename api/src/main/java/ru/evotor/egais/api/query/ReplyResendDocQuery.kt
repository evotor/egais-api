package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.reply.ReplyResendDoc
import ru.evotor.egais.api.provider.reply.ReplyResendDocContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение результата отправки
 * повторного запроса ТТН
 */
class ReplyResendDocQuery : FilterBuilder<ReplyResendDocQuery, ReplyResendDocQuery.SortOrder, ReplyResendDoc>(ReplyResendDocContract.URI) {
    /**
     * Уникальный идентификатор запроса
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ReplyResendDocContract.COLUMN_UUID)

    /**
     * Отправитель запроса
     */
    @JvmField
    val owner = addFieldFilter<String>(ReplyResendDocContract.COLUMN_OWNER)

    /**
     * Идентификатор накладной в системе
     */
    @JvmField
    val wbRegId = addFieldFilter<String?>(ReplyResendDocContract.COLUMN_WB_REG_ID)

    /**
     * Идентификатор квитанции
     */
    @JvmField
    val ticketUuid = addFieldFilter<UUID?>(ReplyResendDocContract.COLUMN_TICKET_UUID)

    override val currentQuery: ReplyResendDocQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        override val currentSortOrder: SortOrder
            get() = this

        /**
         * Уникальный идентификатор запроса
         */
        @JvmField
        val uuid = addFieldSorter(ReplyResendDocContract.COLUMN_UUID)

        /**
         * Отправитель запроса
         */
        @JvmField
        val owner = addFieldSorter(ReplyResendDocContract.COLUMN_OWNER)

        /**
         * Идентификатор накладной в системе
         */
        @JvmField
        val wbRegId = addFieldSorter(ReplyResendDocContract.COLUMN_WB_REG_ID)

        /**
         * Идентификатор квитанции
         */
        @JvmField
        val ticketUuid = addFieldSorter(ReplyResendDocContract.COLUMN_TICKET_UUID)
    }

    override fun getValue(cursor: Cursor<ReplyResendDoc>): ReplyResendDoc {
        return createReplyResendDoc(cursor)
    }

    private fun createReplyResendDoc(cursor: Cursor<ReplyResendDoc>): ReplyResendDoc {
        val columnIndexUuid = cursor.getColumnIndexOrThrow(ReplyResendDocContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndexOrThrow(ReplyResendDocContract.COLUMN_OWNER)
        val columnIndexWbRegId = cursor.getColumnIndexOrThrow(ReplyResendDocContract.COLUMN_WB_REG_ID)
        val columnIndexTicketUuid = cursor.getColumnIndexOrThrow(ReplyResendDocContract.COLUMN_TICKET_UUID)

        return ReplyResendDoc(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexWbRegId),
                cursor.getString(columnIndexTicketUuid)?.let { cursor.createTicket() }
        )
    }
}