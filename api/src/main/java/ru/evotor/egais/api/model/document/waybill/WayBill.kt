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
 *  @property ttnInformBRegUuid uuid формы 2 для накладной
 *  @property wbRegId ИД накладной в системе (присвоенный)
 */
data class WayBill(
        @JvmField val uuid: UUID,
        @JvmField val docOwner: String,
        @JvmField val identity: String?,
        @JvmField val type: Type,
        @JvmField val unitType: UnitType?,
        @JvmField val number: String,
        @JvmField var date: Date,
        @JvmField var shippingDate: Date,
        @JvmField val transport: Transport?,
        @JvmField val shipperId: String,
        @JvmField val consigneeId: String,
        @JvmField val supplierId: String?,
        @JvmField val base: String?,
        @JvmField val note: String?,
        @JvmField val status: Status,
        @JvmField val resolution: Resolution,
        @JvmField val ttnInformBRegUuid: UUID?,
        @JvmField val wbRegId: String?
) : EgaisDocument()