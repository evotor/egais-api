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
        @JvmField val uuid: UUID,
        @JvmField val wayBillUuid: UUID,
        @JvmField val productIdentity: String?,
        @JvmField val productAlcoCode: String,
        @JvmField val packId: String?,
        @JvmField val quantity: BigDecimal,
        @JvmField val price: BigDecimal,
        @JvmField val party: String?,
        @JvmField val identity: String?,
        @JvmField val informARegId: String?,
        @JvmField val informBRegId: String?
)
