package uvg.edu.gt.mendez.pablo.coinmaster.data.repository

import uvg.edu.gt.mendez.pablo.coinmaster.data.local.dao.AssetDao
import uvg.edu.gt.mendez.pablo.coinmaster.data.local.entity.AssetEntity
import uvg.edu.gt.mendez.pablo.coinmaster.data.local.entity.toDomainModel
import uvg.edu.gt.mendez.pablo.coinmaster.data.remote.CoinCapService
import uvg.edu.gt.mendez.pablo.coinmaster.data.remote.toDomainModel
import uvg.edu.gt.mendez.pablo.coinmaster.domain.model.Asset

class AssetRepository(
    private val api: CoinCapService,
    private val dao: AssetDao
) {
    suspend fun fetchAssetsOnline(): List<Asset> {
        val response = api.getAssets()
        // Map response DTO to Domain Model
        return response.map { it.toDomainModel() }
    }

    suspend fun fetchAssetsOffline(): List<Asset> {
        return dao.getAllAssets().map { it.toDomainModel() }
    }

    suspend fun saveAssetsOffline(assets: List<AssetEntity>) {
        dao.insertAssets(assets)
    }
}
