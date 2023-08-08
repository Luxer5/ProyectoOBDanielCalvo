package com.example.disneyappob.data.mappers

import com.example.disneyappob.data.dto.CharacterDetailDto
import com.example.disneyappob.data.dto.CharacterDto
import com.example.disneyappob.data.local.model.CharacterLocal
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.domain.model.DisneyModel
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class DisneyDtoMapperTest {

    //Test CharacterDto.toDisneyListModel
    @Test
    fun `WHEN toDisneyListModel with values EXPECT model id has value 5`(){
        val characterDto = CharacterDto( _id = 5, name = "name", imageUrl = "url")
        val res = characterDto.toDisneyListModel()
        assertThat(res.id, `is`(5))
    }
    @Test
    fun `WHEN toDisneyListModel with values EXPECT model name has value name`(){
        val characterDto = CharacterDto( _id = 5, name = "name", imageUrl = "url")
        val res = characterDto.toDisneyListModel()
        assertThat(res.name, `is`("name"))
    }
    @Test
    fun `WHEN toDisneyListModel with values EXPECT model imageUrl has value url`(){
        val characterDto = CharacterDto( _id = 5, name = "name", imageUrl = "url")
        val res = characterDto.toDisneyListModel()

        assertThat(res.imageUrl, `is`("url"))
    }
    @Test
    fun `WHEN toDisneyListModel with values EXPECT model is instance og DisneyListModel`(){
        val characterDto = CharacterDto( _id = 5, name = "name", imageUrl = "url")
        val res = characterDto.toDisneyListModel()

        assertThat(res, instanceOf(DisneyListModel::class.java))
    }
    @Test
    fun `WHEN toDisneyListModel with null values EXPECT model id is 0 `(){
        val characterDto = CharacterDto( _id = null, name = null, imageUrl = null)
        val res = characterDto.toDisneyListModel()
        assertThat(res.id, `is`(0))
    }

    //Test ChararcterDetailDto.toDisneyModel
    @Test
    fun `WHEN toDisneyModel with values EXPECT model id has value 5`(){
        val characterDetailDto = CharacterDetailDto( _id = 5, name = "name", imageUrl = "url", listOf(), listOf())
        val res = characterDetailDto.toDisneyModel()
        assertThat(res.id, `is`(5))
    }
    @Test
    fun `WHEN toDisneyModel with values EXPECT model name has value name`(){
        val characterDetailDto = CharacterDetailDto( _id = 5, name = "name", imageUrl = "url", listOf(), listOf())
        val res = characterDetailDto.toDisneyModel()
        assertThat(res.name, `is`("name"))
    }
    @Test
    fun `WHEN toDisneyModel with values EXPECT model imageUrl has value url`(){
        val characterDetailDto = CharacterDetailDto( _id = 5, name = "name", imageUrl = "url", listOf(), listOf())
        val res = characterDetailDto.toDisneyModel()
        assertThat(res.id, `is`(5))
    }
    @Test
    fun `WHEN toDisneyModel with values EXPECT model films is instance of List`(){
        val characterDetailDto = CharacterDetailDto( _id = 5, name = "name", imageUrl = "url", films =listOf(), tvShows = listOf())
        val res = characterDetailDto.toDisneyModel()
        assertThat(res.films, instanceOf(List::class.java))
    }
    @Test
    fun `WHEN toDisneyModel with values EXPECT model tvShows is instance of List`(){
        val characterDetailDto = CharacterDetailDto( _id = 5, name = "name", imageUrl = "url", films = listOf(), tvShows = listOf())
        val res = characterDetailDto.toDisneyModel()
        assertThat(res.tvShows, instanceOf(List::class.java))
    }
    @Test
    fun `WHEN toDisneyModel with values EXPECT model is instance of DisneyModel`(){
        val characterDetailDto = CharacterDetailDto( _id = 5, name = "name", imageUrl = "url", films = listOf(), tvShows = listOf())
        val res = characterDetailDto.toDisneyModel()
        assertThat(res, instanceOf(DisneyModel::class.java))
    }
    @Test
    fun `WHEN toDisneyModel with null EXPECT model null values`(){
        val characterDetailDto = CharacterDetailDto( _id = null, name = null, imageUrl = null, films =null, tvShows = null)
        val res = characterDetailDto.toDisneyModel()
        assertThat(res.id, `is`(0))
    }

    //Test Disneymodel.toCharacterLocal
    @Test
    fun `WHEN toCharacterLocal with values EXPECT local model id is 5`(){
        val disneyModel = DisneyModel( id = 5, name = "name", imageUrl = "url", films =listOf(), tvShows = listOf())
        val res = disneyModel.toCharacterLocal()
        assertThat(res.id, `is`(5))
    }
    @Test
    fun `WHEN toCharacterLocal with values EXPECT local model name is name`(){
        val disneyModel = DisneyModel( id = 5, name = "name", imageUrl = "url", films =listOf(), tvShows = listOf())
        val res = disneyModel.toCharacterLocal()
        assertThat(res.id, `is`(5))
    }
    @Test
    fun `WHEN toCharacterLocal with values EXPECT local model imageUrl is url`(){
        val disneyModel = DisneyModel( id = 5, name = "name", imageUrl = "url", films =listOf(), tvShows = listOf())
        val res = disneyModel.toCharacterLocal()
        assertThat(res.id, `is`(5))
    }
    @Test
    fun `WHEN toCharacterLocal with values EXPECT local model is instance of Chararcter Local`(){
        val disneyModel = DisneyModel( id = 5, name = "name", imageUrl = "url", films =listOf(), tvShows = listOf())
        val res = disneyModel.toCharacterLocal()
        assertThat(res, instanceOf(CharacterLocal::class.java))
    }


    // Test CharacterLocal.toDisneyListModel
    @Test
    fun `WHEN toDisneyListModel with values EXPECT  model id is 5`(){
        val characterLocal = CharacterLocal( id = 5, name = "name", imageUrl = "url")
        val res = characterLocal.toDisneyListModel()
        assertThat(res.id, `is`(5))
    }
    @Test
    fun `WHEN toDisneyListModel with values EXPECT  model name is name`(){
        val characterLocal = CharacterLocal( id = 5, name = "name", imageUrl = "url")
        val res = characterLocal.toDisneyListModel()
        assertThat(res.name, `is`("name"))
    }
    @Test
    fun `WHEN toDisneyListModel with values EXPECT  model imageUrl is 5`(){
        val characterLocal = CharacterLocal( id = 5, name = "name", imageUrl = "url")
        val res = characterLocal.toDisneyListModel()
        assertThat(res.imageUrl, `is`("url"))
    }
    @Test
    fun `WHEN toDisneyListModel with values EXPECT  model is instance of DisneyListModel`(){
        val characterLocal = CharacterLocal( id = 5, name = "name", imageUrl = "url")
        val res = characterLocal.toDisneyListModel()
        assertThat(res, instanceOf(DisneyListModel::class.java))
    }
}