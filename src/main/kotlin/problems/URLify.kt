package problems

fun main(){
    val url ="Mr John Smith    "
    val len = 13
    println(urlify(url, len))
}

private fun urlify(url: String, len: Int): String{
    val n = url.length
    val arr = url.toCharArray()
    var i = len - 1
    var j = n-1
    while (i>=0){
        if (arr[i] != ' '){
            arr[j--] = arr[i--]
        }else{
            arr[j--] = '0'
            arr[j--] = '2'
            arr[j--] = '%'
            i--
        }
    }
    return arr.joinToString("")
}