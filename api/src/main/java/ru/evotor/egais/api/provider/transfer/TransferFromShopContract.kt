package ru.evotor.egais.api.provider.transfer

import android.net.Uri

internal object TransferFromShopContract {
    val PATH = "TransferFromShop"
    val URI = Uri.withAppendedPath(TransferContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Кто подает документы
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * Идентификатор документа (клиентский)
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Номер документа
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата составления
     */
    const val COLUMN_TRANSFER_DATE = "TRANSFER_DATE"

    /**
     * Примечание
     */
    const val COLUMN_NOTE = "NOTE"

    /**
     * Статус обработки документа
     */
    const val COLUMN_STATUS = "STATUS"

    /**
     * Комментарий для отказа
     */
    const val COLUMN_REJECT_COMMENT = "REJECT_COMMENT"

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    const val COLUMN_REPLY_ID = "REPLY_ID"
}