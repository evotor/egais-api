package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffPosition
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffPositionContract
import ru.evotor.egais.api.provider.converter.MarkListConverter
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

/**
 * Класс для формирования запроса на получение позиций акта списания со склада
 */
class ActWriteOffPositionQuery : FilterBuilder<ActWriteOffPositionQuery, ActWriteOffPositionQuery.SortOrder, ActWriteOffPosition>(ActWriteOffPositionContract.URI) {

    /**
     * Уникальный идентификатор позиции акта списания со склада
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActWriteOffPositionContract.COLUMN_UUID)

    /**
     * Уникальный идентификатор акта списания со склада
     */
    @JvmField
    val actWriteOffUuid = addFieldFilter<UUID>(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)

    /**
     * Идентификатор позиции акта списания со склада
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_IDENTITY)

    /**
     * Количество
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(ActWriteOffPositionContract.COLUMN_QUANTITY) { QuantityBigDecimalConverter.toLong(it) }

    /**
     * Регистрационный номер раздела справки 2
     */
    @JvmField
    val informF2RegId = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_INFORM_F2_REG_ID)

    /**
     * Информация о марках в формате JSON
     */
    @JvmField
    val informF2MarkInfoJson = addFieldFilter<String?>(ActWriteOffPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)

    /**
     * Информация о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<ActWriteOffPositionQuery, ActWriteOffPositionQuery.SortOrder, ActWriteOffPosition>())

    /**
     * Сумма продажи. Обязательно для заполнения при причине списания "Реализация"
     */
    @JvmField
    val sumSale = addFieldFilter<BigDecimal?, Long?>(ActWriteOffPositionContract.COLUMN_SUM_SALE) { it?.let { QuantityBigDecimalConverter.toLong(it) } }

    override val currentQuery: ActWriteOffPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции акта списания со склада
         */
        @JvmField
        val uuid = addFieldSorter(ActWriteOffPositionContract.COLUMN_UUID)

        /**
         * Уникальный идентификатор акта списания со склада
         */
        @JvmField
        val actWriteOffUuid = addFieldSorter(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)

        /**
         * Идентификатор позиции акта списания со склада
         */
        @JvmField
        val identity = addFieldSorter(ActWriteOffPositionContract.COLUMN_IDENTITY)

        /**
         * Количество
         */
        @JvmField
        val quantity = addFieldSorter(ActWriteOffPositionContract.COLUMN_QUANTITY)

        /**
         * Регистрационный номер раздела справки 2
         */
        @JvmField
        val informF2RegId = addFieldSorter(ActWriteOffPositionContract.COLUMN_INFORM_F2_REG_ID)

        /**
         * Информация о марках в формате JSON
         */
        @JvmField
        val informF2MarkInfoJson = addFieldSorter(ActWriteOffPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<ActWriteOffPositionQuery.SortOrder>())

        /**
         * Сумма продажи. Обязательно для заполнения при причине списания "Реализация"
         */
        @JvmField
        val sumSale = addFieldSorter(ActWriteOffPositionContract.COLUMN_SUM_SALE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOffPosition>): ActWriteOffPosition {
        return createActWriteOffPosition(cursor)
    }

    private fun createActWriteOffPosition(cursor: android.database.Cursor): ActWriteOffPosition {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_ACT_WRITE_OFF_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_IDENTITY)
        val columnIndexInformF2RegId = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_INFORM_F2_REG_ID)
        val columnIndexMarkJson = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)
        val columnIndexMarkList = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_MARK_LIST)
        val columnIndexSumSale = cursor.getColumnIndex(ActWriteOffPositionContract.COLUMN_SUM_SALE)

        return ActWriteOffPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                cursor.getQuantity(ActWriteOffPositionContract.COLUMN_QUANTITY, ActWriteOffPositionContract.COLUMN_QUANTITY_DAL),
                cursor.getString(columnIndexInformF2RegId),
                cursor.getString(columnIndexMarkJson),
                cursor.createProductInfo(),
                if (cursor.isNull(columnIndexSumSale)) null else QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnIndexSumSale)),
                MarkListConverter.toMarkList(cursor.getString(columnIndexMarkList))
        )
    }
}