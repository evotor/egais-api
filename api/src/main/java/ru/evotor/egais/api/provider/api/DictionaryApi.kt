package ru.evotor.egais.api.provider.api

import android.content.Context
import android.database.Cursor
import android.net.Uri
import ru.evotor.egais.api.model.dictionary.OrgInfo
import ru.evotor.egais.api.model.dictionary.ProductInfo
import ru.evotor.egais.api.model.dictionary.ProductType
import ru.evotor.egais.api.model.dictionary.WBTypeUsed
import ru.evotor.egais.api.provider.dictionary.OrgInfoContract
import ru.evotor.egais.api.provider.dictionary.ProductInfoContract

object DictionaryApi {

    const val AUTHORITY = "ru.evotor.egais.dictionary.api"

    @JvmField
    val BASE_URI = Uri.parse("content://${AUTHORITY}")

    @JvmStatic
    fun getOrgInfos(context: Context): ru.evotor.egais.api.provider.Cursor<OrgInfo?>? {
        return context.contentResolver.query(OrgInfoContract.URI, null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<OrgInfo?>(it) {
                        override fun getValue(): OrgInfo? {
                            return createOrgInfo(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getOrgInfoByClientRegId(context: Context, clientRegId: String): ru.evotor.egais.api.provider.Cursor<OrgInfo?>? {
        return context.contentResolver.query(Uri.withAppendedPath(OrgInfoContract.URI, clientRegId), null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<OrgInfo?>(it) {
                        override fun getValue(): OrgInfo? {
                            return createOrgInfo(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getProductInfos(context: Context): ru.evotor.egais.api.provider.Cursor<ProductInfo?>? {
        return context.contentResolver.query(ProductInfoContract.URI, null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<ProductInfo?>(it) {
                        override fun getValue(): ProductInfo? {
                            return createProductInfo(this)
                        }
                    }
                }
    }

    @JvmStatic
    fun getProductInfoByAlcCode(context: Context, alcCode: String): ru.evotor.egais.api.provider.Cursor<ProductInfo?>? {
        return context.contentResolver.query(Uri.withAppendedPath(ProductInfoContract.URI, alcCode), null, null, null, null)
                ?.let {
                    object : ru.evotor.egais.api.provider.Cursor<ProductInfo?>(it) {
                        override fun getValue(): ProductInfo? {
                            return createProductInfo(this)
                        }
                    }
                }
    }

    private fun createOrgInfo(cursor: Cursor): OrgInfo? {
        val columnIndexType = cursor.getColumnIndex(OrgInfoContract.COLUMN_TYPE)
        val columnIndexClientRegId = cursor.getColumnIndex(OrgInfoContract.COLUMN_CLIENT_REG_ID)
        val columnIndexFullName = cursor.getColumnIndex(OrgInfoContract.COLUMN_FULL_NAME)
        val columnIndexShortName = cursor.getColumnIndex(OrgInfoContract.COLUMN_SHORT_NAME)
        val columnIndexInn = cursor.getColumnIndex(OrgInfoContract.COLUMN_INN)
        val columnIndexKpp = cursor.getColumnIndex(OrgInfoContract.COLUMN_KPP)
        val columnIndexUnp = cursor.getColumnIndex(OrgInfoContract.COLUMN_UNP)
        val columnIndexRnn = cursor.getColumnIndex(OrgInfoContract.COLUMN_RNN)
        val columnIndexState = cursor.getColumnIndex(OrgInfoContract.COLUMN_STATE)
        val columnIndexVersionWb = cursor.getColumnIndex(OrgInfoContract.COLUMN_VERSION_WB)

        return OrgInfo(
                OrgInfo.Type.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexClientRegId),
                cursor.getString(columnIndexFullName),
                cursor.getString(columnIndexShortName),
                cursor.getString(columnIndexInn),
                cursor.getString(columnIndexKpp),
                cursor.getString(columnIndexUnp),
                cursor.getString(columnIndexRnn),
                null, // TODO address
                cursor.getString(columnIndexState),
                WBTypeUsed.valueOf(cursor.getString(columnIndexVersionWb))
        )
    }

    private fun createProductInfo(cursor: Cursor): ProductInfo? {
        val columnIndexType = cursor.getColumnIndex(ProductInfoContract.COLUMN_TYPE)
        val columnIndexFullName = cursor.getColumnIndex(ProductInfoContract.COLUMN_FULL_NAME)
        val columnIndexShortName = cursor.getColumnIndex(ProductInfoContract.COLUMN_SHORT_NAME)
        val columnIndexAlcCode = cursor.getColumnIndex(ProductInfoContract.COLUMN_ALC_CODE)
        val columnIndexCapacity = cursor.getColumnIndex(ProductInfoContract.COLUMN_CAPACITY)
        val columnIndexAlcVolume = cursor.getColumnIndex(ProductInfoContract.COLUMN_ALC_VOLUME)
        val columnIndexProducerId = cursor.getColumnIndex(ProductInfoContract.COLUMN_PRODUCER_CLIENT_REG_ID)
        val columnIndexImporterId = cursor.getColumnIndex(ProductInfoContract.COLUMN_IMPORTER_CLIENT_REG_ID)
        val columnIndexProductVCode = cursor.getColumnIndex(ProductInfoContract.COLUMN_PRODUCT_V_CODE)

        return ProductInfo(
                ProductType.valueOf(cursor.getString(columnIndexType)),
                cursor.getString(columnIndexFullName),
                cursor.getString(columnIndexShortName),
                cursor.getString(columnIndexAlcCode),
                cursor.getString(columnIndexCapacity),
                cursor.getString(columnIndexAlcVolume),
                cursor.getString(columnIndexProducerId),
                cursor.getString(columnIndexImporterId),
                cursor.getString(columnIndexProductVCode)
        )
    }
}