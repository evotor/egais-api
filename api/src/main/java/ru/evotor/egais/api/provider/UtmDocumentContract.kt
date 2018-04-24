package ru.evotor.egais.api.provider


internal object UtmDocumentContract {

    /**
     * Направление документа в представлени УТМ (входящий/исходящий)
     */
    const val COLUMN_DIRECTION = "DIRECTION"

    /**
     * Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
     */
    const val COLUMN_REPLY_ID = "REPLY_ID"
}