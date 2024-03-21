package crackingthecodinginterview.arrays_and_strings

class StringCompression{
    
    fun execute(str: String): String {
        if (str.isEmpty()) return ""
        val sb = StringBuilder()
        sb.append(str[0])
        var count = 1
        
        for (i in 1 until str.length){
            if(str[i] == str[i-1]){
                count++
                continue
            }
            sb.append("$count${str[i]}")
            count = 1
        }
        
        sb.append("$count")
        return sb.toString()
    }
}