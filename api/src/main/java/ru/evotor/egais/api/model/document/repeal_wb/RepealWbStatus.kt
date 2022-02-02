package ru.evotor.egais.api.model.document.repeal_wb

/**
 * Статус запроса/ответа на отмену проведения акта для ТТН
 */
enum class RepealWbStatus {
    NOT_PROCESSED,
    ERROR,
    WAIT_UTM_ANSWER,
    WAIT_ANSWER,
    CONFIRMED,
    NOT_CONFIRMED,
    TERM_ENDED
}