package com.example.disneyappob.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.data.dto.CharacterDto
import com.example.disneyappob.data.dto.DisneyListDto
import com.example.disneyappob.data.local.model.CharacterLocal
import com.example.disneyappob.data.remote.DisneyApi
import com.example.disneyappob.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LocalDataSourceImplTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var disneyDao: DisneyDao

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }


    @Test
    fun `WHEN getAll EXPECTS return instance of List`() = runTest{
        coEvery { disneyDao.getAll() } returns getListLocal()

        val localDataSource = LocalDataSourceImpl(disneyDao)
        val res = localDataSource.getAll()

        assertThat(res, instanceOf(List::class.java))
    }
    @Test
    fun `WHEN getAll item EXPECTS return instance of CharacterLocal`() = runTest{
        coEvery { disneyDao.getAll() } returns getListLocal()

        val localDataSource = LocalDataSourceImpl(disneyDao)
        val res = localDataSource.getAll()

        assertThat(res[0], instanceOf(CharacterLocal::class.java))
    }
    @Test
    fun `WHEN checkFav is in database EXPECTS return true`() = runTest{
        coEvery { disneyDao.checkFav(5) } returns true

        val localDataSource = LocalDataSourceImpl(disneyDao)
        val res = localDataSource.checkFav(5)

        assertThat(res, `is`(true))
    }
    @Test
    fun `WHEN checkFav is not in database EXPECTS return false`() = runTest{
        coEvery { disneyDao.checkFav(5) } returns false

        val localDataSource = LocalDataSourceImpl(disneyDao)
        val res = localDataSource.checkFav(5)

        assertThat(res, `is`(false))
    }

}

fun getListLocal() =
    listOf(
        CharacterLocal(1, "name", "url"),
        CharacterLocal(2, "name", "url")
    )
