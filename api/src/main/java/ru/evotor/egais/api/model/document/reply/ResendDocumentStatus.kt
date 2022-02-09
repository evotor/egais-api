package ru.evotor.egais.api.model.document.reply

/**
 * Статус, в котором находится накладная
 */
enum class ResendDocumentStatus {
    /**
     * Отправлен перезапрос, но ответ еще не получен
     */
    WAITING,

    /**
     * ЕГАИС отклонил
     */
    REJECTED,

    /**
     * Перезапрос успешно выполнен
     */
    ACCEPTED
}