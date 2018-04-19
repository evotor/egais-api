package ru.evotor.egais.api.model.dictionary

import java.math.BigDecimal

/**
 * Остатки продукции на складе и магазине с количествами
 * @property productInfo Информация о продукции
 * @property stockQuantity Количество продукции на складе
 * @property shopQuantity Количество продукции в торговом зале
 */
data class ProductRest(
        @JvmField val productInfo: ProductInfo,
        @JvmField val stockQuantity: BigDecimal,
        @JvmField val shopQuantity: BigDecimal
)
