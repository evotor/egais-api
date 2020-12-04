package ru.evotor.egais.api.model.document.waybill

/**
 * Право собственности
 */
enum class ChangeOwnership {
    /**
     * Изменение права собственности
     */
    IS_CHANGE,

    /**
     * Без изменения права собственности
     */
    NOT_CHANGE
}