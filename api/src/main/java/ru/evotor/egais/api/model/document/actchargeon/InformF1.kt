package ru.evotor.egais.api.model.document.actchargeon

import java.math.BigDecimal
import java.util.*

/**
 * Справка 1 к ТТН (Информация о предыдущих отгрузках)
 *
 * @param quantity Количество
 * @param bottlingDate Дата розлива продукции
 * @param ttnNumber Номер ТТН
 * @param ttnDate Дата накладной
 * @param egaisFixNumber Номер подтверждения о фиксации в ЕГАИ
 * @param egaisFixDate Дата подтверждения о фиксации в ЕГАИС
 */
data class InformF1(
        val quantity: BigDecimal,
        val bottlingDate: Date,
        val ttnNumber: String,
        val ttnDate: Date,
        val egaisFixNumber: String,
        val egaisFixDate: Date
)