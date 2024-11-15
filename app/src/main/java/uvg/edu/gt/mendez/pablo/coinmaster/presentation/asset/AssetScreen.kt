package uvg.edu.gt.mendez.pablo.coinmaster.presentation.asset

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uvg.edu.gt.mendez.pablo.coinmaster.viewmodel.CoinViewModel

@Composable
fun AssetScreen(viewModel: CoinViewModel, onAssetClick: (String) -> Unit) {
    val state = viewModel.assets.collectAsState()

    if (state.value.isEmpty()) {
        CircularProgressIndicator()
    } else {
        LazyColumn {
            items(state.value) { asset ->
                Row(modifier = Modifier.clickable { onAssetClick(asset.id) }) {
                    Text(text = asset.name)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "$${asset.priceUsd}")
                    // Visual indicator for positive/negative change
                    if (asset.changePercent24Hr >= 0) {
                        Text(text = "+${asset.changePercent24Hr}%", color = Color.Green)
                    } else {
                        Text(text = "${asset.changePercent24Hr}%", color = Color.Red)
                    }
                }
            }
        }
    }
}
