package ru.evotor.egais.api.model.document.waybillact

/**
 * Статус акта разногласия для ТТН
 */
enum class Status {
    NOT_PROCESSED,
    WAIT_UTM_ANSWER,
    WAIT_SENDER_ANSWER,
    FINISH,
    REJECTED,
    ERROR,
    REPEALED
}