package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.waybillact.AcceptType
import ru.evotor.egais.api.model.document.waybillact.Status
import ru.evotor.egais.api.model.document.waybillact.Type
import ru.evotor.egais.api.model.document.waybillact.WayBillAct
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.waybillact.WayBillActContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение актов ТТН
 */
class WayBillActQuery : FilterBuilder<WayBillActQuery, WayBillActQuery.SortOrder, WayBillAct>(WayBillActContract.URI) {

    /**
     * Уникальный идентификатор акта
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(WayBillActContract.COLUMN_UUID)

    /**
     * Кто подает документы
     */
    @JvmField
    val docOwner = addFieldFilter<String>(WayBillActContract.COLUMN_OWNER)

    /**
     * Идентификатор акта (клиентский)
     */
    @JvmField
    val identity = addFieldFilter<String?>(WayBillActContract.COLUMN_IDENTITY)

    /**
     * Тип подтверждения: Принимаем/есть расхождения/отказываем
     */
    @JvmField
    val acceptType = addFieldFilter<AcceptType?>(WayBillActContract.COLUMN_ACCEPT_TYPE)

    /**
     * Номер акта
     */
    @JvmField
    val number = addFieldFilter<String>(WayBillActContract.COLUMN_NUMBER)

    /**
     * Дата составления акта
     */
    @JvmField
    val creationDate = addFieldFilter<Date, String>(WayBillActContract.COLUMN_CREATION_DATE, { DateConverter.toString(it) })

    /**
     * Идентификатор накладной в системе
     */
    @JvmField
    val wbRegId = addFieldFilter<String?>(WayBillActContract.COLUMN_WB_REG_ID)

    /**
     * Заметки
     */
    @JvmField
    val note = addFieldFilter<String?>(WayBillActContract.COLUMN_NOTE)

    /**
     * Тип приемки: Полная/частичная
     */
    @JvmField
    val type = addFieldFilter<Type?>(WayBillActContract.COLUMN_TYPE)

    /**
     * Версия протокола ЕГАИС
     */
    @JvmField
    val version = addFieldFilter<Version?>(WayBillActContract.COLUMN_VERSION)

    /**
     * Статус накладной
     */
    @JvmField
    val status = addFieldFilter<Status>(WayBillActContract.COLUMN_STATUS)

    /**
     * Комментарий для отказа
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(WayBillActContract.COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    override val currentQuery: WayBillActQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор акта
         */
        @JvmField
        val uuid = addFieldSorter(WayBillActContract.COLUMN_UUID)

        /**
         * Кто подает документы
         */
        @JvmField
        val docOwner = addFieldSorter(WayBillActContract.COLUMN_OWNER)

        /**
         * Идентификатор акта (клиентский)
         */
        @JvmField
        val identity = addFieldSorter(WayBillActContract.COLUMN_IDENTITY)

        /**
         * Тип подтверждения: Принимаем/есть расхождения/отказываем
         */
        @JvmField
        val acceptType = addFieldSorter(WayBillActContract.COLUMN_ACCEPT_TYPE)

        /**
         * Номер акта
         */
        @JvmField
        val number = addFieldSorter(WayBillActContract.COLUMN_NUMBER)

        /**
         * Дата составления акта
         */
        @JvmField
        val creationDate = addFieldSorter(WayBillActContract.COLUMN_CREATION_DATE)

        /**
         * Идентификатор накладной в системе
         */
        @JvmField
        val wbRegId = addFieldSorter(WayBillActContract.COLUMN_WB_REG_ID)

        /**
         * Заметки
         */
        @JvmField
        val note = addFieldSorter(WayBillActContract.COLUMN_NOTE)

        /**
         * Тип приемки: Полная/частичная
         */
        @JvmField
        val type = addFieldSorter(WayBillActContract.COLUMN_TYPE)

        /**
         * Версия протокола ЕГАИС
         */
        @JvmField
        val version = addFieldSorter(WayBillActContract.COLUMN_VERSION)

        /**
         * Статус накладной
         */
        @JvmField
        val status = addFieldSorter(WayBillActContract.COLUMN_STATUS)

        /**
         * Комментарий для отказа
         */
        @JvmField
        val rejectComment = addFieldSorter(WayBillActContract.COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBillAct>): WayBillAct {
        return createWayBillAct(cursor)
    }

    private fun createWayBillAct(cursor: android.database.Cursor): WayBillAct {
        val columnUuid = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_UUID)
        val columnOwner = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_OWNER)
        val columnIdentity = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_IDENTITY)
        val columnAcceptType = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_ACCEPT_TYPE)
        val columnNumber = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_NUMBER)
        val columnDate = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_CREATION_DATE)
        val columnWbRegId = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_WB_REG_ID)
        val columnNote = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_NOTE)
        val columnType = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_TYPE)
        val columnVersion = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_VERSION)
        val columnStatus = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_STATUS)
        val columnRejectComment = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_REJECT_COMMENT)
        val columnReplyId = cursor.getColumnIndexOrThrow(UtmDocumentContract.COLUMN_REPLY_ID)

        return WayBillAct(
                UUID.fromString(cursor.getString(columnUuid)),
                cursor.getString(columnOwner),
                cursor.getString(columnIdentity),
                cursor.getString(columnAcceptType)?.let { AcceptType.valueOf(it) },
                cursor.getString(columnNumber),
                DateConverter.toDate(cursor.getString(columnDate)),
                cursor.getString(columnWbRegId),
                cursor.getString(columnNote),
                cursor.getString(columnType)?.let { Type.valueOf(it) },
                cursor.getString(columnVersion)?.let { Version.valueOf(it) },
                Status.valueOf(cursor.getString(columnStatus)),
                cursor.getString(columnRejectComment),
                cursor.getString(columnReplyId)
        )
    }
}