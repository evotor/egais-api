package ru.evotor.egais.api.provider.actfixbarcode

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ActFixBarcodeContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.actfixbarcode"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmField
    val PATH = "ActFixBarcode"

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
     * Дата привязки
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