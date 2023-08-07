package com.example.disneyappob.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.useCase.GetDisneyList1UseCase
import com.example.disneyappob.domain.useCase.GetDisneyList2UseCase
import com.example.disneyappob.domain.useCase.GetDisneyList3UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListScreenViewModel (
    private val getDisneyList1UseCase: GetDisneyList1UseCase,
    private val getDisneyList2UseCase: GetDisneyList2UseCase,
    private val getDisneyList3UseCase: GetDisneyList3UseCase
    ):ViewModel() {

    //val testString = "Test"

    private val _disneyList1 = MutableLiveData<List<DisneyListModel>>()
    private val _disneyList2 = MutableLiveData<List<DisneyListModel>>()
    private val _disneyList3 = MutableLiveData<List<DisneyListModel>>()

    val disneyList1: LiveData<List<DisneyListModel>> get() = _disneyList1
    val disneyList2: LiveData<List<DisneyListModel>> get() = _disneyList2
    val disneyList3: LiveData<List<DisneyListModel>> get() = _disneyList3

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
            val result3 = withContext(Dispatchers.IO){
                getDisneyList3UseCase.invoke()
            }
            _disneyList1.value = result1
            _disneyList2.value = result2
            _disneyList3.value = result3
        }
    }

}