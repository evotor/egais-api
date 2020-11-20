package ru.evotor.egais.api.model.document.waybillact

import ru.evotor.egais.api.model.document.waybill.ChangeOwnership

/**
 * Транспортный раздел
 *
 * @property changeOwnership Право собственности
 */
data class Transport(
        val changeOwnership: ChangeOwnership
)