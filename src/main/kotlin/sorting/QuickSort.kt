package sorting

private fun main() {
    val arr = intArrayOf(7,3,2,6,1,5)

    val list = makeList(arr)

    println(quickSort(arr, 0, arr.size-1).joinToString())

    list.sort()

    list.display()

}

private fun makeList(nums: IntArray): QLkList {
    val list = QLkList()
    for (n in nums){
        list.insertAtEnd(n)
    }
    return list
}

fun quickSort(nums: IntArray, low: Int, high: Int): IntArray {
    if (low > high) return nums
    val pivotIndex = findPivot(nums, low, high)

    quickSort(nums,low, pivotIndex-1)
    quickSort(nums, pivotIndex+1, high)

    return nums
}

fun findPivot(nums: IntArray, low: Int, high: Int): Int{

    val p = nums[high]

    var i = low
    var j = low
    while (j < high){
        if(nums[j] < p){
            val temp = nums[i]
            nums[i++] = nums[j]
            nums[j] = temp
        }
        j++
    }
    val temp = nums[high]
    nums[high] = nums[i]
    nums[i] = temp

    return i
}

private class QLkList(root: ListNode? = null){
    data class ListNode(var value: Int, var next: ListNode? = null)

    var head = root

    fun insertFromBeginning(num: Int){
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
            insertFromBeginning(num)
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

    fun deleteAtMiddle(index: Int) {
        var temp = head
        for (i in 2 until index){
            temp = temp?.next
        }

        temp?.next = temp?.next?.next
    }

    fun deleteAtEnd(){
        var temp = head
        while (temp?.next != null){
            temp = temp.next
        }

        temp?.next = null
    }

    fun sort(){
        head = quickSort(head, getTail(head))
    }

    fun getTail(node: ListNode?): ListNode?{
        var tail = node
        while (tail?.next != null){
            tail = tail.next
        }
        return tail
    }

    fun quickSort(start: ListNode?, end: ListNode?): ListNode?{
        if (start == null || start == end) return start

        val (newHead, newTail, newPivot) = findPivot(start, end)

        val sortedLeft = if (newHead != newPivot){
            var temp = newHead
            while (temp?.next != newPivot){
                temp = temp?.next
            }
            temp?.next = null
            quickSort(newHead, temp).also {
                while (temp?.next != null){
                    temp = temp!!.next
                }
                temp?.next = newPivot
            }
        }else newPivot

        newPivot?.next = quickSort(newPivot?.next, newTail)

        return sortedLeft
    }

    fun findPivot(start: ListNode?, end: ListNode?): Triple<ListNode?, ListNode?, ListNode?> {

        var pivot = end
        var current = start
        var prev: ListNode? = null
        var tail = pivot

        var newHead: ListNode? = null

        while (current != pivot){
            if (current != null && current.value < pivot!!.value){
                if (newHead == null) newHead = current
                prev = current
                current = current.next
            }else{
                val next = current?.next
                prev?.next = next
                current?.next = null
                tail?.next = current

                tail = current
                current = next
            }
        }

        if (newHead == null){
            newHead = pivot
        }

        return Triple(newHead, tail, pivot)
    }

    fun display() {
        var current = head
        while (current != null) {
            print("${current.value} -> ")
            current = current.next
        }
        println("null")
    }
}