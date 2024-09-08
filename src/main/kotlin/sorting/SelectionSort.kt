package sorting

private fun main() {
    val arr = intArrayOf(7,3,2,6,1,5)

    val list = makeList(arr)

    println(selectionSort(arr).joinToString())

    println()


    list.sort()

    var temp = list.head

    while (temp!=null){
        print(temp.value)
        temp = temp.next
    }
}


fun selectionSort(nums: IntArray): IntArray{
    if (nums.size < 2) return nums
    for (i in nums.indices){
        var minIndex = i
        for (j in i+1 until nums.size) {
            if (nums[j] < nums[minIndex]) {
                minIndex = j
            }
        }
        val temp = nums[i]
        nums[i] = nums[minIndex]
        nums[minIndex] = temp
    }
    return nums
}

private fun makeList(nums: IntArray): SLKList {
    val list = SLKList()
    for (n in nums){
        list.insertAtEnd(n)
    }
    return list
}
private class SLKList(root: ListNode? = null){
    data class ListNode(var value: Int, var next: ListNode? = null)

    var head: ListNode? = root

    fun insertAtBeginning(num: Int){
        var newNode = ListNode(num)
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

    fun deleteAtBeginning(){
        head = head?.next
    }

    fun deleteAtMiddle(index: Int){
        var temp = head
        for (i in 2 until index){
            temp = temp?.next
        }

        temp = temp?.next?.next
    }

    fun deleteAtEnd(){
        var temp = head
        while (temp?.next != null){
            temp = temp?.next
        }

        temp?.next = null
    }

    fun sort(){
        var temp1 = head
        while (temp1 != null){
            var minNode : ListNode = temp1
            var temp2 = temp1.next
            while (temp2!=null){
                if (temp2.value < minNode.value){
                    minNode = temp2
                }
                temp2 = temp2.next
            }

            val swap = minNode.value
            minNode.value = temp1.value
            temp1.value = swap

            temp1 = temp1.next
        }
    }

}