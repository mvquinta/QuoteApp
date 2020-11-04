
import java.io.File
import java.util.Scanner

fun main(){
    //Here I source my quotes.txt file where I have al my quotes saved and nicely formatted to be read by my program
    val fileQuotes = "src/quotes.txt"
    val readQuotes = File(fileQuotes).readLines()

    //Here I filter all categories names and store them in a list to be print out to the user. This way user Knows what categories he can chose
    val categoriesList: MutableList<String> = mutableListOf()
    for (items in readQuotes) {
        if (items.endsWith(".") && items.startsWith(".")) {
            //println("this is my 1 print: $items")
            val temp = items.split(".")
            categoriesList.add(temp[1])
        }
    }

    //Here I select the category I want a quote from.
    //In my TXT file I have category titles in UpperCase and quotes filter in LowerCase to help me better filter it
    //That's why I have in my input request the .toUpperCase method, and in my containsCategory filter .toLowerCase method
    val scanner = Scanner(System.`in`)
    println("Categories -> $categoriesList")
    print("Please choose the category you like or just go for the random quote of the day: ")
    var input = scanner.nextLine().toUpperCase()
    var inputCatFilter = (".$input.")

    //While user does not input a category that I have I will loop my input request until it's true
    //I use inputCatFilter because to check if it's true I have to add . + . to user input to match my txt file format
    while (readQuotes.contains(inputCatFilter) != true) {
        println("Sorry, We don't have that category. Can you please choose again?")
        input = scanner.nextLine().toUpperCase()
        inputCatFilter = (".$input.")
    }

    //function to print a quote from the chosen category
    fun printCategoryQuote(selectCategory: String) {
        //Once input is valid, I read again my file save into readQuotes variable, do a filter based on the input and save those lines to a new variable
        val containsCategory = readQuotes.filter { it.contains(input.toLowerCase()) }
        val filteredList: MutableList<String> = mutableListOf<String>() //Here I declare an empty mutable List where I will save my filtered quotes to later randomize and print one of them

        //In this loop I go trough all filtered quotes, split and remove filter tag, save quote to filteredList variable
        for (item in containsCategory.indices) {
            val temp = containsCategory[item].split('%')
            filteredList.add(temp[1])
        }
        //In this block I will finally random pick one quote and print it
        val counterOfQuotes: Int = filteredList.size
        val randomInt = (0 until counterOfQuotes).random() //here I get a random number that will allow me to print a random quote from a selected category
        println("Quote from: $selectCategory -> ${filteredList[randomInt]}")//print final  quote
    }

    //function to print a total random quote from between all categories
    fun printTotalRandomQuote() {
        val categoriesListSize = categoriesList.size //finds list size
        val randomIntCat: Int = (0 until categoriesListSize).random() //creates a random int based on list size
        val randomCategory = categoriesList[randomIntCat] //selects a random category based on previous step

        //Once input is valid, I read again my file save into readQuotes variable, do a filter based on the input and save those lines to a new variable
        val containsRandomCategory = readQuotes.filter { it.contains(randomCategory.toLowerCase()) }
        val filteredRandomList: MutableList<String> = mutableListOf<String>() //Here I declare an empty mutable List where I will save my filtered quotes to later randomize and print one of them

        //In this loop I go trough all filtered quotes, split and remove filter tag, save quote to filteredList variable
        for (item in containsRandomCategory.indices) {
            val temp = containsRandomCategory[item].split('%')
            filteredRandomList.add(temp[1])
        }
        //In this block I will finally random pick one quote and print it
        val counterOfQuotes: Int = filteredRandomList.size
        val randomInt = (0 until counterOfQuotes).random() //here I get a random number that will allow me to print a random quote from a selected category
        println("Your random quote is from ${randomCategory} -> ${filteredRandomList[randomInt]}")//print final  quote
    }

    //In these final lines I have a do-while loop that prompts the user if he wants another quote.
    do {
        var anotherQuote: String
        if(inputCatFilter != ".RANDOM.") {
            printCategoryQuote(input)
            println("Do you want another quote?(yes/no)")
            anotherQuote = scanner.nextLine()
        } else {
            printTotalRandomQuote()
            println("Do you want another random quote?(yes/no)")
            anotherQuote = scanner.nextLine()
        }
    } while (anotherQuote == "yes" || anotherQuote == "Yes" || anotherQuote == "y" || anotherQuote == "Y")

}