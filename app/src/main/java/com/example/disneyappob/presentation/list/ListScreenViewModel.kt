package com.example.disneyappob.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.useCase.GetDisneyListTreasureUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListHeroUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListHerculesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    init {
        getData()
    }

    fun getData(){
        viewModelScope.launch {
            val result1 = withContext(Dispatchers.IO){
                getDisneyListTreasureUseCase.invoke()
            }
            val result2 = withContext(Dispatchers.IO){
                getDisneyListHeroUseCase.invoke()
            }
            val result3 = withContext(Dispatchers.IO){
                getDisneyListHerculesUseCase.invoke()
            }
            _disneyListTreasure.value = result1
            _disneyListHero.value = result2
            _disneyListHercules.value = result3
        }
    }

}