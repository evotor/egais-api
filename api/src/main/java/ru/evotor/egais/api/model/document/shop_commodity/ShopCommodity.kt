package ru.evotor.egais.api.model.document.shop_commodity

import ru.evotor.egais.api.model.document.EgaisDocument
import java.math.BigDecimal
import java.util.*

/**
 *  Позиция на остатках в магазине
 *
 * @property uuid уникальный идентификатор
 * @property quantity Количество
 * @property productInfoAlcCode Алкокод информации о продукции
 */
data class ShopCommodity(
        @JvmField val uuid: UUID,
        @JvmField var quantity: BigDecimal,
        @JvmField var productInfoAlcCode: String
) : EgaisDocument()
