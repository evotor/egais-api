package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actchargeonshop.ActChargeOnShop
import ru.evotor.egais.api.model.document.actchargeonshop.Status
import ru.evotor.egais.api.model.document.actchargeonshop.Type
import ru.evotor.egais.api.provider.UtmDocumentContract
import ru.evotor.egais.api.provider.actchargeonshop.ActChargeOnShopContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение актов поставки
 */
class ActChargeOnShopQuery : FilterBuilder<ActChargeOnShopQuery, ActChargeOnShopQuery.SortOrder, ActChargeOnShop>(ActChargeOnShopContract.URI) {

    /**
     * Уникальный идентификатор
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActChargeOnShopContract.COLUMN_UUID)

    /**
     * Кто подает документы
     */
    @JvmField
    val docOwner = addFieldFilter<String>(ActChargeOnShopContract.COLUMN_OWNER)

    /**
     * ID акта (клиентсикй)
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_IDENTITY)

    /**
     * Номер документа
     */
    @JvmField
    val number = addFieldFilter<String>(ActChargeOnShopContract.COLUMN_NUMBER)

    /**
     * Дата постановски на баланс
     */
    @JvmField
    val actDate = addFieldFilter<Date, String>(ActChargeOnShopContract.COLUMN_ACT_DATE, { DateConverter.toString(it) })

    /**
     * Причина постановки на баланс (Пересортица/Излишки/Продукция, полученная до 01.01.2016)
     */
    @JvmField
    val type = addFieldFilter<Type>(ActChargeOnShopContract.COLUMN_TYPE_ACT_CHARGE_ON_SHOP)

    /**
     * Регистрационный номер акта списания по типу "Пересортица".
     * Обязательно для заполнения для типа постановки на баланс "Пересортица".
     */
    @JvmField
    val actWriteOff = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_ACT_WRITE_OFF)

    /**
     * Примечание
     */
    @JvmField
    val note = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_NOTE)

    /**
     * Статус документа
     */
    @JvmField
    val status = addFieldFilter<Status>(ActChargeOnShopContract.COLUMN_STATUS)

    /**
     * Комментарий при отказе
     */
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_REJECT_COMMENT)

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    @JvmField
    val replyId = addFieldFilter<String?>(UtmDocumentContract.COLUMN_REPLY_ID)

    override val currentQuery: ActChargeOnShopQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор
         */
        @JvmField
        val uuid = addFieldSorter(ActChargeOnShopContract.COLUMN_UUID)

        /**
         * Кто подает документы
         */
        @JvmField
        val docOwner = addFieldSorter(ActChargeOnShopContract.COLUMN_OWNER)

        /**
         * ID акта (клиентсикй)
         */
        @JvmField
        val identity = addFieldSorter(ActChargeOnShopContract.COLUMN_IDENTITY)

        /**
         * Номер документа
         */
        @JvmField
        val number = addFieldSorter(ActChargeOnShopContract.COLUMN_NUMBER)

        /**
         * Дата постановски на баланс
         */
        @JvmField
        val actDate = addFieldSorter(ActChargeOnShopContract.COLUMN_ACT_DATE)

        /**
         * Причина постановки на баланс (Пересортица/Излишки/Продукция, полученная до 01.01.2016)
         */
        @JvmField
        val type = addFieldSorter(ActChargeOnShopContract.COLUMN_TYPE_ACT_CHARGE_ON_SHOP)

        /**
         * Регистрационный номер акта списания по типу "Пересортица".
         * Обязательно для заполнения для типа постановки на баланс "Пересортица".
         */
        @JvmField
        val actWriteOff = addFieldSorter(ActChargeOnShopContract.COLUMN_ACT_WRITE_OFF)

        /**
         * Примечание
         */
        @JvmField
        val note = addFieldSorter(ActChargeOnShopContract.COLUMN_NOTE)

        /**
         * Статус документа
         */
        @JvmField
        val status = addFieldSorter(ActChargeOnShopContract.COLUMN_STATUS)

        /**
         * Комментарий при отказе
         */
        @JvmField
        val rejectComment = addFieldSorter(ActChargeOnShopContract.COLUMN_REJECT_COMMENT)

        /**
         * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
         */
        @JvmField
        val replyId = addFieldSorter(UtmDocumentContract.COLUMN_REPLY_ID)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActChargeOnShop>): ActChargeOnShop {
        return createActChargeOnShop(cursor)
    }

    private fun createActChargeOnShop(cursor: android.database.Cursor): ActChargeOnShop {
        val columnIndexUuid = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_NUMBER)
        val columnIndexDate = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_TYPE_ACT_CHARGE_ON_SHOP)
        val columnIndexActWriteOff = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_ACT_WRITE_OFF)
        val columnIndexNote = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_REJECT_COMMENT)
        val columnIndexReplyId = cursor.getColumnIndex(UtmDocumentContract.COLUMN_REPLY_ID)

        return ActChargeOnShop(
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