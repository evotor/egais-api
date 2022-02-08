package ru.evotor.egais.api.model.document.unprocessed_document

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Результат запроса на получение необработанных документов
 * @property id Уникальный идентификатор накладной
 * @property number номер накладной
 * @property date дата накладной
 * @property sender отправитель накладной
 * @property status статус накладной
 */
class UnprocessedDocument(
    val id: String,
    val number: String,
    val date: Date,
    val sender: String,
    val status: UnprocessedDocumentStatus
) : EgaisDocument()