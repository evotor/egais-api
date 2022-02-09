package ru.evotor.egais.api.provider.repeal_wb

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object RequestRepealWbContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.repealwb"

    @JvmField
    val BASE_URI: Uri = Uri.parse("content://${AUTHORITY}")

    const val PATH = "RequestRepealWb"
    val URI: Uri = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * UUID документа.
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Отправитель документа.
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * Идентификатор документа (клиентский, к заполнению необязательный).
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Номер документа.
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата составления.
     */
    const val COLUMN_DATE = "CREATION_DATE"

    /**
     * ИД документа в системе ЕГАИС.
     */
    const val COLUMN_WB_REG_ID = "WB_REG_ID"

    /**
     * Заметки.
     */
    const val COLUMN_NOTE = "NOTE"

    /**
     * Текущий статус документа.
     */
    const val COLUMN_STATUS = "STATUS"

    /**
     * Комментарий для отказа
     */
    const val COLUMN_REJECT_COMMENT = "REJECT_COMMENT"
}