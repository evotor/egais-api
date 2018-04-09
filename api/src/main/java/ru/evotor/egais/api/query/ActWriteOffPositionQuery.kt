package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffPosition
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffPositionContract
import ru.evotor.egais.api.provider.converter.MarkListConverter
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class ActWriteOffPositionQuery : FilterBuilder<ActWriteOffPositionQuery, ActWriteOffPositionQuery.SortOrder, ActWriteOffPosition>(ActWriteOffPositionContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(ActWriteOffPositionContract.COLUMN_UUID)
    @JvmField
    val actWriteOffUuid = addFieldFilter<UUID>(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)
    @JvmField
    val identity = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_IDENTITY)
    @JvmField
    val quantity = addFieldFilter<BigDecimal>(ActWriteOffPositionContract.COLUMN_QUANTITY)
    @JvmField
    val informF2RegId = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_INFORM_F2_REG_ID)
    @JvmField
    val informF2MarkInfoJson = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)
    @JvmField
    val productInfoAlcCode = addFieldFilter<String>(ActWriteOffPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

    override val currentQuery: ActWriteOffPositionQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(ActWriteOffPositionContract.COLUMN_UUID)
        @JvmField
        val actWriteOffUuid = addFieldSorter(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)
        @JvmField
        val identity = addFieldSorter(ActWriteOffPositionContract.COLUMN_IDENTITY)
        @JvmField
        val quantity = addFieldSorter(ActWriteOffPositionContract.COLUMN_QUANTITY)
        @JvmField
        val informF2RegId = addFieldSorter(ActWriteOffPositionContract.COLUMN_INFORM_F2_REG_ID)
        @JvmField
        val informF2MarkInfoJson = addFieldSorter(ActWriteOffPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)
        @JvmField
        val productInfoAlcCode = addFieldSorter(ActWriteOffPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOffPosition>): ActWriteOffPosition {
        return createActWriteOffPosition(cursor)
    }

    private fun createActWriteOffPosition(cursor: android.database.Cursor): ActWriteOffPosition {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_IDENTITY)
        val columnIndexQuantity = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_QUANTITY)
        val columnIndexInformF2RegId = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_INFORM_F2_REG_ID)
        val columnIndexMarkJson = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)
        val columnIndexAlcCode = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val columnIndexMarkList = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_MARK_LIST)

        return ActWriteOffPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnIndexQuantity)),
                cursor.getString(columnIndexInformF2RegId),
                cursor.getString(columnIndexMarkJson),
                cursor.getString(columnIndexAlcCode),
                MarkListConverter.toMarkList(cursor.getString(columnIndexMarkList))
        )
    }
}