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
 */
class ActWriteOffShop(
        @JvmField val uuid: UUID,
        @JvmField val docOwner: String,
        @JvmField val identity: String?,
        @JvmField val number: String?,
        @JvmField val actDate: Date?,
        @JvmField val typeWriteOff: TypeWriteOff,
        @JvmField val note: String?,
        @JvmField var status: ActWriteOffStatus,
        @JvmField val rejectComment: String?
) : EgaisDocument()
