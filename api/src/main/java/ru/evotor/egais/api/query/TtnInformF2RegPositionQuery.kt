package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.waybill.TtnInformF2RegPosition
import ru.evotor.egais.api.provider.waybill.TtnInformF2RegPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запросов на полученме позиций справок 2
 */
class TtnInformF2RegPositionQuery : FilterBuilder<TtnInformF2RegPositionQuery, TtnInformF2RegPositionQuery.SortOrder, TtnInformF2RegPosition>(TtnInformF2RegPositionContract.URI) {

    /**
     * Уникальный идентификатор позиции
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(TtnInformF2RegPositionContract.COLUMN_UUID)

    /**
     * Уникальный идентификатор справки 2
     */
    @JvmField
    val ttnInformF2RegUuid = addFieldFilter<UUID>(TtnInformF2RegPositionContract.COLUMN_TTN_INFORM_F2_REG_ID)

    /**
     * Идентификатор позиции внутри накладной
     */
    @JvmField
    val identity = addFieldFilter<String>(TtnInformF2RegPositionContract.COLUMN_IDENTITY)

    /**
     * Регистрационный номер записи справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String>(TtnInformF2RegPositionContract.COLUMN_INFORM_F2_REG_ID)

    override val currentQuery: TtnInformF2RegPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор справки 2
         */
        @JvmField
        val ttnInformF2RegUuid = addFieldSorter(TtnInformF2RegPositionContract.COLUMN_TTN_INFORM_F2_REG_ID)

        /**
         * Идентификатор позиции внутри накладной
         */
        @JvmField
        val identity = addFieldSorter(TtnInformF2RegPositionContract.COLUMN_IDENTITY)

        /**
         * Регистрационный номер записи справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(TtnInformF2RegPositionContract.COLUMN_INFORM_F2_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<TtnInformF2RegPosition>): TtnInformF2RegPosition {
        return createTtnInformF2RegPosition(cursor)
    }

    private fun createTtnInformF2RegPosition(cursor: Cursor<TtnInformF2RegPosition>): TtnInformF2RegPosition {
        val columnUuid = cursor.getColumnIndexOrThrow(TtnInformF2RegPositionContract.COLUMN_UUID)
        val columnIdentity = cursor.getColumnIndexOrThrow(TtnInformF2RegPositionContract.COLUMN_IDENTITY)
        val columnTtnInformF2RegUuid = cursor.getColumnIndexOrThrow(TtnInformF2RegPositionContract.COLUMN_TTN_INFORM_F2_REG_ID)
        val columnInformF2RegId = cursor.getColumnIndexOrThrow(TtnInformF2RegPositionContract.COLUMN_INFORM_F2_REG_ID)

        return TtnInformF2RegPosition(
                UUID.fromString(cursor.getString(columnUuid)),
                UUID.fromString(cursor.getString(columnTtnInformF2RegUuid)),
                cursor.getString(columnIdentity),
                cursor.getString(columnInformF2RegId)
        )
    }
}