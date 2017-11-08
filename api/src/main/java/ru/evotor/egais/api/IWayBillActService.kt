package ru.evotor.egais.api

import java.math.BigDecimal

/**
 * Сервис для работы с актами
 */
interface IWayBillActService {
    /**
     * Отправить акт полной приемки накладной.
     *
     * @property wayBillUuid uuid накладной
     * @property number номер акта
     * @property note заметки
     *
     * @return uuid акта
     */
    fun acceptWayBill(
            wayBillUuid: String,
            number: String,
            note: String?
    ): String

    /**
     * Отправить акт полного отказа накладной.
     *
     * @property wayBillUuid uuid накладной
     * @property number номер акта
     * @property note заметки
     *
     * @return uuid акта
     */
    fun rejectWayBill(
            wayBillUuid: String,
            number: String,
            note: String?
    ): String

    /**
     * Отправить акт частичной приемки накладной.
     *
     * @property wayBillUuid uuid накладной
     * @property number номер акта
     * @property note заметки
     * @property positions список позиций
     *
     * @return uuid акта
     */
    fun partialAcceptWayBill(
            wayBillUuid: String,
            number: String,
            note: String?,
            positions: List<Position>
    ): String

    /**
     * Отправить согласие с актом частичной приемки накладной.
     *
     * @property wayBillActUuid uuid акта
     * @property note заметки
     *
     * @return uuid подтверждения
     */
    fun acceptWayBillAct(
            wayBillActUuid: String,
            note: String?
    )

    /**
     * Отправить согласие с актом частичной приемки накладной.
     *
     * @property wayBillActUuid uuid акта
     * @property note заметки
     *
     * @return uuid подтверждения
     */
    fun rejectWayBillAct(
            wayBillActUuid: String,
            note: String?
    )

    /**
     * Позиция в акте
     *
     * @property identity Идентификатор позиции внутри накладной
     * @property quantity Количество
     * @property informF2RegId Регистрационный номер раздела справки 2
     */
    data class Position(
            val identity: String,
            val quantity: BigDecimal,
            val informF2RegId: String?
    )
}