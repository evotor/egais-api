package ru.evotor.egais.api.provider.waybill

import android.net.Uri

internal object TtnInformF2RegContract {
    val PATH = "TtnInformF2Reg"
    val URI = Uri.withAppendedPath(WayBillContract.BASE_URI, PATH)

    /**
     * Уникальный идентификатор справки 2
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Кто подает документы
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * ИД накладной(клиентский, исходной накладной, если заполнялся)
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * ИД накладной в системе (присвоенный)
     */
    const val COLUMN_WB_REG_ID = "WB_REG_ID"

    /**
     * Номер фиксации накладной(отгрузки) в ЕГАИС
     */
    const val COLUMN_EGAIS_FIX_NUMBER = "EGAIS_FIX_NUMBER"

    /**
     * Дата составления накладной(отгрузки) в ЕГАИС
     */
    const val COLUMN_EGAIS_FIX_DATE = "EGAIS_FIX_DATE"

    /**
     * Номер накладной
     */
    const val COLUMN_WB_NUMBER = "WB_NUMBER"

    /**
     * Дата составления накладной
     */
    const val COLUMN_WB_DATE = "WB_DATE"

    /**
     * Грузоотправитель
     */
    const val COLUMN_SHIPPER_ID = "SHIPPER_ID"

    /**
     * Грузополучатель
     */
    const val COLUMN_CONSIGNEE_ID = "CONSIGNEE_ID"

    /**
     * Поставщик
     */
    const val COLUMN_SUPPLIER_ID = "SUPPLIER_ID"

    /**
     * Уникальный идентификатор ТТН
     */
    const val COLUMN_WAY_BILL_ID = "WAY_BILL_ID"

    /**
     * Текущий статус справки 2
     */
    const val COLUMN_STATUS = "STATUS"
}