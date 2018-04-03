package ru.evotor.egais.api.query

import ru.evotor.egais.api.ActWriteOffShopApi
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffShop
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffStatus
import ru.evotor.egais.api.model.document.actwriteoff.TypeWriteOff
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffShopContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class ActWriteOffShopQuery : FilterBuilder<ActWriteOffShopQuery, ActWriteOffShopQuery.SortOrder, ActWriteOffShop>(ActWriteOffShopContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(ActWriteOffShopContract.COLUMN_UUID)
    @JvmField
    val docOwner = addFieldFilter<String>(ActWriteOffShopContract.COLUMN_OWNER)
    @JvmField
    val identity = addFieldFilter<String?>(ActWriteOffShopContract.COLUMN_IDENTITY)
    @JvmField
    val number = addFieldFilter<String?>(ActWriteOffShopContract.COLUMN_NUMBER)
    @JvmField
    val actDate = addFieldFilter<Date?>(ActWriteOffShopContract.COLUMN_ACT_DATE)
    @JvmField
    val typeWriteOff = addFieldFilter<TypeWriteOff>(ActWriteOffShopContract.COLUMN_TYPE_WRITE_OFF)
    @JvmField
    val note = addFieldFilter<String?>(ActWriteOffShopContract.COLUMN_NOTE)
    @JvmField
    val status = addFieldFilter<ActWriteOffStatus>(ActWriteOffShopContract.COLUMN_STATUS)
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActWriteOffShopContract.COLUMN_REJECT_COMMENT)

    override val currentQuery: ActWriteOffShopQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(ActWriteOffShopContract.COLUMN_UUID)
        @JvmField
        val docOwner = addFieldSorter(ActWriteOffShopContract.COLUMN_OWNER)
        @JvmField
        val identity = addFieldSorter(ActWriteOffShopContract.COLUMN_IDENTITY)
        @JvmField
        val number = addFieldSorter(ActWriteOffShopContract.COLUMN_NUMBER)
        @JvmField
        val actDate = addFieldSorter(ActWriteOffShopContract.COLUMN_ACT_DATE)
        @JvmField
        val typeWriteOff = addFieldSorter(ActWriteOffShopContract.COLUMN_TYPE_WRITE_OFF)
        @JvmField
        val note = addFieldSorter(ActWriteOffShopContract.COLUMN_NOTE)
        @JvmField
        val status = addFieldSorter(ActWriteOffShopContract.COLUMN_STATUS)
        @JvmField
        val rejectComment = addFieldSorter(ActWriteOffShopContract.COLUMN_REJECT_COMMENT)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOffShop>): ActWriteOffShop {
        return ActWriteOffShopApi.createActWriteOffShop(cursor)
    }

}