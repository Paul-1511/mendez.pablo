package uvg.edu.gt.mendez.pablo.coinmaster.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import uvg.edu.gt.mendez.pablo.coinmaster.domain.model.Asset

@Entity(tableName = "assets")
data class AssetEntity(
    @PrimaryKey val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: Double,
    val changePercent24Hr: Double,
    val updatedAt: Long,
    val supply: Double,
    val maxSupply: Double?,
    val marketCapUsd: Double,
)

fun AssetEntity.toDomainModel(): Asset {
    return Asset(
        id = this.id,
        name = this.name,
        symbol = this.symbol,
        priceUsd = this.priceUsd,
        changePercent24Hr = this.changePercent24Hr,
        updatedAt = this.updatedAt,
        supply = this.supply,
        maxSupply = this.maxSupply,
        marketCapUsd = this.marketCapUsd
    )
}

fun Asset.toEntity(): AssetEntity{
    return AssetEntity(
        id = this.id,
        name = this.name,
        symbol = this.symbol,
        priceUsd = this.priceUsd,
        changePercent24Hr = this.changePercent24Hr,
        supply = this.supply,
        maxSupply = this.maxSupply,
        marketCapUsd = this.marketCapUsd,
        updatedAt = this.updatedAt
    )
}