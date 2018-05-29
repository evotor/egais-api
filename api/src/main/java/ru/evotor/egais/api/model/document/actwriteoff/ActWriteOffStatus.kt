package ru.evotor.egais.api.model.document.actwriteoff

enum class ActWriteOffStatus {
    NOT_PROCESSED,
    FINISH,
    REJECTED;

    companion object {
        fun toString(status: ActWriteOffStatus): String {
            return when (status) {
                NOT_PROCESSED -> "Не обработано"
                FINISH -> "Завершена"
                REJECTED -> "Отказ"
            }
        }
    }
}