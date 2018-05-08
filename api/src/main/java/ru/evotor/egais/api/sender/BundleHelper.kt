package ru.evotor.egais.api.sender

import android.os.Bundle
import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.ticket.ConclusionType
import ru.evotor.egais.api.model.document.ticket.DocType
import ru.evotor.egais.api.model.document.waybillact.AcceptType
import java.math.BigDecimal

/**
 * Класс для формирования Bundle из документов ЕГАИС и обратно
 */
object BundleHelper {
    private const val DOC_TYPE = "docType"
    private const val IDENTITY = "identity"
    private const val ACCEPT_TYPE = "acceptType"
    private const val NUMBER = "number"
    private const val WB_REG_ID = "wbRegId"
    private const val NOTE = "note"
    private const val VERSION = "version"
    private const val POSITIONS = "positions"

    private const val INFORM_F2_REG_ID = "inforF2RegId"
    private const val REAL_QUANTITY = "realQuantity"
    private const val MARKS = "marks"

    private const val CONCLUSION_TYPE = "conclusionType"

    /**
     * Добавление акта разногласий к ТТН в Bundle
     *
     * @param identity ИД Акта (клиентский)
     * @param acceptType Тип подтверждения: Принимаем/отказываем
     * @param number Номер акта
     * @param wbRegId ИД накладной в системе
     * @param version Версия протокола докумкетооборота ЕГАИС
     * @param note Заметки
     * @param positions Позиции акта разногласий к ТТН, сформированные в Bundle
     */
    fun wayBillActToBundle(identity: String?, acceptType: AcceptType?, number: String, wbRegId: String, version: Version, note: String?, positions: List<Bundle>): Bundle {
        val bundle = Bundle()
        bundle.putString(DOC_TYPE, DocType.WAY_BILL_ACT.toString())
        bundle.putString(IDENTITY, identity)
        bundle.putString(ACCEPT_TYPE, acceptType.toString())
        bundle.putString(NUMBER, number)
        bundle.putString(WB_REG_ID, wbRegId)
        bundle.putString(NOTE, note)
        bundle.putString(VERSION, version.toString())
        bundle.putParcelableArrayList(POSITIONS, ArrayList(positions))

        return bundle
    }

    /**
     * Добавление позиции акта разногласий к ТТН в Bundle
     *
     * @param identity Идентификатор позиции внутри накладной
     * @param informBRegId Регистрационный номер записи справки Б
     * @param realQuantity Количество фактическое
     * @param marks Перечень считанных кодов марок
     */
    fun wayBillActPositionToBundle(identity: String, informF2RegId: String, realQuantity: BigDecimal, marks: List<String>): Bundle {
        val bundle = Bundle()
        bundle.putString(IDENTITY, identity)
        bundle.putString(INFORM_F2_REG_ID, informF2RegId)
        bundle.putSerializable(REAL_QUANTITY, realQuantity)
        bundle.putStringArrayList(MARKS, ArrayList(marks))

        return bundle
    }

    /**
     * Добавление тикета подтверждения для акта разногласий к ТТН в Bundle
     *
     * @param identity ИД Акта (клиентский)
     * @param isConfirm Тип подтверждения: Принимаем/отказываем
     * @param number Номер акта
     * @param wbRegId ИД накладной в системе
     * @param note Заметки
     */
    fun confirmTicketToBundle(identity: String?, isConfirm: ConclusionType?, ticketNumber: String, wbRegId: String, note: String?): Bundle {
        val bundle = Bundle()
        bundle.putString(DOC_TYPE, DocType.CONFIRM_TICKET.toString())
        bundle.putString(IDENTITY, identity)
        bundle.putString(CONCLUSION_TYPE, isConfirm.toString())
        bundle.putString(NUMBER, ticketNumber)
        bundle.putString(WB_REG_ID, wbRegId)
        bundle.putString(NOTE, note)

        return bundle
    }

    /**
     * Тип документа
     */
    fun Bundle.getDocType() = getString(DOC_TYPE)

    /**
     * Идентификатор (клиентский)
     */
    fun Bundle.getIdentity() = getString(IDENTITY)

    /**
     * Номер документа
     */
    fun Bundle.getNumber() = getString(NUMBER)

    /**
     * ИД накладной в системе
     */
    fun Bundle.getWbRegId() = getString(WB_REG_ID)

    /**
     * Заметки
     */
    fun Bundle.getNote() = getString(NOTE)

    /**
     * Версия протокола докумкетооборота ЕГАИС
     */
    fun Bundle.getVersion() = getString(VERSION)?.let { Version.valueOf(it) }

    /**
     * Регистрационный номер записи справки 2
     */
    fun Bundle.getInformF2RegId() = getString(INFORM_F2_REG_ID)

    /**
     * Перечень считанных кодов марок
     */
    fun Bundle.getMarks() = getStringArrayList(MARKS)

    /**
     * Список позиций документа, сформированных в Bundle
     */
    fun Bundle.getPositions(): List<Bundle>? = getParcelableArrayList(POSITIONS)

    /**
     * Тип подтверждения: Принимаем/отказываем
     */
    fun Bundle.getAcceptType() = getString(ACCEPT_TYPE)?.let { AcceptType.valueOf(it) }

    /**
     * Количество фактическое
     */
    fun Bundle.getRealQuantity() = getSerializable(REAL_QUANTITY) as? BigDecimal

    /**
     * Тип подтверждения: Принимаем/отказываем
     */
    fun Bundle.getConclusionType() = getString(CONCLUSION_TYPE)?.let { ConclusionType.valueOf(it) }
}