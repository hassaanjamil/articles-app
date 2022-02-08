package com.nytimes.app

import com.nytimes.app.data.remote.model.Article
import com.nytimes.app.utils.Resource
import com.nytimes.app.utils.Status
import com.nytimes.app.utils.toDateFormat
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 * @author Hassan Jamil
 */
class UtilsUnitTest {
    @Test
    fun testDateConversion() {
        val actual = "2022-02-08 14:08:30".toDateFormat("yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd")
        assertEquals("2022-02-08", actual)
    }

    @Test
    fun testResource() {
        assertNotNull(Resource.success(Article(title = "ABC")))
        assertNull(Resource.error("Exception", null).data)
        assertNull(Resource.loading(null).message)
    }

    @Test
    fun testStatus() {
        assertEquals(Status.ERROR.ordinal, 1)
    }
}