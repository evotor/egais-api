package ru.evotor.egais.api.model.document.stock_commodity

import ru.evotor.egais.api.model.document.EgaisDocument
import java.math.BigDecimal
import java.util.*

/**
 * Позиция на остатках на складе
 *
 * @property uuid Уникальный идентификатор
 * @property informF1RegId Регистрационный номер раздела справки 1
 * @property informF2RegId Регистрационный номер раздела справки 2
 * @property quantity Количество
 * @property productInfoAlcCode Алкокод информации о продукции
 */

data class StockCommodity(
        @JvmField val uuid: UUID,
        @JvmField val informF1RegId: String,
        @JvmField val informF2RegId: String,
        @JvmField var quantity: BigDecimal,
        @JvmField var productInfoAlcCode: String
) : EgaisDocument()
