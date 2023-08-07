package com.example.disneyappob.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.useCase.GetDisney1ListUseCase
import com.example.disneyappob.domain.useCase.GetDisneyList2UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListScreenViewModel (
    private val getDisneyList1UseCase: GetDisney1ListUseCase,
    private val getDisneyList2UseCase: GetDisneyList2UseCase
    ):ViewModel() {

    //val testString = "Test"

    private val _disneyList1 = MutableLiveData<List<DisneyListModel>>()
    private val _disneyList2 = MutableLiveData<List<DisneyListModel>>()

    val disneyList1: LiveData<List<DisneyListModel>> get() = _disneyList1
    val disneyList2: LiveData<List<DisneyListModel>> get() = _disneyList2

    init {
        getData()
    }

    fun getData(){
        viewModelScope.launch {
            val result1 = withContext(Dispatchers.IO){
                getDisneyList1UseCase.invoke()
            }
            val result2 = withContext(Dispatchers.IO){
                getDisneyList2UseCase.invoke()
            }
            _disneyList1.value = result1
            _disneyList2.value = result2
        }
    }

}