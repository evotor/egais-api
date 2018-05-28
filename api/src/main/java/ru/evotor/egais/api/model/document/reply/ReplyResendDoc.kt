package ru.evotor.egais.api.model.document.reply

import ru.evotor.egais.api.model.document.EgaisDocument
import ru.evotor.egais.api.model.document.ticket.Ticket
import java.util.*


/**
 * Результат отправки повторного запроса ТТН
 *
 * @param uuid Уникальный идентификатор запроса
 * @param owner Отправитель запроса
 * @param wbRegId ИД накладной в системе (присвоенный)
 * @param ticket Квитанция
 */
class ReplyResendDoc(
        val uuid: UUID,
        val docOwner: String,
        var wbRegId: String,
        var ticket: Ticket?
) : EgaisDocument()