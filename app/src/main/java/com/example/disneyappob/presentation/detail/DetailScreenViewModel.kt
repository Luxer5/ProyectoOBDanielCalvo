package com.example.disneyappob.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyappob.domain.model.DisneyModel
import com.example.disneyappob.domain.useCase.CheckFavoriteUseCase
import com.example.disneyappob.domain.useCase.DeleteFavoriteUseCase
import com.example.disneyappob.domain.useCase.GetDetailUseCase
import com.example.disneyappob.domain.useCase.InsertFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailScreenViewModel(
    private val getDetailUseCase: GetDetailUseCase,
    private val insertFavoriteUseCase: InsertFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase,
    private val checkFavoriteUseCase: CheckFavoriteUseCase
): ViewModel() {

    private val _disney = MutableLiveData<DisneyModel>()
    private val _fav = MutableLiveData<Boolean>()
    val disney: LiveData<DisneyModel> get() = _disney
    val fav: LiveData<Boolean> get() = _fav

    fun getData(id: Int){
        viewModelScope.launch {
            val resultDisney = withContext(Dispatchers.IO){
                getDetailUseCase.invoke(id)
            }
            _disney.value = resultDisney
        }
    }

    fun checkFav(id: Int){
        viewModelScope.launch {
            val resultFav = withContext(Dispatchers.IO){
                checkFavoriteUseCase.invoke(id)
            }
            _fav.value = resultFav
        }
    }

    fun insertFav(character: DisneyModel){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                insertFavoriteUseCase.invoke(character)
            }
        }
    }
    fun deleteFav(character: DisneyModel){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                deleteFavoriteUseCase.invoke(character)
            }
        }
    }

}