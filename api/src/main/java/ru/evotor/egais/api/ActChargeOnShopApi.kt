package ru.evotor.egais.api

import android.content.Context
import ru.evotor.egais.api.model.document.actchargeonshop.ActChargeOnShop
import ru.evotor.egais.api.model.document.actchargeonshop.ActChargeOnShopPosition
import ru.evotor.egais.api.model.document.actchargeonshop.Status
import ru.evotor.egais.api.model.document.actchargeonshop.Type
import ru.evotor.egais.api.provider.actchargeonshop.ActChargeOnShopContract
import ru.evotor.egais.api.provider.actchargeonshop.ActChargeOnShopPositionContract
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.query.Cursor
import java.util.*

object ActChargeOnShopApi {
    @JvmStatic
    fun getActChargeOnShopList(context: Context): Cursor<ActChargeOnShop>? {
        return context.contentResolver.query(
                ActChargeOnShopContract.URI,
                null,
                null,
                null,
                null
        )?.let {
            object : Cursor<ActChargeOnShop>(it) {
                override fun getValue(): ActChargeOnShop {
                    return createActChargeOnShop(this)
                }
            }
        }
    }

    @JvmStatic
    fun getActChargeOnShopListByDate(context: Context, date: Date): Cursor<ActChargeOnShop>? {
        return context.contentResolver.query(
                ActChargeOnShopContract.URI,
                null,
                "${ActChargeOnShopContract.COLUMN_ACT_DATE} >= ?",
                arrayOf(date.toString()),
                null
        )?.let {
            object : Cursor<ActChargeOnShop>(it) {
                override fun getValue(): ActChargeOnShop {
                    return createActChargeOnShop(this)
                }
            }
        }
    }

    @JvmStatic
    fun getActChargeOnShopPositionsByUuid(context: Context, uuid: UUID): Cursor<ActChargeOnShopPosition>? {
        return context.contentResolver.query(
                ActChargeOnShopPositionContract.URI,
                null,
                "${ActChargeOnShopPositionContract.COLUMN_ACT_CHARGE_ON_SHOP_UUID} = ?",
                arrayOf(uuid.toString()),
                null
        )?.let {
            object : Cursor<ActChargeOnShopPosition>(it) {
                override fun getValue(): ActChargeOnShopPosition {
                    return createActChargeOnShopPosition(this)
                }
            }
        }
    }

    internal fun createActChargeOnShop(cursor: android.database.Cursor): ActChargeOnShop {
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

    internal fun createActChargeOnShopPosition(cursor: android.database.Cursor): ActChargeOnShopPosition {
        val columnIndexUuid = cursor.getColumnIndex(ActChargeOnShopPositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActChargeOnShopPositionContract.COLUMN_ACT_CHARGE_ON_SHOP_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActChargeOnShopPositionContract.COLUMN_IDENTITY)
        val columnIndexQuantity = cursor.getColumnIndex(ActChargeOnShopPositionContract.COLUMN_QUANTITY)
        val columnIndexAlcCode = cursor.getColumnIndex(ActChargeOnShopPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)

        return ActChargeOnShopPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnIndexQuantity)),
                cursor.getString(columnIndexAlcCode)
        )
    }
}
