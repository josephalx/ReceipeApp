package com.example.receipeapppractice.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.receipeapppractice.model.Categories
import com.example.receipeapppractice.service.CategoriesService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _categoriesList = mutableStateOf(CategoriesState())
    val categoriesList: State<CategoriesState> = _categoriesList

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            try {
                val result = CategoriesService.getCategories()
                _categoriesList.value = _categoriesList.value.copy(
                    loading = false,
                    categoriesList = result.categoriesList
                )
            } catch (e: Exception) {
                println("Error while loading")
                println("Error: ${e.message}")
                _categoriesList.value = _categoriesList.value.copy(
                    loading = false,
                    error = e.message
                )
            }

        }
    }

    data class CategoriesState(
        val loading: Boolean = true,
        val categoriesList: List<Categories> = emptyList(),
        val error: String? = null
    )
}