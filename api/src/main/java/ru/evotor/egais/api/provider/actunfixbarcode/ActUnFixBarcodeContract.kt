package ru.evotor.egais.api.provider.actunfixbarcode

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ActUnFixBarcodeContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.actunfixbarcode"

    @JvmField
    val BASE_URI = Uri.parse("content://$AUTHORITY")

    @JvmField
    val PATH = "ActUnFixBarcode"

    @JvmField
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
     * ID акта (клиентсикй)
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Номер документа
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата отвязки
     */
    const val COLUMN_ACT_DATE = "ACT_DATE"

    /**
     * Примечание
     */
    const val COLUMN_NOTE = "NOTE"

    /**
     * Статус документа
     */
    const val COLUMN_STATUS = "STATUS"

    /**
     * Комментарий при отказе
     */
    const val COLUMN_REJECT_COMMENT = "REJECT_COMMENT"
}