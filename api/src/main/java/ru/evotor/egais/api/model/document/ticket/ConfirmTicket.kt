package ru.evotor.egais.api.model.document.ticket

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Подтверждение акта разногласий для Товарно-Транспортной Накладной
 *
 * @property uuid уникальный идентификатор
 * @property docOwner кто подает документы
 * @property identity Идентификатор документа (клиентский, к заполнению необязательный)
 * @property isConfirm Тип подтверждения: Принимаем/отказываем
 * @property ticketNumber Номер подтверждения
 * @property ticketDate Дата составления подтверждения
 * @property wbRegId ИД накладной в системе
 * @property note примечание
 * @property status Статус
 * @property rejectComment Комментарий для отказа
 */
data class ConfirmTicket(
        val uuid: UUID,
        val docOwner: String,
        val identity: String?,
        val isConfirm: ConclusionType?,
        val ticketNumber: String?,
        val ticketDate: Date?,
        val wbRegId: String?,
        val note: String?,
        val status: ConfirmTicketStatus,
        val rejectComment: String?
) : EgaisDocument()