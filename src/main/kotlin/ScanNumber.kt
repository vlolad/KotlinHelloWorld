import java.util.Scanner

class ScanNumber {

    companion object {
        fun checkInputIsOdd() {
            println("Start checking system")
            println("______________________")

            val sc = Scanner(System.`in`)

            println("Input a number (type = integer)")
            print("Input: ")
            while(!sc.hasNextInt()) {
                println("Please enter the number, not a symbol or text")
                sc.nextLine()
            }
            val x: Int = sc.nextInt()

            if (x % 2 == 0) {
                println("Input is odd")
            } else {
                println("Input is not odd!")
            }
        }
    }
}
