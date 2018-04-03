package ru.evotor.egais.api.query

import ru.evotor.egais.api.ActChargeOnShopApi
import ru.evotor.egais.api.model.document.actchargeonshop.ActChargeOnShopPosition
import ru.evotor.egais.api.provider.actchargeonshop.ActChargeOnShopPositionContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

class ActChargeOnShopPositionQuery : FilterBuilder<ActChargeOnShopPositionQuery, ActChargeOnShopPositionQuery.SortOrder, ActChargeOnShopPosition>(ActChargeOnShopPositionContract.URI) {


    @JvmField
    val uuid = addFieldFilter<UUID>(ActChargeOnShopPositionContract.COLUMN_UUID)
    @JvmField
    val actChargeOnShopUuid = addFieldFilter<UUID>(ActChargeOnShopPositionContract.COLUMN_ACT_CHARGE_ON_SHOP_UUID)
    @JvmField
    val identity = addFieldFilter<String>(ActChargeOnShopPositionContract.COLUMN_IDENTITY)
    @JvmField
    val quantity = addFieldFilter<BigDecimal>(ActChargeOnShopPositionContract.COLUMN_QUANTITY)
    @JvmField
    val productInfoAlcCode = addFieldFilter<String>(ActChargeOnShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

    override val currentQuery: ActChargeOnShopPositionQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_UUID)
        @JvmField
        val actChargeOnShopUuid = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_ACT_CHARGE_ON_SHOP_UUID)
        @JvmField
        val identity = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_IDENTITY)
        @JvmField
        val quantity = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_QUANTITY)
        @JvmField
        val productInfoAlcCode = addFieldSorter(ActChargeOnShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActChargeOnShopPosition>): ActChargeOnShopPosition {
        return ActChargeOnShopApi.createActChargeOnShopPosition(cursor)
    }

}