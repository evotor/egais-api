package ru.evotor.egais.api.model.document

import ru.evotor.egais.api.model.document.ticket.DocType
import java.util.*

data class EgaisDocumentStatusRecord(

        /**
         * UUID документа
         * */
        val uuid: UUID,

        /**
         * Старый статус документа
         * */
        val stateOld: String?,

        /**
         * Новый статус документа
         * */
        val stateNew: String?,

        /**
         * Тип документа
         * */
        val type: DocType,

        /**
         * Дата изменения статуса
         * */
        val date: Date
)