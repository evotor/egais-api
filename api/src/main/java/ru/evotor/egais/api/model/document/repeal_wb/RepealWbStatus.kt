package ru.evotor.egais.api.model.document.repeal_wb

/**
 * Статус запроса/ответа на отмену проведения акта для ТТН
 */
enum class RepealWbStatus {
    NOT_PROCESSED,
    WAIT_UTM_ANSWER,
    NOT_CONFIRMED,
    ERROR,
    FINISH,
    REJECTED
}