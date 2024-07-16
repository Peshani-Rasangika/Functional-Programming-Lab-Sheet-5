def fibonacci(x: Int): Int = x match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci(x - 1) + fibonacci(x - 2)
}

def getSequence(n: Int): List[Int] = {
    var list = List[Int]()

    for(i <- 0 until n) {
        list = list :+ fibonacci(i)
    }

    list
}

@main def q2fibonacci() = {
    print("Enter value for first n numbers: ")
    val n = scala.io.StdIn.readInt()
    val list = getSequence(n)
    print(list)
}