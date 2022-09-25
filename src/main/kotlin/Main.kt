import impl.DynamicArray
import impl.LinkedList

fun main() {
    checkLinkedListImpl()
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

private fun checkLinkedListImpl(){
    val list = LinkedList(LinkedList.Companion.Node(1))
    list.push(2)
    list.push(3)
    list.push(4)
    list.push(5)
    list.remove(3)
    list.print()
    println()
    println(list.pop())
    list.print()
}