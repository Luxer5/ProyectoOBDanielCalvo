package com.example.disneyappob.domain

import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.model.DisneyModel

class TestDataListBuilder() {
    var id = 5
    var name = "nombre Heroe"
    var imageUrl = "url del personaje"
    var numElements: Int = 15

    fun withName(name: String): TestDataListBuilder {
        this.name =  name
        return  this
    }
    fun withPhotoUrl(imageUrl: String): TestDataListBuilder {
        this.imageUrl =  imageUrl
        return  this
    }
    fun withNumElements(numElements: Int): TestDataListBuilder {
        this.numElements =  numElements
        return  this
    }

    fun buildList():List<DisneyListModel>{
        val list = mutableListOf<DisneyListModel>()
        for(i in 0 until numElements){
            list.add(DisneyListModel(id,name, imageUrl))
        }
        return list.toList()
    }

    fun buildSingle():DisneyListModel = DisneyListModel(id,name, imageUrl)

}