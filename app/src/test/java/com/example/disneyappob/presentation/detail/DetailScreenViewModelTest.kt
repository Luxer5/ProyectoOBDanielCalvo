package com.example.disneyappob.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.domain.TestDataBuilder
import com.example.disneyappob.domain.model.DisneyModel
import com.example.disneyappob.domain.useCase.CheckFavoriteUseCase
import com.example.disneyappob.domain.useCase.DeleteFavoriteUseCase
import com.example.disneyappob.domain.useCase.GetDetailUseCase
import com.example.disneyappob.domain.useCase.InsertFavoriteUseCase
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

class DetailScreenViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()


    @MockK(relaxed = true)
    private lateinit var getDetailUseCase: GetDetailUseCase

    @MockK(relaxed = true)
    private lateinit var insertFavoriteUseCase: InsertFavoriteUseCase

    @MockK(relaxed = true)
    private lateinit var deleteFavoriteUseCase: DeleteFavoriteUseCase

    @MockK(relaxed = true)
    private lateinit var checkFavoriteUseCase: CheckFavoriteUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        //Liberar recursos del test
    }

    @Test
    fun `WHEN detailViewModel getData EXPECT disney live data has value`() = runTest {
        coEvery { getDetailUseCase.invoke(5) } returns TestDataBuilder().buildSingle()

        val viewModel = DetailScreenViewModel(
            getDetailUseCase,
            insertFavoriteUseCase,
            deleteFavoriteUseCase,
            checkFavoriteUseCase
        )
        viewModel.getData(5)

        val res = viewModel.disney.getOrAwaitValue()
        MatcherAssert.assertThat(res.id, `is`(5))
    }
    @Test
    fun `WHEN detailViewModel init EXPECT disney live data is instance of DisneyModel`() = runTest {
        coEvery { getDetailUseCase.invoke(5) } returns TestDataBuilder().buildSingle()

        val viewModel = DetailScreenViewModel(
            getDetailUseCase,
            insertFavoriteUseCase,
            deleteFavoriteUseCase,
            checkFavoriteUseCase
        )
        viewModel.getData(5)

        val res = viewModel.disney.getOrAwaitValue()
        MatcherAssert.assertThat(res, instanceOf(DisneyModel::class.java))
    }


    @Test
    fun `WHEN detailViewModel checkFav true EXPECT fav live data true`() = runTest {
        coEvery { checkFavoriteUseCase.invoke(5) } returns true

        val viewModel = DetailScreenViewModel(
            getDetailUseCase,
            insertFavoriteUseCase,
            deleteFavoriteUseCase,
            checkFavoriteUseCase
        )
        viewModel.checkFav(5)

        val res = viewModel.fav.getOrAwaitValue()
        MatcherAssert.assertThat(res, `is`(true))
    }
    @Test
    fun `WHEN detailViewModel checkFav false EXPECT fav live data false`() = runTest {
        coEvery { checkFavoriteUseCase.invoke(5) } returns false

        val viewModel = DetailScreenViewModel(
            getDetailUseCase,
            insertFavoriteUseCase,
            deleteFavoriteUseCase,
            checkFavoriteUseCase
        )
        viewModel.checkFav(5)

        val res = viewModel.fav.getOrAwaitValue()
        MatcherAssert.assertThat(res, `is`(false))
    }

}