import impl.DynamicArray

fun main(args: Array<String>) {
    checkDynamicArrayImpl()
}

private fun checkDynamicArrayImpl(){
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