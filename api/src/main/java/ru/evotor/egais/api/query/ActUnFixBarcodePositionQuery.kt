package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actunfixbarcode.ActUnFixBarcodePosition
import ru.evotor.egais.api.provider.actunfixbarcode.ActUnFixBarcodePositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*


/**
 * Класс для формирования запроса на получение позиций акта отвязки марок от партии
 */
class ActUnFixBarcodePositionQuery : FilterBuilder<ActUnFixBarcodePositionQuery, ActUnFixBarcodePositionQuery.SortOrder, ActUnFixBarcodePosition>(ActUnFixBarcodePositionContract.URI) {

    /**
     * Уникальный идентификатор позиции акта отвязки марок от партии
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActUnFixBarcodePositionContract.COLUMN_UUID)

    /**
     * Уникальный идентификатор акта отвязки марок от партии
     */
    @JvmField
    val actUnFixBarcodeUuid = addFieldFilter<UUID>(ActUnFixBarcodePositionContract.COLUMN_ACT_UNFIX_BARCODE_UUID)

    /**
     * Идентификатор позиции акта отвязки марок от партии
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActUnFixBarcodePositionContract.COLUMN_IDENTITY)

    /**
     * Регистрационный номер раздела справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(ActUnFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

    override val currentQuery: ActUnFixBarcodePositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции акта отвязки марок от партии
         */
        @JvmField
        val uuid = addFieldSorter(ActUnFixBarcodePositionContract.COLUMN_UUID)

        /**
         * Уникальный идентификатор акта отвязки марок от партии
         */
        @JvmField
        val actUnFixBarcodeUuid = addFieldSorter(ActUnFixBarcodePositionContract.COLUMN_ACT_UNFIX_BARCODE_UUID)

        /**
         * Идентификатор позиции акта отвязки марок от партии
         */
        @JvmField
        val identity = addFieldSorter(ActUnFixBarcodePositionContract.COLUMN_IDENTITY)

        /**
         * Регистрационный номер раздела справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(ActUnFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

        override val currentSortOrder: SortOrder
            get() = this
    }

    override fun getValue(cursor: Cursor<ActUnFixBarcodePosition>): ActUnFixBarcodePosition {
        return createActUnFixBarcodePosition(cursor)
    }

    private fun createActUnFixBarcodePosition(cursor: android.database.Cursor): ActUnFixBarcodePosition {
        val columnIndexUuid = cursor.getColumnIndex(ActUnFixBarcodePositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActUnFixBarcodePositionContract.COLUMN_ACT_UNFIX_BARCODE_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActUnFixBarcodePositionContract.COLUMN_IDENTITY)
        val columnIndexInformF2RegId = cursor.getColumnIndex(ActUnFixBarcodePositionContract.COLUMN_INFORM_F2_REG_ID)

        return ActUnFixBarcodePosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexInformF2RegId)
        )
    }
}