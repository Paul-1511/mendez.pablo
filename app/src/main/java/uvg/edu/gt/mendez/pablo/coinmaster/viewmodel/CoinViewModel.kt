package uvg.edu.gt.mendez.pablo.coinmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import uvg.edu.gt.mendez.pablo.coinmaster.data.local.entity.toEntity
import uvg.edu.gt.mendez.pablo.coinmaster.data.repository.AssetRepository
import uvg.edu.gt.mendez.pablo.coinmaster.domain.model.Asset

class CoinViewModel(private val repository: AssetRepository) : ViewModel() {

    private val _assets = MutableStateFlow<List<Asset>>(emptyList())
    val assets: StateFlow<List<Asset>> get() = _assets

    private val _selectedAsset = MutableStateFlow<Asset?>(null)
    val selectedAsset: StateFlow<Asset?> get() = _selectedAsset

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    init {
        fetchAssets()
    }

    fun fetchAssets() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fetchedAssets = repository.fetchAssetsOnline()
                _assets.value = fetchedAssets
                repository.saveAssetsOffline(fetchedAssets.map { it.toEntity() })
            } catch (e: Exception) {
                _error.value = e.message
                _assets.value = repository.fetchAssetsOffline()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun selectAssetById(id: String) {
        _selectedAsset.value = _assets.value.find { it.id == id }
    }

    fun toggleOfflineMode() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _assets.value = repository.fetchAssetsOffline()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
