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
        @JvmField val uuid: UUID,
        @JvmField val docOwner: String,
        @JvmField var identity: String?,
        @JvmField var acceptType: AcceptType?,
        @JvmField var number: String?,
        @JvmField var creationDate: Date,
        @JvmField var wbRegId: String?,
        @JvmField var note: String?,
        @JvmField var type: Type?,
        @JvmField var version: Version?,
        @JvmField var status: Status,
        @JvmField var rejectComment: String?
) : EgaisDocument()
