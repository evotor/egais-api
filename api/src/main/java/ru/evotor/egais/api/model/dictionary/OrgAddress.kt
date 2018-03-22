package ru.evotor.egais.api.model.dictionary

import java.util.*

/**
 * Фактический адрес произвольной формы
 *
 * @property uuid
 * @property country Страна
 * @property index Индекс
 * @property regionCode Код региона
 * @property area Область
 * @property city Город
 * @property place Район
 * @property street Улица
 * @property house Дом
 * @property building Строение
 * @property liter Литера
 * @property description Описание
 */
data class OrgAddress(
        val uuid: UUID,
        val country: String?,
        val index: String?,
        val regionCode: String?,
        val area: String?,
        val city: String?,
        val place: String?,
        val street: String?,
        val house: String?,
        val building: String?,
        val liter: String?,
        val description: String?
)
