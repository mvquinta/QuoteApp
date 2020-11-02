
import java.util.Scanner

fun main(){
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
    val input = scanner.nextLine()

    fun printCategoryQuote(selectCategory: String) {
        //I than create a counter and an if + for condition to get the number of quotes the selected category haves. This is needed to randomized the quote in a further step
        var counterOfQuotes = 0
        if (mapOfQuotes.containsKey(selectCategory)) {
            for (value in mapOfQuotes[selectCategory]!!) {
                counterOfQuotes += 1
            }
        } else {
            println("We do not have the category: ${selectCategory}. Please select other.")
        }
        val randomInt = (0 until counterOfQuotes).random() //here I get a random number that will allow me to print a random quote from a selected category
        println("Quote from: $selectCategory -> ${mapOfQuotes[selectCategory]?.get(randomInt)}")//print final  quote
    } //function to print a random quote of selected category

    fun printTotalRandomQuote() {
        val listOfCategories = mapOfQuotes.keys.toMutableList() //turns map keys into a list
        val listOfCategoriesSize = mapOfQuotes.size //finds list size
        val randomIntCat: Int = (0 until listOfCategoriesSize).random() //creates a random int based on list size
        val randomCategory = listOfCategories[randomIntCat] //selects a random category (key) base on previous step

        var secondCounterOfQuotes = 0 //create a counter and if loop to get the number of random selected category
        if (mapOfQuotes.containsKey(randomCategory)) {
            for (value in mapOfQuotes[randomCategory]!!) {
                secondCounterOfQuotes += 1
            }
        }

        val randomCounterOfQuotes = (0 until secondCounterOfQuotes).random() //creates a random number between 0 and the last index of random selected category
        println("Random Quote from: ${randomCategory} -> ${mapOfQuotes[randomCategory]?.get(randomCounterOfQuotes)}") //print final random quote
    } //function to print a total random quote from between all categories

    printCategoryQuote(input)
    printTotalRandomQuote()

}