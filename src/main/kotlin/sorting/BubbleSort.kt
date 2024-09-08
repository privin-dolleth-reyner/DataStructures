package sorting

fun main() {
    val arr = intArrayOf(7,3,2,6,1,5)
    bubbleSort(arr)

    println()

    val list = makeList(arr)

    list.sort()
    var temp = list.head


    while (temp != null) {
        print(temp.value)
        temp = temp.next
    }
}

fun bubbleSort(array: IntArray){
    for (i in array.indices){
        for (j in i+1 until array.size){
            if (array[j] < array[i]){
                val temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
        }
    }

    println(array.joinToString())
}

fun makeList(array: IntArray): LKList {
    val linkedList = LKList()
    for (n in array){
        linkedList.insertAtEnd(n)
    }

    return linkedList
}

data class ListNode(var value: Int, var next: ListNode? = null)
class LKList(root: ListNode? = null){

    var head: ListNode? = root
        private set

    fun insertAtBeginning(num: Int){
        val newNode = ListNode(num, head)
        head = newNode
    }

    fun insertAtIndex(num: Int, index: Int){
        val newNode = ListNode(num)
        var temp = head
        for (i in 2 until index){
            if (temp?.next != null) {
                temp = temp.next
            }
        }
        newNode.next = temp?.next
        temp?.next = newNode
    }

    fun insertAtEnd(num: Int){
        val newNode = ListNode(num)
        if (head == null){
            insertAtBeginning(num)
        }else{
            var temp = head

            while (temp?.next != null){
                temp = temp.next
            }
            temp?.next = newNode
        }

    }

    fun deleteAtBeginning(): Int? {
        val data = head?.value
        head = head?.next
        return data
    }

    fun deleteAtMiddle(index: Int){
        var temp = head
        for (i in 2 until index){
            if (temp?.next != null){
                temp = temp.next
            }
        }

        temp?.next = temp?.next?.next
    }

    fun deleteAtEnd(){
        var temp = head

        while (temp?.next?.next!=null){
            temp = temp.next
        }
        temp?.next = null
    }

    fun search(target:Int): Boolean {
        var temp = head

        while (temp?.next != null){
            if (temp.value == target) return true
            temp = temp.next
        }

        return false
    }

    fun sort() {
        var temp = head

        while (temp !=null) {
            var current = temp.next
            while (current !=null){
                if (current.value < temp.value){
                    val swap = current.value
                    current.value = temp.value
                    temp.value = swap
                }
                current = current.next
            }
            temp = temp.next
        }
    }
}