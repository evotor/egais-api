package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actunfixbarcode.ActUnFixBarcodePositionMark
import ru.evotor.egais.api.provider.actunfixbarcode.ActUnFixBarcodePositionMarkContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

/**
 * Класс для формирования запроса на получение марок позиций акта отвязки марок от партии
 */
class ActUnFixBarcodePositionMarkQuery : FilterBuilder<ActUnFixBarcodePositionMarkQuery, ActUnFixBarcodePositionMarkQuery.SortOrder, ActUnFixBarcodePositionMark>(ActUnFixBarcodePositionMarkContract.URI) {

    /**
     * Уникальный идентификатор позиции акта отвязки марок от партии
     */
    @JvmField
    val actUnFixBarcodePositionUuid = addFieldFilter<UUID>(ActUnFixBarcodePositionMarkContract.COLUMN_ACT_UNFIX_BARCODE_POSITION_UUID)

    /**
     * Марка
     */
    @JvmField
    val mark = addFieldFilter<String>(ActUnFixBarcodePositionMarkContract.COLUMN_MARK)

    override val currentQuery: ActUnFixBarcodePositionMarkQuery
        get() = this

    override fun getValue(cursor: Cursor<ActUnFixBarcodePositionMark>): ActUnFixBarcodePositionMark {
        val columnActUnFixBarcodePositionUuid = cursor.getColumnIndexOrThrow(ActUnFixBarcodePositionMarkContract.COLUMN_ACT_UNFIX_BARCODE_POSITION_UUID)
        val columnMark = cursor.getColumnIndexOrThrow(ActUnFixBarcodePositionMarkContract.COLUMN_MARK)

        return ActUnFixBarcodePositionMark(
                UUID.fromString(cursor.getString(columnActUnFixBarcodePositionUuid)),
                cursor.getString(columnMark)
        )
    }

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции акта отвязки марок от партии
         */
        @JvmField
        val actUnFixBarcodePositionUuid = addFieldSorter(ActUnFixBarcodePositionMarkContract.COLUMN_ACT_UNFIX_BARCODE_POSITION_UUID)

        /**
         * Марка
         */
        @JvmField
        val mark = addFieldSorter(ActUnFixBarcodePositionMarkContract.COLUMN_MARK)

        override val currentSortOrder: SortOrder
            get() = this
    }
}