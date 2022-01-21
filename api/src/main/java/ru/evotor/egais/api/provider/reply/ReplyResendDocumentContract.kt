package ru.evotor.egais.api.provider.reply

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ReplyResendDocumentContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.replyresenddocument"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmField
    val PATH = "ReplyResendDocument"

    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    const val COLUMN_WB_REG_ID = "WB_REG_ID"

    const val COLUMN_OWNER = "OWNER"

    const val COLUMN_STATUS = "STATUS"

    const val COLUMN_COMMENT = "COMMENT"

    const val COLUMN_DATE = "DATE"

    const val COLUMN_UTM_DOCUMENT_UUID = "UTM_DOCUMENT_UUID"
}