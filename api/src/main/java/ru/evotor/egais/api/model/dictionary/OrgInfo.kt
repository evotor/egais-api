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
        val type: Type?,
        val clientRegId: String,
        val fullName: String,
        val shortName: String?,
        val inn: String?,
        val kpp: String?,
        val unp: String?,
        val rnn: String?,
        val address: OrgAddress?,
        val state: String?,
        val versionWB: WBTypeUsed?
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
