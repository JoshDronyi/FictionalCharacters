package com.example.kitsuanimeapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitsuanimeapp.data.model.KitsuRepo
import com.example.kitsuanimeapp.ui.view.composables.animelist.AnimeListState
import com.example.kitsuanimeapp.ui.view.composables.category.CategoryState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: KitsuRepo
) : ViewModel() {

    private val _categoryState: MutableStateFlow<CategoryState> = MutableStateFlow(CategoryState())
    val categoryState: StateFlow<CategoryState> get() = _categoryState

    private val _animeList:MutableStateFlow<AnimeListState> = MutableStateFlow(AnimeListState())


    fun getAnimeCategories() = viewModelScope.launch(Dispatchers.IO) {
        _categoryState.update {
            it.copy(isLoading = true)
        }
        val categories = repo.getCategories()
        _categoryState.update {
            it.copy(isLoading = false, categoryList = categories)
        }
    }

    fun getSelectedCategoryList(catLink: String) = viewModelScope.launch(Dispatchers.IO) {

    }

}