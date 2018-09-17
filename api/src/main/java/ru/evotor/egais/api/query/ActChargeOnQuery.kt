package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actchargeon.ActChargeOn
import ru.evotor.egais.api.model.document.actchargeon.Status
import ru.evotor.egais.api.model.document.actchargeon.Type
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.actchargeon.ActChargeOnContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение актов постановки на баланс на склад
 */
class ActChargeOnQuery : FilterBuilder<ActChargeOnQuery, ActChargeOnQuery.SortOrder, ActChargeOn>(ActChargeOnContract.URI) {

    /**
     * Уникальный идентификатор
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActChargeOnContract.COLUMN_UUID)

    /**
     * Кто подает документы
     */
    @JvmField
    val docOwner = addFieldFilter<String>(ActChargeOnContract.COLUMN_OWNER)

    /**
     * ID акта (клиентсикй)
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActChargeOnContract.COLUMN_IDENTITY)

    /**
     * Номер документа
     */
    @JvmField
    val number = addFieldFilter<String>(ActChargeOnContract.COLUMN_NUMBER)

    /**
     * Дата постановски на баланс
     */
    @JvmField
    val actDate = addFieldFilter<Date, String>(ActChargeOnContract.COLUMN_ACT_DATE) { DateConverter.toString(it) }

    /**
     * Причина постановки на баланс (Пересортица/Излишки/Продукция, полученная до 01.01.2016)
     */
    @JvmField
    val type = addFieldFilter<Type>(ActChargeOnContract.COLUMN_TYPE_ACT_CHARGE_ON)

    /**
     * Регистрационный номер акта списания по типу "Пересортица".
     * Обязательно для заполнения для типа постановки на баланс "Пересортица".
     */
    @JvmField
    val actWriteOff = addFieldFilter<String?>(ActChargeOnContract.COLUMN_ACT_WRITE_OFF)

    /**
     * Примечание
     */
    @JvmField
    val note = addFieldFilter<String?>(ActChargeOnContract.COLUMN_NOTE)

    /**
     * Статус документа
     */
    @JvmField
    val status = addFieldFilter<Status>(ActChargeOnContract.COLUMN_STATUS)

    /**
     * Комментарий при отказе
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActChargeOnContract.COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    override val currentQuery: ActChargeOnQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор
         */
        @JvmField
        val uuid = addFieldSorter(ActChargeOnContract.COLUMN_UUID)

        /**
         * Кто подает документы
         */
        @JvmField
        val docOwner = addFieldSorter(ActChargeOnContract.COLUMN_OWNER)

        /**
         * ID акта (клиентсикй)
         */
        @JvmField
        val identity = addFieldSorter(ActChargeOnContract.COLUMN_IDENTITY)

        /**
         * Номер документа
         */
        @JvmField
        val number = addFieldSorter(ActChargeOnContract.COLUMN_NUMBER)

        /**
         * Дата постановски на баланс
         */
        @JvmField
        val actDate = addFieldSorter(ActChargeOnContract.COLUMN_ACT_DATE)

        /**
         * Причина постановки на баланс (Пересортица/Излишки/Продукция, полученная до 01.01.2016)
         */
        @JvmField
        val type = addFieldSorter(ActChargeOnContract.COLUMN_TYPE_ACT_CHARGE_ON)

        /**
         * Регистрационный номер акта списания по типу "Пересортица".
         * Обязательно для заполнения для типа постановки на баланс "Пересортица".
         */
        @JvmField
        val actWriteOff = addFieldSorter(ActChargeOnContract.COLUMN_ACT_WRITE_OFF)

        /**
         * Примечание
         */
        @JvmField
        val note = addFieldSorter(ActChargeOnContract.COLUMN_NOTE)

        /**
         * Статус документа
         */
        @JvmField
        val status = addFieldSorter(ActChargeOnContract.COLUMN_STATUS)

        /**
         * Комментарий при отказе
         */
        @JvmField
        val rejectComment = addFieldSorter(ActChargeOnContract.COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActChargeOn>): ActChargeOn {
        return createActChargeOnShop(cursor)
    }

    private fun createActChargeOnShop(cursor: android.database.Cursor): ActChargeOn {
        val columnIndexUuid = cursor.getColumnIndex(ActChargeOnContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActChargeOnContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActChargeOnContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActChargeOnContract.COLUMN_NUMBER)
        val columnIndexDate = cursor.getColumnIndex(ActChargeOnContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActChargeOnContract.COLUMN_TYPE_ACT_CHARGE_ON)
        val columnIndexActWriteOff = cursor.getColumnIndex(ActChargeOnContract.COLUMN_ACT_WRITE_OFF)
        val columnIndexNote = cursor.getColumnIndex(ActChargeOnContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActChargeOnContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActChargeOnContract.COLUMN_REJECT_COMMENT)
        val columnIndexReplyId = cursor.getColumnIndex(UtmDocumentContract.COLUMN_REPLY_ID)

        return ActChargeOn(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                DateConverter.toDate(cursor.getString(columnIndexDate)),
                Type.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexActWriteOff),
                cursor.getString(columnIndexNote),
                Status.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment),
                cursor.getString(columnIndexReplyId)
        )
    }
}