package com.example.disneyappob.presentation.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.domain.TestDataListBuilder
import com.example.disneyappob.domain.useCase.GetDisneyListHerculesUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListHeroUseCase
import com.example.disneyappob.domain.useCase.GetDisneyListTreasureUseCase
import com.example.disneyappob.domain.useCase.GetFavoriteListUseCase
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
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListScreenViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getDisneyListTreasureUseCase: GetDisneyListTreasureUseCase
    @MockK(relaxed = true)
    private lateinit var getDisneyListHeroUseCase: GetDisneyListHeroUseCase
    @MockK(relaxed = true)
    private lateinit var getDisneyListHerculesUseCase: GetDisneyListHerculesUseCase


    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        //Liberar recursos del test
    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData in Treasure`() = runTest {
        coEvery { getDisneyListTreasureUseCase.invoke() } returns TestDataListBuilder()
            .withNumElements(15)
            .buildList()

        val viewModel = ListScreenViewModel(
            getDisneyListTreasureUseCase,
            getDisneyListHeroUseCase,
            getDisneyListHerculesUseCase
        )

        val res = viewModel.disneyListTreasure.getOrAwaitValue()
        MatcherAssert.assertThat(res.size, `is`(15))
    }
    @Test
    fun `WHEN viewModel init EXPECT data at LiveData in Hero`() = runTest {
        coEvery { getDisneyListHeroUseCase.invoke() } returns TestDataListBuilder()
            .withNumElements(14)
            .buildList()

        val viewModel = ListScreenViewModel(
            getDisneyListTreasureUseCase,
            getDisneyListHeroUseCase,
            getDisneyListHerculesUseCase
        )

        val res = viewModel.disneyListHero.getOrAwaitValue()
        MatcherAssert.assertThat(res.size, `is`(14))
    }
    @Test
    fun `WHEN viewModel init EXPECT data at LiveData in Hercules`() = runTest {
        coEvery { getDisneyListHerculesUseCase.invoke() } returns TestDataListBuilder()
            .withNumElements(13)
            .buildList()

        val viewModel = ListScreenViewModel(
            getDisneyListTreasureUseCase,
            getDisneyListHeroUseCase,
            getDisneyListHerculesUseCase
        )

        val res = viewModel.disneyListHercules.getOrAwaitValue()
        MatcherAssert.assertThat(res.size, `is`(13))
    }

}