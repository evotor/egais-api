package ru.evotor.egais.api.model.document

import ru.evotor.egais.api.model.document.ticket.DocType
import java.util.*

data class EgaisDocumentStatusRecord(
        val uuid: UUID,
        val stateOld: String?,
        val stateNew: String?,
        val type: DocType,
        val date: Date
)