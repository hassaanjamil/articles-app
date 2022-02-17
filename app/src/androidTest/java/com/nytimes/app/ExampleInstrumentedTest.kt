package com.nytimes.app

import androidx.fragment.app.viewModels
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.nytimes.app.data.remote.ApiHelper
import com.nytimes.app.data.remote.ApiService
import com.nytimes.app.ui.home.HomeViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import javax.inject.Inject


/**
 * Instrumented test, which will execute on Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 *
 * @author Hassan Jamil
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ExampleInstrumentedTest {
    @Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiHelper: ApiHelper

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.nytimes.app", appContext.packageName)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testApi() = runBlocking {
        val response = apiHelper.getMostPopularArticles()
        assertEquals("OK", response.status)
    }
}