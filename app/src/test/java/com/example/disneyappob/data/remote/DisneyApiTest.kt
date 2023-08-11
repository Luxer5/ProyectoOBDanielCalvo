package com.example.disneyappob.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.disneyappob.data.dto.DisneyCharacterDto
import com.example.disneyappob.data.dto.DisneyListDto
import com.example.disneyappob.testutil.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DisneyApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    private lateinit var api: DisneyApi

    @Before
    fun setup(){
        api = retrofit.create(DisneyApi::class.java)
    }

    @Test
    fun `WHEN request disney list Treasure EXPECT result`() = runTest{
        val result = api.getDisneyListTreasure()
        assertThat(result.data.isNotEmpty(), `is`(true) )
    }
    @Test
    fun `WHEN request disney list Treasure EXPECT instance of DisneyListDto`() = runTest{
        val result = api.getDisneyListTreasure()
        assertThat(result, instanceOf(DisneyListDto::class.java) )
    }
    @Test
    fun `WHEN request disney list Hero EXPECT instance of DisneyListDto`() = runTest{
        val result = api.getDisneyListHero()
        assertThat(result, instanceOf(DisneyListDto::class.java) )
    }
    @Test
    fun `WHEN request disney list Hercules EXPECT instance of DisneyListDto`() = runTest{
        val result = api.getDisneyListHercules()
        assertThat(result, instanceOf(DisneyListDto::class.java) )
    }

    @Test
    fun `WHEN getDisneyChararcter with id 35 EXPECT instace of DisneyChararcterDto`() = runTest {
        val result = api.getDisneyCharacter(35)
        assertThat(result, instanceOf(DisneyCharacterDto::class.java))
    }
    @Test
    fun `WHEN getDisneyChararcter with id 35 EXPECT instace of result id = 355`() = runTest {
        val result = api.getDisneyCharacter(35)
        assertThat(result.data._id, `is`(35) )
    }

    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                //Lo ideal es probar contra un entorno estable
                //Entorno de QA
                .baseUrl("https://api.disneyapi.dev/")
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(
                            HttpLoggingInterceptor.Logger.DEFAULT)
                            .apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                )
                .build()
        }

    }

}