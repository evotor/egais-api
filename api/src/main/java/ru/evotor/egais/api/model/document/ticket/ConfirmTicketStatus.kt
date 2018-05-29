package ru.evotor.egais.api.model.document.ticket

/**
 * Статус тикета подтверждения
 */
enum class ConfirmTicketStatus {
    NOT_PROCESSED,
    FINISH,
    REJECTED;

    companion object {
        fun toString(status: ConfirmTicketStatus): String {
            return when (status) {
                NOT_PROCESSED -> "Не обработано"
                FINISH -> "Завершена"
                REJECTED -> "Отказ"
            }
        }
    }
}