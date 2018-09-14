package ru.evotor.egais.api.model.document.actunfixbarcode

import java.util.*

/**
 * Позиция акта отвязки марок от партии
 *
 * @property uuid Уникальный идентификатор позиции акта
 * @property actUnFixBarcodeUuid Уникальный идентификатор акта отвязки, содержащего позицию
 * @property identity Идентификатор позиции внутри накладной
 * @property informF2RegId Регистрационный номер раздела справки 2
 */
data class ActUnFixBarcodePosition(
        val uuid: UUID,
        val actUnFixBarcodeUuid: UUID,
        val identity: String,
        val informF2RegId: String
)