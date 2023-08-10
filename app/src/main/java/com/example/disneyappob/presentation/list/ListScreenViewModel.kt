package com.example.disneyappob.presentation.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.useCase.GetDisneyListTreasureUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListHeroUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListHerculesUseCase
import com.example.disneyappob.domain.useCase.GetFavoriteListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ListScreenViewModel (
    private val getDisneyListTreasureUseCase: GetDisneyListTreasureUseCase,
    private val getDisneyListHeroUseCase: GetDisneyListHeroUseCase,
    private val getDisneyListHerculesUseCase: GetDisneyListHerculesUseCase
    ):ViewModel() {

    //val testString = "Test"

    private val _disneyListTreasure = MutableLiveData<List<DisneyListModel>>()
    private val _disneyListHero = MutableLiveData<List<DisneyListModel>>()
    private val _disneyListHercules = MutableLiveData<List<DisneyListModel>>()

    val disneyListTreasure: LiveData<List<DisneyListModel>> get() = _disneyListTreasure
    val disneyListHero: LiveData<List<DisneyListModel>> get() = _disneyListHero
    val disneyListHercules: LiveData<List<DisneyListModel>> get() = _disneyListHercules

    private val _errorMessage = MutableLiveData<String?>()
    val error: LiveData<String?> get() =_errorMessage


    init {
        getData()
    }

    fun getData(){
        viewModelScope.launch {
            try {
                _errorMessage.value = null
                val resultTreasure = withContext(Dispatchers.IO){
                    getDisneyListTreasureUseCase.invoke()
                }
                val resultHero = withContext(Dispatchers.IO){
                    getDisneyListHeroUseCase.invoke()
                }
                val resultHercules = withContext(Dispatchers.IO){
                    getDisneyListHerculesUseCase.invoke()
                }

                _disneyListTreasure.value = resultTreasure
                _disneyListHero.value = resultHero
                _disneyListHercules.value = resultHercules
            }catch (e: Exception){
                _errorMessage.value = "Error producido al realizar la peticion a la api"
            }

        }
    }

}