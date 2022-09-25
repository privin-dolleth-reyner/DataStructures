package impl

class DoubleLinkedList(root: Node? = null) {
    companion object{
        data class Node(var value: Int, var next: Node? = null, var prev : Node? = null)
    }

    var head: Node? = root

    private var current: Node? = root

    fun push(item: Int) {
        val newNode = DoubleLinkedList.Companion.Node(item)
        if (head == null){
            head = newNode
            current = newNode
            return
        }
        if (current == null){
            current = Node(item)
        }else {
            var n = Node(item)
            n.prev = current
            current!!.next = n
            current = n
        }
    }

    fun set(index: Int, item: Int) {
        var temp = head
        val newNode = Node(item)
        var counter = 0
        while (temp != null) {
            if (counter == index) {
                newNode.prev = temp.prev
                newNode.next = temp.next
                if (temp.prev==null){
                    head = newNode
                    return
                }
                temp.prev?.next = newNode
                return
            }
            temp = temp.next
            counter++
        }
    }

    fun remove(item: Int) {
        var temp = head
        while (temp != null) {
            if (temp.value == item) {
                temp.prev?.next = temp.next
                return
            }
            temp = temp.next
        }
    }

    fun removeAt(index: Int) {
        var temp = head
        var counter = 0
        while (temp != null) {
            if (counter == index) {
                temp.prev?.next = temp.next
                return
            }
            temp = temp.next
            counter++
        }
    }

    fun pop(): Int {
        val d = current!!.value
        current = current!!.prev
        current!!.next = null
        return d
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
    val list = DoubleLinkedList(DoubleLinkedList.Companion.Node(1))
    list.push(2)
    list.push(3)
    list.push(4)
    list.push(5)
    list.removeAt(3)
    list.print()
    list.set(0, 9)
    println()
    println(list.pop())
    list.print()
}