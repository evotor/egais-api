package ru.evotor.egais.api.sender

import android.os.Bundle
import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.ticket.DocType
import ru.evotor.egais.api.model.document.waybillact.AcceptType
import java.math.BigDecimal

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

    fun wayBillActPositionToBundle(identity: String, inforF2RegId: String, realQuantity: BigDecimal, marks: List<String>): Bundle {
        val bundle = Bundle()
        bundle.putString(IDENTITY, identity)
        bundle.putString(INFORM_F2_REG_ID, inforF2RegId)
        bundle.putSerializable(REAL_QUANTITY, realQuantity)
        bundle.putStringArrayList(MARKS, ArrayList(marks))

        return bundle
    }

    fun Bundle.getDocType() = getString(DOC_TYPE)

    fun Bundle.getIdentity() = getString(IDENTITY)

    fun Bundle.getNumber() = getString(NUMBER)

    fun Bundle.getWbRegId() = getString(WB_REG_ID)

    fun Bundle.getNote() = getString(NOTE)

    fun Bundle.getVersion() = getString(VERSION)?.let { Version.valueOf(it) }

    fun Bundle.getInformF2RegId() = getString(INFORM_F2_REG_ID)

    fun Bundle.getMarks() = getStringArrayList(MARKS)

    fun Bundle.getPositions(): List<Bundle>? = getParcelableArrayList(POSITIONS)

    fun Bundle.getAcceptType() = getString(ACCEPT_TYPE)?.let { AcceptType.valueOf(it) }

    fun Bundle.getRealQuantity() = getSerializable(REAL_QUANTITY) as? BigDecimal
}