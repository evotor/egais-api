package ru.evotor.egais.api.model.document.repeal_wb

import ru.evotor.egais.api.model.document.EgaisDocument
import ru.evotor.egais.api.model.document.ticket.ConfirmTicketStatus
import java.util.*

/**
 * Запрос на отмену проведения акта для ТТН
 *
 * @property uuid Уникальный идентификатор
 * @property docOwner Кто подает документы
 * @property identity ИД Акта (клиентский)
 * @property number Номер документа
 * @property date Дата создания запроса
 * @property wbRegId ID ТТН в системе
 * @property note Примечание
 * @property status Статус документа
 * @property rejectComment Комментарий при отказе
 * @property replyId Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
 */
data class RequestRepealWb(
    val uuid: UUID,
    val docOwner: String,
    val identity: String?,
    val number: String,
    val date: Date?,
    val wbRegId: String,
    val note: String?,
    val status: ConfirmTicketStatus,
    val rejectComment: String?,
    val replyId: String?
) : EgaisDocument()
