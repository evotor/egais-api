package ru.evotor.egais.api.provider.actchargeonshop

import android.net.Uri
import ru.evotor.egais.api.provider.MainContract

internal object ActChargeOnShopContract {
    const val AUTHORITY = "${MainContract.AUTHORITY_PREFIX}.actchargeonshop"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmField
    val PATH = "ActChargeOnShop"

    @JvmField
    val URI = Uri.withAppendedPath(BASE_URI, PATH)

    /**
     * Уникальный идентификатор
     */
    const val COLUMN_UUID = "UUID"

    /**
     * Кто подает документы
     */
    const val COLUMN_OWNER = "OWNER"

    /**
     * ID акта (клиентсикй)
     */
    const val COLUMN_IDENTITY = "IDENTITY"

    /**
     * Номер документа
     */
    const val COLUMN_NUMBER = "NUMBER"

    /**
     * Дата постановски на баланс
     */
    const val COLUMN_ACT_DATE = "ACT_DATE"

    /**
     * Причина постановки на баланс (Пересортица/Излишки/Продукция, полученная до 01.01.2016)
     */
    const val COLUMN_TYPE_ACT_CHARGE_ON_SHOP = "TYPE_ACT_CHARGE_ON_SHOP"

    /**
     * Регистрационный номер акта списания по типу "Пересортица".
     * Обязательно для заполнения для типа постановки на баланс "Пересортица".
     */
    const val COLUMN_ACT_WRITE_OFF = "ACT_WRITE_OFF"

    /**
     * Примечание
     */
    const val COLUMN_NOTE = "NOTE"

    /**
     * Статус документа
     */
    const val COLUMN_STATUS = "STATUS"

    /**
     * Комментарий при отказе
     */
    const val COLUMN_REJECT_COMMENT = "REJECT_COMMENT"
}