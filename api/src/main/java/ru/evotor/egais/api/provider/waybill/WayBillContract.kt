package ru.evotor.egais.api.provider.waybill

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object WayBillContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.waybill"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    val PATH = "WayBill"
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * UUID накладной.
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Идентификатор накладной (клиентский, к заполнению необязательный).
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Отправитель накладной.
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * Тип накладной.
     */
    const val COLUMN_TYPE = "TYPE"

    /**
     * Тип упаковки.
     */
    const val COLUMN_UNIT_TYPE = "UNIT_TYPE"

    /**
     * Номер документа.
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата составления.
     */
    const val COLUMN_DATE = "DATE"

    /**
     * Дата отгрузки продукции.
     */
    const val COLUMN_SHIPPING_DATE = "SHIPPING_DATE"

    /**
     * Грузоотправитель.
     */
    const val COLUMN_SHIPPER_ID = "SHIPPER_ID"

    /**
     * Грузополучатель.
     */
    const val COLUMN_CONSIGNEE_ID = "CONSIGNEE_ID"

    /**
     * Поставщик.
     */
    const val COLUMN_SUPPLIER_ID = "SUPPLIER_ID"

    /**
     * Основание.
     */
    const val COLUMN_BASE = "BASE"

    /**
     * Заметки.
     */
    const val COLUMN_NOTE = "NOTE"

    /**
     * Текущий статус накладной.
     */
    const val COLUMN_STATUS = "STATUS"

    /**
     * Резолюция накладной.
     */
    const val COLUMN_RESOLUTION = "RESOLUTION"

    /**
     * uuid справки 2 для накладной.
     */
    const val COLUMN_TTN_INFORM_F2_REG_UUID = "TTN_INFORM_F2_REG_UUID"

    /**
     * Версия протокола ЕГАИС, по которому отправлена накладная
     */
    const val COLUMN_VERSION = "VERSION"

    /**
     * Транспорт. Тип перевозки.
     */
    const val COLUMN_TRANSPORT_TYPE = "TRANSPORT_TYPE"
    /**
     * Транспорт. Название компании перевозчика.
     */
    const val COLUMN_TRANSPORT_COMPANY = "TRANSPORT_COMPANY"
    /**
     * Транспорт. Автомобиль.
     */
    const val COLUMN_TRANSPORT_CAR = "TRANSPORT_CAR"
    /**
     * Транспорт. Прицеп.
     */
    const val COLUMN_TRANSPORT_TRAILER = "TRANSPORT_TRAILER"
    /**
     * Транспорт. Заказчики.
     */
    const val COLUMN_TRANSPORT_CUSTOMER = "TRANSPORT_CUSTOMER"
    /**
     * Транспорт. Водитель.
     */
    const val COLUMN_TRANSPORT_DRIVER = "TRANSPORT_DRIVER"
    /**
     * Транспорт. Место погрузки.
     */
    const val COLUMN_TRANSPORT_LOADPOINT = "TRANSPORT_LOADPOINT"
    /**
     * Транспорт. Место разгрузки.
     */
    const val COLUMN_TRANSPORT_UNLOADPOINT = "TRANSPORT_UNLOADPOINT"
    /**
     * Транспорт. Перенаправление.
     */
    const val COLUMN_TRANSPORT_REDIRECT = "TRANSPORT_REDIRECT"
    /**
     * Транспорт. Экспедитор.
     */
    const val COLUMN_TRANSPORT_FORWARDER = "TRANSPORT_FORWARDER"

    /**
     * ИД накладной в системе ЕГАИС.
     */
    const val COLUMN_WB_REG_ID = "WB_REG_ID"
}