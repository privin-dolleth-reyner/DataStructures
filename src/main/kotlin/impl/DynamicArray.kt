package impl

class DynamicArray constructor(initialCapacity: Int = 1): Iterator<Int> {

    var capacity: Int = initialCapacity
        private set

    var size = 0
        private set

    private var iteratorIndex = 0

    private var arr: IntArray = IntArray(initialCapacity)

    fun add(item: Int){
        if (size == capacity){
            capacity *=2
            val temp = IntArray(capacity)
            arr.forEachIndexed { index, it ->
                temp[index] = it
            }
            arr = temp
        }

        arr[size] = item
        size++
    }

    operator fun set(index: Int, item: Int){
        if (index == capacity){
            add(item)
        }else{
            arr[index] = item
        }
    }

    operator fun get(index: Int) = arr[index]

    fun remove(index: Int){
        if (index == size-1) {
            size--
            return
        }
        if (index < size){
            arr[index] = -1
        }else{
            throw IllegalStateException("Index not within bounds")
        }
    }

    operator fun iterator(){
        arr.iterator()
    }

    override fun hasNext(): Boolean {
        if (iteratorIndex >= size) {
            iteratorIndex = 0
            return false
        }
        return true
    }

    override fun next(): Int {
        return arr[iteratorIndex++]
    }

}

fun main(){
    val list = DynamicArray()
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    list[1] = 8
    list.remove(4)
    list.forEach {
        print(it)
    }
    println()
    list.forEach {
        print(it)
    }
    println()
    println("ArrayItem: ${list[1]}")
}