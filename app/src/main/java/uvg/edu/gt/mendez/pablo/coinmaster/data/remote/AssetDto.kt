package uvg.edu.gt.mendez.pablo.coinmaster.data.remote

import kotlinx.serialization.Serializable
import uvg.edu.gt.mendez.pablo.coinmaster.domain.model.Asset

@Serializable
data class AssetDto(
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: String,
    val changePercent24Hr: String,
    val supply: Double,
    val maxSupply: Double?,
    val marketCapUsd: Double,
    val updatedAt: String
)

// Función de extensión para convertir AssetDto a Asset
fun AssetDto.toDomainModel(): Asset {
    return Asset(
        id = this.id,
        name = this.name,
        symbol = this.symbol,
        priceUsd = this.priceUsd.toDouble(),
        changePercent24Hr = this.changePercent24Hr.toDouble(),
        updatedAt = System.currentTimeMillis(),
        supply = this.supply,
        maxSupply = this.maxSupply,
        marketCapUsd = this.marketCapUsd
    )
}
