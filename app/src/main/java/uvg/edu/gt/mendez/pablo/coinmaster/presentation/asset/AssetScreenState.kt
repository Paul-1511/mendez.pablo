package uvg.edu.gt.mendez.pablo.coinmaster.presentation.asset

import uvg.edu.gt.mendez.pablo.coinmaster.domain.model.Asset

data class AssetScreenState(
    val isLoaging: Boolean = false,
    val assets: List<Asset> = emptyList(),
    val isOffline: Boolean = false,
    val error: String? = null
)