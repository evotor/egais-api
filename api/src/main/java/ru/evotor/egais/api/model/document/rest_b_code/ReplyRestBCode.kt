package ru.evotor.egais.api.model.document.rest_b_code

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.Date
import java.util.UUID

class ReplyRestBCode(
    val uuid: UUID,
    val owner: String,
    val restsDate: Date?,
    val informF2RegId: String,
    val utmDocumentUuid: UUID
) : EgaisDocument()