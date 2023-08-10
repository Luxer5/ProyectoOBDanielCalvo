package com.example.disneyappob.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.domain.TestDataListBuilder
import com.example.disneyappob.domain.model.DisneyListModel
import com.example.disneyappob.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetFavoriteListUseCaseTest{
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var disneyRepository: DisneyRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN invoke EXPECT return instance of List`() = runTest{
        coEvery { disneyRepository.getAll() } returns TestDataListBuilder()
            .withNumElements(15)
            .buildList()

        val useCase = GetFavoriteListUseCase(disneyRepository)
        val res = useCase.invoke()

        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(15))
    }
    @Test
    fun `WHEN invoke EXPECT item return instance of DisneyListModel`() = runTest{
        coEvery { disneyRepository.getAll() } returns TestDataListBuilder()
            .withNumElements(15)
            .buildList()

        val useCase = GetFavoriteListUseCase(disneyRepository)
        val res = useCase.invoke()

        MatcherAssert.assertThat(res[0], CoreMatchers.instanceOf(DisneyListModel::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(15))
    }


}