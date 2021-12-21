package ru.evotor.egais.api.model.document.repeal_wb

import ru.evotor.egais.api.model.document.repeal_wb.ConfirmType.ACCEPTED
import ru.evotor.egais.api.model.document.repeal_wb.ConfirmType.REJECTED

/**
 * Тип ответа на запрос об отмене проведения ТТН
 *
 * @property ACCEPTED
 * @property REJECTED
 */
enum class ConfirmType {
    ACCEPTED,
    REJECTED
}