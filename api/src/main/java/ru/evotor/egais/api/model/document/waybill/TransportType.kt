package ru.evotor.egais.api.model.document.waybill

/**
 * Тип транспортного средства
 */
enum class TransportType {
    /**
     * Автомобиль
     */
    CAR,

    /**
     * Водное транспортное средство
     */
    SHIP,

    /**
     * Железнодорожный вагон
     */
    RAILWAY,

    /**
     * Авиационное транспортное средство
     */
    AIRCRAFT,

    /**
     * Иное
     */
    OTHER
}