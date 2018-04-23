package ru.evotor.egais.api.model.document.waybill

import ru.evotor.egais.api.model.dictionary.ProductInfo
import java.math.BigDecimal
import java.util.*

/**
 * Позиция в товарно-транспортной накладной
 *
 * @property uuid Уникальный идентификатор
 * @property wayBillUuid Уникальный идентификатор накладной
 * @property productIdentity Информация о продукции
 * @property productInfo Информация о продукции
 * @property packId Идентификатор упаковки
 * @property quantity Количество
 * @property price Цена за единицу товара
 * @property party Номер партии
 * @property identity Идентификатор позиции внутри накладной
 * @property informF1RegId Справка 1
 * @property informF2RegId Регистрационный номер раздела справки 2
 */
data class WayBillPosition(
        val uuid: UUID,
        val wayBillUuid: UUID,
        val productIdentity: String?,
        val productInfo: ProductInfo,
        val packId: String?,
        val quantity: BigDecimal,
        val price: BigDecimal,
        val party: String?,
        val identity: String?,
        val informF1RegId: String?,
        val informF2RegId: String?
)
