package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.document.actwriteoff.ActWriteOffShopPosition
import ru.evotor.egais.api.provider.actwtiteoff.ActWriteOffShopPositionContract
import ru.evotor.egais.api.provider.converter.MarkListConverter
import ru.evotor.egais.api.provider.converter.QuantityBigDecimalConverter
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.math.BigDecimal
import java.util.*

/**
 * Класс для формирования запроса на получение позиций акта списания из магазина
 */
class ActWriteOffShopPositionQuery : FilterBuilder<ActWriteOffShopPositionQuery, ActWriteOffShopPositionQuery.SortOrder, ActWriteOffShopPosition>(ActWriteOffShopPositionContract.URI) {

    /**
     * Уникальный идентификатор позиции акта списания из магазина
     */
    @JvmField
    val uuid = addFieldFilter<UUID>(ActWriteOffShopPositionContract.COLUMN_UUID)

    /**
     * Уникальный идентификатор акта списания из магазина
     */
    @JvmField
    val actWriteOffShopId = addFieldFilter<UUID?>(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_UUID)

    /**
     * Идентификатор позиции акта списания из магазина (клиентский, к заполнению необязательный)
     */
    @JvmField
    val identity = addFieldFilter<String?>(ActWriteOffShopPositionContract.COLUMN_IDENTITY)

    /**
     * Количество
     */
    @JvmField
    val quantity = addFieldFilter<BigDecimal, Long>(ActWriteOffShopPositionContract.COLUMN_QUANTITY) { QuantityBigDecimalConverter.toLong(it) }

    /**
     * Информация о марках в формате JSON
     */
    @JvmField
    val informF2MarkInfoJson = addFieldFilter<String?>(ActWriteOffShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)

    /**
     * Информация о продукции
     */
    @JvmField
    val productInfo = addInnerFilterBuilder(ProductInfoFilter<ActWriteOffShopPositionQuery, ActWriteOffShopPositionQuery.SortOrder, ActWriteOffShopPosition>())

    /**
     * Сумма продажи. Обязательно для заполнения при причине списания "Реализация"
     */
    @JvmField
    val sumSale = addFieldFilter<BigDecimal?, Long?>(ActWriteOffShopPositionContract.COLUMN_SUM_SALE) { it?.let { QuantityBigDecimalConverter.toLong(it) } }

    override val currentQuery: ActWriteOffShopPositionQuery
        get() = this

    /**
     * Класс для сортировки полей в результе запроса
     */
    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        /**
         * Уникальный идентификатор позиции акта списания из магазина
         */
        @JvmField
        val uuid = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_UUID)

        /**
         * Уникальный идентификатор акта списания из магазина
         */
        @JvmField
        val actWriteOffShopUuid = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_UUID)

        /**
         * Идентификатор позиции акта списания из магазина (клиентский, к заполнению необязательный)
         */
        @JvmField
        val identity = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_IDENTITY)

        /**
         * Количество
         */
        @JvmField
        val quantity = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_QUANTITY)

        /**
         * Информация о марках в формате JSON
         */
        @JvmField
        val informF2MarkInfoJson = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)

        /**
         * Информация о продукции
         */
        @JvmField
        val productInfo = addInnerSortOrder(ProductInfoFilter.SortOrder<ActWriteOffShopPositionQuery.SortOrder>())

        /**
         * Сумма продажи. Обязательно для заполнения при причине списания "Реализация"
         */
        @JvmField
        val sumSale = addFieldSorter(ActWriteOffShopPositionContract.COLUMN_SUM_SALE)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<ActWriteOffShopPosition>): ActWriteOffShopPosition {
        return createActWriteOffShopPosition(cursor)
    }

    private fun createActWriteOffShopPosition(cursor: android.database.Cursor): ActWriteOffShopPosition {
        val columnIndexUuid = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_UUID)
        val columnIndexActUuid = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_ACT_WRITE_OFF_SHOP_UUID)
        val columnIndexIdentity = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_IDENTITY)
        val columnIndexMarkJson = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_INFORM_F2_MARK_INFO_JSON)
        val columnIndexMarkList = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_MARK_LIST)
        val columnIndexSumSale = cursor.getColumnIndex(ActWriteOffShopPositionContract.COLUMN_SUM_SALE)

        return ActWriteOffShopPosition(
                UUID.fromString(cursor.getString(columnIndexUuid)),
                UUID.fromString(cursor.getString(columnIndexActUuid)),
                cursor.getString(columnIndexIdentity),
                cursor.getQuantity(ActWriteOffShopPositionContract.COLUMN_QUANTITY, ActWriteOffShopPositionContract.COLUMN_QUANTITY_DAL),
                cursor.getString(columnIndexMarkJson),
                cursor.createProductInfo(),
                if (cursor.isNull(columnIndexSumSale)) null else QuantityBigDecimalConverter.toBigDecimal(cursor.getLong(columnIndexSumSale)),
                MarkListConverter.toMarkList(cursor.getString(columnIndexMarkList))
        )
    }
}