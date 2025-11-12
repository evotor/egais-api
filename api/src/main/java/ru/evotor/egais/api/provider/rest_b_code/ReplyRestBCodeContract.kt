package ru.evotor.egais.api.provider.rest_b_code

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ReplyRestBCodeContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.replyrestbcode"

    @JvmField
    val BASE_URI = Uri.parse("content://$AUTHORITY")

    @JvmField
    val PATH = "ReplyRestBCode"

    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    const val COLUMN_UUID = "UUID"

    const val COLUMN_OWNER = "OWNER"

    const val COLUMN_RESTS_DATE = "RESTS_DATE"

    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"

    const val COLUMN_UTM_DOCUMENT_UUID = "UTM_DOCUMENT_UUID"
}