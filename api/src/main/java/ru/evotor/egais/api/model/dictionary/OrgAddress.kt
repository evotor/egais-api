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
 * @property place TODO
 * @property street Улица
 * @property house Дом
 * @property building TODO
 * @property liter TODO
 * @property description Описание
 */
data class OrgAddress(
        @JvmField val uuid: UUID,
        @JvmField val country: String?,
        @JvmField val index: String?,
        @JvmField val regionCode: String?,
        @JvmField val area: String?,
        @JvmField val city: String?,
        @JvmField val place: String?,
        @JvmField val street: String?,
        @JvmField val house: String?,
        @JvmField val building: String?,
        @JvmField val liter: String?,
        @JvmField val description: String?
)
