package ru.evotor.egais.api.model.document.waybillact

/**
 * Статус акта разногласия для ТТН
 */
enum class Status {
    /**
     * Новый
     */
    NOT_PROCESSED,
    /**
     * Ожидание данных от УТМ
     */
    WAIT_UTM_ANSWER,
    /**
     * Принят
     */
    FINISH,
    /**
     * Отклонен (Полный отказ от приемки ТТН)
     */
    NOT_CONFIRMED,
    /**
     * Ожидание ответа от отправителя
     */
    WAIT_SENDER_ANSWER,
    /**
     * Акт разногласий отклонен
     */
    REJECTED_WBA,
    /**
     * Распроведен (Отмена проведения акта ТТН)
     */
    REPEALED,
    /**
     * Ошибка
     */
    ERROR,
    /**
     * Нулевой акт расхождения
     */
    ZERO_QUANTITY_DIFFERENCES,
    /**
     * Новая версия
     */
    NEW_VERSION,
    /**
     * Отозвана
     */
    CANCEL_WB,
    /**
     * Запрошена отмена акта накладной (Отмена проведения акта ТТН)
     */
    WAIT_REPEALED_ANSWER,
    /**
     * Отказ в распроведении (Отказ грузоотправителя от отмены проведения акта ТТН)
     */
    REJECTED_REPEAL
}