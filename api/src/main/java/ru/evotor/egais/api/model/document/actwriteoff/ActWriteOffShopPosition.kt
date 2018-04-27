package ru.evotor.egais.api.model.document.actwriteoff

import java.math.BigDecimal
import java.util.*

/**
 * Позиция в акте списания из торгового зала
 *
 * @property uuid Уникальный идентификатор
 * @property actWriteOffShopUuid Идентификатор акта списания содержащего позицию
 * @property identity Идентификатор позиции внутри накладной
 * @property quantity Количество
 * @property informF2MarkInfoJson Информация о марках в формате JSON
 * @property productInfoAlcCode Алкокод информации о продукции
 * @property markList Перечень считанных кодов марок
 */
data class ActWriteOffShopPosition(
        @JvmField val uuid: UUID,
        @JvmField val actWriteOffShopUuid: UUID,
        @JvmField val identity: String?,
        @JvmField val quantity: BigDecimal,
        @JvmField val informF2MarkInfoJson: String?,
        @JvmField val productInfoAlcCode: String,
        @JvmField val markList: List<String>
)