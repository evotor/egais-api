package ru.evotor.egais.api.model.document.waybill

enum class TtnInformF2RegStatus {
    NOT_PROCESSED,
    FINISH;

    companion object {
        fun toString(status: TtnInformF2RegStatus): String {
            return when (status) {
                NOT_PROCESSED -> "Не обработано"
                FINISH -> "Завершена"
            }
        }
    }
}