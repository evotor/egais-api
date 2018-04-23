package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.waybill.WayBillPositionMark
import ru.evotor.egais.api.provider.waybill.WayBillPositionMarkContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение марок позиций ТТН
 */
class WayBillPositionMarkQuery : FilterBuilder<WayBillPositionMarkQuery, WayBillPositionMarkQuery.SortOrder, WayBillPositionMark>(WayBillPositionMarkContract.URI) {

    /**
     * Уникальный идентификатор позиции в ТТН
     */
    @JvmField
    val wayBillPositionUuid = addFieldFilter<UUID>(WayBillPositionMarkContract.COLUMN_WAYBILL_POSITION_UUID)

    /**
     * Номер короба
     */
    @JvmField
    val boxNumber = addFieldFilter<String>(WayBillPositionMarkContract.COLUMN_BOX_NUMBER)

    /**
     * Марка
     */
    @JvmField
    val mark = addFieldFilter<String>(WayBillPositionMarkContract.COLUMN_MARK)

    override val currentQuery: WayBillPositionMarkQuery
        get() = this

    override fun getValue(cursor: Cursor<WayBillPositionMark>): WayBillPositionMark {
        val columnWayBillPositionUuid = cursor.getColumnIndexOrThrow(WayBillPositionMarkContract.COLUMN_WAYBILL_POSITION_UUID)
        val columnBoxNumber = cursor.getColumnIndexOrThrow(WayBillPositionMarkContract.COLUMN_BOX_NUMBER)
        val columnMark = cursor.getColumnIndexOrThrow(WayBillPositionMarkContract.COLUMN_MARK)

        return WayBillPositionMark(
                UUID.fromString(cursor.getString(columnWayBillPositionUuid)),
                cursor.getString(columnBoxNumber),
                cursor.getString(columnMark)
        )
    }

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции в ТТН
         */
        @JvmField
        val wayBillPositionUuid = addFieldSorter(WayBillPositionMarkContract.COLUMN_WAYBILL_POSITION_UUID)


        /**
         * Номер короба
         */
        @JvmField
        val boxNumber = addFieldSorter(WayBillPositionMarkContract.COLUMN_BOX_NUMBER)

        /**
         * Марка
         */
        @JvmField
        val mark = addFieldSorter(WayBillPositionMarkContract.COLUMN_MARK)

        override val currentSortOrder: SortOrder
            get() = this
    }
}