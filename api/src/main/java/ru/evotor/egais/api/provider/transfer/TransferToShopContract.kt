package ru.evotor.egais.api.provider.transfer

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object TransferToShopContract {
    private const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.transfertoshop"
    val BASE_URI = Uri.parse("content://${AUTHORITY}")
    val PATH = "TransferToShop"
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

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
}