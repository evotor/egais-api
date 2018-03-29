package ru.evotor.egais.api.model.dictionary

/**
 *  Информация об организации
 *
 * @property type
 * @property clientRegId Код организации
 * @property fullName Наименование организации полное
 * @property shortName Наименование организации краткое
 * @property inn ИНН
 * @property kpp КПП
 * @property unp УНП для респ.Беларусь
 * @property rnn РНН(БИН/ИИН) для респ.Казахстан
 * @property address Фактический адрес
 * @param state Статус: действующая или удалена
 * @param versionWB Версия схемы накладной принимаемая организацией
 */
data class OrgInfo(
        @JvmField val type: Type?,
        @JvmField val clientRegId: String,
        @JvmField val fullName: String,
        @JvmField val shortName: String?,
        @JvmField val inn: String?,
        @JvmField val kpp: String?,
        @JvmField val unp: String?,
        @JvmField val rnn: String?,
        @JvmField val address: OrgInfoAddress?,
        @JvmField val state: String?,
        @JvmField val versionWB: WBTypeUsed?
) {

    enum class Type {
        /**
         * Юридическое лицо
         */
        UL,
        /**
         * Индивидуальный предприниматель
         */
        FL,
        /**
         * Иностранец (исключая таможенный союз)
         */
        FO,
        /**
         * Таможенный союз
         */
        TS
    }
}
