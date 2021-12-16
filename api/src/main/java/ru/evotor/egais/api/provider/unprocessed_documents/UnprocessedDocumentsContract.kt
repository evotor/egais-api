package ru.evotor.egais.api.provider.unprocessed_documents

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object UnprocessedDocumentsContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.unprocesseddocuments"

    @JvmField
    val BASE_URI = Uri.parse("content://$AUTHORITY")

    @JvmField
    val PATH = "UnprocessedDocumentsContract"

    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * Уникальный идентификатор накладной
     */
    const val COLUMN_ID = "ID"

    /**
     * Номер накладной
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата накладной
     */
    const val COLUMN_DATE = "DATE"

    /**
     * Отправитель накладной
     */
    const val COLUMN_SENDER = "SENDER"
}