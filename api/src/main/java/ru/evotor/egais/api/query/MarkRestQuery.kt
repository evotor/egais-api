package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.dictionary.MarkRest
import ru.evotor.egais.api.provider.dictionary.MarkRestContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение информации о марках на 3-м регистре
 */
class MarkRestQuery : FilterBuilder<MarkRestQuery, MarkRestQuery.SortOrder, MarkRest>(MarkRestContract.URI) {

    /**
     * UUID документа основания
     */
    @JvmField
    val docUuid = addFieldFilter<UUID>(MarkRestContract.COLUMN_DOCUMENT_UUID)

    /**
     * Регистрационный номер раздела справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String>(MarkRestContract.COLUMN_NAME_INFORM_F2_REG_ID)

    /**
     * Марка
     */
    @JvmField
    val mark = addFieldFilter<String>(MarkRestContract.COLUMN_MARK)

    override val currentQuery: MarkRestQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * UUID документа основания
         */
        @JvmField
        val docUuid = addFieldSorter(MarkRestContract.COLUMN_DOCUMENT_UUID)

        /**
         * Регистрационный номер раздела справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(MarkRestContract.COLUMN_NAME_INFORM_F2_REG_ID)

        /**
         * Марка
         */
        @JvmField
        val mark = addFieldSorter(MarkRestContract.COLUMN_MARK)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<MarkRest>): MarkRest {
        return createMarkRest(cursor)
    }

    private fun createMarkRest(cursor: android.database.Cursor): MarkRest {
        val columnIndexDocUuid = cursor.getColumnIndex(MarkRestContract.COLUMN_DOCUMENT_UUID)
        val columnIndexInformF2RegId = cursor.getColumnIndex(MarkRestContract.COLUMN_NAME_INFORM_F2_REG_ID)
        val columnIndexMark = cursor.getColumnIndex(MarkRestContract.COLUMN_MARK)
        return MarkRest(
                UUID.fromString(cursor.getString(columnIndexDocUuid)),
                cursor.getString(columnIndexInformF2RegId),
                cursor.getString(columnIndexMark)
        )
    }
}
