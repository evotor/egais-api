package ru.evotor.egais.api.model.document.waybill

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 *  Товарно-транспортная накладная (ТТН)
 *
 *  @property uuid уникальный иднтификатор
 *  @property docOwner кто подает документы
 *  @property identity Идентификатор накладной (клиентский, к заполнению необязательный)
 *  @property type Тип накладной
 *  @property unitType Тип поставки (упакованная или нет)
 *  @property number Номер документа
 *  @property date Дата составления
 *  @property shippingDate  Дата отгрузки продукции
 *  @property transport Информация о транспорте
 *  @property shipperId Грузоотправитель
 *  @property consigneeId Грузополучатель
 *  @property supplierId Поставщик
 *  @property base Основание
 *  @property note Заметки
 *  @property status Состояние накладной
 *  @property resolution резолюция по накладной
 *  @property ttnInformF2RegUuid uuid формы 2 для накладной
 *  @property wbRegId ИД накладной в системе (присвоенный)
 */
data class WayBill(
        val uuid: UUID,
        val docOwner: String,
        val identity: String?,
        val type: Type,
        val unitType: UnitType?,
        val number: String,
        var date: Date,
        var shippingDate: Date,
        val transport: Transport?,
        val shipperId: String,
        val consigneeId: String,
        val supplierId: String?,
        val base: String?,
        val note: String?,
        val status: Status,
        val resolution: Resolution,
        val ttnInformF2RegUuid: UUID?,
        val wbRegId: String?
) : EgaisDocument()