package com.example.disneyappob.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.useCase.GetDisney1ListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListScreenViewModel (
    private val getDisneyList1UseCase: GetDisney1ListUseCase
    ):ViewModel() {

    //val testString = "Test"

    private val _disneyList = MutableLiveData<List<DisneyListModel>>()

    val disneyList: LiveData<List<DisneyListModel>> get() = _disneyList

    init {
        getData()
    }

    fun getData(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                getDisneyList1UseCase.invoke()
            }
            _disneyList.value = result
        }
    }

}