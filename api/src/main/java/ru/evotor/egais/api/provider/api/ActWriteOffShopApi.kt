package ru.evotor.egais.api.provider.api

import android.content.Context
import android.database.Cursor
import android.net.Uri
import org.apache.commons.lang3.StringUtils
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffShop
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffShopPosition
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffStatus
import ru.evotor.egais.api.model.document.actwriteoff.TypeWriteOff
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffShopContract
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffShopPositionContract
import java.math.BigDecimal
import java.util.*

object ActWriteOffShopApi {
    const val AUTHORITY = "ru.evotor.egais.actwriteoffshop.api"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmStatic
    fun getActWriteOffShopList(context: Context): ru.evotor.egais.api.provider.Cursor<ActWriteOffShop?>? {
        return context.contentResolver.query(ActWriteOffShopContract.URI, null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<ActWriteOffShop?>(it) {
                        override fun getValue(): ActWriteOffShop? {
                            return createActWriteOffShop(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getActWriteOffShopListByDate(context: Context, date: Date): ru.evotor.egais.api.provider.Cursor<ActWriteOffShop?>? {
        return context.contentResolver.query(Uri.withAppendedPath(ActWriteOffShopContract.URI, date.toString()), null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<ActWriteOffShop?>(it) {
                        override fun getValue(): ActWriteOffShop? {
                            return createActWriteOffShop(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getActWriteOffShopPositionsByUuid(context: Context, uuid: UUID): ru.evotor.egais.api.provider.Cursor<ActWriteOffShopPosition?>? {
        return context.contentResolver.query(Uri.withAppendedPath(ActWriteOffShopPositionContract.URI, uuid.toString()), null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<ActWriteOffShopPosition?>(it) {
                        override fun getValue(): ActWriteOffShopPosition? {
                            return createActWriteOffShopPosition(this)
                        }
                    }
                }
    }

    private fun createActWriteOffShopPosition(cursor: Cursor): ActWriteOffShopPosition? {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_UUID)
        val columnIndexActId = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_ID)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_IDENTITY)
        val columnIndexQuantity = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_QUANTITY)
        val columnIndexMarkJson = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_INFORM_B_MARK_INFO_JSON)
        val columnIndexAlcCode = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val columnIndexMarkList = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_MARK_LIST)

        return ActWriteOffShopPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActId)),
                cursor.getString(columnIndexIdentity),
                BigDecimal(cursor.getLong(columnIndexQuantity)),
                cursor.getString(columnIndexMarkJson),
                cursor.getString(columnIndexAlcCode),
                toMarkList(cursor.getString(columnIndexMarkList))
        )
    }

    private fun createActWriteOffShop(cursor: Cursor): ActWriteOffShop? {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_NUMBER)
        val columnIndexActDate = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActWriteOffShopContract.COLUMN_TYPE_ACT_WRITE_OFF)
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

    private fun toMarkList(markListString: String?): List<String> {
        return markListString?.let {
            StringUtils.split(markListString, ",")?.toList()
        } ?: ArrayList<String>()
    }
}