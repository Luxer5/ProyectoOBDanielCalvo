package com.example.disneyappob.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.data.dto.CharacterDetailDto
import com.example.disneyappob.data.dto.CharacterDto
import com.example.disneyappob.data.dto.DisneyListDto
import com.example.disneyappob.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RemoteDataSourceImplTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var disneyApi: DisneyApi

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getDisneyListTreasure expect instance of List`() = runTest {
        coEvery { disneyApi.getDisneyListTreasure() } returns getListRemote()

        val dataSource = RemoteDataSourceImpl(disneyApi)
        val res = dataSource.getDisneyListTreasure()

        assertThat(res, CoreMatchers.instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }
    @Test
    fun `WHEN getDisneyListTreasure item expect instance of CharacterDto`() = runTest {
        coEvery { disneyApi.getDisneyListTreasure() } returns getListRemote()

        val dataSource = RemoteDataSourceImpl(disneyApi)
        val res = dataSource.getDisneyListTreasure()

        assertThat(res[1], instanceOf(CharacterDto::class.java))
    }
    @Test
    fun `WHEN getDisneyListHero expect instance of List`() = runTest {
        coEvery { disneyApi.getDisneyListHero() } returns getListRemote()

        val dataSource = RemoteDataSourceImpl(disneyApi)
        val res = dataSource.getDisneyListHero()

        assertThat(res, CoreMatchers.instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }
    @Test
    fun `WHEN getDisneyListHero item expect instance of CharacterDto`() = runTest {
        coEvery { disneyApi.getDisneyListHero() } returns getListRemote()

        val dataSource = RemoteDataSourceImpl(disneyApi)
        val res = dataSource.getDisneyListHero()

        assertThat(res[0], instanceOf(CharacterDto::class.java))
    }
    @Test
    fun `WHEN getDisneyListHercules expect instance of List`() = runTest {
        coEvery { disneyApi.getDisneyListHercules() } returns getListRemote()

        val dataSource = RemoteDataSourceImpl(disneyApi)
        val res = dataSource.getDisneyListHercules()

        assertThat(res, CoreMatchers.instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }
    @Test
    fun `WHEN getDisneyListHercules item expect instance of ChararcterDto`() = runTest {
        coEvery { disneyApi.getDisneyListHercules() } returns getListRemote()

        val dataSource = RemoteDataSourceImpl(disneyApi)
        val res = dataSource.getDisneyListHercules()

        assertThat(res[0], instanceOf(CharacterDto::class.java))
    }
    @Test
    fun `WHEN getDisneychararcter expect instance of ChararcterDetailDto`() = runTest {
        coEvery { disneyApi.getDisneyCharacter(5).data } returns getCharacterRemote()

        val dataSource = RemoteDataSourceImpl(disneyApi)
        val res = dataSource.getDisneyCharacter(5)

        assertThat(res, instanceOf(CharacterDetailDto::class.java))
    }

}

fun getListRemote() = DisneyListDto(
    listOf(
        CharacterDto(1, "name", "url"),
        CharacterDto(2, "name", "url")
    )
)


fun getCharacterRemote() = CharacterDetailDto(5, "name", "url", listOf(), listOf())