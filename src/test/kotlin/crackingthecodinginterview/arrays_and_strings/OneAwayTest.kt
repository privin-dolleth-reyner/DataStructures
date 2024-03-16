package crackingthecodinginterview.arrays_and_strings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class OneAwayTest{
    private val oneAway = OneAway()
    
    @Test
    fun testReplace(){
        assertEquals(true, oneAway.method1("pale","bale"))
        assertEquals(true, oneAway.method2("pale","bale"))
    }
    
    @Test
    fun testInsert(){
        assertEquals(true, oneAway.method1("pale","ple"))
        assertEquals(true, oneAway.method2("pale","ple"))
    }
    

    @Test
    fun testRemove(){
        assertEquals(true, oneAway.method1("pales","pale"))
        assertEquals(true, oneAway.method2("pales","pale"))
    }
    
    @Test
    fun testMoreThanOneAway(){
        assertEquals(false, oneAway.method1("pale","bake"))
        assertEquals(false, oneAway.method2("pale","bake"))
    }
    
    
}