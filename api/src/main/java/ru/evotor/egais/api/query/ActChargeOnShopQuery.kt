package ru.evotor.egais.api.query

import ru.evotor.egais.api.ActChargeOnShopApi
import ru.evotor.egais.api.model.document.actchargeonshop.ActChargeOnShop
import ru.evotor.egais.api.model.document.actchargeonshop.Status
import ru.evotor.egais.api.model.document.actchargeonshop.Type
import ru.evotor.egais.api.provider.actchargeonshop.ActChargeOnShopContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class ActChargeOnShopQuery : FilterBuilder<ActChargeOnShopQuery, ActChargeOnShopQuery.SortOrder, ActChargeOnShop>(ActChargeOnShopContract.URI) {

    val uuid = addFieldFilter<UUID>(ActChargeOnShopContract.COLUMN_UUID)
    val docOwner = addFieldFilter<String>(ActChargeOnShopContract.COLUMN_OWNER)
    val identity = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_IDENTITY)
    val number = addFieldFilter<String>(ActChargeOnShopContract.COLUMN_NUMBER)
    val actDate = addFieldFilter<Date>(ActChargeOnShopContract.COLUMN_ACT_DATE)
    val type = addFieldFilter<Type>(ActChargeOnShopContract.COLUMN_TYPE_ACT_CHARGE_ON_SHOP)
    val actWriteOff = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_ACT_WRITE_OFF)
    val note = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_NOTE)
    val status = addFieldFilter<Status>(ActChargeOnShopContract.COLUMN_STATUS)
    val rejectComment = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_REJECT_COMMENT)

    override val currentQuery: ActChargeOnShopQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        val uuid = addFieldSorter(ActChargeOnShopContract.COLUMN_UUID)
        val docOwner = addFieldSorter(ActChargeOnShopContract.COLUMN_OWNER)
        val identity = addFieldSorter(ActChargeOnShopContract.COLUMN_IDENTITY)
        val number = addFieldSorter(ActChargeOnShopContract.COLUMN_NUMBER)
        val actDate = addFieldSorter(ActChargeOnShopContract.COLUMN_ACT_DATE)
        val type = addFieldSorter(ActChargeOnShopContract.COLUMN_TYPE_ACT_CHARGE_ON_SHOP)
        val actWriteOff = addFieldSorter(ActChargeOnShopContract.COLUMN_ACT_WRITE_OFF)
        val note = addFieldSorter(ActChargeOnShopContract.COLUMN_NOTE)
        val status = addFieldSorter(ActChargeOnShopContract.COLUMN_STATUS)
        val rejectComment = addFieldSorter(ActChargeOnShopContract.COLUMN_REJECT_COMMENT)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActChargeOnShop>): ActChargeOnShop {
        return ActChargeOnShopApi.createActChargeOnShop(cursor)
    }

}