package ru.evotor.egais.api.query

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
        return createActWriteOffShop(cursor)
    }

    private fun createActWriteOffShop(cursor: android.database.Cursor): ActWriteOffShop {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_NUMBER)
        val columnIndexActDate = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_TYPE_WRITE_OFF)
        val columnIndexNote = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_REJECT_COMMENT)

        return ActWriteOffShop(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                Date(cursor.getString(columnIndexActDate)),
                TypeWriteOff.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexNote),
                ActWriteOffStatus.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment)
        )
    }
}