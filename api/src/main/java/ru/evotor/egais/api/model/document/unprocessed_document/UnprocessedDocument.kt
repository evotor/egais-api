package ru.evotor.egais.api.model.document.unprocessed_document

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Результат запроса на получение необработанных документов
 * @param id Уникальный идентификатор накладной
 * @param number номер накладной
 * @param date дата накладной
 * @param sender отправитель накладной
 * @param status документ с данным идентификатором находится в приёмке
 */
class UnprocessedDocument(
    val id: String,
    val number: String,
    val date: Date,
    val sender: String,
    val status: UnprocessedDocumentStatus
) : EgaisDocument()