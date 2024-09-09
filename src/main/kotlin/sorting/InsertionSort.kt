package sorting

private fun main(){
    val arr = intArrayOf(7,3,2,6,1,5)

    val list = makeList(arr)

    val result = insertionSort(arr)

    println(result.joinToString())

    list.sort()

    var temp = list.head

    while (temp!=null){
        print(temp.value)
        temp = temp.next
    }
}

fun insertionSort(nums: IntArray): IntArray {
    if (nums.size < 2) return nums
    for (i in 1 until nums.size){
//        println(nums.joinToString())
        val key = nums[i]
        var j = i
        while (j>0){
            if (key < nums[j-1]){
                nums[j] = nums[j - 1]
            } else break
            j--
        }
        nums[j] = key
    }
    return nums
}

private fun makeList(nums: IntArray): LkList {
    val list = LkList()
    for (n in nums){
        list.insertAtEnd(n)
    }
    return list
}

private class LkList(root: ListNode? = null) {

    data class ListNode(var value: Int, var next: ListNode? = null)

    var head: ListNode? = null

    fun insertAtBeginning(num: Int){
        val newNode = ListNode(num)
        newNode.next = head
        head = newNode
    }

    fun insertAtMiddle(num: Int, index: Int){
        val newNode = ListNode(num)
        var temp = head
        for (i in 2 until index){
            temp = temp?.next
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

    fun deleteFromBeginning(){
        head = head?.next
    }

    fun deleteAtMiddle(index: Int){
        var temp = head
        for (i in 2 until index){
            temp = temp?.next
        }
        temp?.next = temp?.next?.next
    }

    fun deleteAtEnd(){
        var temp = head
        while (temp?.next?.next != null){
            temp = temp.next
        }
        temp?.next = null
    }

    fun sort(){
        var temp = head
        var sorted: ListNode? = null
        while (temp != null){
            val next = temp.next
            sorted = insertionSort(temp, sorted)
            temp = next
        }

        head = sorted
    }

    fun insertionSort(temp: ListNode, sorted: ListNode?): ListNode {
        return if(sorted == null || sorted.value >= temp.value){
            temp.next = sorted
            temp
        }else{
            var current = sorted
            while (current?.next != null && current.next!!.value < temp.value){
                current = current.next
            }
            temp.next = current?.next
            current?.next = temp
            sorted
        }
    }
}