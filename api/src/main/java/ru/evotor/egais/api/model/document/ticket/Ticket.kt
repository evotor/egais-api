package ru.evotor.egais.api.model.document.ticket

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*


/**
 * Квитанция
 *
 * @property uuid уникальный идентификатор
 * @property docOwner кто подает документы
 * @property ticketDate Дата квитанции
 * @property identity Идентификатор документа(исходного, клиентский из содержимого XML(может не быть))
 * @property docId Ид задачи из файловой базы
 * @property transportId Транспортный ид из файловой базы
 * @property regId Присвоенный документу номер
 * @property docHash Хэш документа
 * @property docType Тип исходного документа
 * @property resultConclusion Результат фиксации
 * @property resultDate Дата фиксации
 * @property resultComments Описание результата фиксации, описание ошибки фиксации
 * @property operationResultName Операция
 * @property operationResultResult Результат выполнения
 * @property operationResultComment Сообщение
 * @property operationResultDate Дата операции
 */
data class Ticket(
        val uuid: UUID,
        val docOwner: String,
        val ticketDate: Date?,
        val identity: String?,
        val docId: String?,
        val transportId: String?,
        val regId: String?,
        val docHash: String?,
        val docType: DocType?,
        val resultConclusion: ConclusionType?,
        val resultDate: Date?,
        val resultComments: String?,
        val operationResultName: String?,
        val operationResultResult: OperationResult?,
        val operationResultComment: String?,
        val operationResultDate: Date?
) : EgaisDocument()