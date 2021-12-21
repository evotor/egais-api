package ru.evotor.egais.api.model.document.repeal_wb

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Ответ на запрос об отмене проведения акта для ТТН
 * @property identity Идентификатор Акта (клиентский)
 * @property confirmType Тип подтверждения: Принимаем/отказываем
 * @property number Номер документа
 * @property date Дата документа
 * @property wbRegId Идентификатор накладной в системе
 * @property note Заметки
 */
data class ConfirmRepealWb(
    val identity: String?,
    val confirmType: ConfirmType,
    val number: String,
    val date: Date?,
    val wbRegId: String,
    val note: String?
) : EgaisDocument()
