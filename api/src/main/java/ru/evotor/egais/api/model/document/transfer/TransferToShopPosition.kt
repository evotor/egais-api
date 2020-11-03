package ru.evotor.egais.api.model.document.transfer

import ru.evotor.egais.api.model.dictionary.ProductInfo
import java.math.BigDecimal
import java.util.*

/**
 * Позиция акта передачи продукции в торговый зал со склада
 *
 * @property uuid Уникальный идентификатор позиции документа передачи
 * @property transferToShopUuid Уникальный идентификатор документа передачи
 * @property identity Идентификатор позиции внутри акта
 * @property productCode Регистрационный код продукции
 * @property quantity Количество
 * @property informF2RegId Регистрационный номер раздела справки 2
 * @property informF2MarkInfoJson Информация о марках в формате JSON
 * @property productInfo Информация о продукте
 */
data class TransferToShopPosition(
        val uuid: UUID,
        val transferToShopUuid: UUID,
        val identity: String,
        val productCode: String,
        val quantity: BigDecimal,
        val informF2RegId: String?,
        @Deprecated("Не используется")
        val informF2MarkInfoJson: String?,
        val productInfo: ProductInfo
)