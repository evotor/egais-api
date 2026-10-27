package ru.evotor.egais.api.query.rest_b_code

import ru.evotor.egais.api.model.document.rest_b_code.ReplyRestBCode
import ru.evotor.egais.api.provider.rest_b_code.ReplyRestBCodeContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.text.SimpleDateFormat
import java.util.*

/**
 * Класс для формирования запроса на получение результатов отправки
 * запросов на получение марок по справке 2 (справка Б)
 */
class ReplyRestBCodeQuery: FilterBuilder<ReplyRestBCodeQuery, ReplyRestBCodeQuery.SortOrder, ReplyRestBCode>(
    ReplyRestBCodeContract.URI
) {

    private val dateFormat by lazy(LazyThreadSafetyMode.NONE) {
        SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    }

    /**
     * UUID документа.
     */
    @JvmField
    val uuid = addFieldFilter<String>(ReplyRestBCodeContract.COLUMN_UUID)

    /**
     * Отправитель запроса
     */
    @JvmField
    val owner = addFieldFilter<String>(ReplyRestBCodeContract.COLUMN_OWNER)

    /**
     * Дата обновления марок
     */
    @JvmField
    val restsDate = addFieldFilter<String?>(ReplyRestBCodeContract.COLUMN_RESTS_DATE)

    /**
     * uuid справки 2 для накладной.
     */
    @JvmField
    val informF2RegId = addFieldFilter<String>(ReplyRestBCodeContract.COLUMN_INFORM_F2_REG_ID)


    /**
     * ID утм документа для ответа на запрос
     */
    @JvmField
    val utmDocumentUuid = addFieldFilter<UUID>(ReplyRestBCodeContract.COLUMN_UTM_DOCUMENT_UUID)

    override val currentQuery: ReplyRestBCodeQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        override val currentSortOrder: SortOrder
            get() = this

        @JvmField
        val uuid = addFieldSorter(ReplyRestBCodeContract.COLUMN_UUID)

        @JvmField
        val owner = addFieldSorter(ReplyRestBCodeContract.COLUMN_OWNER)

        @JvmField
        val restsDate = addFieldSorter(ReplyRestBCodeContract.COLUMN_RESTS_DATE)

        @JvmField
        val informF2RegId = addFieldSorter(ReplyRestBCodeContract.COLUMN_INFORM_F2_REG_ID)

        @JvmField
        val utmDocumentUuid = addFieldSorter(ReplyRestBCodeContract.COLUMN_UTM_DOCUMENT_UUID)
    }

    override fun getValue(cursor: Cursor<ReplyRestBCode>): ReplyRestBCode {
        return createReplyRestBCode(cursor)
    }

    private fun createReplyRestBCode(cursor: Cursor<ReplyRestBCode>): ReplyRestBCode {
        val columnUuid =
            cursor.getColumnIndexOrThrow(ReplyRestBCodeContract.COLUMN_UUID)
        val columnOwner =
            cursor.getColumnIndexOrThrow(ReplyRestBCodeContract.COLUMN_OWNER)
        val columnRestsDate =
            cursor.getColumnIndexOrThrow(ReplyRestBCodeContract.COLUMN_RESTS_DATE)
        val columnInformF2RegId = cursor.getColumnIndexOrThrow(ReplyRestBCodeContract.COLUMN_INFORM_F2_REG_ID)
        val columnUtmDocumentUuid =
            cursor.getColumnIndexOrThrow(ReplyRestBCodeContract.COLUMN_UTM_DOCUMENT_UUID)

        return ReplyRestBCode(
            UUID.fromString(cursor.getString(columnUuid)),
            cursor.getString(columnOwner),
            dateFormat.parse(cursor.getString(columnRestsDate)) ?: Date(),
            cursor.getString(columnInformF2RegId),
            UUID.fromString(cursor.getString(columnUtmDocumentUuid))
        )
    }
}