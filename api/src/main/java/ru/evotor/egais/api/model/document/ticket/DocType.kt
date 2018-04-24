package ru.evotor.egais.api.model.document.ticket

/**
 * Тип исходного документа
 *
 * @property WAY_BILL
 * @property WAY_BILL_ACT
 * @property TRANSFER_TO_SHOP
 * @property TRANSFER_FROM_SHOP
 * @property CONFIRM_TICKET
 * @property QUERY_AP
 * @property QUERY_RESTS
 * @property QUERY_RESTS_SHOP
 * @property QUERY_CLIENTS
 * @property QUERY_RESEND_DOC
 * @property ACT_WRITE_OFF
 * @property INFO_VERSION_TTN
 * @property ACT_CHARGE_ON_SHOP
 * @property ACT_WRITE_OFF_SHOP
 */
enum class DocType {
    WAY_BILL,
    WAY_BILL_ACT,
    TRANSFER_TO_SHOP,
    TRANSFER_FROM_SHOP,
    CONFIRM_TICKET,
    QUERY_AP,
    QUERY_RESTS,
    QUERY_RESTS_SHOP,
    QUERY_CLIENTS,
    QUERY_RESEND_DOC,
    ACT_WRITE_OFF,
    INFO_VERSION_TTN,
    ACT_CHARGE_ON_SHOP,
    ACT_WRITE_OFF_SHOP
}