package ru.evotor.egais.api.model.document.waybill

/**
 * Транспорт
 *
 * @property type Тип перевозки
 * @property company Название компании перевозчика
 * @property car Автомобиль
 * @property trailer Прицеп
 * @property customer Заказчики
 * @property driver Водитель
 * @property loadpoint Место погрузки
 * @property unloadpoint Место разгрузки
 * @property redirect Перенаправление
 * @property forwarder Экспедитор
 */
data class Transport(
        val type: String?,
        val company: String?,
        val car: String?,
        val trailer: String?,
        val customer: String?,
        val driver: String?,
        val loadpoint: String?,
        val unloadpoint: String?,
        val redirect: String?,
        val forwarder: String?
)