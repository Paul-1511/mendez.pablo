package uvg.edu.gt.mendez.pablo.coinmaster.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uvg.edu.gt.mendez.pablo.coinmaster.presentation.asset.AssetDetailScreen
import uvg.edu.gt.mendez.pablo.coinmaster.presentation.asset.AssetScreen
import uvg.edu.gt.mendez.pablo.coinmaster.viewmodel.CoinViewModel

@Composable
fun NavigationGraph(navController: NavHostController, viewModel: CoinViewModel) {
    NavHost(navController = navController, startDestination = "assets") {
        composable("assets") {
            AssetScreen(viewModel = viewModel, onAssetClick = { assetId ->
                viewModel.selectAssetById(assetId)
                navController.navigate("assetDetail/$assetId")
            })
        }
        composable("assetDetail/{id}") { backStackEntry ->
            val asset = viewModel.selectedAsset.collectAsState().value
            if (asset != null) {
                AssetDetailScreen(asset = asset)
            } else {
                // Manejo en caso el asset sea null
                Text(text = "Cargando...")
            }
        }
    }
}
