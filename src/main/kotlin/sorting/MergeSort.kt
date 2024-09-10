package sorting

private fun main(){
    val arr = intArrayOf(7,3,2,6,1,5)

    val list = makeList(arr)

    println(mergerSort(arr, 0, arr.size -1).joinToString())

//    list.display()

    var temp = list.mergeSort(list.head)

    while (temp!=null){
        print(temp.value)
        temp = temp.next
    }
}

fun mergerSort(nums: IntArray,p: Int, r: Int): IntArray {
    if (p >= r){
        return nums
    }
    val q = (p + r)/2
    mergerSort(nums, p, q)
    mergerSort(nums, q+1, r)
    return merge(nums, p, q, r)
}

private fun makeList(nums: IntArray): MLkList {
    val list = MLkList()
    for (n in nums){
        list.insertAtEnd(n)
    }
    return list
}

fun merge(nums: IntArray, p: Int, q: Int, r: Int): IntArray {
    val left = nums.slice(IntRange(p, q))
    val right = nums.slice(IntRange(q+1, r))

    val n1 = q - p +1
    val n2 = r - q
    var i = 0
    var j = 0
    var k = p

    while (i < n1 && j < n2){
        if (left[i] <= right[j]){
            nums[k++] = left[i++]
        }else{
            nums[k++] = right[j++]
        }
    }

    while (i<n1){
        nums[k++] = left[i++]
    }

    while (j<n2){
        nums[k++] = right[j++]
    }

    return nums
}

private class MLkList(root: ListNode? = null){

    data class ListNode(var value: Int, var next: ListNode? = null)

    var head = root

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

    fun deleteFromMiddle(index: Int){
        var temp = head
        for (i in 2 until index){
            temp = temp?.next
        }
        temp?.next = temp?.next?.next
    }

    fun deleteAtEnd(){
        var temp = head
        while (temp?.next !=null){
            temp = temp.next
        }

        temp?.next = null
    }

    fun sort(){
        if (head == null || head?.next == null) return
        mergeSort(head)
    }
    fun mergeSort(node: ListNode?): ListNode? {
        if (node?.next == null) return node
        val middle = getMiddle(node)
        val nextToMiddle = middle?.next

        middle?.next = null

        val left = mergeSort(node)
        val right = mergeSort(nextToMiddle)

        return merge(left, right)
    }
    fun getMiddle(node: ListNode?): ListNode? {
        if (node == null) return node
        var slow = node
        var fast = node

        while (slow?.next != null && fast?.next?.next != null){
            slow = slow.next
            fast = fast.next?.next
        }

        return slow
    }

    fun merge(left: ListNode?, right: ListNode?): ListNode? {
        if (left == null) return right
        if (right == null) return left

        var resultNode: ListNode? = null

        if (left.value <= right.value){
            resultNode = left
            resultNode.next = merge(left.next, right)
        }else{
            resultNode = right
            resultNode.next = merge(left, right.next)
        }

        return resultNode
    }

    // Display the list
    fun display() {
        var current = head
        while (current != null) {
            print("${current.value} -> ")
            current = current.next
        }
        println("null")
    }
}