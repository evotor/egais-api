package ru.evotor.egais.api.model.document

/**
 * Тип документа
 *
 * @property CONNECT_TAP_DOCUMENT Подключение кега к оборудованию для розлива
 * @property X_API_KEY_TOKEN Аутентификационный токен X-Api-Key
 */
enum class TrueApiDocType {
    CONNECT_TAP_DOCUMENT,
    X_API_KEY_TOKEN,
}