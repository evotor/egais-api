package ru.evotor.egais.api.provider.dictionary

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object MarkRestContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.markrest"

    @JvmField
    val BASE_URI = Uri.parse("content://$AUTHORITY")

    val PATH = "MarkRest"
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * UUID документа основания
     */
    const val COLUMN_DOCUMENT_UUID = "DOCUMENT_UUID"

    /**
     * Регистрационный номер раздела справки 2
     */
    const val COLUMN_NAME_INFORM_F2_REG_ID = "INFORM_F2_REG_ID"

    /**
     * Марка
     */
    const val COLUMN_MARK = "MARK"
}