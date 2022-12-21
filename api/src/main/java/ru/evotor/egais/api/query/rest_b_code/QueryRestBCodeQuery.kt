package ru.evotor.egais.api.query.rest_b_code

import ru.evotor.egais.api.model.dictionary.QueryRestBCodeRequestType
import ru.evotor.egais.api.model.dictionary.QueryStatus
import ru.evotor.egais.api.model.document.rest_b_code.QueryRestBCode
import ru.evotor.egais.api.provider.rest_b_code.QueryRestBCodeContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение
 * запросов на получение марок по справке 2 (справка Б)
 */
class QueryRestBCodeQuery :
    FilterBuilder<QueryRestBCodeQuery, QueryRestBCodeQuery.SortOrder, QueryRestBCode>(
        QueryRestBCodeContract.URI
    ) {

    /**
     * UUID документа.
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(QueryRestBCodeContract.COLUMN_UUID)

    /**
     * Отправитель запроса
     */
    @JvmField
    val owner = addFieldFilter<String>(QueryRestBCodeContract.COLUMN_OWNER)

    /**
     * uuid справки 2 для накладной.
     */
    @JvmField
    val informF2RegId = addFieldFilter<String>(QueryRestBCodeContract.COLUMN_INFORM_F2_REG_ID)

    /**
     * Статус запроса
     */
    @JvmField
    val status = addFieldFilter<QueryStatus?>(QueryRestBCodeContract.COLUMN_STATUS)

    /**
     * Комментарий от ЕГАИС
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(QueryRestBCodeContract.COLUMN_REJECT_COMMENT)

    /**
     * ID утм документа для накладной
     */
    @JvmField
    val utmDocumentUuid = addFieldFilter<UUID>(QueryRestBCodeContract.COLUMN_UTM_DOCUMENT_UUID)

    /**
     * Тип запроса
     */
    @JvmField
    val requestType = addFieldFilter<QueryRestBCodeRequestType?>(QueryRestBCodeContract.COLUMN_REQUEST_TYPE)

    override val currentQuery: QueryRestBCodeQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {
        override val currentSortOrder: SortOrder
            get() = this

        @JvmField
        val uuid = addFieldSorter(QueryRestBCodeContract.COLUMN_UUID)

        @JvmField
        val owner = addFieldSorter(QueryRestBCodeContract.COLUMN_OWNER)

        @JvmField
        val informF2RegId = addFieldSorter(QueryRestBCodeContract.COLUMN_INFORM_F2_REG_ID)

        @JvmField
        val status = addFieldSorter(QueryRestBCodeContract.COLUMN_STATUS)

        @JvmField
        val rejectComment = addFieldSorter(QueryRestBCodeContract.COLUMN_REJECT_COMMENT)

        @JvmField
        val utmDocumentUuid = addFieldSorter(QueryRestBCodeContract.COLUMN_UTM_DOCUMENT_UUID)

        @JvmField
        val requestType = addFieldSorter(QueryRestBCodeContract.COLUMN_REQUEST_TYPE)
    }

    override fun getValue(cursor: Cursor<QueryRestBCode>): QueryRestBCode {
        return createQueryRestBCode(cursor)
    }

    private fun createQueryRestBCode(cursor: Cursor<QueryRestBCode>): QueryRestBCode {
        val columnIndexUuid =
            cursor.getColumnIndexOrThrow(QueryRestBCodeContract.COLUMN_UUID)
        val columnIndexOwner =
            cursor.getColumnIndexOrThrow(QueryRestBCodeContract.COLUMN_OWNER)
        val columnIndexInformF2RegId =
            cursor.getColumnIndexOrThrow(QueryRestBCodeContract.COLUMN_INFORM_F2_REG_ID)
        val columnIndexStatus =
            cursor.getColumnIndexOrThrow(QueryRestBCodeContract.COLUMN_STATUS)
        val columnIndexRejectComment =
            cursor.getColumnIndexOrThrow(QueryRestBCodeContract.COLUMN_REJECT_COMMENT)
        val columnIndexUtmDocumentUuid =
            cursor.getColumnIndexOrThrow(QueryRestBCodeContract.COLUMN_UTM_DOCUMENT_UUID)
        val columnRequestType =
            cursor.getColumnIndexOrThrow(QueryRestBCodeContract.COLUMN_REQUEST_TYPE)

        return QueryRestBCode(
            UUID.fromString(cursor.getString(columnIndexUuid)),
            cursor.getString(columnIndexOwner),
            cursor.getString(columnIndexInformF2RegId),
            QueryStatus.valueOf(cursor.getString(columnIndexStatus)),
            cursor.getString(columnIndexRejectComment),
            UUID.fromString(cursor.getString(columnIndexUtmDocumentUuid)),
            QueryRestBCodeRequestType.valueOf(cursor.getString(columnRequestType)),
        )
    }
}