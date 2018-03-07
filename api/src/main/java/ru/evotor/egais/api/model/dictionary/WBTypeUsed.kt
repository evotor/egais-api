package ru.evotor.egais.api.model.dictionary

/**
 * Поддерживаемая клиентом версия формата ТТН
 *
 * @property WAYBILL_V1 - версия 1
 * @property WAYBILL_V2 - версия 2
 * @property WAYBILL_V3 - версия 3
 */
enum class WBTypeUsed {
    WAYBILL_V1,
    WAYBILL_V2,
    WAYBILL_V3
}