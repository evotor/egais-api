package ru.evotor.egais.api.model.document.waybill

import ru.evotor.egais.api.model.Version
import java.util.*

/**
 *  Товарно-транспортная накладная (ТТН)
 *
 *  @property uuid уникальный иднтификатор
 *  @property docOwner кто подает документы
 *  @property identity Идентификатор накладной (клиентский, к заполнению необязательный)
 *  @property type Тип накладной
 *  @property unitType TODO
 *  @property number Номер документа
 *  @property date Дата составления
 *  @property shippingDate  Дата отгрузки продукции
 *  @property transportType Тип перевозки
 *  @property transportCompany Название компании перевозчика
 *  @property transportCar Автомобиль
 *  @property transportTrailer Прицеп
 *  @property transportCustomer Заказчики
 *  @property transportDriver Водитель
 *  @property transportLoadpoint Место погрузки
 *  @property transportUnloadpoint Место разгрузки
 *  @property transportRedirect Перенаправление
 *  @property transportForwarder Экспедитор
 *  @property shipperId Грузоотправитель
 *  @property consigneeId Грузополучатель
 *  @property supplierId Поставщик
 *  @property base Основание
 *  @property note Заметки
 *  @property state Состояние накладной
 *  @property ttnInformBRegId TODO
 *  @property wbRegId TODO
 *  @property version TODO
 */
data class WayBill(
        val uuid: UUID,
        val docOwner: String,
        var identity: String?,
        var type: Type?,
        var unitType: UnitType?,
        var number: String?,
        private var _date: Date? = null,
        private var _shippingDate: Date? = null,
        val transportType: String?,
        val transportCompany: String?,
        val transportCar: String?,
        val transportTrailer: String?,
        val transportCustomer: String?,
        val transportDriver: String?,
        val transportLoadpoint: String?,
        val transportUnloadpoint: String?,
        val transportRedirect: String?,
        val transportForwarder: String?,
        var shipperId: Long?,
        var consigneeId: Long?,
        var supplierId: Long?,
        var base: String?,
        var note: String?,
        var state: State = State.NEW,
        var ttnInformBRegId: Long?,
        var wbRegId: String?,
        var version: Version?
) {

    var date: Date?
        get() = copyDate(_date)
        set(value) {
            _date = copyDate(value)
        }

    var shippingDate: Date?
        get() = copyDate(_shippingDate)
        set(value) {
            _shippingDate = copyDate(value)
        }

    private fun copyDate(date: Date?): Date? {
        return if (date == null) {
            null
        } else Date(date.time)
    }

    enum class State {
        NEW, /**
         * это как NEW, но по какому-то связанному акту или confirmTicket пришёл Ticket с
         * Result.Conclusion=Rejected
         */
        ERROR,
        NOT_CONFIRMED, WAIT_UTM_ANSWER, REJECTED, ACCEPTED
    }
}
