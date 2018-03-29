package ru.evotor.egais.api.model.document.waybillact

/**
 * Тип подтверждения: Принимаем/есть расхождения/отказываем
 *
 * @property ACCEPTED ТТН принята
 * @property DIFFERENCES  есть расхождения
 * @property REJECTED ТТН отклонена
 */
enum class AcceptType {
    ACCEPTED,
    DIFFERENCES,
    REJECTED
}