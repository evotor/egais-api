package ru.evotor.egais.api.provider.reply

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

@Deprecated(
    message = """
        Используйте [ru.evotor.egais.api.provider.reply.ReplyResendDocumentContract].
        Для получения квитанции используйте [ru.evotor.egais.api.query.TicketQuery].
        Класс будет удален в следующем релизе.
    """
)
internal object ReplyResendDocContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.reply"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmField
    val PATH = "ReplyResendDoc"

    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * Уникальный идентификатор запроса
     */
    const val COLUMN_UUID = "QUERY_UUID"

    /**
     * Отправитель запроса
     */
    const val COLUMN_OWNER = "QUERY_OWNER"

    /**
     * Идентификатор накладной в системе
     */
    const val COLUMN_WB_REG_ID = "QUERY_WB_REG_ID"

    /**
     * Идентификатор квитанции
     */
    const val COLUMN_TICKET_UUID = "UUID"
}