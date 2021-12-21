package ru.evotor.egais.api.model.document.repeal_wb

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Запрос на отмену проведения акта для ТТН
 * @param identity ИД Акта (клиентский)
 * @param number Номер документа
 * @param date Дата создания запроса
 * @param wbRegId ID ТТН в системе
 * @param note Примечание
 */
data class RequestRepealWb(
    val identity: String?,
    val number: String,
    val date: Date?,
    val wbRegId: String,
    val note: String?
) : EgaisDocument()
