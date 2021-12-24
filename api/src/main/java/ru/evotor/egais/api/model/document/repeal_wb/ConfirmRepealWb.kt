package ru.evotor.egais.api.model.document.repeal_wb

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Ответ на запрос об отмене проведения акта для ТТН
 *
 * @property uuid Уникальный идентификатор
 * @property docOwner Кто подает документы
 * @property identity Идентификатор Акта (клиентский)
 * @property isConfirm Тип подтверждения: Принимаем/отказываем
 * @property number Номер документа
 * @property date Дата документа
 * @property wbRegId Идентификатор накладной в системе
 * @property note Заметки
 * @property status Статус документа
 * @property rejectComment Комментарий при отказе
 * @property replyId Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
 */
data class ConfirmRepealWb(
    val uuid: UUID,
    val docOwner: String,
    val identity: String?,
    val isConfirm: ConfirmType?,
    val number: String?,
    val date: Date?,
    val wbRegId: String?,
    val note: String?,
    val status: RepealWbStatus,
    val rejectComment: String?,
    val replyId: String?
) : EgaisDocument()
