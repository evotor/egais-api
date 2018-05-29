package ru.evotor.egais.api.model.document.waybill

enum class Status {
    NOT_PROCESSED,
    WAIT_UTM_ANSWER,
    NOT_CONFIRMED,
    ERROR,
    FINISH,
    REJECTED;

    companion object {
        fun toString(status: Status): String {
            return when (status) {
                NOT_PROCESSED -> "Не обработано"
                FINISH -> "Завершена"
                WAIT_UTM_ANSWER -> "Ожидание данных от УТМ"
                NOT_CONFIRMED -> "Не подтверждена"
                ERROR -> "Ошибка"
                REJECTED -> "Отказ"
            }
        }
    }
}
