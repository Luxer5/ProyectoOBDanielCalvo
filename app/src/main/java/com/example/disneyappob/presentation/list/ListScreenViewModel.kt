package com.example.disneyappob.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyappob.domain.model.DisneyModel
import com.example.disneyappob.domain.useCase.GetDisneyListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListScreenViewModel (
    private val getDisneyListUseCase: GetDisneyListUseCase
    ):ViewModel() {

    //val testString = "Test"

    private val _disneyList = MutableLiveData<List<DisneyModel>>()

    val disneyList: LiveData<List<DisneyModel>> get() = _disneyList

    init {
        getData()
    }

    fun getData(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                getDisneyListUseCase.invoke()
            }
            _disneyList.value = result
        }
    }

}