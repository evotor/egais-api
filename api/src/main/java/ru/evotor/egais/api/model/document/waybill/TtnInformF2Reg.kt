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
        val identity: String?,
        val wbRegId: String,
        val egaisFixNumber: String?,
        val egaisFixDate: Date?,
        val wbNumber: String?,
        val wbDate: Date?,
        val shipperId: String?,
        val consigneeId: String?,
        val supplierId: String?,
        val wayBillId: UUID?,
        val status: TtnInformF2RegStatus
) : EgaisDocument()
