package ru.evotor.egais.api.model.document.waybill

import java.math.BigDecimal
import java.util.*

/**
 * Позиция в товарно-транспортной накладной
 *
 * @property uuid Уникальный идентификатор
 * @property wayBillUuid Уникальный идентификатор накладной
 * @property productIdentity Информация о продукции
 * @property productAlcoCode Информация о продукции
 * @property packId Идентификатор упаковки
 * @property quantity Количество
 * @property price Цена за единицу товара
 * @property party Номер партии
 * @property identity Идентификатор позиции внутри накладной
 * @property informARegId Справка А
 * @property informBRegId Регистрационный номер раздела справки Б
 */
data class WayBillPosition(
        val uuid: UUID,
        val wayBillUuid: UUID,
        val productIdentity: String?,
        val productAlcoCode: String,
        val packId: String?,
        val quantity: BigDecimal,
        val price: BigDecimal,
        val party: String?,
        val identity: String?,
        val informARegId: String?,
        val informBRegId: String?
)
