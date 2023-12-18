package ru.evotor.egais.api.model.document.ticket

/**
 * Тип исходного документа
 *
 * @property WAY_BILL Товарно-транспортная накладная
 * @property WAY_BILL_ACT Акт разногласий для товарно-транспортной накладной
 * @property TRANSFER_TO_SHOP Акт перемещения продукции в торговый зал
 * @property TRANSFER_FROM_SHOP Акт перемещения продукции на склад
 * @property CONFIRM_TICKET Квитанция подтверждения на акт разногласий для товарно-транспортной накладной
 * @property QUERY_AP Запрос продукции ЕГАИС
 * @property QUERY_RESTS Запрос товарных остатков на складе
 * @property QUERY_RESTS_SHOP Запрос товарных остатков в торговом зале
 * @property QUERY_CLIENTS Запрос контрагентов
 * @property QUERY_RESEND_DOC Перезапрос документа
 * @property ACT_WRITE_OFF Акт списания со склада
 * @property INFO_VERSION_TTN Информация об используемой версии формата ТТН
 * @property ACT_CHARGE_ON_SHOP Акт постановки в торговый зал
 * @property ACT_WRITE_OFF_SHOP Акт списания из торгового зала
 * @property ACT_FIX_BARCODE Акт привязки марки к партии
 * @property ACT_UNFIX_BARCODE Акт отвязки марки от партии
 * @property ACT_CHARGE_ON Акт постановки на склад
 * @property QUERY_UNPROCESSED_DOCUMENTS Запрос необработанных документов
 * @property REQUEST_REPEAL_WB Запрос на отмену проведения акта для ТТН
 * @property CONFIRM_REPEAL_WB Ответ на запрос об отмене проведения акта для ТТН
 * @property JSON_STRING Документ json в формате String
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
    ACT_WRITE_OFF_SHOP,
    ACT_FIX_BARCODE,
    ACT_UNFIX_BARCODE,
    ACT_CHARGE_ON,
    QUERY_UNPROCESSED_DOCUMENTS,
    REQUEST_REPEAL_WB,
    CONFIRM_REPEAL_WB,
    JSON_STRING
}