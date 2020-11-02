

fun main(){

    ///////
    //Variables Declaration

    //Declaration of map, map categories (keys) and respective quotes (values
    val mapOfQuotes: MutableMap<String, MutableList<String>> = mutableMapOf<String, MutableList<String>>()
    mapOfQuotes["Motivational"] = mutableListOf("It always seems impossible until it's done.", "Start where you are. Use what you have. Do what you can.", "Aim for the moon. If you miss, you may hit a star.", "If you fell down yesterday, stand up today.")
    mapOfQuotes["Life"] = mutableListOf("One More Quote","He who has a why to live can bear almost any how.", "We do not remember days, we remember moments.", "Life is a lively process of becoming.", "Life is a lively process of becoming.")
    mapOfQuotes["Funny"] = mutableListOf("A day without sunshine is like, you know, night.", "Do not take life too seriously. You will never get out of it alive", "What's another word for Thesaurus?", "Never take a solemn oath. People think you mean it.")
    mapOfQuotes["Love"] = mutableListOf("Love has no age, no limit; and no death.", "Life is the flower for which love is the honey.", "Great thoughts come from the heart.", "To love and be loved is to feel the sun from both sides.")

    //Here I select the category I want a quote from
    val selectCategory = "Life"


    //Finished variables declaration
    ///////

    //I than create a counter and an if + for condition to get the number of quotes the selected category haves. This is needed to randomized the quote in a further step
    var counterOfQuotes = 0
    fun quotesCounter() {
        counterOfQuotes = 0
        if (mapOfQuotes.containsKey(selectCategory)) {
            for (value in mapOfQuotes[selectCategory]!!) {
                counterOfQuotes += 1
            }
        } else {
            println("We do not have the category: ${selectCategory}. Please select other.")
        }
    }
    quotesCounter() //I execute the fun quotesCounter to update my counter to the number of elements the selected category haves



    fun quotesRandomInt(quoteLastIndex: Int): Int {
        return (0 until quoteLastIndex).random()
    } //this function is only to create a random number between 0 and the last index of selected category
    val randomInt = quotesRandomInt(counterOfQuotes) //wich I'll then store into a variable

    fun printCategoryQuote(category: String, randomNumber: Int) {
        println(mapOfQuotes[category]?.get(randomNumber))
    } //function to print a random quote of selected cateogory

    fun printTotalRandomQuote() {
        val listOfCategories = mapOfQuotes.keys.toMutableList()
        val listOfCategoriesSize = mapOfQuotes.size
        val randomIntCat: Int = (0 until listOfCategoriesSize).random()
        val randomCategory = listOfCategories[randomIntCat]
        println(mapOfQuotes[randomCategory]?.get(randomInt))
    } //funtion to print a total random quote from between all categories

    printCategoryQuote(selectCategory, randomInt)
    printTotalRandomQuote()

    //Create a random number with a range limited bu the number of quotes that exist in the selected category and print quote
//    val randomInt: Int = (0 until counterOfQuotes).random()
//    println(mapOfQuotes[selectCategory]?.get(randomInt))
//
//    //These lines select a random category and print a random quote from it
//    val listOfCategories = mapOfQuotes.keys.toMutableList()
//    val listOfCategoriesSize = mapOfQuotes.size
//    val randomIntCat: Int = (0 until listOfCategoriesSize).random()
//    println(listOfCategories[randomIntCat]) //dont need this line. Only to check is selection is working right
//    val randomCategory = listOfCategories[randomIntCat]
//    println(mapOfQuotes[randomCategory]?.get(randomInt)) //todo este randomInt está a ir à selectedcategory. Tem que ir antes à randomCategory para não ir outofbounds

}