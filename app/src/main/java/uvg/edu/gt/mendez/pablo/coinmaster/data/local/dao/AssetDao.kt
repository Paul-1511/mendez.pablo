package uvg.edu.gt.mendez.pablo.coinmaster.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uvg.edu.gt.mendez.pablo.coinmaster.data.local.entity.AssetEntity

@Dao
interface AssetDao {
    @Query("SELECT * FROM assets")
    fun getAllAssets(): List<AssetEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAssets(assets: List<AssetEntity>)
}
