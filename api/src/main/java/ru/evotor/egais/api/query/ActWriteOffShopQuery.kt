package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffShop
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffStatus
import ru.evotor.egais.api.model.document.actwriteoff.TypeWriteOff
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffShopContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение актов списания из магазина
 */
class ActWriteOffShopQuery : FilterBuilder<ActWriteOffShopQuery, ActWriteOffShopQuery.SortOrder, ActWriteOffShop>(ActWriteOffShopContract.URI) {

    /**
     * Уникальный идентификатор акта списания из магазина
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActWriteOffShopContract.COLUMN_UUID)

    /**
     * Отправитель акта списания из магазина
     */
    @JvmField
    val docOwner = addFieldFilter<String>(ActWriteOffShopContract.COLUMN_OWNER)

    /**
     * Идентификатор акта списания из магазина (клиентский, к заполнению необязательный)
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActWriteOffShopContract.COLUMN_IDENTITY)

    /**
     * Номер документа
     */
    @JvmField
    val number = addFieldFilter<String?>(ActWriteOffShopContract.COLUMN_NUMBER)

    /**
     * Дата составления
     */
    @JvmField
    val actDate = addFieldFilter<Date?, String?>(ActWriteOffShopContract.COLUMN_ACT_DATE, { DateConverter.toNullableString(it) })

    /**
     * Причина списания (Пересортица/Недостача/Уценка/Порча/Потери/Проверки/Арест/Иные цели/Реализация)
     */
    @JvmField
    val typeWriteOff = addFieldFilter<TypeWriteOff>(ActWriteOffShopContract.COLUMN_TYPE_WRITE_OFF)

    /**
     * Примечание
     */
    @JvmField
    val note = addFieldFilter<String?>(ActWriteOffShopContract.COLUMN_NOTE)

    /**
     * Статус акта списания
     */
    @JvmField
    val status = addFieldFilter<ActWriteOffStatus>(ActWriteOffShopContract.COLUMN_STATUS)

    /**
     * Комментарий для отказа на акт списания из магазина
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActWriteOffShopContract.COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    override val currentQuery: ActWriteOffShopQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор акта списания из магазина
         */
        @JvmField
        val uuid = addFieldSorter(ActWriteOffShopContract.COLUMN_UUID)

        /**
         * Отправитель акта списания из магазина
         */
        @JvmField
        val docOwner = addFieldSorter(ActWriteOffShopContract.COLUMN_OWNER)

        /**
         * Идентификатор акта списания из магазина (клиентский, к заполнению необязательный)
         */
        @JvmField
        val identity = addFieldSorter(ActWriteOffShopContract.COLUMN_IDENTITY)

        /**
         * Номер документа
         */
        @JvmField
        val number = addFieldSorter(ActWriteOffShopContract.COLUMN_NUMBER)

        /**
         * Дата составления
         */
        @JvmField
        val actDate = addFieldSorter(ActWriteOffShopContract.COLUMN_ACT_DATE)

        /**
         * Причина списания (Пересортица/Недостача/Уценка/Порча/Потери/Проверки/Арест/Иные цели/Реализация)
         */
        @JvmField
        val typeWriteOff = addFieldSorter(ActWriteOffShopContract.COLUMN_TYPE_WRITE_OFF)

        /**
         * Примечание
         */
        @JvmField
        val note = addFieldSorter(ActWriteOffShopContract.COLUMN_NOTE)

        /**
         * Статус акта списания
         */
        @JvmField
        val status = addFieldSorter(ActWriteOffShopContract.COLUMN_STATUS)

        /**
         * Комментарий для отказа на акт списания из магазина
         */
        @JvmField
        val rejectComment = addFieldSorter(ActWriteOffShopContract.COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOffShop>): ActWriteOffShop {
        return createActWriteOffShop(cursor)
    }

    private fun createActWriteOffShop(cursor: android.database.Cursor): ActWriteOffShop {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_NUMBER)
        val columnIndexActDate = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_TYPE_WRITE_OFF)
        val columnIndexNote = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_REJECT_COMMENT)
        val columnIndexReplyId = cursor.getColumnIndex(UtmDocumentContract.COLUMN_REPLY_ID)

        return ActWriteOffShop(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                cursor.getString(columnIndexActDate)?.let { DateConverter.toDate(it) },
                TypeWriteOff.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexNote),
                ActWriteOffStatus.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment),
                cursor.getString(columnIndexReplyId)
        )
    }
}