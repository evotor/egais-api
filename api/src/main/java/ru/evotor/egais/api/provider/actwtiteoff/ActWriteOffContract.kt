package ru.evotor.egais.api.provider.actwtiteoff

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ActWriteOffContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.actwriteoff"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmField
    val PATH = "ActWriteOff"

    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * Уникальный идентификатор акта списания со склада
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Отправитель акта списания со склада
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * Идентификатор акта списания со склада (клиентский, к заполнению необязательный)
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Номер документа
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата составления
     */
    const val COLUMN_ACT_DATE = "ACT_DATE"

    /**
     * Причина списания (Пересортица/Недостача/Уценка/Порча/Потери/Проверки/Арест/Иные цели/Реализация)
     */
    const val COLUMN_TYPE_WRITE_OFF = "TYPE_WRITE_OFF"

    /**
     * Примечание
     */
    const val COLUMN_NOTE = "NOTE"

    /**
     * Статус акта списания
     */
    const val COLUMN_STATUS = "STATUS"

    /**
     * Комментарий для отказа на акт списания со склада
     */
    const val COLUMN_REJECT_COMMENT = "REJECT_COMMENT"

    /**
     * Версия протокола ЕГАИС
     */
    const val COLUMN_VERSION = "VERSION"
}