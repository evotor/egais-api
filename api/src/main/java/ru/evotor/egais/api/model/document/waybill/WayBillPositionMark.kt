package ru.evotor.egais.api.model.document.waybill

import java.util.*

/**
 * Марка в позиции товарно-транспортной накладной
 *
 * @property wayBillPositionUuid Уникальный идентификатор позиции в ТТН
 * @property boxNumber Номер короба
 * @property mark Марка
 */
data class WayBillPositionMark(
        val wayBillPositionUuid: UUID,
        val boxNumber: String?,
        val mark: String
)