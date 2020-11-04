
import java.io.File
import java.util.Scanner

fun main(){
    /*
    //Variables Declaration
    //Declaration of map, map categories (keys) and respective quotes (values
    val mapOfQuotes: MutableMap<String, MutableList<String>> = mutableMapOf<String, MutableList<String>>()
    mapOfQuotes["Motivational"] = mutableListOf("It always seems impossible until it's done.", "Start where you are. Use what you have. Do what you can.", "Aim for the moon. If you miss, you may hit a star.", "If you fell down yesterday, stand up today.")
    mapOfQuotes["Life"] = mutableListOf("One More Quote","He who has a why to live can bear almost any how.", "We do not remember days, we remember moments.", "Life is a lively process of becoming.", "Life is a lively process of becoming.")
    mapOfQuotes["Funny"] = mutableListOf("A day without sunshine is like, you know, night.", "Do not take life too seriously. You will never get out of it alive", "What's another word for Thesaurus?", "Never take a solemn oath. People think you mean it.")
    mapOfQuotes["Love"] = mutableListOf("Love has no age, no limit; and no death.", "Life is the flower for which love is the honey.", "Great thoughts come from the heart.", "To love and be loved is to feel the sun from both sides.")

    //Here I select the category I want a quote from
    val scanner = Scanner(System.`in`)
    print("Please choose the category you like or just go for the random quote of the day: ")
    val input = scanner.nextLine()*/

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
    //println("Here is my list: $myList")

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
    var counterOfQuotes: Int = filteredList.size
    fun printCategoryQuote(selectCategory: String) {
        val randomInt = (0 until counterOfQuotes).random() //here I get a random number that will allow me to print a random quote from a selected category
        println("Quote from: $selectCategory -> ${filteredList[randomInt]}")//print final  quote
    }



    fun printTotalRandomQuote() {
        val categoriesListSize = categoriesList.size //finds list size
        val randomIntCat: Int = (0 until categoriesListSize).random() //creates a random int based on list size
        val randomCategory = categoriesList[randomIntCat] //selects a random category based on previous step

        println("Your random quote is:")
        printCategoryQuote(randomCategory)

        //val randomCounterOfQuotes = (0 until secondCounterOfQuotes).random() //creates a random number between 0 and the last index of random selected category
        //println("Random Quote from: ${randomCategory} -> ${mapOfQuotes[randomCategory]?.get(randomCounterOfQuotes)}") //print final random quote
    } //function to print a total random quote from between all categories

    //printTotalRandomQuote()
    //printCategoryQuote(input)

    if(inputCatFilter != ".RANDOM.") {
        println("this")
        printCategoryQuote(input)
    } else {
        println("that")
        printTotalRandomQuote()
    }

    //TODO random quote pront não está bem. penso que está  a imprimir quote do escrito

}