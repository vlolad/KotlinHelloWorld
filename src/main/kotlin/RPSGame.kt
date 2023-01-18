import kotlin.system.exitProcess

class RPSGame {

    fun startGame() {
        println("Rock-Paper-Scissors game!")
        println("___________________________")

        println("Generating computer choice...")
        val computerChoice = generateComputerChoice()
        println("Generated!")

        val playerOption = getPlayerOption()
        println("Great! Now computing the winner...")
        println("___________________________")

        resultingGame(computerChoice, playerOption)
    }

    enum class Options {
        ROCK,
        PAPER,
        SCISSORS;

        companion object {
            fun size(): Int {
                return Options.values().size
            }

            fun stringValues(): List<String> {
                val strValues = arrayListOf<String>()
                for (opt in Options.values()) {
                    strValues.add(opt.toString())
                }
                return strValues
            }
        }
    }

    private fun generateComputerChoice(): Options {
        val rand = (1..Options.size()).random()
        println("DEBUG = result is -> $rand")

        return when (rand) {
            1 -> Options.ROCK
            2 -> Options.PAPER
            3 -> Options.SCISSORS
            else -> {
                println("ERROR")
                exitProcess(0)
            }
        }
    }

    private fun getPlayerOption(): Options {
        println("Now your choice, player")
        println("Applicable options: ROCK, PAPER, SCISSORS")
        var option = Options.ROCK
        var isValid = false

        while (!isValid) {
            println("Write down your choice:")
            print("Option -> ")
            val userInput = readLine()

            if (userInput != null && userInput in Options.stringValues()) {
                isValid = true
                option = Options.valueOf(userInput)
            } else {
                println("There is no such option, please try again")
            }
        }

        return option
    }

    private fun resultingGame(comp: Options, user: Options) {
        if (comp == user) {
            println("Draw!")
        } else if ((user.equals(Options.ROCK) && comp.equals(Options.SCISSORS)
                    || (user.equals(Options.SCISSORS) && comp.equals(Options.PAPER)))
            || (user.equals(Options.PAPER) && comp.equals(Options.ROCK))
        ) {
            println("User wins!!!")
        } else {
            println("Computer wins!")
        }

        println("User choice: $user, Computer choice: $comp")
    }
}
