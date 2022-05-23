package ru.evotor.egais.api.model.document.waybill

/**
 * Статус ТТН
 */
enum class Status {
    /**
     * Новая
     */
    NOT_PROCESSED,

    /**
     * Ожидание данных от УТМ
     */
    WAIT_UTM_ANSWER,

    /**
     * Принята
     */
    FINISH,

    /**
     * Отклонена
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
     * Распроведена (Отмена проведения акта накладной)
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
     * Запрошена отмена акта накладной (Отмена проведения акта накладной)
     */
    WAIT_REPEALED_ANSWER,

    /**
     * Отказ в распроведении (Отказ грузоотправителя от отмены проведения акта ТТН)
     */
    REJECTED_REPEAL,

    /**
     * Неизвестный статус (Например, новый статус, который не известен в этой версии апи)
     */
    UNKNOWN
}
