package ru.evotor.egais.api.model.document.waybillact

/**
 * Статус акта разногласия для ТТН
 */
enum class Status {
    NOT_PROCESSED,
    FINISH,
    REJECTED;

    companion object {
        fun toString(status: Status): String {
            return when (status) {
                NOT_PROCESSED -> "Не обработано"
                FINISH -> "Завершена"
                REJECTED -> "Отказ"
            }
        }
    }
}