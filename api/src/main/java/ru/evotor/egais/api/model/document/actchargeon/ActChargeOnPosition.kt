package ru.evotor.egais.api.model.document.actchargeon

import ru.evotor.egais.api.model.dictionary.ProductInfo
import java.math.BigDecimal
import java.util.*

/**
 * Позиция в акте постановки на баланс на склад
 *
 * @property uuid Уникальный идентификатор позиции акта
 * @property actChargeOnUuid Идентификатор акта постановки, содержащего позицию
 * @property identity Идентификатор позиции внутри накладной
 * @property quantity Количество
 * @property productInfo Информация о продукции
 * @property informF1 Справка 1
 * @property markList Список считанных кодов марок
 */
data class ActChargeOnPosition(
        @JvmField val uuid: UUID,
        @JvmField val actChargeOnUuid: UUID,
        @JvmField val identity: String,
        @JvmField val quantity: BigDecimal,
        @JvmField val productInfo: ProductInfo,
        @JvmField val informF1: InformF1,
        @JvmField val markList: List<String>
)