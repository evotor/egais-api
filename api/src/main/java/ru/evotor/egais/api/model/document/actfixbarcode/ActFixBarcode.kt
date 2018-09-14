package ru.evotor.egais.api.model.document.actfixbarcode

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Акт привязки марки к партии
 *
 * @property uuid Уникальный идентификатор акта
 * @property owner Кто подает документы
 * @property identity ИД Акта (клиентский)
 * @property number Номер акта
 * @property actDate Дата составления акта
 * @property note Примечание
 * @property rejectComment
 * @property status Состояние
 * @property replyId Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
 */
data class ActFixBarcode(
        val uuid: UUID,
        val owner: String,
        val identity: String?,
        val number: String,
        val actDate: Date,
        val note: String?,
        val rejectComment: String?,
        val status: Status,
        val replyId: String?
) : EgaisDocument()