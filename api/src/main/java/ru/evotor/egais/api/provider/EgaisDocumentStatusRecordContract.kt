package ru.evotor.egais.api.provider

import android.net.Uri

object EgaisDocumentStatusRecordContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.egaisdocumentstatus"

    const val EGAIS_DOCUMENT_STATUS_RECORD_PATH = "EgaisDocumentStatusRecord"

    val BASE_URI = Uri.parse("content://$AUTHORITY")
    val URI = Uri.withAppendedPath(BASE_URI, EGAIS_DOCUMENT_STATUS_RECORD_PATH)

    /**
     * Уникальный идентификатор
     */
    const val UUID_COLUMN = "UUID"

    /**
     * Старый статус
     */
    const val STATE_OLD_COLUMN = "STATE_OLD"

    /**
     * Новый статус
     */
    const val STATE_NEW_COLUMN = "STATE_NEW"

    /**
     * Тип документа
     */
    const val TYPE_COLUMN = "TYPE"

    /**
     * Дата и время изменения статуса
     */
    const val DATE_COLUMN = "DATE"
}