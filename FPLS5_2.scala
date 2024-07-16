case class Book(title: String, author: String, isbn: String)

var library: Set[Book] = Set(
    Book("Title1", "Author1", "1111"),
    Book("Title2", "Author2", "1112"),
    Book("Title3", "Author3", "1113"),
    Book("Title4", "Author4", "1114")
)

def printCurrentLibrary() = {
  println("Current library collection:")
  library.foreach ( book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
}

def addBook() = {
    println("\n****ADD A NEW BOOK****")

    println("Enter Book Title:")
    val title = scala.io.StdIn.readLine()
    println("Enter Book Author:")
    val author = scala.io.StdIn.readLine()
    println("Enter Book ISBN:")
    val isbn = scala.io.StdIn.readLine()

    val newBook = Book(title, author, isbn)
    library = library + newBook

    printCurrentLibrary()
}

var updatedLibrary: Set[Book]  = Set()

def printUpdatedLibrary() = {
    println("Current library collection:")
    updatedLibrary.foreach ( book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
}

def removeBook() = {
    println("\n****REMOVE A BOOK****")

    println("Enter the ISBN of the book to remove:")
    val removeISBN = scala.io.StdIn.readLine()

    library.foreach { book =>
        if (book.isbn != removeISBN) {
            updatedLibrary = updatedLibrary + book
        }
    }

    library = updatedLibrary

    printUpdatedLibrary()
}

def checkBook() = {
    println("\n****CHECK A BOOK BY ISBN****")

    println("Enter the ISBN of the book to check:")
    val checkISBN = scala.io.StdIn.readLine()

    var found = false

    library.foreach { book =>
        if (book.isbn == checkISBN) {
            found = true
        
            if (found) {
                println(s"Book found.\nTitle: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
            }
        }
    }

    if (!found) {
        println(s"Book with ISBN $checkISBN is not in the library.")
    }
    
}

def checkBookTitle() = {
    println("\n****CHECK A BOOK BY TITLE****")

    println("Enter the Title of the book to check:")
    val checkTitle = scala.io.StdIn.readLine().toLowerCase

    var found = false

    library.foreach { book =>
        if (book.title.toLowerCase() == checkTitle) {
            found = true
        
            if (found) {
                println(s"Book found.\nTitle: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
            }
        }
    }

    if (!found) {
        println(s"Book with title $checkTitle is not in the library.")
    }
    
}

def checkBookAuthor() = {
    println("\n****CHECK A BOOKS BY AUTHOR****")

    println("Enter the Author of the book to check:")
    val checkAuthor = scala.io.StdIn.readLine().toLowerCase

    var found = false

    library.foreach { book =>
        if (book.author.toLowerCase() == checkAuthor) {
           
            
            if (!found) {
                println(s"Books found by author ${book.author}.")
                 found = true
            }
                println(s"Title: ${book.title}, ISBN: ${book.isbn}")
            
        }
    }

    if (!found) {
        println(s"Books with author $checkAuthor are not in the library.")
    }
    
}

@main def q2library() = {
    printCurrentLibrary()
    addBook()
    removeBook()
    checkBook()
    checkBookTitle()
    checkBookAuthor()
}