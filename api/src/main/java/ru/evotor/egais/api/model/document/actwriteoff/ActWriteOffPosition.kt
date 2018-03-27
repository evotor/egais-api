package ru.evotor.egais.api.model.document.actwriteoff

import java.math.BigDecimal
import java.util.*

/**
 * Позиция в акте о списании со склада
 *
 * @property uuid Уникальный идентификатор
 * @property actWriteOffUuid Идентификатор акта списания, содержащего позицию
 * @property identity Идентификатор позиции внутри накладной
 * @property quantity Количество
 * @property informBRegId Регистрационный номер раздела справки Б
 * @property informBMarkInfoJson Информация о марках в формате JSON
 * @property productInfoAlcCode Алкокод информации о продукции
 * @property markList Перечень считанных кодов марок
 */
data class ActWriteOffPosition(
        @JvmField val uuid: UUID,
        @JvmField val actWriteOffUuid: UUID,
        @JvmField val identity: String?,
        @JvmField val quantity: BigDecimal,
        @JvmField val informBRegId: String?,
        @JvmField val informBMarkInfoJson: String?,
        @JvmField val productInfoAlcCode: String,
        @JvmField val markList: List<String>
)
