package ru.evotor.egais.api.model.dictionary

import ru.evotor.egais.api.model.document.EgaisDocument
import java.math.BigDecimal

/**
 *  Позиция на остатках в магазине
 *
 * @property quantity Количество
 * @property productInfo Информация о продукции
 */
data class ShopCommodity(
        @JvmField val quantity: BigDecimal,
        @JvmField val productInfo: ProductInfo
) : EgaisDocument()
