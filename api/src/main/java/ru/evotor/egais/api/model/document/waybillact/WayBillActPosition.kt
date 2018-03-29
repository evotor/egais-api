package ru.evotor.egais.api.model.document.waybillact

import java.math.BigDecimal
import java.util.*

/**
 * Позиция акта разногласий для товарно-транспортной накладной
 *
 * @property uuid Уникальный идентификатор
 * @property wayBillActUuid Уникальный идентификатор акта разногласий
 * @property identity Идентификатор позиции внутри накладной
 * @property informBRegId Регистрационный номер записи справки Б
 * @property realQuantity Количество фактическое
 */
data class WayBillActPosition(
        @JvmField val uuid: UUID,
        @JvmField var wayBillActUuid: UUID,
        @JvmField var identity: String,
        @JvmField var informBRegId: String?,
        @JvmField var realQuantity: BigDecimal
)