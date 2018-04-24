package ru.evotor.egais.api.model.document.actchargeonshop

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Акт постановки на баланс в торговый зал
 *
 * @property uuid Уникальный идентификатор
 * @property docOwner Кто подает документы
 * @property identity ID акта (клиентский)
 * @property number Номер документа
 * @property actDate Дата постановски на баланс
 * @property type Причина постановки на баланс
 * @property actWriteOff Регистрационный номер акта списания по типу "Пересортица".
 * Обязательно для заполнения для типа постановки на баланс "Пересортица".
 * @property note Примечание
 * @property status Статус документа
 * @property rejectComment Комментарий при отказе
 * @property replyId Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
 */
data class ActChargeOnShop(
        val uuid: UUID,
        val docOwner: String,
        val identity: String?,
        val number: String,
        val actDate: Date,
        val type: Type,
        val actWriteOff: String?,
        val note: String?,
        val status: Status,
        val rejectComment: String?,
        val replyId: String?
) : EgaisDocument() {
}