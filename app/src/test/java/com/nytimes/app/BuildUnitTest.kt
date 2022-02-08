package com.nytimes.app

import com.nytimes.app.utils.toDateFormat
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 * @author Hassan Jamil
 */
class BuildUnitTest {
    @Test
    fun testBuild() {
        assertEquals("com.nytimes.app", BuildConfig.APPLICATION_ID)
        assertEquals("debug", BuildConfig.BUILD_TYPE)
        assertEquals(1, BuildConfig.VERSION_CODE)
        assertEquals(true, BuildConfig.DEBUG)
        assertEquals("1.0", BuildConfig.VERSION_NAME)
        assertEquals("OQcEo9fdy3pn8YA5xt5Fow5RyU4bH3mE", BuildConfig.API_KEY)
        assertEquals("https://api.nytimes.com/svc/mostpopular/v2/mostviewed/", BuildConfig.BASE_URL)
    }
}