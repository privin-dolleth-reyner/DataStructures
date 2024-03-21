package crackingthecodinginterview.arrays_and_strings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringCompressionTest{
    
    private val stringCompression = StringCompression()
    
    @Test
    fun testCompression(){
        val str = stringCompression.execute("aabcccd")
        assertEquals("a2b1c3d1", str)
    }
    
    @Test
    fun testCompression1(){
        val str = stringCompression.execute("abcd")
        assertEquals("abcd", str)
    }
    

    @Test
    fun testCompression2(){
        val str = stringCompression.execute("a")
        assertEquals("a1", str)
    }
    
    @Test
    fun testCompression3(){
        val str = stringCompression.execute("")
        assertEquals("", str)
    }
}