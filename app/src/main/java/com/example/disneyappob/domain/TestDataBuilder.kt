package com.example.disneyappob.domain

import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.model.DisneyModel

class TestDataBuilder() {
    var id = 5
    var name = "nombre"
    var imageUrl = "url"
    var numElements: Int = 15

    fun withName(name: String): TestDataBuilder {
        this.name =  name
        return  this
    }
    fun withPhotoUrl(imageUrl: String): TestDataBuilder {
        this.imageUrl =  imageUrl
        return  this
    }
    fun withNumElements(numElements: Int): TestDataBuilder {
        this.numElements =  numElements
        return  this
    }

    fun buildList():List<DisneyModel>{
        val list = mutableListOf<DisneyModel>()
        for(i in 0 until numElements){
            list.add(DisneyModel(id,name, imageUrl, listOf(), listOf()))
        }
        return list.toList()
    }

    fun buildSingle():DisneyModel = DisneyModel(id,name, imageUrl, listOf(), listOf())

}