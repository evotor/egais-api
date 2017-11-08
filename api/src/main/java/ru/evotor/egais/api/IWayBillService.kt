package ru.evotor.egais.api

import ru.evotor.egais.api.model.document.waybill.Transport
import ru.evotor.egais.api.model.document.waybill.Type
import ru.evotor.egais.api.model.document.waybill.UnitType
import java.math.BigDecimal
import java.util.*

/**
 * Сревис для работы с накладными
 */
interface IWayBillService {
    /**
     * Отправить накладную в систему ЕГАИС.
     *
     * @property type тип накладной
     * @property unitType тип упаковки
     * @property shippingDate дата отгрузки продукции
     * @property transport транспорт
     * @property consigneeClientRegId грузополучатель
     * @property base основание
     * @property note заметки
     * @property positions список данные о позициях
     *
     * @return uuid накладной
     */
    fun sendWayBill(
            type: Type,
            unitType: UnitType,
            shippingDate: Date,
            transport: Transport?,
            consigneeClientRegId: String,
            base: String?,
            note: String?,
            positions: List<PositionData>
    ): String

    /**
     * Данные о позиции в накладной
     *
     * @property alcoCode код продукции согласно ЕГАИС
     * @property quantity Количество
     * @property price Цена за единицу товара
     * @property identity Идентификатор позиции внутри накладной
     * @property informF1RegId Справка 1
     * @property informF2RegIdIncome Регистрационный номер раздела справки 2, по которому продукция была получена отправителем
     * @property packId Идентификатор упаковки
     * @property party Номер партии
     */
    data class PositionData(
            val alcoCode: String,
            val quantity: BigDecimal,
            val price: BigDecimal,
            val informF1RegId: String,
            val informF2RegIdIncome: String,
            val packId: String?,
            val party: String?
    )
}