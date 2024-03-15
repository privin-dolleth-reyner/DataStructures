package impl

class HashMap<K,V>{
    
    companion object{
        private val DEFAULT_SIZE = 32
    }
    
    data class Item<K,V>(val key: K, var value: V?){
        var next: Item<K,V>? = null
    }
    
    
    private val arr = Array<Item<K,V>?>(DEFAULT_SIZE){ null }
    var size = 0
      private set 
    
    fun add(key: K, value: V){
        val str = key.toString()
        val index = hash(str) % DEFAULT_SIZE
        var temp = arr[index]
        while(temp != null){
            if(temp.key == key){
                temp.value = value
                return
            }
            temp = temp.next
        }
        val newItem = Item(key, value)
        newItem.next = arr[index]
        arr[index] = newItem
        size++
    }
    
    fun get(key: K): V?{
        val str = key.toString()
        val index = hash(str) % DEFAULT_SIZE
        var head = arr[index]
        while(head!=null){
            if(head.key == key){
                return head.value
            }
            head = head.next
        }
        return null
    }
    
    fun remove(key: K){
        val str = key.toString()
        val index = hash(str) % DEFAULT_SIZE
        var head = arr[index]
        while(head != null){
            if (head.key == key){
                val v = head.value
                head = head.next
                arr[index] = head
                size--
                return
            }
            head = head.next
        }
    }
    
    fun isEmpty() = size == 0
    private fun hash(str: String): Int{
        var hash = 7
        for(ch in str){
            hash = 31 * ch.toInt()
        }
        return hash
    }
    
    @Override
    override fun toString(): String{
        val sb = StringBuilder()
        sb.append("{ \n")
        for(head in arr){
            var temp = head
            while(temp != null){
                sb.append("\t")
                sb.append("${temp.key} : ${temp.value}, \n")
                temp = temp.next
            }
        }
        sb.append("}")
        return sb.toString()
    }
}

fun main(){
    val hashMap = HashMap<String,String>()
    println(hashMap.isEmpty())
    hashMap.add("a","App")
    hashMap.add("b","Banana")
    hashMap.add("c","Cat")
    println(hashMap.size.toString())
    println(hashMap.toString())
    hashMap.add("a","Apple")
    println(hashMap.get("c"))
    println(hashMap.toString())
    hashMap.remove("a")
    println(hashMap.toString())
    hashMap.remove("c")
    println(hashMap.toString())
    hashMap.remove("b")
    println(hashMap.toString())
    println(hashMap.isEmpty())
    
}