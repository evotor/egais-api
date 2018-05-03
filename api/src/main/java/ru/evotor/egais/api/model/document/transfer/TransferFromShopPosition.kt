package ru.evotor.egais.api.model.document.transfer

import ru.evotor.egais.api.model.dictionary.ProductInfo
import java.math.BigDecimal
import java.util.*

/**
 * Позиция акта передачи продукции из торгового зала на склад
 *
 * @property transferFromShopUuid Уникальный идентификатор документа передачи
 * @property identity Идентификатор позиции внутри акта
 * @property productCode Регистрационный код продукции
 * @property quantity Количество
 * @property informF2RegId Регистрационный номер раздела справки 2
 * @property productInfo Информация о продукции
 */
data class TransferFromShopPosition(
        val transferFromShopUuid: UUID,
        val identity: String?,
        val productCode: String,
        val quantity: BigDecimal,
        val informF2RegId: String?,
        val productInfo: ProductInfo
)
