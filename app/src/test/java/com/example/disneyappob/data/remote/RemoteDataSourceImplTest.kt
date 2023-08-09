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

}

fun getListRemote() = DisneyListDto(
    listOf(
        CharacterDto(1, "name", "url"),
        CharacterDto(2, "name", "url")
    )
)


fun getCharacterRemote() = CharacterDetailDto(1, "name", "url", listOf(), listOf())