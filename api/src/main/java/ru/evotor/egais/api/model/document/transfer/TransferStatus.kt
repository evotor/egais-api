package ru.evotor.egais.api.model.document.transfer

enum class TransferStatus {
    NOT_PROCESSED,
    FINISH,
    REJECTED;

    companion object {
        fun toString(status: TransferStatus): String {
            return when (status) {
                NOT_PROCESSED -> "Не обработано"
                FINISH -> "Завершена"
                REJECTED -> "Отказ"
            }
        }
    }
}