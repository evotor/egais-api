package ru.evotor.egais.api.query

import ru.evotor.egais.api.ActWriteOffShopApi
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffShopPosition
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffShopPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class ActWriteOffShopPositionQuery : FilterBuilder<ActWriteOffShopPositionQuery, ActWriteOffShopPositionQuery.SortOrder, ActWriteOffShopPosition>(ActWriteOffShopPositionContract.URI) {

    val uuid = addFieldFilter<UUID>(ActWriteOffShopPositionContract.COLUMN_UUID)
    val actWriteOffShopId = addFieldFilter<UUID?>(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_UUID)
    val identity = addFieldFilter<String?>(ActWriteOffShopPositionContract.COLUMN_IDENTITY)
    val quantity = addFieldFilter<BigDecimal>(ActWriteOffShopPositionContract.COLUMN_QUANTITY)
    val informBMarkInfoJson = addFieldFilter<String?>(ActWriteOffShopPositionContract.COLUMN_INFORM_B_MARK_INFO_JSON)
    val productInfoAlcCode = addFieldFilter<String>(ActWriteOffShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
    val markList = addFieldFilter<List<String>>(ActWriteOffShopPositionContract.COLUMN_MARK_LIST)

    override val currentQuery: ActWriteOffShopPositionQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val uuid = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_UUID)
        val actWriteOffShopId = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_UUID)
        val identity = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_IDENTITY)
        val quantity = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_QUANTITY)
        val informBMarkInfoJson = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_INFORM_B_MARK_INFO_JSON)
        val productInfoAlcCode = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val markList = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_MARK_LIST)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOffShopPosition>): ActWriteOffShopPosition {
        return ActWriteOffShopApi.createActWriteOffShopPosition(cursor)
    }

}