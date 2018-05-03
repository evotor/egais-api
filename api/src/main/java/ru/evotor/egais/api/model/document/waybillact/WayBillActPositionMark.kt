package ru.evotor.egais.api.model.document.waybillact

import java.util.*

/**
 * Марка в позиции акта разногласий для товарно-транспортной накладной
 *
 * @property wayBillActPositionUuid Уникальный идентификатор позиции акта разногласий
 * @property mark Марка
 */
data class WayBillActPositionMark(
        val wayBillActPositionUuid: UUID,
        val mark: String
)
