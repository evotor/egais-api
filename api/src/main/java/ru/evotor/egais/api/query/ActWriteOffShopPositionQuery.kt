package ru.evotor.egais.api.query

import ru.evotor.egais.api.ActWriteOffShopApi
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffShopPosition
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffShopPositionContract
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
        return ActWriteOffShopApi.createActWriteOffShopPosition(cursor)
    }

}