package problems

import java.util.Arrays

fun main() {
    val a = "abc"
    val b = "cba"
    println(isPermutation(a,b))
}

private fun isPermutation(a: String, b: String): Boolean{
    if (a.length != b.length) return false
    val x = a.run {
        val arr = toCharArray()
        Arrays.sort(arr)
        String(arr)
    }
    val y = b.run {
        val arr = toCharArray()
        Arrays.sort(arr)
        String(arr)
    }
    return x == y
}



private fun isPermutations(a: String, b: String): Boolean{
    if (a.length != b.length) return false
    val map = HashMap<Char,Int>()
    for (ch in a){
        if (map[ch] == null)
            map[ch] = 0
        map[ch] = map[ch]!! + 1
    }
    for (ch in b){
        when(map[ch]){
            null-> return false
            1 -> map.remove(ch)
            else -> map[ch] = map[ch]!! - 1
        }
    }
    return map.size == 0
}