package ru.evotor.egais.api.model.document.actfixbarcode

import java.util.*

/**
 * Позиция акта привязки марки к партии
 *
 * @property uuid Уникальный идентификатор позиции акта
 * @property actFixBarcodeUuid Уникальный идентификатор акта привязки, содержащего позицию
 * @property identity Идентификатор позиции внутри накладной
 * @property informF2RegId Регистрационный номер раздела справки 2
 */
data class ActFixBarcodePosition(
        val uuid: UUID,
        val actFixBarcodeUuid: UUID,
        val identity: String,
        val informF2RegId: String
)