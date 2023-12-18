package ru.evotor.egais.api.model.document.rest_b_code

import ru.evotor.egais.api.model.dictionary.QueryRestBCodeRequestType
import ru.evotor.egais.api.model.dictionary.QueryStatus
import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.UUID

class QueryRestBCode(
    val uuid: UUID,
    val owner: String,
    val informF2RegId: String,
    val status: QueryStatus,
    val rejectComment: String?,
    val utmDocumentUuid: UUID,
    val requestType: QueryRestBCodeRequestType?
) : EgaisDocument()