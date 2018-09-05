package ru.evotor.egais.api.model.document.actwriteoff

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Акт списания из торгового зала
 *
 * @property uuid Уникальный идентификатор
 * @property docOwner Владелец документа
 * @property identity ИД Акта (клиентский)
 * @property number Номер документа
 * @property actDate Дата составления
 * @property typeWriteOff Причина списания
 * @property note Примечание
 * @property status Статус акта списания
 * @property rejectComment Комментарий для отказа на акт списания из зала
 * @property replyId Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
 */
data class ActWriteOffShop(
        val uuid: UUID,
        val docOwner: String,
        val identity: String?,
        val number: String?,
        val actDate: Date?,
        val typeWriteOff: TypeWriteOff,
        val note: String?,
        val status: ActWriteOffStatus,
        val rejectComment: String?,
        val replyId: String?
) : EgaisDocument()
