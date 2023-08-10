package com.example.disneyappob.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.useCase.GetFavoriteListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteScreenViewModel(
    private val getFavoriteListUseCase: GetFavoriteListUseCase
) : ViewModel() {

    private val _disneyListFavorites = MutableLiveData<List<DisneyListModel>>()

    val disneyListFavorites: LiveData<List<DisneyListModel>> get() = _disneyListFavorites

    init{
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            val resultFavorites = withContext(Dispatchers.IO) {
                getFavoriteListUseCase.invoke()
            }
            _disneyListFavorites.value = resultFavorites
        }

    }
}