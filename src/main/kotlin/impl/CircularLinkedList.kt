package impl

class CircularLinkedList {
    companion object{
        data class Node(var value: Int, var next: Node? = null)
    }

    private var head: Node? = null
    private var tail: Node? = null

    fun insert(item: Int){
        val newNode = Node(item)
        if (head == null){
            head = newNode
            tail = newNode
            return
        }
        newNode.next = tail!!.next
        tail!!.next = newNode
        tail = newNode
    }

    fun insertAt(index: Int, item: Int){
        val newNode = Node(item)
        if (head == null) return
        var temp = head!!.next
        var counter = 1
        while (temp != null && temp != head){
            if (counter+1 == index){
                newNode.next = temp!!.next
                temp.next = newNode
            }
            counter++
            temp = temp!!.next
        }
    }

    fun remove(item: Int){
        if (head == null) return
        val temp = head!!.next
        while (temp != null && temp != head){
            if (temp!!.next != head && temp.next!!.value == item){
                temp.next = temp.next!!.next
                return
            }
        }
    }

    fun removeAt(index: Int){
        if (head == null) return
        var temp = head!!.next
        var counter = 1
        while (temp != null && temp != head){
            if (counter+1 == index){
                temp?.next = temp?.next?.next
            }
            counter++
            temp = temp!!.next
        }
    }

    fun print(){
        if (head == null) return
        var temp = head!!.next
        print(head!!.value)
        while (temp!=null && temp!=head){
            print(temp!!.value)
            temp = temp!!.next
        }
    }
}


fun main(){
    val list = CircularLinkedList()
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
    list.print()
}