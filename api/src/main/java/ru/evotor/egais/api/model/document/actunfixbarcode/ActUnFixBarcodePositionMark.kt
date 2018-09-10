package ru.evotor.egais.api.model.document.actunfixbarcode

import java.util.*

/**
 * Марка в позиции акта отвязки марок от партии
 *
 * @property actUnFixBarcodePositionUuid Уникальный идентификатор акта отвязки, содержащего позицию
 * @property mark Марка
 */
data class ActUnFixBarcodePositionMark(
        val actUnFixBarcodePositionUuid: UUID,
        val mark: String
)