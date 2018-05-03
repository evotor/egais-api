package ru.evotor.egais.api.model.document.actchargeonshop

import ru.evotor.egais.api.model.dictionary.ProductInfo
import java.math.BigDecimal
import java.util.*

/**
 * Позиция в акте постановки на баланс
 *
 * @property uuid Уникальный идентификатор позиции акта
 * @property actChargeOnShopUuid Идентификатор акта постановки, содержащего позицию
 * @property identity Идентификатор позиции внутри накладной
 * @property quantity Количество
 * @property productInfo Информация о продукции
 */
data class ActChargeOnShopPosition(
        @JvmField val uuid: UUID,
        @JvmField val actChargeOnShopUuid: UUID,
        @JvmField val identity: String,
        @JvmField val quantity: BigDecimal,
        @JvmField val productInfo: ProductInfo
)