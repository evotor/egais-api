package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actchargeon.ActChargeOnPosition
import ru.evotor.egais.api.model.document.actchargeon.InformF1
import ru.evotor.egais.api.provider.actchargeon.ActChargeOnPositionContract
import ru.evotor.egais.api.provider.converter.DateConverter
import ru.evotor.egais.api.provider.converter.MarkListConverter
import ru.evotor.egais.api.provider.converter.QuantityDalBigDecimalConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

/**
 * Класс для формирования запроса на получение позиций акта поставки на баланс на склад
 */
class ActChargeOnPositionQuery : FilterBuilder<ActChargeOnPositionQuery, ActChargeOnPositionQuery.SortOrder, ActChargeOnPosition>(ActChargeOnPositionContract.URI) {

    /**
     * Уникальный идентификатор позиции акта
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActChargeOnPositionContract.COLUMN_UUID)

    /**
     * Идентификатор акта постановки, содержащего позицию
     */
    @JvmField
    val actChargeOnUuid = addFieldFilter<UUID>(ActChargeOnPositionContract.COLUMN_ACT_CHARGE_ON_UUID)

    /**
     * Идентификатор позиции внутри накладной
     */
    @JvmField
    val identity = addFieldFilter<String>(ActChargeOnPositionContract.COLUMN_IDENTITY)

    /**
     * Количество
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(ActChargeOnPositionContract.COLUMN_QUANTITY) { QuantityDalBigDecimalConverter.toLong(it) }

    /**
     * Информация о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<ActChargeOnPositionQuery, ActChargeOnPositionQuery.SortOrder, ActChargeOnPosition>())

    /**
     * Справка 1: Количество
     */
    @JvmField
    val informF1Quantity = addFieldFilter<BigDecimal, Long>(ActChargeOnPositionContract.COLUMN_INFORMF1_QUANTITY) { QuantityDalBigDecimalConverter.toLong(it) }

    /**
     * Справка 1: Дата розлива продукции
     */
    @JvmField
    val informF1BottlingDate = addFieldFilter<Date, String>(ActChargeOnPositionContract.COLUMN_INFORMF1_BOTTLING_DATE) { DateConverter.toString(it) }

    /**
     * Справка 1: Номер ТТН
     */
    @JvmField
    val informF1TtnNumber = addFieldFilter<String>(ActChargeOnPositionContract.COLUMN_INFORMF1_TTN_NUMBER)

    /**
     * Справка 1: Дата накладной
     */
    @JvmField
    val informF1TtnDate = addFieldFilter<Date, String>(ActChargeOnPositionContract.COLUMN_INFORMF1_TTN_DATE) { DateConverter.toString(it) }

    /**
     * Справка 1: Номер подтверждения о фиксации в ЕГАИС
     */
    @JvmField
    val informF1EgaisFixNumber = addFieldFilter<String>(ActChargeOnPositionContract.COLUMN_INFORMF1_EGAIS_FIX_NUMBER)

    /**
     * Справка 1: Дата подтверждения о фиксации в ЕГАИС
     */
    @JvmField
    val informF1EgaisFixDate = addFieldFilter<Date, String>(ActChargeOnPositionContract.COLUMN_INFORMF1_EGAIS_FIX_DATE) { DateConverter.toString(it) }

    override val currentQuery: ActChargeOnPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции акта
         */
        @JvmField
        val uuid = addFieldSorter(ActChargeOnPositionContract.COLUMN_UUID)

        /**
         * Идентификатор акта постановки, содержащего позицию
         */
        @JvmField
        val actChargeOnUuid = addFieldSorter(ActChargeOnPositionContract.COLUMN_ACT_CHARGE_ON_UUID)

        /**
         * Идентификатор позиции внутри накладной
         */
        @JvmField
        val identity = addFieldSorter(ActChargeOnPositionContract.COLUMN_IDENTITY)

        /**
         * Количество
         */
        @JvmField
        val quantity = addFieldSorter(ActChargeOnPositionContract.COLUMN_QUANTITY)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<ActChargeOnPositionQuery.SortOrder>())

        /**
         * Справка 1: Количество
         */
        @JvmField
        val informF1Quantity = addFieldSorter(ActChargeOnPositionContract.COLUMN_INFORMF1_QUANTITY)

        /**
         * Справка 1: Дата розлива продукции
         */
        @JvmField
        val informF1BottlingDate = addFieldSorter(ActChargeOnPositionContract.COLUMN_INFORMF1_BOTTLING_DATE)

        /**
         * Справка 1: Номер ТТН
         */
        @JvmField
        val informF1TtnNumber = addFieldSorter(ActChargeOnPositionContract.COLUMN_INFORMF1_TTN_NUMBER)

        /**
         * Справка 1: Дата накладной
         */
        @JvmField
        val informF1TtnDate = addFieldSorter(ActChargeOnPositionContract.COLUMN_INFORMF1_TTN_DATE)

        /**
         * Справка 1: Номер подтверждения о фиксации в ЕГАИС
         */
        @JvmField
        val informF1EgaisFixNumber = addFieldSorter(ActChargeOnPositionContract.COLUMN_INFORMF1_EGAIS_FIX_NUMBER)

        /**
         * Справка 1: Дата подтверждения о фиксации в ЕГАИС
         */
        @JvmField
        val informF1EgaisFixDate = addFieldSorter(ActChargeOnPositionContract.COLUMN_INFORMF1_EGAIS_FIX_DATE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActChargeOnPosition>): ActChargeOnPosition {
        return createActChargeOnPosition(cursor)
    }

    private fun createActChargeOnPosition(cursor: android.database.Cursor): ActChargeOnPosition {
        val columnIndexUuid = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_ACT_CHARGE_ON_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_IDENTITY)
        val columnIndexQuantity = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_QUANTITY)
        val columnIndexInformF1Quantity = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_INFORMF1_QUANTITY)
        val columnIndexInformF1BottlingDate = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_INFORMF1_BOTTLING_DATE)
        val columnIndexInformF1TtnNumber = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_INFORMF1_TTN_NUMBER)
        val columnIndexInformF1TtnDate = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_INFORMF1_TTN_DATE)
        val columnIndexInformF1EgaisFixNumber = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_INFORMF1_EGAIS_FIX_NUMBER)
        val columnIndexInformF1EgaisFixDate = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_INFORMF1_EGAIS_FIX_DATE)
        val columnIndexMarks = cursor.getColumnIndex(ActChargeOnPositionContract.COLUMN_MARK_LIST)


        return ActChargeOnPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                QuantityDalBigDecimalConverter.toBigDecimal(cursor.getLong(columnIndexQuantity)),
                cursor.createProductInfo(),
                InformF1(
                        QuantityDalBigDecimalConverter.toBigDecimal(cursor.getLong(columnIndexInformF1Quantity)),
                        DateConverter.toDate(cursor.getString(columnIndexInformF1BottlingDate)),
                        cursor.getString(columnIndexInformF1TtnNumber),
                        DateConverter.toDate(cursor.getString(columnIndexInformF1TtnDate)),
                        cursor.getString(columnIndexInformF1EgaisFixNumber),
                        DateConverter.toDate(cursor.getString(columnIndexInformF1EgaisFixDate))
                ),
                MarkListConverter.toMarkList(cursor.getString(columnIndexMarks))
        )
    }
}