package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.waybillact.WayBillActPositionMark
import ru.evotor.egais.api.provider.waybillact.WayBillActPositionMarkContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение марок позиций ТТН
 */
class WayBillActPositionMarkQuery : FilterBuilder<WayBillActPositionMarkQuery, WayBillActPositionMarkQuery.SortOrder, WayBillActPositionMark>(WayBillActPositionMarkContract.URI) {

    /**
     * Уникальный идентификатор позиции ТТН
     */
    @JvmField
    val wayBillActPositionUuid = addFieldFilter<UUID>(WayBillActPositionMarkContract.COLUMN_WAY_BILL_ACT_POSITION_UUID)

    /**
     * Марка
     */
    @JvmField
    val mark = addFieldFilter<String>(WayBillActPositionMarkContract.COLUMN_MARK)

    override val currentQuery: WayBillActPositionMarkQuery
        get() = this

    override fun getValue(cursor: Cursor<WayBillActPositionMark>): WayBillActPositionMark {
        val columnWayBillActPositionUuid = cursor.getColumnIndexOrThrow(WayBillActPositionMarkContract.COLUMN_WAY_BILL_ACT_POSITION_UUID)
        val columnMark = cursor.getColumnIndexOrThrow(WayBillActPositionMarkContract.COLUMN_MARK)

        return WayBillActPositionMark(
                UUID.fromString(cursor.getString(columnWayBillActPositionUuid)),
                cursor.getString(columnMark)
        )
    }

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции ТТН
         */
        @JvmField
        val wayBillActPositionUuid = addFieldSorter(WayBillActPositionMarkContract.COLUMN_WAY_BILL_ACT_POSITION_UUID)

        /**
         * Марка
         */
        @JvmField
        val mark = addFieldSorter(WayBillActPositionMarkContract.COLUMN_MARK)

        override val currentSortOrder: SortOrder
            get() = this
    }
}