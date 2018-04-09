package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actchargeonshop.ActChargeOnShop
import ru.evotor.egais.api.model.document.actchargeonshop.Status
import ru.evotor.egais.api.model.document.actchargeonshop.Type
import ru.evotor.egais.api.provider.actchargeonshop.ActChargeOnShopContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class ActChargeOnShopQuery : FilterBuilder<ActChargeOnShopQuery, ActChargeOnShopQuery.SortOrder, ActChargeOnShop>(ActChargeOnShopContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(ActChargeOnShopContract.COLUMN_UUID)
    @JvmField
    val docOwner = addFieldFilter<String>(ActChargeOnShopContract.COLUMN_OWNER)
    @JvmField
    val identity = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_IDENTITY)
    @JvmField
    val number = addFieldFilter<String>(ActChargeOnShopContract.COLUMN_NUMBER)
    @JvmField
    val actDate = addFieldFilter<Date>(ActChargeOnShopContract.COLUMN_ACT_DATE)
    @JvmField
    val type = addFieldFilter<Type>(ActChargeOnShopContract.COLUMN_TYPE_ACT_CHARGE_ON_SHOP)
    @JvmField
    val actWriteOff = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_ACT_WRITE_OFF)
    @JvmField
    val note = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_NOTE)
    @JvmField
    val status = addFieldFilter<Status>(ActChargeOnShopContract.COLUMN_STATUS)
    @JvmField
    val rejectComment = addFieldFilter<String?>(ActChargeOnShopContract.COLUMN_REJECT_COMMENT)

    override val currentQuery: ActChargeOnShopQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(ActChargeOnShopContract.COLUMN_UUID)
        @JvmField
        val docOwner = addFieldSorter(ActChargeOnShopContract.COLUMN_OWNER)
        @JvmField
        val identity = addFieldSorter(ActChargeOnShopContract.COLUMN_IDENTITY)
        @JvmField
        val number = addFieldSorter(ActChargeOnShopContract.COLUMN_NUMBER)
        @JvmField
        val actDate = addFieldSorter(ActChargeOnShopContract.COLUMN_ACT_DATE)
        @JvmField
        val type = addFieldSorter(ActChargeOnShopContract.COLUMN_TYPE_ACT_CHARGE_ON_SHOP)
        @JvmField
        val actWriteOff = addFieldSorter(ActChargeOnShopContract.COLUMN_ACT_WRITE_OFF)
        @JvmField
        val note = addFieldSorter(ActChargeOnShopContract.COLUMN_NOTE)
        @JvmField
        val status = addFieldSorter(ActChargeOnShopContract.COLUMN_STATUS)
        @JvmField
        val rejectComment = addFieldSorter(ActChargeOnShopContract.COLUMN_REJECT_COMMENT)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActChargeOnShop>): ActChargeOnShop {
        return createActChargeOnShop(cursor)
    }

    private fun createActChargeOnShop(cursor: android.database.Cursor): ActChargeOnShop {
        val columnIndexUuid = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_NUMBER)
        val columnIndexDate = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_TYPE_ACT_CHARGE_ON_SHOP)
        val columnIndexActWriteOff = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_ACT_WRITE_OFF)
        val columnIndexNote = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActChargeOnShopContract.COLUMN_REJECT_COMMENT)

        return ActChargeOnShop(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                Date(cursor.getString(columnIndexDate)),
                Type.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexActWriteOff),
                cursor.getString(columnIndexNote),
                Status.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment)
        )
    }
}