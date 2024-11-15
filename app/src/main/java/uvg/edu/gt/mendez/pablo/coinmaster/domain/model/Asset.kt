package uvg.edu.gt.mendez.pablo.coinmaster.domain.model

data class Asset(
    val id: String,
    val name: String,
    val symbol: String,
    val priceUsd: Double,
    val changePercent24Hr: Double,
    val updatedAt: Long,
    val supply: Double,
    val maxSupply: Double?,
    val marketCapUsd: Double,
)
