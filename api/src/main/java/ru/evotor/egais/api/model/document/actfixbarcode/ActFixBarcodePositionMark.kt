package ru.evotor.egais.api.model.document.actfixbarcode

import java.util.*

/**
 * Марка в позиции акта привязки марки к партии
 *
 * @property actFixBarcodePositionUuid Уникальный идентификатор акта привязки, содержащего позицию
 * @property mark Марка
 */
data class ActFixBarcodePositionMark(
        val actFixBarcodePositionUuid: UUID,
        val mark: String
)