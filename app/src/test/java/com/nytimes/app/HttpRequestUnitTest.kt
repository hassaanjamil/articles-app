package com.nytimes.app

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 * @author Hassan Jamil
 */
class HttpRequestUnitTest {
    @Test
    fun testRequestUrlValidation() {
        if(BuildConfig.BASE_URL.contains("https")) {
            assertEquals("https://", BuildConfig.BASE_URL.substring(0, 8))
        } else {
            assertEquals("http://", BuildConfig.BASE_URL.substring(0, 8))
        }
    }

    @Test
    fun testRequestBaseUrlValidation() {
        val baseUrl = BuildConfig.BASE_URL
        assertEquals("https://api.nytimes.com/svc/mostpopular/v2/mostviewed/", baseUrl)
    }
}