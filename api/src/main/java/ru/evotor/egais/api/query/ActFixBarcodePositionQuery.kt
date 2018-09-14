package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actfixbarcode.ActFixBarcodePosition
import ru.evotor.egais.api.provider.actfixbarcode.ActFixBarcodePositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*


/**
 * Класс для формирования запроса на получение позиций акта привязки марок к партии
 */
class ActFixBarcodePositionQuery : FilterBuilder<ActFixBarcodePositionQuery, ActFixBarcodePositionQuery.SortOrder, ActFixBarcodePosition>(ActFixBarcodePositionContract.URI) {

    /**
     * Уникальный идентификатор позиции акта привязки марок к партии
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActFixBarcodePositionContract.COLUMN_UUID)

    /**
     * Уникальный идентификатор акта привязки марок к партии
     */
    @JvmField
    val actFixBarcodeUuid = addFieldFilter<UUID>(ActFixBarcodePositionContract.COLUMN_ACT_FIX_BARCODE_UUID)

    /**
     * Идентификатор позиции акта привязки марок к партии
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActFixBarcodePositionContract.COLUMN_IDENTITY)

    /**
     * Регистрационный номер раздела справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(ActFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

    override val currentQuery: ActFixBarcodePositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции акта привязки марок к партии
         */
        @JvmField
        val uuid = addFieldSorter(ActFixBarcodePositionContract.COLUMN_UUID)

        /**
         * Уникальный идентификатор акта привязки марок к партии
         */
        @JvmField
        val actFixBarcodeUuid = addFieldSorter(ActFixBarcodePositionContract.COLUMN_ACT_FIX_BARCODE_UUID)

        /**
         * Идентификатор позиции акта привязки марок к партии
         */
        @JvmField
        val identity = addFieldSorter(ActFixBarcodePositionContract.COLUMN_IDENTITY)

        /**
         * Регистрационный номер раздела справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(ActFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<ActFixBarcodePosition>): ActFixBarcodePosition {
        return createActFixBarcodePosition(cursor)
    }

    private fun createActFixBarcodePosition(cursor: android.database.Cursor): ActFixBarcodePosition {
        val columnIndexUuid = cursor.getColumnIndex(ActFixBarcodePositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActFixBarcodePositionContract.COLUMN_ACT_FIX_BARCODE_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActFixBarcodePositionContract.COLUMN_IDENTITY)
        val columnIndexInformF2RegId = cursor.getColumnIndex(ActFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

        return ActFixBarcodePosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexInformF2RegId)
        )
    }
}