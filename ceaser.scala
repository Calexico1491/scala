import scala.io.Source
import scala.collection.mutable.ArrayBuffer




//Checks if letter is within letter limits
//def badCheck(x:Int): Boolean if !(assert( x < 65 ) | assert(91 to 96 contains x) | assert(x > 123)) 
//Checks if letter is capital or
def asc (x:Char): Int = if (x.isLetter) x.toInt else return 32
def bigCheck(x: Int): Boolean = if (x > 96 ) true else false
def stillLower(x: Int): Boolean = if (x < 123 & x > 96) true else false
def stillUpper (x: Int): Boolean = if (x > 64 & x < 91) true else false
def newNumber(x: Int, y: Int): Int = x - y
def negativeShift(x: Int, y: Int): Int = if (y > 0) (x - y + 26) else (x - y - 26)
def numberChanged(x: Char, y: Char): Boolean = if ((x.toInt - args(0).toInt) == y.toInt | (x.toInt - args(0).toInt + 26) == y.toInt) true else false
    


//val sentence = args(1)
//val ceaser = sentence.toList
val altered = ArrayBuffer[Char]()

for (letter <- args(1).toList) {
    if (bigCheck(asc(letter))){ 
        // letter is lowercase
        if (stillLower(newNumber(asc(letter), args(0).toInt))) {
            altered += newNumber(asc(letter), args(0).toInt).toChar
        }
        else {
            altered += negativeShift(asc(letter), args(0).toInt).toChar
        }
    }
    else{
        //Letter is uppercase
        if (stillUpper(newNumber(asc(letter), args(0).toInt))) {
            altered += newNumber(asc(letter), args(0).toInt).toChar
        }
        else {
            println(args(0).toInt)
            altered += negativeShift(asc(letter), args(0).toInt).toChar
        }
    }
}

//assert(numberChanged(ceaser(0), altered(0)))
//assert(numberChanged(ceaser(1), altered(1)))

//println(ceaser)
println(altered)
    
//ABCDEFGHIJKLMNOPQRSTUVWXYZ