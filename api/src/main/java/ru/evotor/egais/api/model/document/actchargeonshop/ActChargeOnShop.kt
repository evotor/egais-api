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
 */
data class ActChargeOnShop(
        @JvmField val uuid: UUID,
        @JvmField val docOwner: String,
        @JvmField val identity: String?,
        @JvmField val number: String,
        @JvmField val actDate: Date,
        @JvmField val type: Type,
        @JvmField val actWriteOff: String?,
        @JvmField val note: String?,
        @JvmField val status: Status,
        @JvmField val rejectComment: String?
) : EgaisDocument() {
}