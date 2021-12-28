package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.repeal_wb.RepealWbStatus
import ru.evotor.egais.api.model.document.repeal_wb.RequestRepealWb
import ru.evotor.egais.api.provider.UtmDocumentContract.COLUMN_REPLY_ID
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_DATE
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_IDENTITY
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_NOTE
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_NUMBER
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_OWNER
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_REJECT_COMMENT
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_STATUS
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_UUID
import ru.evotor.egais.api.provider.repeal_wb.RequestRepealWbContract.COLUMN_WB_REG_ID
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение запросов на отмену проведения акта для ТТН
 */
class RequestRepealWbQuery :
    FilterBuilder<RequestRepealWbQuery, RequestRepealWbQuery.SortOrder, List<RequestRepealWb>>(
        RequestRepealWbContract.URI
    ) {

    /**
     * UUID документа.
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(COLUMN_UUID)

    /**
     * Отправитель документа.
     */
    @JvmField
    val docOwner = addFieldFilter<String>(COLUMN_OWNER)

    /**
     * Идентификатор документа (клиентский, к заполнению необязательный).
     */
    @JvmField
    val identity = addFieldFilter<String?>(COLUMN_IDENTITY)

    /**
     * Номер документа.
     */
    @JvmField
    val number = addFieldFilter<String>(COLUMN_NUMBER)

    /**
     * Дата составления.
     */
    @JvmField
    val date =
        addFieldFilter<Date, String>(COLUMN_DATE, { DateConverter.toString(it) })

    /**
     * ИД документа в системе ЕГАИС.
     */
    @JvmField
    val wbRegId = addFieldFilter<String?>(COLUMN_WB_REG_ID)

    /**
     * Заметки.
     */
    @JvmField
    val note = addFieldFilter<String?>(COLUMN_NOTE)

    /**
     * Текущий статус документа.
     */
    @JvmField
    val status = addFieldFilter<RepealWbStatus>(COLUMN_STATUS)

    /**
     * Комментарий для отказа
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(COLUMN_REPLY_ID)

    override val currentQuery: RequestRepealWbQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * UUID документа.
         */
        @JvmField
        val uuid = addFieldSorter(COLUMN_UUID)

        /**
         * Отправитель документа.
         */
        @JvmField
        val docOwner = addFieldSorter(COLUMN_OWNER)

        /**
         * Идентификатор документа (клиентский, к заполнению необязательный).
         */
        @JvmField
        val identity = addFieldSorter(COLUMN_IDENTITY)

        /**
         * Номер документа.
         */
        @JvmField
        val number = addFieldSorter(COLUMN_NUMBER)

        /**
         * Дата составления.
         */
        @JvmField
        val date = addFieldSorter(COLUMN_DATE)

        /**
         * ИД документа в системе ЕГАИС.
         */
        @JvmField
        val wbRegId = addFieldSorter(COLUMN_WB_REG_ID)

        /**
         * Заметки.
         */
        @JvmField
        val note = addFieldSorter(COLUMN_NOTE)

        /**
         * Текущий статус документа.
         */
        @JvmField
        val status = addFieldSorter(COLUMN_STATUS)

        /**
         * Комментарий для отказа
         */
        @JvmField
        val rejectComment = addFieldSorter(COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<List<RequestRepealWb>>): List<RequestRepealWb> {
        return createRequestRepealWb(cursor)
    }

    private fun createRequestRepealWb(cursor: Cursor<List<RequestRepealWb>>): List<RequestRepealWb> {
        val requestsRepealWb = mutableListOf<RequestRepealWb>()

        if (cursor.moveToFirst().not()) {
            return requestsRepealWb
        }

        do {
            val columnUuid = cursor.getColumnIndexOrThrow(COLUMN_UUID)
            val columnDocOwner = cursor.getColumnIndexOrThrow(COLUMN_OWNER)
            val columnIdentity = cursor.getColumnIndexOrThrow(COLUMN_IDENTITY)
            val columnNumber = cursor.getColumnIndexOrThrow(COLUMN_NUMBER)
            val columnDate = cursor.getColumnIndexOrThrow(COLUMN_DATE)
            val columnWBRegId = cursor.getColumnIndexOrThrow(COLUMN_WB_REG_ID)
            val columnNote = cursor.getColumnIndexOrThrow(COLUMN_NOTE)
            val columnStatus = cursor.getColumnIndexOrThrow(COLUMN_STATUS)
            val columnRejectComment = cursor.getColumnIndexOrThrow(COLUMN_REJECT_COMMENT)
            val columnReplyId = cursor.getColumnIndexOrThrow(COLUMN_REPLY_ID)
            requestsRepealWb.add(
                RequestRepealWb(
                    uuid = UUID.fromString(cursor.getString(columnUuid)),
                    docOwner = cursor.getString(columnDocOwner),
                    identity = cursor.getString(columnIdentity),
                    number = cursor.getString(columnNumber),
                    date = DateConverter.toDate(cursor.getString(columnDate)),
                    wbRegId = cursor.getString(columnWBRegId),
                    note = cursor.getString(columnNote),
                    status = RepealWbStatus.valueOf(cursor.getString(columnStatus)),
                    rejectComment = cursor.getString(columnRejectComment),
                    replyId = cursor.getString(columnReplyId)
                )
            )
        } while (cursor.moveToNext())
        return requestsRepealWb
    }
}