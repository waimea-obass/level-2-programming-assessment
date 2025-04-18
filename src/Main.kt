@file:Suppress("NAME_SHADOWING", "UNUSED_CHANGED_VALUE")

/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   OK GUNS
 * Project Author: Ollie Bass
 * GitHub Repo:    https://github.com/waimea-obass/level-2-programming-assessment
 * ---------------------------------------------------------------------
 * Notes: This is a game called OK Guns
 * =====================================================================
 */

//These are the constant values that are used globally
//SHOOT, PROTECT and RELOAD are the keys players press in order to do their action
const val SHOOT = 'S'
const val PROTECT = 'P'
const val RELOAD = 'R'
const val EMPTY = 0
fun main() {
    val playerNames = mutableListOf<String>()
    val playerBullets = mutableListOf<Int>()
    val playerHealths = mutableListOf<Int>()
    val playerActionNames = mutableListOf<String>()
    val playerActions = mutableListOf<Char>()
    playerHealths.add(3)
    playerHealths.add(3)

    showInstructions()

    getPlayer(playerNames)
    setupBullets(playerBullets)



    //Starts game with the while loop
    while (true) {
        // Allows each player to have a turn
        for (player in listOf(0, 1)) {

            val opponent = if (player == 0) 1 else 0
            //The current player swaps from player 1 to player 2 once the player 1 finishes their turn
            //Vice versa with the opponent
            val currentPlayer = playerNames[player]
            val currentOpponent = playerNames[opponent]

            //Lets the player choose what they want to do
            println("Look away $currentOpponent!")
            println("$currentPlayer, you have " + playerBullets[player] + " bullet/s")

            while(true) {
                when (val action = getAction(currentPlayer, playerActions)) {
                    SHOOT -> {
                        //This function checks if you have enough bullets to shoot. If you don't it will return false, and you will have to do it again
                        if (checkBullets(playerBullets[player])) {
                            playerActions.add(action)
                            println(playerActions)
                            playerBullets[player]--
                            println("You shot, congrats!".red())
                            //actionList holds the actions of both players
                            playerActionNames.add("SHOOT")
                            //After checking that you have a viable amount of bullets to shoot, you are allowed to shoot

                            //The function gap adds spaces so the next player cannot see what the previous player did
                            gap()
                            break
                        }
                        else {
                            continue
                        }
                    }

                    PROTECT -> {
                        //Protecting stops you from getting damaged if the other player decides to shoot.
                        println("You have protected yourself!".green())
                        playerActionNames.add("PROTECT")
                        playerActions.add(action)
                        println(playerActions)
                        gap()
                        break
                    }

                    RELOAD -> {
                        //Reloading gives the player 1 bullet, with the risk of being shot
                        playerBullets[player]++
                        println("You reloaded, risky!".blue())
                        playerActions.add(action)
                        println(playerActions)
                        playerActionNames.add("RELOAD")
                        gap()
                        break
                    }
                }
            }
        }

        //--------------------------------------AFTERMATH-------------------------------------------------------------------------
        //After both players have chosen their choices, the aftermath will show what consequences/rewards they get

            println("-------------------------------------AFTERMATH-------------------------------------")
            println()
            println()
            println("Thank you, here's the aftermath!")
            println()
            println()
        println(playerActionNames)


        println(playerNames[0] + " chose to " + playerActionNames[0] + " and " + playerNames[1] + " chose to " + playerActionNames[1])

        // Show the result of the players actions
        println(showAftermath(playerActions, playerNames, playerHealths, ""))
        // And clear them out for next time
        playerActions.clear()
        playerActionNames.clear()

        println()
        println(playerNames[0] + ", you have " + playerHealths[0] + " health and " + playerNames[1] + ",  you have " + playerHealths[1] + " health.")

        if (playerHealths[0] == EMPTY) {
            println("Congratulations" + playerNames[1] + ", you win!")
            break
        } else if (playerHealths[1] == EMPTY) {
            println("Congratulations" + playerNames[0] + ", you win!")
            break
        } else {
            println("Nobody died yet so lets continue!")
            println()
            continue
        }

    }


}


