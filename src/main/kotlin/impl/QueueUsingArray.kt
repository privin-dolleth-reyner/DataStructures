package impl

import javax.naming.SizeLimitExceededException

class QueueUsingArray(private val capacity: Int) {

    private var front: Int = 0
    private var rear: Int = 0
    private var arr = IntArray(capacity)

    fun enqueue(item:Int){
        if (rear >= capacity) throw SizeLimitExceededException(" Queue is full")
        arr[rear] = item
        rear++
    }

    fun poll(): Int{
        if (rear == front ) throw Exception(" Queue is empty")
        val n = arr[0]
        for (i in 0 until rear){
            arr[i] = arr[i+1]
        }
        rear--
        return n
    }

    fun peek(): Int{
        return arr[front]
    }

    fun print(){
        for (i in front until rear){
            print(arr[i])
        }
    }
}

fun main(){
    val queue = QueueUsingArray(5)
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    println(queue.peek())
    println(queue.poll())
    queue.print()
}