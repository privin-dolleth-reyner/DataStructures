package crackingthecodinginterview.arrays_and_strings

class OneAway {
    
    fun method1(word: String, edit: String): Boolean {
        if(Math.abs(word.length - edit.length) > 1){
            return false
        }
        if(word.length == edit.length){
            var foundChange = false
            for (i in word.indices){
                if(word[i] != edit[i]){
                    if (foundChange) return false
                    foundChange = true
                }
            }
        }else if(word.length > edit.length){
            return insertChange(word, edit)
        }else{
            return insertChange(edit,word)
        }
        return true
    }
    
    private fun insertChange(word: String, edit: String): Boolean {
        var foundChange = false
        var i = 0
        var j = 0
        while (i < word.length && j < edit.length){
            println("$i, $j")
            if(word[i] != edit[j]){
                if (foundChange) return false
                foundChange = true
                i++
            }
            i++
            j++
        }
        return true
    }
    
    // Optimized checks
    fun method2(word: String, edit: String): Boolean {
        if(Math.abs(word.length - edit.length) > 1){
            return false
        }
        
        var foundChange = false
        var i = 0
        var j = 0
        while (i < word.length && j < edit.length){
            println("$i, $j")
            if(word[i] != edit[j]){
                if (foundChange) return false
                foundChange = true
                i++
                if(word.length == edit.length){
                    j++
                }
            }
            i++
            j++
        }
        return true
    }
}