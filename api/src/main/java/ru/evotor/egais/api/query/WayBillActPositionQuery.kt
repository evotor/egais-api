package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.waybillact.WayBillActPosition
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.egais.api.provider.waybillact.WayBillActPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

/**
 * Класс для формирования запроса на получение позиций ТТН
 */
class WayBillActPositionQuery : FilterBuilder<WayBillActPositionQuery, WayBillActPositionQuery.SortOrder, WayBillActPosition>(WayBillActPositionContract.URI) {

    /**
     * Уникальный идентификатор позиции
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(WayBillActPositionContract.COLUMN_UUID)

    /**
     * Уникальный идентификатор акта, содержащего позицию
     */
    @JvmField
    val wayBillActUuid = addFieldFilter<UUID>(WayBillActPositionContract.COLUMN_WAY_BILL_ACT_UUID)

    /**
     * Идентификатор позиции внутри накладной
     */
    @JvmField
    val identity = addFieldFilter<String>(WayBillActPositionContract.COLUMN_IDENTITY)

    /**
     * Регистрационный номер раздела справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(WayBillActPositionContract.COLUMN_INFORM_F2_REG_ID)

    /**
     * Количество
     */
    @JvmField
    val realQuantity = addFieldFilter<BigDecimal, Long>(
            WayBillActPositionContract.COLUMN_REAL_QUANTITY,
            { QuantityBigDecimalConverter.toLong(it) }
    )

    override val currentQuery: WayBillActPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции
         */
        @JvmField
        val uuid = addFieldSorter(WayBillActPositionContract.COLUMN_UUID)

        /**
         * Уникальный идентификатор акта, содержащего позицию
         */
        @JvmField
        val wayBillActUuid = addFieldSorter(WayBillActPositionContract.COLUMN_WAY_BILL_ACT_UUID)

        /**
         * Идентификатор позиции внутри накладной
         */
        @JvmField
        val identity = addFieldSorter(WayBillActPositionContract.COLUMN_IDENTITY)

        /**
         * Регистрационный номер раздела справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(WayBillActPositionContract.COLUMN_INFORM_F2_REG_ID)

        /**
         * Количество
         */
        @JvmField
        val realQuantity = addFieldSorter(WayBillActPositionContract.COLUMN_REAL_QUANTITY)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBillActPosition>): WayBillActPosition {
        return createWayBillActPosition(cursor)
    }

    private fun createWayBillActPosition(cursor: android.database.Cursor): WayBillActPosition {
        val columnUuid = cursor.getColumnIndex(WayBillActPositionContract.COLUMN_UUID)
        val columnWayBillActUuid = cursor.getColumnIndex(WayBillActPositionContract.COLUMN_WAY_BILL_ACT_UUID)
        val columnIdentity = cursor.getColumnIndex(WayBillActPositionContract.COLUMN_IDENTITY)
        val columnInformF2RegId = cursor.getColumnIndex(WayBillActPositionContract.COLUMN_INFORM_F2_REG_ID)

        return WayBillActPosition(
                UUID.fromString(cursor.getString(columnUuid)),
                UUID.fromString(cursor.getString(columnWayBillActUuid)),
                cursor.getString(columnIdentity),
                cursor.getString(columnInformF2RegId),
                cursor.getQuantity(WayBillActPositionContract.COLUMN_REAL_QUANTITY, WayBillActPositionContract.COLUMN_REAL_QUANTITY_DAL)
        )
    }
}