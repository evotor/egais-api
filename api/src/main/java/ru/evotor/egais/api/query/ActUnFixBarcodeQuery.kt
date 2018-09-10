package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actunfixbarcode.ActUnFixBarcode
import ru.evotor.egais.api.model.document.actunfixbarcode.Status
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.actunfixbarcode.ActUnFixBarcodeContract
import ru.evotor.egais.api.provider.actunfixbarcode.ActUnFixBarcodePositionContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение акта отвязки марок от партии
 */
class ActUnFixBarcodeQuery : FilterBuilder<ActUnFixBarcodeQuery, ActUnFixBarcodeQuery.SortOrder, ActUnFixBarcode>(ActUnFixBarcodeContract.URI) {

    /**
     * Уникальный идентификатор акта отвязки марок от партии
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActUnFixBarcodeContract.COLUMN_UUID)

    /**
     * Отправитель акта отвязки марок от партии
     */
    @JvmField
    val docOwner = addFieldFilter<String>(ActUnFixBarcodeContract.COLUMN_OWNER)

    /**
     * Идентификатор акта отвязки марок от партии (клиентский, к заполнению необязательный)
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActUnFixBarcodeContract.COLUMN_IDENTITY)

    /**
     * Номер документа
     */
    @JvmField
    val number = addFieldFilter<String?>(ActUnFixBarcodeContract.COLUMN_NUMBER)

    /**
     * Дата составления
     */
    @JvmField
    val actDate = addFieldFilter<Date, String>(ActUnFixBarcodeContract.COLUMN_ACT_DATE) { DateConverter.toString(it) }

    /**
     * Примечание
     */
    @JvmField
    val note = addFieldFilter<String?>(ActUnFixBarcodeContract.COLUMN_NOTE)

    /**
     * Статус акта списания
     */
    @JvmField
    val status = addFieldFilter<Status>(ActUnFixBarcodeContract.COLUMN_STATUS)

    /**
     * Комментарий для отказа на акт отвязки марок от партии
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActUnFixBarcodeContract.COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    /**
     * Регистрационный номер раздела справки 2 в позициях акта отвязки марок от партии
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(ActUnFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

    override val currentQuery: ActUnFixBarcodeQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<ActUnFixBarcodeQuery.SortOrder>() {

        /**
         * Уникальный идентификатор акта отвязки марок от партии
         */
        @JvmField
        val uuid = addFieldSorter(ActUnFixBarcodeContract.COLUMN_UUID)

        /**
         * Отправитель акта отвязки марок от партии
         */
        @JvmField
        val docOwner = addFieldSorter(ActUnFixBarcodeContract.COLUMN_OWNER)

        /**
         * Идентификатор акта отвязки марок от партии (клиентский, к заполнению необязательный)
         */
        @JvmField
        val identity = addFieldSorter(ActUnFixBarcodeContract.COLUMN_IDENTITY)

        /**
         * Номер документа
         */
        @JvmField
        val number = addFieldSorter(ActUnFixBarcodeContract.COLUMN_NUMBER)

        /**
         * Дата составления
         */
        @JvmField
        val actDate = addFieldSorter(ActUnFixBarcodeContract.COLUMN_ACT_DATE)

        /**
         * Примечание
         */
        @JvmField
        val note = addFieldSorter(ActUnFixBarcodeContract.COLUMN_NOTE)

        /**
         * Статус акта отвязки марок от партии
         */
        @JvmField
        val status = addFieldSorter(ActUnFixBarcodeContract.COLUMN_STATUS)

        /**
         * Комментарий для отказа на акт отвязки марок от партии
         */
        @JvmField
        val rejectComment = addFieldSorter(ActUnFixBarcodeContract.COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        /**
         * Регистрационный номер раздела справки 2 в позициях акта отвязки марок от партии
         */
        @JvmField
        val informF2RegId = addFieldSorter(ActUnFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<ActUnFixBarcode>): ActUnFixBarcode {
        return createActFixBarcode(cursor)
    }

    private fun createActFixBarcode(cursor: android.database.Cursor): ActUnFixBarcode {
        val columnIndexUuid = cursor.getColumnIndex(ActUnFixBarcodeContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActUnFixBarcodeContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActUnFixBarcodeContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActUnFixBarcodeContract.COLUMN_NUMBER)
        val columnIndexActDate = cursor.getColumnIndex(ActUnFixBarcodeContract.COLUMN_ACT_DATE)
        val columnIndexNote = cursor.getColumnIndex(ActUnFixBarcodeContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActUnFixBarcodeContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActUnFixBarcodeContract.COLUMN_REJECT_COMMENT)
        val columnIndexReplyId = cursor.getColumnIndex(UtmDocumentContract.COLUMN_REPLY_ID)

        return ActUnFixBarcode(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                DateConverter.toDate(cursor.getString(columnIndexActDate)),
                cursor.getString(columnIndexNote),
                cursor.getString(columnIndexRejectComment),
                Status.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexReplyId)
        )
    }
}