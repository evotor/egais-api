package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actfixbarcode.ActFixBarcodePositionMark
import ru.evotor.egais.api.provider.actfixbarcode.ActFixBarcodePositionMarkContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение марок позиций акта привязки марок к партии
 */
class ActFixBarcodePositionMarkQuery : FilterBuilder<ActFixBarcodePositionMarkQuery, ActFixBarcodePositionMarkQuery.SortOrder, ActFixBarcodePositionMark>(ActFixBarcodePositionMarkContract.URI) {

    /**
     * Уникальный идентификатор позиции акта привязки марок к партии
     */
    @JvmField
    val actFixBarcodePositionUuid = addFieldFilter<UUID>(ActFixBarcodePositionMarkContract.COLUMN_ACT_FIX_BARCODE_POSITION_UUID)

    /**
     * Марка
     */
    @JvmField
    val mark = addFieldFilter<String>(ActFixBarcodePositionMarkContract.COLUMN_MARK)

    override val currentQuery: ActFixBarcodePositionMarkQuery
        get() = this

    override fun getValue(cursor: Cursor<ActFixBarcodePositionMark>): ActFixBarcodePositionMark {
        val columnActFixBarcodePositionUuid = cursor.getColumnIndexOrThrow(ActFixBarcodePositionMarkContract.COLUMN_ACT_FIX_BARCODE_POSITION_UUID)
        val columnMark = cursor.getColumnIndexOrThrow(ActFixBarcodePositionMarkContract.COLUMN_MARK)

        return ActFixBarcodePositionMark(
                UUID.fromString(cursor.getString(columnActFixBarcodePositionUuid)),
                cursor.getString(columnMark)
        )
    }

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции акта привязки марок к партии
         */
        @JvmField
        val actFixBarcodePositionUuid = addFieldSorter(ActFixBarcodePositionMarkContract.COLUMN_ACT_FIX_BARCODE_POSITION_UUID)

        /**
         * Марка
         */
        @JvmField
        val mark = addFieldSorter(ActFixBarcodePositionMarkContract.COLUMN_MARK)

        override val currentSortOrder: SortOrder
            get() = this
    }
}