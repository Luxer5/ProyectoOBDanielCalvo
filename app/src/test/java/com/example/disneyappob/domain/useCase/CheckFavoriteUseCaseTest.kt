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
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CheckFavoriteUseCaseTest{
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
    fun `WHEN invoke id in database EXPECT return true`() = runTest{
        coEvery { disneyRepository.checkFav(5) } returns true

        val useCase = CheckFavoriteUseCase(disneyRepository)
        val res = useCase.invoke(5)

        MatcherAssert.assertThat(res, `is`(true))
    }
    @Test
    fun `WHEN invoke id in database EXPECT return false`() = runTest{
        coEvery { disneyRepository.checkFav(5) } returns false

        val useCase = CheckFavoriteUseCase(disneyRepository)
        val res = useCase.invoke(5)

        MatcherAssert.assertThat(res, `is`(false))
    }


}