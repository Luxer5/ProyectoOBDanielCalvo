package com.example.disneyappob.domain.model

import com.example.disneyappob.domain.TestDataListBuilder
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Test

class DisneyListModelTest{
    val disneyListModel = TestDataListBuilder().buildSingle()

    @Test
    fun `WHEN disneyListModel id = 5 EXPECT id = 5`()
    {
        assertThat(disneyListModel.id, `is`(5))
    }
    @Test
    fun `WHEN disneyListModel name = nombre EXPECT name = nombre`()
    {
        assertThat(disneyListModel.name, `is`("nombre"))
    }
    @Test
    fun `WHEN disneyListModel imageUrl = url EXPECT imageUrl = url`()
    {
        assertThat(disneyListModel.imageUrl, `is`("url"))
    }
    @Test
    fun `WHEN create model EXPECT not null vlue`(){
        assertThat(disneyListModel, CoreMatchers.instanceOf(DisneyListModel::class.java))
        assertThat(disneyListModel, CoreMatchers.notNullValue())
    }
}