package com.example.disneyappob.domain.useCase

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.data.DisneyRepository
import com.example.disneyappob.data.remote.DisneyApi
import com.example.disneyappob.domain.TestDataBuilder
import com.example.disneyappob.domain.model.DisneyModel
import com.example.disneyappob.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetDetailUseCaseTest{
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
    fun `WHEN invoke with id EXPECT return instance of DisneyModel`() = runTest{
        coEvery { disneyRepository.getDisneyCharacter(5) } returns TestDataBuilder()
            .withId(5).buildSingle()

        val useCase = GetDetailUseCase(disneyRepository)
        val res = useCase.invoke(5)

        assertThat(res, instanceOf(DisneyModel::class.java))
    }

}