package uvg.edu.gt.mendez.pablo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import uvg.edu.gt.mendez.pablo.coinmaster.presentation.navigation.NavigationGraph
import uvg.edu.gt.mendez.pablo.coinmaster.presentation.ui.theme.MendezpabloTheme
import uvg.edu.gt.mendez.pablo.coinmaster.viewmodel.CoinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Obtén una instancia del ViewModel
        val coinViewModel: CoinViewModel by viewModels()

        setContent {
            // Establece el tema de la aplicación
            MendezpabloTheme() {
                // Inicializa el NavController
                val navController = rememberNavController()
                // Configura el gráfico de navegación
                NavigationGraph(navController = navController, viewModel = coinViewModel)
            }
        }
    }
}