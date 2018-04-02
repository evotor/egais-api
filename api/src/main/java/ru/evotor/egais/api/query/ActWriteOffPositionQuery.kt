package ru.evotor.egais.api.query

import ru.evotor.egais.api.ActWriteOffApi
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffPosition
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class ActWriteOffPositionQuery : FilterBuilder<ActWriteOffPositionQuery, ActWriteOffPositionQuery.SortOrder, ActWriteOffPosition>(ActWriteOffPositionContract.URI) {

    val uuid = addFieldFilter<UUID>(ActWriteOffPositionContract.COLUMN_UUID)
    val actWriteOffUuid = addFieldFilter<UUID>(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)
    val identity = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_IDENTITY)
    val quantity = addFieldFilter<BigDecimal>(ActWriteOffPositionContract.COLUMN_QUANTITY)
    val informBRegId = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_INFORM_B_REG_ID)
    val informBMarkInfoJson = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_INFORM_B_MARK_INFO_JSON)
    val productInfoAlcCode = addFieldFilter<String>(ActWriteOffPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
    val markList = addFieldFilter<List<String>>(ActWriteOffPositionContract.COLUMN_MARK_LIST)

    override val currentQuery: ActWriteOffPositionQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val uuid = addFieldSorter(ActWriteOffPositionContract.COLUMN_UUID)
        val actWriteOffUuid = addFieldSorter(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)
        val identity = addFieldSorter(ActWriteOffPositionContract.COLUMN_IDENTITY)
        val quantity = addFieldSorter(ActWriteOffPositionContract.COLUMN_QUANTITY)
        val informBRegId = addFieldSorter(ActWriteOffPositionContract.COLUMN_INFORM_B_REG_ID)
        val informBMarkInfoJson = addFieldSorter(ActWriteOffPositionContract.COLUMN_INFORM_B_MARK_INFO_JSON)
        val productInfoAlcCode = addFieldSorter(ActWriteOffPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val markList = addFieldSorter(ActWriteOffPositionContract.COLUMN_MARK_LIST)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOffPosition>): ActWriteOffPosition {
        return ActWriteOffApi.createActWriteOffPosition(cursor)
    }

}