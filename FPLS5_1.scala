var list = List.empty[String]
var i = 0

def getProductList() = {
    var product = ""

    print("Enter items:\n")   
    while(product != "done"){
        product = scala.io.StdIn.readLine();

        if(product != "done"){
            list = list :+ product
        }
    }
}

def printProductList() = {
    println("\nList of Products")
    for(i <- 0 to list.length-1){
        println(i+1 + ":" + list(i))
    }
}

def getTotalProducts() = {
    print("\nTotal number of products: " + list.length);
}

@main def q1() = {
    getProductList()
    printProductList()
    getTotalProducts()
}