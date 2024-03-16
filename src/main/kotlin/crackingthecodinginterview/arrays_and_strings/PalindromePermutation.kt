package crackingthecodinginterview.arrays_and_strings

fun main(){
    val word = "Tact Coa"
    val word1 = "abccba"
    println(palindromePermutation(word1))
}

// Using HashMap
private fun palindromePermutationUsingHash(word: String): Boolean {
    val map = HashMap<Char,Int>()
    for(ch in word){
        if(Character.isLetter(ch).not()) continue
        val l = ch.lowercase()[0]
        if (map[l] == null){
            map[l] = 0
        }
        map[l] = map[l]!! + 1
    }
    val isAllCharEqFreq = map.values.all { it % 2 == 0 }
    val isAllCharEqFreqExceptOne = map.values.filterNot { it % 2 == 0 }.size == 1
    return isAllCharEqFreq || isAllCharEqFreqExceptOne
}

// Using bit manipulation
private fun palindromePermutation(word: String): Boolean {
    var bitVector = 0
    for(ch in word){
        if(Character.isLetter(ch)){
            val mask = 1.shl((ch.lowercase()[0] - 'a'))
            bitVector = bitVector.xor(mask)
        }
    }
    return bitVector == 0 || bitVector.and(bitVector - 1) == 0
}