package ru.evotor.egais.api.model.dictionary

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Марка на балансе 3 регистра
 *
 * @property documentUuid uuid документа основания
 * @property informF2RegId справка 2
 * @property mark Марка
 */
data class MarkRest(
        @JvmField val documentUuid: UUID,
        @JvmField val informF2RegId: String,
        @JvmField val mark: String
) : EgaisDocument()
