package com.example.disneyappob.data

import org.junit.Rule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.data.dto.CharacterDetailDto
import com.example.disneyappob.data.dto.CharacterDto
import com.example.disneyappob.data.local.LocalDataSource
import com.example.disneyappob.data.local.model.CharacterLocal
import com.example.disneyappob.data.remote.RemoteDataSource
import com.example.disneyappob.domain.model.DisneyModel
import com.example.disneyappob.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test


class DisneyRepositoryImplTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @Before
    fun setup(){
        MockKAnnotations.init(this)
    }


    @Test
    fun `WHEN getDisneyListTreasure EXPECT instance of List`() = runTest{
        coEvery { remoteDataSource.getDisneyListTreasure() } returns getListRemote()

        val repo = DisneyRepositoryImpl(remoteDataSource, localDataSource)
        val res = repo.getDisneyListTreasure()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))

    }
    @Test
    fun `WHEN getDisneyListHero EXPECT instance of List`() = runTest{
        coEvery { remoteDataSource.getDisneyListHero() } returns getListRemote()

        val repo = DisneyRepositoryImpl(remoteDataSource, localDataSource)
        val res = repo.getDisneyListHero()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))

    }
    @Test
    fun `WHEN getDisneyListHercules EXPECT instance of List`() = runTest{
        coEvery { remoteDataSource.getDisneyListHercules() } returns getListRemote()

        val repo = DisneyRepositoryImpl(remoteDataSource, localDataSource)
        val res = repo.getDisneyListHercules()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))

    }
    @Test
    fun `WHEN getDisneyCharacter EXPECT instance of CharacterDetailDto`() = runTest{
        coEvery { remoteDataSource.getDisneyCharacter(1) } returns getCharacterRemote()

        val repo = DisneyRepositoryImpl(remoteDataSource, localDataSource)
        val res = repo.getDisneyCharacter(1)

        assertThat(res, instanceOf(DisneyModel::class.java))
        assertThat(res.id, `is`(1))

    }
    @Test
    fun `WHEN getAll EXPECT instance of List`() = runTest{
        coEvery { localDataSource.getAll() } returns getListLocal()

        val repo = DisneyRepositoryImpl(remoteDataSource, localDataSource)
        val res = repo.getAll()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))

    }
}

fun getListRemote() = listOf(
    CharacterDto(1, "name", "url"),
    CharacterDto(2, "name", "url")
)
fun getListLocal() = listOf(
    CharacterLocal(1, "name", "url"),
    CharacterLocal(2, "name", "url")
)

fun getCharacterRemote() = CharacterDetailDto(1, "name", "url", listOf(), listOf())