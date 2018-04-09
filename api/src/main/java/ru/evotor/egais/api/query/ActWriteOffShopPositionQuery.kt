package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffShopPosition
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffShopPositionContract
import ru.evotor.egais.api.provider.converter.MarkListConverter
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class ActWriteOffShopPositionQuery : FilterBuilder<ActWriteOffShopPositionQuery, ActWriteOffShopPositionQuery.SortOrder, ActWriteOffShopPosition>(ActWriteOffShopPositionContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(ActWriteOffShopPositionContract.COLUMN_UUID)
    @JvmField
    val actWriteOffShopId = addFieldFilter<UUID?>(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_UUID)
    @JvmField
    val identity = addFieldFilter<String?>(ActWriteOffShopPositionContract.COLUMN_IDENTITY)
    @JvmField
    val quantity = addFieldFilter<BigDecimal>(ActWriteOffShopPositionContract.COLUMN_QUANTITY)
    @JvmField
    val informF2MarkInfoJson = addFieldFilter<String?>(ActWriteOffShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)
    @JvmField
    val productInfoAlcCode = addFieldFilter<String>(ActWriteOffShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

    override val currentQuery: ActWriteOffShopPositionQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_UUID)
        @JvmField
        val actWriteOffShopUuid = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_UUID)
        @JvmField
        val identity = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_IDENTITY)
        @JvmField
        val quantity = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_QUANTITY)
        @JvmField
        val informF2MarkInfoJson = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)
        @JvmField
        val productInfoAlcCode = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOffShopPosition>): ActWriteOffShopPosition {
        return createActWriteOffShopPosition(cursor)
    }

    private fun createActWriteOffShopPosition(cursor: android.database.Cursor): ActWriteOffShopPosition {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_IDENTITY)
        val columnIndexQuantity = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_QUANTITY)
        val columnIndexMarkJson = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)
        val columnIndexAlcCode = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val columnIndexMarkList = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_MARK_LIST)

        return ActWriteOffShopPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnIndexQuantity)),
                cursor.getString(columnIndexMarkJson),
                cursor.getString(columnIndexAlcCode),
                MarkListConverter.toMarkList(cursor.getString(columnIndexMarkList))
        )
    }
}