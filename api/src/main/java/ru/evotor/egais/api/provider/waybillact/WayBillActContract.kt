package ru.evotor.egais.api.provider.waybillact

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object WayBillActContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.waybillact"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")
    @JvmField
    val PATH = "WayBillAct"
    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * Уникальный идентификатор акта
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Кто подает документы
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * Идентификатор акта (клиентский)
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Тип подтверждения: Принимаем/есть расхождения/отказываем
     */
    const val COLUMN_ACCEPT_TYPE = "ACCEPT_TYPE"

    /**
     * Номер акта
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата составления акта
     */
    const val COLUMN_CREATION_DATE = "CREATION_DATE"

    /**
     * Идентификатор накладной в системе
     */
    const val COLUMN_WB_REG_ID = "WB_REG_ID"

    /**
     * Заметки
     */
    const val COLUMN_NOTE = "NOTE"

    /**
     * Тип приемки: Полная/частичная
     */
    const val COLUMN_TYPE = "TYPE"

    /**
     * Версия протокола ЕГАИС
     */
    const val COLUMN_VERSION = "VERSION"

    /**
     * Статус накладной
     */
    const val COLUMN_STATUS = "STATUS"

    /**
     * Комментарий для отказа
     */
    const val COLUMN_REJECT_COMMENT = "REJECT_COMMENT"
}