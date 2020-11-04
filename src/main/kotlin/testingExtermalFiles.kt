import java.io.File
import java.util.*

fun main() {
    //Here I source my quotes.txt file where I have al my quotes saved and nicely formatted to be read by my program
    val fileQuotes = "src/quotes.txt"
    val readQuotes = File(fileQuotes).readLines()

    //Here I filter all categories names and store them in a list to be print out to the user. This way user Knows what categories he can chose
    val myList: MutableList<String> = mutableListOf()
    for (items in readQuotes) {
        if (items.endsWith(".") && items.startsWith(".")) {
            //println("this is my 1 print: $items")
            val temp = items.split(".")
            myList.add(temp[1])
        }
    }
    //println("Here is my list: $myList")

    //Here I select the category I want a quote from.
    //In my TXT file I have category titles in UpperCase and quotes filter in LowerCase to help me better filter it
    //That's why I have in my input request the .toUpperCase method, and in my containsCategory filter .toLowerCase method
    val scanner = Scanner(System.`in`)
    println("Categories -> $myList")
    print("Please choose the category you like or just go for the random quote of the day: ")
    var input = scanner.nextLine().toUpperCase()
    var inputCatFilter = (".$input.")

    //While user does not input a category that I have I will loop my input request until it's true
    //I use inputCatFilter because to check if it's true I have to add . + . to user input to match my txt file format
    while (readQuotes.contains(inputCatFilter) != true) {
        println("we dont have that cat. pls choose again")
        input = scanner.nextLine().toUpperCase()
        inputCatFilter = (".$input.")
    }
    println("we have that category")

    //Once input is valid, I read again my file save into readQuotes variable, do a filter based on the input and save those lines to a new variable
    val containsCategory = readQuotes.filter { it.contains(input.toLowerCase()) }
    val filteredList: MutableList<String> = mutableListOf<String>() //Here I declare an empty mutable List where I will save my filtered quotes to later randomize and print one of them

    //In this loop I go trough all filtered quotes, split and remove filter tag, save quote to filteredList variable
    for (item in containsCategory.indices) {
        val temp = containsCategory[item].split('%')
        filteredList.add(temp[1])
    }

    //In this block I will finally random pick one quote and print it (still need to do random quote print
    println("this is my filteredList: ${filteredList}")
    println(filteredList.size)
}