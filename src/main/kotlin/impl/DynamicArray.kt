package impl

class DynamicArray constructor(initialCapacity: Int = 1) {

    var capacity: Int = initialCapacity
        private set

    var size = 0
        private set

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

}