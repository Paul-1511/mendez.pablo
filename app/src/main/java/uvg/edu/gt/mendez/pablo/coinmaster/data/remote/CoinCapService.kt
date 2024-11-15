package uvg.edu.gt.mendez.pablo.coinmaster.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CoinCapService {
    @GET("assets")
    suspend fun getAssets(): List<AssetDto>

    @GET("assets/{id}")
    suspend fun getAssetDetail(@Path("id") id: String): AssetDetailDto
}
