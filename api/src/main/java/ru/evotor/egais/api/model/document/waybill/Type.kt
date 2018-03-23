package ru.evotor.egais.api.model.document.waybill

/**
 * Тип накладной:
 * - INVOICE_FROM_ME - расход
 * - RETURN_TO_ME - возврат мне
 * - INVOICE_TO_ME - приход
 * - RETURN_FROM_ME - возврат от меня
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