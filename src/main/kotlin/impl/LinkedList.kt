package impl

class LinkedList(root: Node? = null) {

    companion object {
        data class Node(var value: Int, var next: Node? = null)
    }

    var head: Node? = root

    private var current: Node? = root

    fun insert(item: Int) {
        val newNode = Node(item)
        if (head == null){
            head = newNode
            current = newNode
            return
        }
        if (current == null){
            current = Node(item)
        }else {
            current!!.next = Node(item)
            current = current!!.next
        }
    }

    fun insertAt(index: Int, item: Int) {
        var temp = head
        val newNode = Node(item)
        var counter = 0
        while (temp != null) {
            if (temp.next != null && counter+1 == index) {
                newNode.next = temp.next
                temp.next = newNode
                return
            }
            counter++
            temp = temp.next
        }
    }

    fun remove(item: Int) {
        var temp = head
        while (temp != null) {
            if (temp.next != null && temp.next!!.value == item) {
                temp.next = temp.next!!.next
                return
            }
            temp = temp.next
        }
    }

    fun removeAt(index: Int) {
        var temp = head
        var counter = 0
        while (temp != null) {
            if (temp.next != null && counter + 1 == index) {
                temp.next = temp.next!!.next
                return
            }
            counter++
            temp = temp.next
        }
    }

    fun pop(): Int {
        var temp = head
        while (temp != null) {
            if (temp.next != null && temp.next!!.next == null) {
                val r = temp.next!!.value
                temp.next = null
                return r
            }
            temp = temp.next
        }
        return -1
    }

    fun print(){
        var temp = head
        while (temp!=null){
            print(temp.value)
            temp = temp.next
        }
    }
}

fun main() {
    val list = LinkedList()
    list.insert(1)
    list.insert(2)
    list.insert(3)
    list.insert(4)
    list.insert(5)
    list.remove(3)
    list.insertAt(2, 3)
    list.print()
    println()
    list.removeAt(2)
    println(list.pop())
    list.print()
}