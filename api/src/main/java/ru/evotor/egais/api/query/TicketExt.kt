package ru.evotor.egais.api.query

import android.database.Cursor
import ru.evotor.egais.api.model.document.ticket.ConclusionType
import ru.evotor.egais.api.model.document.ticket.DocType
import ru.evotor.egais.api.model.document.ticket.OperationResult
import ru.evotor.egais.api.model.document.ticket.Ticket
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.ticket.TicketContract
import java.util.*

internal fun Cursor.createTicket(): Ticket {
    val columnIndexUuid = this.getColumnIndexOrThrow(TicketContract.COLUMN_UUID)
    val columnIndexOwner = this.getColumnIndexOrThrow(TicketContract.COLUMN_OWNER)
    val columnIndexTicketDate = this.getColumnIndexOrThrow(TicketContract.COLUMN_TICKET_DATE)
    val columnIndexIdentity = this.getColumnIndexOrThrow(TicketContract.COLUMN_IDENTITY)
    val columnIndexDocId = this.getColumnIndexOrThrow(TicketContract.COLUMN_DOC_ID)
    val columnTransportId = this.getColumnIndexOrThrow(TicketContract.COLUMN_TRANSPORT_ID)
    val columnRegId = this.getColumnIndexOrThrow(TicketContract.COLUMN_REG_ID)
    val columnDocHash = this.getColumnIndexOrThrow(TicketContract.COLUMN_DOC_HASH)
    val columnDocType = this.getColumnIndexOrThrow(TicketContract.COLUMN_DOC_TYPE)
    val columnResultConclusion = this.getColumnIndexOrThrow(TicketContract.COLUMN_RESULT_CONCLUSION)
    val columnResultDate = this.getColumnIndexOrThrow(TicketContract.COLUMN_RESULT_DATE)
    val columnResultComments = this.getColumnIndexOrThrow(TicketContract.COLUMN_RESULT_COMMENTS)
    val columnOperationResultName = this.getColumnIndexOrThrow(TicketContract.COLUMN_OPERATION_RESULT_NAME)
    val columnOperationResultResult = this.getColumnIndexOrThrow(TicketContract.COLUMN_OPERATION_RESULT_RESULT)
    val columnOperationResultComment = this.getColumnIndexOrThrow(TicketContract.COLUMN_OPERATION_RESULT_COMMENT)
    val columnOperationResultDate = this.getColumnIndexOrThrow(TicketContract.COLUMN_OPERATION_RESULT_DATE)

    return Ticket(
            UUID.fromString(this.getString(columnIndexUuid)),
            this.getString(columnIndexOwner),
            this.getString(columnIndexTicketDate)?.let { DateConverter.toDate(it) },
            this.getString(columnIndexIdentity),
            this.getString(columnIndexDocId),
            this.getString(columnTransportId),
            this.getString(columnRegId),
            this.getString(columnDocHash),
            this.getString(columnDocType)?.let { DocType.valueOf(it) },
            this.getString(columnResultConclusion)?.let { ConclusionType.valueOf(it) },
            this.getString(columnResultDate)?.let { DateConverter.toDate(it) },
            this.getString(columnResultComments),
            this.getString(columnOperationResultName),
            this.getString(columnOperationResultResult)?.let { OperationResult.valueOf(it) },
            this.getString(columnOperationResultComment),
            this.getString(columnOperationResultDate)?.let { DateConverter.toDate(it) }
    )
}