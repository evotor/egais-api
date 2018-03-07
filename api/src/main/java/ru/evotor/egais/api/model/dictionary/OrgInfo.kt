package ru.evotor.egais.api.model.dictionary

import ru.evotor.egais.api.model.Version

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
        @JvmField var type: Type,
        @JvmField val clientRegId: String,
        @JvmField val fullName: String,
        @JvmField val shortName: String?,
        @JvmField val inn: String?,
        @JvmField val kpp: String?,
        @JvmField val unp: String?,
        @JvmField val rnn: String?,
        @JvmField val address: OrgAddress?,
        @JvmField var state: String?,
        @JvmField var versionWB: WBTypeUsed?
) {

    companion object {

        private val DASH = "-"

        fun createDescription(orgInfo: OrgInfo?): String {
            if (orgInfo == null) {
                return DASH
            }

            val b: Boolean? = orgInfo.fullName?.trim { it <= ' ' }?.isEmpty()

            if (orgInfo.shortName != null && !orgInfo.shortName.trim { it <= ' ' }.isEmpty()) {
                return orgInfo.shortName
            } else if (b != null && !b) {
                return orgInfo.fullName
            } else {
                return DASH
            }
        }

        fun canSendInVersion2Document(orgInfo: OrgInfo?): Boolean {
            if (orgInfo != null) {

                if (orgInfo.type == null) {
                    return false
                }
            }
            return true
        }

        fun calcVersion(orgInfo: OrgInfo?): Version {
            if (!canSendInVersion2Document(orgInfo)) {
                return Version.V1
            }

            return when (orgInfo?.versionWB) {
                WBTypeUsed.WAYBILL_V2 -> Version.V2
                WBTypeUsed.WAYBILL_V3 -> Version.V3
                else -> Version.V2
            }
        }
    }

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
