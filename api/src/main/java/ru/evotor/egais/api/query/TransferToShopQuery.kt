package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.transfer.TransferStatus
import ru.evotor.egais.api.model.document.transfer.TransferToShop
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.transfer.TransferToShopContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение документов передачи продукции со склада в торговый зал
 */
class TransferToShopQuery : FilterBuilder<TransferToShopQuery, TransferToShopQuery.SortOrder, TransferToShop>(TransferToShopContract.URI) {

    /**
     * Уникальный идентификатор
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(TransferToShopContract.COLUMN_UUID)

    /**
     * Кто подает документы
     */
    @JvmField
    val owner = addFieldFilter<String>(TransferToShopContract.COLUMN_OWNER)

    /**
     * Идентификатор документа (клиентский)
     */
    @JvmField
    val identity = addFieldFilter<String?>(TransferToShopContract.COLUMN_IDENTITY)

    /**
     * Номер документа
     */
    @JvmField
    val transferNumber = addFieldFilter<String>(TransferToShopContract.COLUMN_NUMBER)

    /**
     * Дата составления
     */
    @JvmField
    val transferDate = addFieldFilter<Date?, String?>(TransferToShopContract.COLUMN_TRANSFER_DATE, { DateConverter.toNullableString(it) })

    /**
     * Примечание
     */
    @JvmField
    val note = addFieldFilter<String?>(TransferToShopContract.COLUMN_NOTE)

    /**
     * Статус обработки документа
     */
    @JvmField
    val status = addFieldFilter<TransferStatus>(TransferToShopContract.COLUMN_STATUS)

    /**
     * Комментарий для отказа
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(TransferToShopContract.COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    override val currentQuery: TransferToShopQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор
         */
        @JvmField
        val uuid = addFieldSorter(TransferToShopContract.COLUMN_UUID)

        /**
         * Кто подает документы
         */
        @JvmField
        val docOwner = addFieldSorter(TransferToShopContract.COLUMN_OWNER)

        /**
         * Идентификатор документа (клиентский)
         */
        @JvmField
        val identity = addFieldSorter(TransferToShopContract.COLUMN_IDENTITY)

        /**
         * Номер документа
         */
        @JvmField
        val transferNumber = addFieldSorter(TransferToShopContract.COLUMN_NUMBER)

        /**
         * Дата составления
         */
        @JvmField
        val transferDate = addFieldSorter(TransferToShopContract.COLUMN_TRANSFER_DATE)

        /**
         * Примечание
         */
        @JvmField
        val note = addFieldSorter(TransferToShopContract.COLUMN_NOTE)

        /**
         * Статус обработки документа
         */
        @JvmField
        val status = addFieldSorter(TransferToShopContract.COLUMN_STATUS)

        /**
         * Комментарий для отказа
         */
        @JvmField
        val rejectComment = addFieldSorter(TransferToShopContract.COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<TransferToShop>): TransferToShop {
        val columnIndexUuid = cursor.getColumnIndexOrThrow(TransferToShopContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndexOrThrow(TransferToShopContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndexOrThrow(TransferToShopContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndexOrThrow(TransferToShopContract.COLUMN_NUMBER)
        val columnIndexDate = cursor.getColumnIndexOrThrow(TransferToShopContract.COLUMN_TRANSFER_DATE)
        val columnIndexNote = cursor.getColumnIndexOrThrow(TransferToShopContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndexOrThrow(TransferToShopContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndexOrThrow(TransferToShopContract.COLUMN_REJECT_COMMENT)
        val columnIndexReplyId = cursor.getColumnIndexOrThrow(UtmDocumentContract.COLUMN_REPLY_ID)

        return TransferToShop(
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