fun showInstructions() {
    //Game instructions
    println()
    println("--------------------WELCOME TO OK GUNS!--------------------------------------------------")
    println()
    println("This game is very simple.")
    println("Players will take turns choosing an action, either to Shoot or Reload their guns or to Protect themselves from harm.")
    println("To be able to shoot you must have a bullet and when you shoot you lose a bullet. In order to get bullets you must reload, but when you reload is the only time that you are vulnerable to getting shot.")
    println("When you are shot you lose 1 of your 3 health.")
    println()
    println("This game is set so when player 1 takes a turn player 2 must look away so the actions the players' choose is anonymous. Then you will learn the aftermath of your choices. Eg: Player 1 tried to reload but player2 shot them")
    println("The aim of the game is to get the other players health to 0")
    println()
    println("Have fun!")
}

fun gap() {
    println("\n".repeat(50))
}



fun getString(prompt: String): String {
    var userInput: String
    while (true) {
        print(prompt)

        userInput = readln()
        if (userInput.isNotBlank()) break
    }
    return userInput
}

fun getPlayer(playerNames: MutableList<String>) {
    //Gets player

    val player1 = getString("Player 1, what is your name? ")
    val player2 = getString("Player 2, what is your name? ")
    playerNames.add(player1)
    playerNames.add(player2)
    }
fun setupBullets(bulletsList: MutableList<Int>) {
    bulletsList.add(1)
    bulletsList.add(1)
}



fun getAction(playerName: String, playerActions: MutableList<Char> ): Char {
    //Gets player's action as a Char which corresponds to a constant value
    while(true) {
        val playerAction = getString("$playerName, what do you want to do? Either 'S': Shoot 'R': Reload or 'P': Protect: ")
        val action = playerAction.uppercase().first()

        if (action == SHOOT || action == RELOAD || action == PROTECT) {


            return action
        }

    }

}


fun checkBullets(numBullets: Int ): Boolean {

    if (numBullets != EMPTY) {
        println("You have enough bullets to shoot!")
        return true
    }
    else  {
        println("You don't have enough bullets to shoot!")
        return false
    }
}
fun showAftermath(playerActions: MutableList<Char>, playerNames: List<String>, playerHealths: MutableList<Int>, aftermath: String) : String {
    if (playerActions[0] == SHOOT && playerActions[1] == PROTECT) {
        val aftermath = (playerNames[0] + " you tried to shoot but " + playerNames[1] + " protected")
        return aftermath
    }
    else if (playerActions[1] == SHOOT && playerActions[0] == PROTECT) {
        val aftermath = (playerNames[1] + " you tried to shoot but " + playerNames[0] + " protected")
        return aftermath
    }
    else if (playerActions[0] == RELOAD && playerActions[1] == SHOOT) {
        val aftermath = (playerNames[1] + ", you shot!")
        playerHealths[0]--
        return aftermath
    }
    else if (playerActions[1] == RELOAD && playerActions[0] == SHOOT) {
        val aftermath = (playerNames[1] + ", you shot!")
        playerHealths[1]--
        return aftermath
    }
    else if (playerActions[0] == SHOOT && playerActions[1] == SHOOT) {
        val aftermath = (playerNames[0] + " and " + playerNames[1] + ", you both shot which means nothing happens other than you both lose a bullet!")
        return aftermath
    }
    else if (playerActions[1] == PROTECT && playerActions[0] == RELOAD || playerActions[0] == PROTECT && playerActions[1] == RELOAD || playerActions[1] == RELOAD && playerActions[0] == RELOAD || playerActions[0] == PROTECT && playerActions[1] == PROTECT) {
        val aftermath = ("Nothing happened")
        return aftermath

    }
    else {
        return aftermath
    }
}





