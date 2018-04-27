package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.transfer.TransferFromShop
import ru.evotor.egais.api.model.document.transfer.TransferStatus
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.transfer.TransferFromShopContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение документов передачи продукции из торгового зала на склад
 */
class TransferFromShopQuery : FilterBuilder<TransferFromShopQuery, TransferFromShopQuery.SortOrder, TransferFromShop>(TransferFromShopContract.URI) {

    /**
     * Уникальный идентификатор
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(TransferFromShopContract.COLUMN_UUID)

    /**
     * Кто подает документы
     */
    @JvmField
    val owner = addFieldFilter<String>(TransferFromShopContract.COLUMN_OWNER)

    /**
     * Идентификатор документа (клиентский)
     */
    @JvmField
    val identity = addFieldFilter<String?>(TransferFromShopContract.COLUMN_IDENTITY)

    /**
     * Номер документа
     */
    @JvmField
    val transferNumber = addFieldFilter<String>(TransferFromShopContract.COLUMN_NUMBER)

    /**
     * Дата составления
     */
    @JvmField
    val transferDate = addFieldFilter<Date?, String?>(TransferFromShopContract.COLUMN_TRANSFER_DATE, { DateConverter.toNullableString(it) })

    /**
     * Примечание
     */
    @JvmField
    val note = addFieldFilter<String?>(TransferFromShopContract.COLUMN_NOTE)

    /**
     * Статус обработки документа
     */
    @JvmField
    val status = addFieldFilter<TransferStatus>(TransferFromShopContract.COLUMN_STATUS)

    /**
     * Комментарий для отказа
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(TransferFromShopContract.COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    override val currentQuery: TransferFromShopQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор
         */
        @JvmField
        val uuid = addFieldSorter(TransferFromShopContract.COLUMN_UUID)

        /**
         * Кто подает документы
         */
        @JvmField
        val docOwner = addFieldSorter(TransferFromShopContract.COLUMN_OWNER)

        /**
         * Идентификатор документа (клиентский)
         */
        @JvmField
        val identity = addFieldSorter(TransferFromShopContract.COLUMN_IDENTITY)

        /**
         * Номер документа
         */
        @JvmField
        val transferNumber = addFieldSorter(TransferFromShopContract.COLUMN_NUMBER)

        /**
         * Дата составления
         */
        @JvmField
        val transferDate = addFieldSorter(TransferFromShopContract.COLUMN_TRANSFER_DATE)

        /**
         * Примечание
         */
        @JvmField
        val note = addFieldSorter(TransferFromShopContract.COLUMN_NOTE)

        /**
         * Статус обработки документа
         */
        @JvmField
        val status = addFieldSorter(TransferFromShopContract.COLUMN_STATUS)

        /**
         * Комментарий для отказа
         */
        @JvmField
        val rejectComment = addFieldSorter(TransferFromShopContract.COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<TransferFromShop>): TransferFromShop {
        val columnIndexUuid = cursor.getColumnIndexOrThrow(TransferFromShopContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndexOrThrow(TransferFromShopContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndexOrThrow(TransferFromShopContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndexOrThrow(TransferFromShopContract.COLUMN_NUMBER)
        val columnIndexDate = cursor.getColumnIndexOrThrow(TransferFromShopContract.COLUMN_TRANSFER_DATE)
        val columnIndexNote = cursor.getColumnIndexOrThrow(TransferFromShopContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndexOrThrow(TransferFromShopContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndexOrThrow(TransferFromShopContract.COLUMN_REJECT_COMMENT)
        val columnIndexReplyId = cursor.getColumnIndexOrThrow(UtmDocumentContract.COLUMN_REPLY_ID)

        return TransferFromShop(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                cursor.getString(columnIndexDate)?.let { DateConverter.toDate(it) },
                cursor.getString(columnIndexNote),
                TransferStatus.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment),
                cursor.getString(columnIndexReplyId)
        )
    }
}