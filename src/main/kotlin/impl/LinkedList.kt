package impl

class LinkedList(root: Node) {

    companion object {
        data class Node(var value: Int, var next: Node? = null)
    }

    var head: Node? = root

    private var current: Node? = root

    fun push(item: Int) {
        if (current == null){
            current = Node(item)
        }else {
            current!!.next = Node(item)
            current = current!!.next
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