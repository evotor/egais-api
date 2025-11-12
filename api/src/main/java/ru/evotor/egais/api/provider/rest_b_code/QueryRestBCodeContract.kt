package ru.evotor.egais.api.provider.rest_b_code

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object QueryRestBCodeContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.queryrestbcode"

    @JvmField
    val BASE_URI = Uri.parse("content://$AUTHORITY")

    @JvmField
    val PATH = "QueryRestBCode"

    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    const val COLUMN_UUID = "UUID"

    const val COLUMN_OWNER = "OWNER"

    const val COLUMN_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"

    const val COLUMN_STATUS = "STATUS"

    const val COLUMN_REJECT_COMMENT = "REJECT_COMMENT"

    const val COLUMN_UTM_DOCUMENT_UUID = "UTM_DOCUMENT_UUID"

    const val COLUMN_REQUEST_TYPE = "REQUEST_TYPE"
}