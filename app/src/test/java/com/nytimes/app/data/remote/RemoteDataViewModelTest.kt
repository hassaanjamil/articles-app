package com.nytimes.app.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nytimes.app.BuildConfig
import com.nytimes.app.utils.TestCoroutineRule
import com.nytimes.app.data.remote.model.ResponseArticles
import com.nytimes.app.data.repository.MainRepository
import com.nytimes.app.ui.home.HomeViewModel
import com.nytimes.app.utils.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RemoteDataViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiHelper: ApiHelper

    @Mock
    private lateinit var apiUsersObserver: Observer<Resource<ResponseArticles>>

    @Test
    fun testRequestUrlValidation() {
        if(BuildConfig.BASE_URL.contains("https")) {
            Assert.assertEquals("https://", BuildConfig.BASE_URL.substring(0, 8))
        } else {
            Assert.assertEquals("http://", BuildConfig.BASE_URL.substring(0, 8))
        }
    }

    @Test
    fun testRequestBaseUrlValidation() {
        val baseUrl = BuildConfig.BASE_URL
        Assert.assertEquals("https://api.nytimes.com/svc/mostpopular/v2/mostviewed/", baseUrl)
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            Mockito.doReturn(ResponseArticles())
                .`when`(apiHelper)
                .getMostPopularArticles()
            val viewModel = HomeViewModel(MainRepository(apiHelper))
            viewModel.getMostPopularArticles().observeForever(apiUsersObserver)
            Mockito.verify(apiHelper).getMostPopularArticles()
            Mockito.verify(apiUsersObserver).onChanged(Resource.success(ResponseArticles()))
            viewModel.getMostPopularArticles().removeObserver(apiUsersObserver)
        }
    }

}