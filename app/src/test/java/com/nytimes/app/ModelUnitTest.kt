package com.nytimes.app

import com.nytimes.app.data.remote.model.Article
import com.nytimes.app.utils.toDateFormat
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 * @author Hassan Jamil
 */
class ModelUnitTest {
    @Test
    fun testBuild() {
        val model = Article("", "",1221L, 100L, "NY Times",
            "2022-02-08", "today", "news", "", "",
            "","","Hassan", "","SampleTitle","",
            listOf(), listOf(), listOf(), listOf(), listOf(),5)
        assertEquals("", model.url)
        assertEquals(1221L, model.id)
        assertEquals(100L, model.assetId)
        assertEquals("NY Times", model.source)
        assertEquals("2022-02-08", model.publishedDate)
        assertEquals("today", model.updated)
        assertEquals("news", model.section)
        assertEquals("", model.subsection)
        assertEquals("", model.nytdsection)
        assertEquals("", model.adxKeywords)
        assertEquals("", model.column)
        assertEquals("Hassan", model.byline)
        assertEquals("", model.type)
        assertEquals("SampleTitle", model.title)
    }
}