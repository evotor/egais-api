package ru.evotor.egais.api

import android.content.Context
import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOff
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffPosition
import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffStatus
import ru.evotor.egais.api.model.document.actwriteoff.TypeWriteOff
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffContract
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffPositionContract
import ru.evotor.egais.api.provider.converter.MarkListConverter
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.query.Cursor
import java.util.*

object ActWriteOffApi {
    @JvmStatic
    fun getActWriteOffList(context: Context): Cursor<ActWriteOff>? {
        return context.contentResolver.query(
                ActWriteOffContract.URI,
                null,
                null,
                null,
                null
        )?.let {
            object : Cursor<ActWriteOff>(it) {
                override fun getValue(): ActWriteOff {
                    return createActWriteOff(this)
                }
            }
        }
    }

    @JvmStatic
    fun getActWriteOffListByDate(context: Context, date: Date): Cursor<ActWriteOff>? {
        return context.contentResolver.query(
                ActWriteOffContract.URI,
                null,
                "${ActWriteOffContract.COLUMN_ACT_DATE} >= ?",
                arrayOf(date.toString()),
                null
        )?.let {
            object : Cursor<ActWriteOff>(it) {
                override fun getValue(): ActWriteOff {
                    return createActWriteOff(this)
                }
            }
        }
    }

    @JvmStatic
    fun getActWriteOffPositionsByUuid(context: Context, uuid: UUID): Cursor<ActWriteOffPosition>? {
        return context.contentResolver.query(
                ActWriteOffPositionContract.URI,
                null,
                "${ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID} = ?",
                arrayOf(uuid.toString()),
                null
        )?.let {
            object : Cursor<ActWriteOffPosition>(it) {
                override fun getValue(): ActWriteOffPosition {
                    return createActWriteOffPosition(this)
                }
            }
        }
    }

    private fun createActWriteOffPosition(cursor: android.database.Cursor): ActWriteOffPosition {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_IDENTITY)
        val columnIndexQuantity = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_QUANTITY)
        val columnIndexInformBRegId = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_INFORM_B_REG_ID)
        val columnIndexMarkJson = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_INFORM_B_MARK_INFO_JSON)
        val columnIndexAlcCode = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_PRODUCT_INFO_ALC_CODE)
        val columnIndexMarkList = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_MARK_LIST)

        return ActWriteOffPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnIndexQuantity)),
                cursor.getString(columnIndexInformBRegId),
                cursor.getString(columnIndexMarkJson),
                cursor.getString(columnIndexAlcCode),
                MarkListConverter.toMarkList(cursor.getString(columnIndexMarkList))
        )
    }

    private fun createActWriteOff(cursor: android.database.Cursor): ActWriteOff {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffContract.COLUMN_UUID)
        val columnIndexOwner = cursor.getColumnIndex(ActWriteOffContract.COLUMN_OWNER)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffContract.COLUMN_IDENTITY)
        val columnIndexNumber = cursor.getColumnIndex(ActWriteOffContract.COLUMN_NUMBER)
        val columnIndexActDate = cursor.getColumnIndex(ActWriteOffContract.COLUMN_ACT_DATE)
        val columnIndexType = cursor.getColumnIndex(ActWriteOffContract.COLUMN_TYPE_WRITE_OFF)
        val columnIndexNote = cursor.getColumnIndex(ActWriteOffContract.COLUMN_NOTE)
        val columnIndexStatus = cursor.getColumnIndex(ActWriteOffContract.COLUMN_STATUS)
        val columnIndexRejectComment = cursor.getColumnIndex(ActWriteOffContract.COLUMN_REJECT_COMMENT)
        val columnIndexVersion = cursor.getColumnIndex(ActWriteOffContract.COLUMN_VERSION)

        return ActWriteOff(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                cursor.getString(columnIndexOwner),
                cursor.getString(columnIndexIdentity),
                cursor.getString(columnIndexNumber),
                Date(cursor.getString(columnIndexActDate)),
                TypeWriteOff.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexNote),
                ActWriteOffStatus.valueOf(cursor.getString(columnIndexStatus)),
                cursor.getString(columnIndexRejectComment),
                Version.valueOf(cursor.getString(columnIndexVersion))
        )
    }
}