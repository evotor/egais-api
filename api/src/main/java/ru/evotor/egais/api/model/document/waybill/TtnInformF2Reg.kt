package ru.evotor.egais.api.model.document.waybill

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Справка 2 Информация о предыдущих отгрузках
 *
 * @property uuid уникальный идентификатор
 * @property docOwner кто подает документы
 * @property identity ИД накладной(клиентский, исходной накладной, если заполнялся)
 * @property wbRegId ИД накладной в системе (присвоенный)
 * @property egaisFixNumber Номер фиксации накладной(отгрузки) в ЕГАИС
 * @property egaisFixDate Дата составления накладной(отгрузки) в ЕГАИС
 * @property wbNumber Номер накладной
 * @property wbDate Дата составления накладной
 * @property shipperId Грузоотправитель
 * @property consigneeId Грузополучатель
 * @property supplierId Поставщик
 * @property wayBillId уникальный идентификатор ТТН
 */
data class TtnInformF2Reg(
        val uuid: UUID,
        val docOwner: String,
        var identity: String?,
        var wbRegId: String,
        var egaisFixNumber: String?,
        private var _egaisFixDate: Date?,
        var wbNumber: String?,
        private var _wbDate: Date?,
        var shipperId: String?,
        var consigneeId: String?,
        var supplierId: String?,
        var wayBillId: UUID?,
        var status: TtnInformF2RegStatus
) : EgaisDocument() {

    var egaisFixDate: Date?
        get() = copyDate(_egaisFixDate)
        set(value) {
            _egaisFixDate = copyDate(value)
        }

    var wbDate: Date?
        get() = copyDate(_wbDate)
        set(value) {
            _wbDate = copyDate(value)
        }

    private fun copyDate(date: Date?): Date? {
        return if (date == null) {
            null
        } else Date(date.time)
    }
}
