package ru.evotor.egais.api.model.document.waybill

enum class Status {
    NOT_PROCESSED,
    WAIT_UTM_ANSWER,
    FINISH,
    NOT_CONFIRMED,
    WAIT_SENDER_ANSWER,
    REJECTED_WBA,
    REPEALED,
    ERROR,
    ZERO_QUANTITY_DIFFERENCES,
    NEW_VERSION,
    CANCEL_WB
}
