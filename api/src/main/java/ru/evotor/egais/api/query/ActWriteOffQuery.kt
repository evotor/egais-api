package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOff
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffStatus
import ru.evotor.egais.api.model.document.actwriteoff.TypeWriteOff
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение позиций акта списания со склада
 */
class ActWriteOffQuery : FilterBuilder<ActWriteOffQuery, ActWriteOffQuery.SortOrder, ActWriteOff>(ActWriteOffContract.URI) {

    /**
     * Уникальный идентификатор акта списания со склада
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActWriteOffContract.COLUMN_UUID)

    /**
     * Отправитель акта списания со склада
     */
    @JvmField
    val docOwner = addFieldFilter<String>(ActWriteOffContract.COLUMN_OWNER)

    /**
     * Идентификатор акта списания со склада (клиентский, к заполнению необязательный)
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActWriteOffContract.COLUMN_IDENTITY)

    /**
     * Номер документа
     */
    @JvmField
    val number = addFieldFilter<String?>(ActWriteOffContract.COLUMN_NUMBER)

    /**
     * Дата составления
     */
    @JvmField
    val actDate = addFieldFilter<Date, String>(ActWriteOffContract.COLUMN_ACT_DATE, { DateConverter.toString(it) })

    /**
     * Причина списания (Пересортица/Недостача/Уценка/Порча/Потери/Проверки/Арест/Иные цели/Реализация)
     */
    @JvmField
    val typeWriteOff = addFieldFilter<TypeWriteOff?>(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)

    /**
     * Примечание
     */
    @JvmField
    val note = addFieldFilter<String?>(ActWriteOffContract.COLUMN_NOTE)

    /**
     * Статус акта списания
     */
    @JvmField
    val status = addFieldFilter<ActWriteOffStatus>(ActWriteOffContract.COLUMN_STATUS)

    /**
     * Комментарий для отказа на акт списания со склада
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActWriteOffContract.COLUMN_REJECT_COMMENT)

    /**
     * Версия протокола ЕГАИС
     */
    @JvmField
    val version = addFieldFilter<Version>(ActWriteOffContract.COLUMN_VERSION)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    override val currentQuery: ActWriteOffQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор акта списания со склада
         */
        @JvmField
        val uuid = addFieldSorter(ActWriteOffContract.COLUMN_UUID)

        /**
         * Отправитель акта списания со склада
         */
        @JvmField
        val docOwner = addFieldSorter(ActWriteOffContract.COLUMN_OWNER)

        /**
         * Идентификатор акта списания со склада (клиентский, к заполнению необязательный)
         */
        @JvmField
        val identity = addFieldSorter(ActWriteOffContract.COLUMN_IDENTITY)

        /**
         * Номер документа
         */
        @JvmField
        val number = addFieldSorter(ActWriteOffContract.COLUMN_NUMBER)

        /**
         * Дата составления
         */
        @JvmField
        val actDate = addFieldSorter(ActWriteOffContract.COLUMN_ACT_DATE)

        /**
         * Причина списания (Пересортица/Недостача/Уценка/Порча/Потери/Проверки/Арест/Иные цели/Реализация)
         */
        @JvmField
        val typeWriteOff = addFieldSorter(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)

        /**
         * Примечание
         */
        @JvmField
        val note = addFieldSorter(ActWriteOffContract.COLUMN_NOTE)

        /**
         * Статус акта списания
         */
        @JvmField
        val status = addFieldSorter(ActWriteOffContract.COLUMN_STATUS)

        /**
         * Комментарий для отказа на акт списания со склада
         */
        @JvmField
        val rejectComment = addFieldSorter(ActWriteOffContract.COLUMN_REJECT_COMMENT)

        /**
         * Версия протокола ЕГАИС
         */
        @JvmField
        val version = addFieldSorter(ActWriteOffContract.COLUMN_VERSION)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOff>): ActWriteOff {
        return createActWriteOff(cursor)
    }

    private fun createActWriteOff(cursor: android.database.Cursor): ActWriteOff {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActWriteOffContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActWriteOffContract.COLUMN_NUMBER)
        val columnIndexActDate = cursor.getColumnIndex(ActWriteOffContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)
        val columnIndexNote = cursor.getColumnIndex(ActWriteOffContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActWriteOffContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActWriteOffContract.COLUMN_REJECT_COMMENT)
        val columnIndexVersion = cursor.getColumnIndex(ActWriteOffContract.COLUMN_VERSION)
        val columnIndexReplyId = cursor.getColumnIndex(UtmDocumentContract.COLUMN_REPLY_ID)

        return ActWriteOff(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                DateConverter.toDate(cursor.getString(columnIndexActDate)),
                cursor.getString(columnIndexType)?.let { TypeWriteOff.valueOf(it) },
                cursor.getString(columnIndexNote),
                ActWriteOffStatus.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment),
                Version.valueOf(cursor.getString(columnIndexVersion)),
                cursor.getString(columnIndexReplyId)
        )
    }
}