package ru.evotor.egais.api.model.dictionary

import ru.evotor.egais.api.model.document.EgaisDocument
import java.math.BigDecimal

/**
 * Позиция на остатках на складе
 *
 * @property informF1RegId Регистрационный номер раздела справки 1
 * @property informF2RegId Регистрационный номер раздела справки 2
 * @property quantity Количество
 * @property productInfo Информация о продукции
 */

data class StockCommodity(
        @JvmField val informF1RegId: String,
        @JvmField val informF2RegId: String,
        @JvmField val quantity: BigDecimal,
        @JvmField val productInfo: ProductInfo
) : EgaisDocument()
