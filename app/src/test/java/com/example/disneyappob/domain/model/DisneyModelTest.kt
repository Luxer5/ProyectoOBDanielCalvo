package com.example.disneyappob.domain.model

import com.example.disneyappob.domain.TestDataBuilder
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test



class DisneyModelTest{
    val disneyModel = TestDataBuilder().buildSingle()

    @Test
    fun `WHEN disneyListModel id = 5 EXPECT id = 5`()
    {
        MatcherAssert.assertThat(disneyModel.id, CoreMatchers.`is`(5))
    }
    @Test
    fun `WHEN disneyListModel name = "nombre" EXPECT name = "nombre"`()
    {
        MatcherAssert.assertThat(disneyModel.name, CoreMatchers.`is`("nombre"))
    }
    @Test
    fun `WHEN disneyListModel imageUrl = "url" EXPECT imageUrl = "url"`()
    {
        MatcherAssert.assertThat(disneyModel.imageUrl, CoreMatchers.`is`("url"))
    }
    @Test
    fun `WHEN create model EXPECT not null vlue`(){
        MatcherAssert.assertThat(
            disneyModel,
            CoreMatchers.instanceOf(DisneyModel::class.java)
        )
        MatcherAssert.assertThat(disneyModel, CoreMatchers.notNullValue())
    }
}