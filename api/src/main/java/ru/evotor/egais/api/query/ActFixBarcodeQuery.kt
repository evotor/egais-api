package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actfixbarcode.ActFixBarcode
import ru.evotor.egais.api.model.document.actfixbarcode.Status
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.actfixbarcode.ActFixBarcodeContract
import ru.evotor.egais.api.provider.actfixbarcode.ActFixBarcodePositionContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение акта привязки марок к партии
 */
class ActFixBarcodeQuery : FilterBuilder<ActFixBarcodeQuery, ActFixBarcodeQuery.SortOrder, ActFixBarcode>(ActFixBarcodeContract.URI) {

    /**
     * Уникальный идентификатор акта привязки марок к партии
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActFixBarcodeContract.COLUMN_UUID)

    /**
     * Отправитель акта привязки марок к партии
     */
    @JvmField
    val docOwner = addFieldFilter<String>(ActFixBarcodeContract.COLUMN_OWNER)

    /**
     * Идентификатор акта привязки марок к партии (клиентский, к заполнению необязательный)
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActFixBarcodeContract.COLUMN_IDENTITY)

    /**
     * Номер документа
     */
    @JvmField
    val number = addFieldFilter<String?>(ActFixBarcodeContract.COLUMN_NUMBER)

    /**
     * Дата составления
     */
    @JvmField
    val actDate = addFieldFilter<Date, String>(ActFixBarcodeContract.COLUMN_ACT_DATE) { DateConverter.toString(it) }

    /**
     * Примечание
     */
    @JvmField
    val note = addFieldFilter<String?>(ActFixBarcodeContract.COLUMN_NOTE)

    /**
     * Статус акта списания
     */
    @JvmField
    val status = addFieldFilter<Status>(ActFixBarcodeContract.COLUMN_STATUS)

    /**
     * Комментарий для отказа на акт привязки марок
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActFixBarcodeContract.COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    /**
     * Регистрационный номер раздела справки 2 в позициях акта привязки
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(ActFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

    override val currentQuery: ActFixBarcodeQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<ActFixBarcodeQuery.SortOrder>() {

        /**
         * Уникальный идентификатор акта привязки марок к партии
         */
        @JvmField
        val uuid = addFieldSorter(ActFixBarcodeContract.COLUMN_UUID)

        /**
         * Отправитель акта привязки марок к партии
         */
        @JvmField
        val docOwner = addFieldSorter(ActFixBarcodeContract.COLUMN_OWNER)

        /**
         * Идентификатор акта привязки марок к партии (клиентский, к заполнению необязательный)
         */
        @JvmField
        val identity = addFieldSorter(ActFixBarcodeContract.COLUMN_IDENTITY)

        /**
         * Номер документа
         */
        @JvmField
        val number = addFieldSorter(ActFixBarcodeContract.COLUMN_NUMBER)

        /**
         * Дата составления
         */
        @JvmField
        val actDate = addFieldSorter(ActFixBarcodeContract.COLUMN_ACT_DATE)

        /**
         * Примечание
         */
        @JvmField
        val note = addFieldSorter(ActFixBarcodeContract.COLUMN_NOTE)

        /**
         * Статус акта привязки марок к партии
         */
        @JvmField
        val status = addFieldSorter(ActFixBarcodeContract.COLUMN_STATUS)

        /**
         * Комментарий для отказа на акт привязки марок к партии
         */
        @JvmField
        val rejectComment = addFieldSorter(ActFixBarcodeContract.COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        /**
         * Регистрационный номер раздела справки 2 в позициях акта привязки
         */
        @JvmField
        val informF2RegId = addFieldSorter(ActFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<ActFixBarcode>): ActFixBarcode {
        return createActFixBarcode(cursor)
    }

    private fun createActFixBarcode(cursor: android.database.Cursor): ActFixBarcode {
        val columnIndexUuid = cursor.getColumnIndex(ActFixBarcodeContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActFixBarcodeContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActFixBarcodeContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActFixBarcodeContract.COLUMN_NUMBER)
        val columnIndexActDate = cursor.getColumnIndex(ActFixBarcodeContract.COLUMN_ACT_DATE)
        val columnIndexNote = cursor.getColumnIndex(ActFixBarcodeContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActFixBarcodeContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActFixBarcodeContract.COLUMN_REJECT_COMMENT)
        val columnIndexReplyId = cursor.getColumnIndex(UtmDocumentContract.COLUMN_REPLY_ID)

        return ActFixBarcode(
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