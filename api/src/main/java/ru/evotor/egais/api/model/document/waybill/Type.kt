package ru.evotor.egais.api.model.document.waybill

/**
 * Тип накладной: WBInvoiceFromMe - расход; WBReturnToMe - возврат мне; WBInvoiceToMe - приход; WBReturnFromMe - возврат от меня;
 */
enum class Type {
    /**
     * расход
     */
    INVOICE_FROM_ME,
    /**
     * возврат мне
     */
    RETURN_TO_ME,
    /**
     * приход
     */
    INVOICE_TO_ME,
    /**
     * возврат от меня
     */
    RETURN_FROM_ME

}