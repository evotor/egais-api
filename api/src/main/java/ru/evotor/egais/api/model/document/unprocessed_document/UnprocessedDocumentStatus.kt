package ru.evotor.egais.api.model.document.unprocessed_document

/**
 * Статусы необработанных документов
 */
enum class UnprocessedDocumentStatus {
    /**
     * Документ есть в приёмке
     */
    DEFAULT,

    /**
     * Документа нет в приёмке и не отправлялся перезапрос
     */
    NEW,

    /**
     * Для документа отправлен перезапрос
     */
    WAITING,

    /**
     * ЕГАИС отклонил документ при перезапросе
     */
    REJECTED
}