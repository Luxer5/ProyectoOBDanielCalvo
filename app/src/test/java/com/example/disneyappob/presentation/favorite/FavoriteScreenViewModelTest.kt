package com.example.disneyappob.presentation.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.domain.TestDataListBuilder
import com.example.disneyappob.domain.useCase.GetFavoriteListUseCase
import com.example.disneyappob.presentation.list.ListScreenViewModel
import com.example.disneyappob.testutil.DefaultDispatcherRule
import com.example.disneyappob.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteScreenViewModelTest{

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getFavoriteListUseCase: GetFavoriteListUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData in Favorites`() = runTest {
        coEvery { getFavoriteListUseCase.invoke() } returns TestDataListBuilder()
            .withNumElements(12)
            .buildList()

        val viewModel = FavoriteScreenViewModel(getFavoriteListUseCase)

        val res = viewModel.disneyListFavorites.getOrAwaitValue()
        MatcherAssert.assertThat(res.size, `is`(12))
    }
}