package ru.evotor.egais.api.model.dictionary

/**
 * Информация о продукции
 *
 * @property type Тип продукции (АП | ССП | ССНП | Спирт) Если не указано, то АП
 * @property fullName Наименование продукции полное
 * @property shortName Наименование продукции краткое
 * @property alcCode Код продукции согласно ЕГАИС
 * @property capacity Емкость упаковки продукции согласно ЕГАИС
 * @property alcVolume Содержание этилового спирта, %
 * @property producerId Производитель
 * @property importerId Импортер
 * @property productVCode Код вида продукции.
 * @property unitType Тип поставки (упакованная или нет)
 */
data class ProductInfo(
        @JvmField val type: ProductType,
        @JvmField val fullName: String?,
        @JvmField val shortName: String?,
        @JvmField val alcCode: String,
        @JvmField val capacity: String?,
        @JvmField val alcVolume: String?,
        @JvmField val producerId: String?,
        @JvmField val importerId: String?,
        @JvmField val productVCode: String?,
        @JvmField val unitType: UnitType
) {

    companion object {

        private val DASH = "-"

        fun createDescription(productInfo: ProductInfo?): String {
            if (productInfo == null) {
                return DASH
            }

            val shortName = productInfo.shortName?.trim({ it <= ' ' })
            val b: Boolean? = productInfo.fullName?.trim({ it <= ' ' })?.isEmpty()
            return if (shortName != null && !shortName.isEmpty()) {
                shortName
            } else if (b != null && !b) {
                productInfo.fullName
            } else {
                DASH
            }
        }
    }
}
