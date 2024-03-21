package crackingthecodinginterview.arrays_and_strings

class StringCompression{
    
    fun execute(str: String): String {
        val finalLength = countCompression(str)
        if(str.isEmpty() || finalLength >= str.length) return str
        val sb = StringBuilder(finalLength)
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

    private fun countCompression(str: String): Int{
        var count = 1
        var length = 0
        for (i in 1 until str.length){
            if(str[i] == str[i-1]){
                count++
                continue
            }
            length += 1 + count.toString().length
            count = 1
        }
        return length
    }
}