package ru.evotor.egais.api.model.document.waybill

enum class WayBillErrorCode {
    /**
     * Акт не соответствует актуальной схеме проверки.
     */
    XSD_SCHEME,

    /**
     * Ранее был выслан акт на данную ТТН,
     * но из-за проблем со стороны ЕГАИС мы не получили квитанцию о регистрации акта
     */
    REPEAT_ACT,

    /**
     * На отправленный акт не получена квитанция о регистрации в ЕГАИС
     */
    NO_RECEIPT,

    /**
     * Для акта с ошибкой вручную был сменен статус на предыдущий
     */
    ERROR_SOLVED,

    /**
     * При отправке документа RequestRepealWB в ответ от УТМ пришла квитанция с отказом
     */
    REPEAL_ERROR,

    /**
     * Переводится в этот статус, если на запрос отмены проведения акта
     * в течение 30 дней не было получено ответа от грузоотправителя
     */
    REPEAL_ERROR_TIME
}