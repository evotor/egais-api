package ru.evotor.egais.api.query.reply_resend

import ru.evotor.egais.api.model.document.reply.ReplyResendDocument
import ru.evotor.egais.api.provider.reply.ReplyResendDocumentContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.text.SimpleDateFormat
import java.util.*

/**
 * Класс для формирования запроса на получение результата отправки
 * повторного запроса ТТН
 */
class ReplyResendDocumentQuery :
    FilterBuilder<ReplyResendDocumentQuery, ReplyResendDocumentQuery.SortOrder, ReplyResendDocument>(
        ReplyResendDocumentContract.URI
    ) {

    private val dateFormat by lazy(LazyThreadSafetyMode.NONE) {
        SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    }

    /**
     * Отправитель запроса
     */
    @JvmField
    val owner = addFieldFilter<String>(ReplyResendDocumentContract.COLUMN_OWNER)

    /**
     * Идентификатор накладной в системе
     */
    @JvmField
    val wbRegId = addFieldFilter<String?>(ReplyResendDocumentContract.COLUMN_WB_REG_ID)

    /**
     * Статус накладной
     */
    @JvmField
    val status = addFieldFilter<String?>(ReplyResendDocumentContract.COLUMN_STATUS)

    /**
     * Комментарий от ЕГАИС
     */
    @JvmField
    val comment = addFieldFilter<String?>(ReplyResendDocumentContract.COLUMN_COMMENT)

    /**
     * Дата накладной
     */
    @JvmField
    val date = addFieldFilter<String?>(ReplyResendDocumentContract.COLUMN_DATE)

    override val currentQuery: ReplyResendDocumentQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        override val currentSortOrder: SortOrder
            get() = this

        @JvmField
        val owner = addFieldSorter(ReplyResendDocumentContract.COLUMN_OWNER)

        @JvmField
        val wbRegId = addFieldSorter(ReplyResendDocumentContract.COLUMN_WB_REG_ID)

        @JvmField
        val status = addFieldSorter(ReplyResendDocumentContract.COLUMN_STATUS)

        @JvmField
        val comment = addFieldSorter(ReplyResendDocumentContract.COLUMN_COMMENT)

        @JvmField
        val date = addFieldSorter(ReplyResendDocumentContract.COLUMN_DATE)
    }

    override fun getValue(cursor: Cursor<ReplyResendDocument>): ReplyResendDocument {
        return createReplyResendDoc(cursor)
    }

    private fun createReplyResendDoc(cursor: Cursor<ReplyResendDocument>): ReplyResendDocument {
        val columnIndexOwner =
            cursor.getColumnIndexOrThrow(ReplyResendDocumentContract.COLUMN_OWNER)
        val columnIndexWbRegId =
            cursor.getColumnIndexOrThrow(ReplyResendDocumentContract.COLUMN_WB_REG_ID)
        val columnIndexComment =
            cursor.getColumnIndexOrThrow(ReplyResendDocumentContract.COLUMN_COMMENT)
        val columnIndexDate = cursor.getColumnIndexOrThrow(ReplyResendDocumentContract.COLUMN_DATE)
        val columnIndexStatus =
            cursor.getColumnIndexOrThrow(ReplyResendDocumentContract.COLUMN_STATUS)
        val ticketUuid =
            cursor.getColumnIndexOrThrow(ReplyResendDocumentContract.COLUMN_TICKET_UUID)

        return ReplyResendDocument(
            cursor.getString(columnIndexWbRegId),
            cursor.getString(columnIndexOwner),
            cursor.getString(columnIndexStatus),
            cursor.getString(columnIndexComment),
            dateFormat.parse(cursor.getString(columnIndexDate)) ?: Date(),
            UUID.fromString(cursor.getString(ticketUuid))
        )
    }
}