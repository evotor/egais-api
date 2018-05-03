package ru.evotor.egais.api.model.document.waybill

import java.util.*

/**
 * Позиция в Справке 2 Информации о предыдущих отгрузках
 * @property uuid Уникальный идентификатор позиции
 * @property ttnInformF2RegUuid Уникальный идентификатор справки 2
 * @property identity Идентификатор позиции внутри накладной
 * @property informF2RegId Регистрационный номер записи справки 2
 */
data class TtnInformF2RegPosition(
        val uuid: UUID,
        val ttnInformF2RegUuid: UUID,
        val identity: String,
        val informF2RegId: String
)
