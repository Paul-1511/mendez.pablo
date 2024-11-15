package uvg.edu.gt.mendez.pablo.coinmaster.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class AssetDetailDto(
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val supply: String,
    val maxSupply: String?,
    val marketCapUsd: String,
    val updatedAt: String
)
