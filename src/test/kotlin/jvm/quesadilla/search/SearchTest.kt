package jvm.quesadilla.search

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SearchTest {

    @Test
    fun `test search with exact match`() {
        val data = listOf("apple", "banana", "cherry")
        val result = Search.search("banana", data)
        assertEquals(listOf("banana"), result)
    }

    @Test
    fun `test search with similar match`() {
        val data = listOf("apple", "banana", "cherry")
        val result = Search.search("banan", data)
        assertEquals(listOf("banana"), result)
    }

    @Test
    fun `test search with no match`() {
        val data = listOf("apple", "banana", "cherry")
        val result = Search.search("grape", data)
        assertEquals(emptyList<String>(), result)
    }

    @Test
    fun `test search with custom threshold`() {
        val data = listOf("apple", "banana", "cherry")
        val result = Search.search("banan", data, threshold = 1)
        assertEquals(listOf("banana"), result)
    }
}