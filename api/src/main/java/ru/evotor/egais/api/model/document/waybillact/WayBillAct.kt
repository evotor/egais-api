package ru.evotor.egais.api.model.document.waybillact

import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*


/**
 * Акт разногласий для Товарно-Транспортной Накладной
 *
 * @property uuid Уникальный идентификатор
 * @property owner Кто подает документы
 * @property identity Идентификатор Акта (клиентский)
 * @property acceptType Тип подтверждения: Принимаем/есть расхождения/отказываем
 * @property number Номер акта
 * @property creationDate Дата составления акта
 * @property wbRegId Идентификатор накладной в системе
 * @property note Заметки
 * @property type Типа акта расхождения к ТТН (Полный/Частичный)
 * @property version Версия протокола ЕГАИС
 */
data class WayBillAct(
        val uuid: UUID,
        val docOwner: String,
        val identity: String?,
        val acceptType: AcceptType?,
        val number: String?,
        val creationDate: Date,
        val wbRegId: String?,
        val note: String?,
        val type: Type?,
        val version: Version?,
        val status: Status,
        val rejectComment: String?,
        val replyId: String?
) : EgaisDocument()
