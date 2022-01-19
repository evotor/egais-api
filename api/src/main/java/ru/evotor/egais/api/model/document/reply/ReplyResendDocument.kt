package ru.evotor.egais.api.model.document.reply

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Результат отправки повторного запроса ТТН
 *
 * @param wbRegId ИД накладной в системе (присвоенный)
 * @param owner Отправитель запроса
 * @param status Статус накладной
 * @param comment Комментарий от ЕГАИС при запросе накладной
 * @param date Дата накладной
 * @param ticketUUID ID квитанции для накладной
 */
class ReplyResendDocument(
    val wbRegId: String,
    val owner: String,
    val status: String,
    val comment: String,
    val date: Date,
    val ticketUUID: UUID
) : EgaisDocument()