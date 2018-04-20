package ru.evotor.egais.api.query

import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.test.ProviderTestCase2
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as mockitoWhen
import org.robolectric.annotation.Config
import ru.evotor.egais.api.model.dictionary.ProductRest
import java.math.BigDecimal
import android.test.mock.MockContentProvider
import ru.evotor.egais.api.provider.dictionary.DictionaryContract.AUTHORITY
import org.robolectric.RobolectricTestRunner

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class ProductRestQueryTest : ProviderTestCase2<ProductRestQueryTest.QueryMockContentProvider>(QueryMockContentProvider::class.java, AUTHORITY) {

    private val columnNames = arrayOf(
            "STOCK_QUANTITY",
            "SHOP_QUANTITY",
            "TOTAL_QUANTITY",
            "TYPE",
            "FULL_NAME",
            "FULL_NAME_UPPER_CASE",
            "SHORT_NAME",
            "SHORT_NAME_UPPER_CASE",
            "ALC_CODE",
            "CAPACITY",
            "ALC_VOLUME",
            "PRODUCER_CLIENT_REG_ID",
            "IMPORTER_CLIENT_REG_ID",
            "PRODUCT_V_CODE"
    )
//    private val allProductRests = arrayListOf<ProductRest>(
//            mock(ProductRest::class.java),
//            mock(ProductRest::class.java),
//            mock(ProductRest::class.java),
//            mock(ProductRest::class.java)
//    )
    private val cursor = MatrixCursor(columnNames)

    @Test
    fun testNoFilters() {
        cursor.addRow(arrayOf(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        ))
        provider.addQueryResult(cursor)
        val result = ProductRestQuery().noFilters().execute(mockContext)
        Assert.assertEquals(cursor.count, result.count)
        result.toList().forEach {
            Assert.assertNotNull(it)
        }
    }

    @Test
    fun testTotalQuantityGreaterThanZero() {
//        val conditionMatched = arrayListOf<ProductRest>(allProductRests[0])
//        mockitoWhen(conditionMatched[0].stockQuantity).thenReturn(BigDecimal.TEN)
//        mockitoWhen(provider.query(
//                any(Uri::class.java),
//                any(Array<String>::class.java),
//                any(String::class.java),
//                any(Array<String>::class.java),
//                any(String::class.java))
//        ).thenReturn(cursor)
        cursor.addRow(arrayOf(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""
        ))
        provider.addQueryResult(cursor)
        val result = ProductRestQuery().totalQuantity.greater(BigDecimal.ZERO).execute(mockContext)
        Assert.assertEquals(cursor.count, result.count)
        result.toList().forEach {
            Assert.assertNotNull(it)
        }
    }

    inner class QueryMockContentProvider : MockContentProvider() {
        private var queryResult: Cursor? = null

        fun addQueryResult(expectedResult: Cursor) {
            this.queryResult = expectedResult
        }

        override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
            return this.queryResult
        }
    }
}
