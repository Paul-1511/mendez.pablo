package uvg.edu.gt.mendez.pablo.coinmaster.presentation.asset

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import uvg.edu.gt.mendez.pablo.coinmaster.domain.model.Asset

@Composable
fun AssetDetailScreen(asset: Asset) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Nombre: ${asset.name}", style = MaterialTheme.typography.titleLarge)
        Text(text = "Símbolo: ${asset.symbol}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Precio (USD): $${asset.priceUsd}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))

        // Visual indicator for positive/negative change
        val changeColor = if (asset.changePercent24Hr >= 0) Color.Green else Color.Red
        Text(
            text = "Cambio 24h: ${asset.changePercent24Hr}%",
            color = changeColor,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Supply: ${asset.supply}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Max Supply: ${asset.maxSupply ?: "N/A"}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Market Cap (USD): $${asset.marketCapUsd}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))

        // Fecha de actualización
        Text(text = "Última actualización: ${asset.updatedAt}", style = MaterialTheme.typography.bodySmall)
    }
}
