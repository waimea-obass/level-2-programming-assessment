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
const val HEAL = 'H'
const val DOUBLE = 'D'

fun main() {
    //All the lists that are used
    val playerNames = mutableListOf<String>()
    val playerBullets = mutableListOf<Int>()
    val playerHealths = mutableListOf<Int>()
    val playerActionNames = mutableListOf<String>()
    val playerActions = mutableListOf<Char>()
    //If you don't have a limit on protects you can theoretically protect forever so this list will count them
    val playerProtects = mutableListOf<Int>()

    showInstructions()

    getPlayer(playerNames)
    setupBullets(playerBullets)
    setupHealth(playerHealths)
    setupProtects(playerProtects)

    /**
     *  GAME LOOP STARTS
     */
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
            println()
            println()
            //Shows players' bullet counts
            println("$currentPlayer, you have " + playerBullets[player] + " bullet/s")
            println()
            while(true) {
                when (val action = getAction(currentPlayer)) {
                    SHOOT -> {
                        println()
                        //This function checks if you have enough bullets to shoot. If you don't it will return false, and you will have to do it again
                        //After checking that you have a viable amount of bullets to shoot, you are allowed to shoot
                        if (checkBullets(playerBullets[player])) {
                            println()
                            //Adds the action(which is a Char) into the list this will be useful later when the players see the aftermath of their actions
                            playerActions.add(action)
                            //If they can shoot it takes away a bullet from the player
                            playerBullets[player]--
                            //The player didn't choose PROTECT so the count resets
                            playerProtects[player] = 0
                            println("You shot, congrats!".red())
                            playerActionNames.add("SHOOT")

                            //This lets the player look at the action they did before going to the next player
                            endTurn()
                            //The function gap adds spaces so the next player cannot see what the previous player did
                            gap()
                            break
                        }
                        else {
                            continue
                        }
                    }

                    PROTECT -> {
                        println()
                        if (checkProtects(playerProtects[player])) {
                            //Protecting stops you from getting damaged if the other player decides to shoot.
                            println("You have protected yourself!".green())
                            playerActionNames.add("PROTECT")
                            playerProtects[player]++
                            playerActions.add(action)
                            endTurn()
                            gap()
                            break
                        }
                    }

                    RELOAD -> {
                        println()
                        //Reloading gives the player 1 bullet, with the risk of being shot
                        playerBullets[player]++
                        println("You reloaded, risky!".blue())
                        playerActions.add(action)
                        playerActionNames.add("RELOAD")
                        playerProtects[player] = 0
                        endTurn()
                        gap()
                        break
                    }
                    HEAL -> {
                        println()
                        playerHealths[player]++
                        println("You heal riskily, if you get shot now it's bad!".red())
                        playerActions.add(action)
                        playerActionNames.add("HEAL")
                        playerProtects[player] = 0
                        endTurn()
                        gap()
                        break
                    }
                }
            }
        }

        /**
         * --------------------------------------AFTERMATH-------------------------------------------------------------------------
         *         After both players have chosen their choices, the aftermath will show what consequences/rewards they get
         */


        println("-------------------------------------AFTERMATH-------------------------------------------------")
        println()
        println("Thank you, here's the aftermath!")
        println()

        //Says what they did
        println(playerNames[0] + " chose to " + playerActionNames[0] + " and " + playerNames[1] + " chose to " + playerActionNames[1])
        println()
        // Show the result of the players actions
        println(showAftermath(playerActions, playerNames, playerHealths, ""))
        println()
        // And clear them out for next time
        playerActions.clear()
        playerActionNames.clear()

        println()
        println(playerNames[0] + ", you have " + playerHealths[0] + " health and " + playerNames[1] + " has " + playerHealths[1] + " health.")
        //Checks to see whether a player has won or not and congratulates them if they do
        if (playerHealths[0] == 0) {
            println("Congratulations ".yellow() + playerNames[1].yellow() + ", you win!".yellow())
            break
        } else if (playerHealths[1] == 0) {
            println("Congratulations ".yellow() + playerNames[0].yellow() + " you win!".yellow())
            break
        } else {
            //If nobody dies, the game goes onto the next round
            println("Nobody has died yet so lets continue!")
            println()
            println("-----------------------------------------------------------------------------------------")
            println()
            endTurn()
            continue
        }

    }


}


fun showInstructions() {
    //Game instructions
    println()
    println("--------------------WELCOME TO OK GUNS!--------------------------------------------------".yellow())
    println()
    println("This game is very simple.")
    println("Players will take turns choosing an action, either to Shoot or Reload their guns or to Protect themselves from harm.")
    println("To be able to shoot you must have a bullet and when you shoot you lose a bullet. In order to get bullets you must reload, but when you reload is the only time that you are vulnerable to getting shot.")
    println("When you are shot you lose 1 of your 3 health.")
    println()
    println("This game is set so when player 1 takes a turn player 2 must look away so the actions the players' choose is anonymous. Then you will learn the aftermath of your choices. Eg: Player 1 tried to reload but Player 2 shot them")
    println("The aim of the game is to get the other players health to 0")
    println()
    println("Have fun!")
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
fun setupBullets(playerBullets: MutableList<Int>) {
    //Adds each players' bullets into the list
    playerBullets.add(1)
    playerBullets.add(1)
}
fun setupHealth(playerHealths: MutableList<Int>) {
    //Adds each players' health into the list
    playerHealths.add(3)
    playerHealths.add(3)
}
fun setupProtects(playerProtects: MutableList<Int>) {
    playerProtects.add(0)
    playerProtects.add(0)
}


/**
 * This function asks the player for an Action, it only returns if valid
 */
fun getAction(playerName: String ): Char {
    //Gets player's action as a Char which corresponds to a constant value
    while(true) {
        val playerAction = getString("$playerName, what do you want to do? Either 'S': Shoot 'R': Reload or 'P': Protect: ")
        val action = playerAction.uppercase().first()
    //Only returns if the action is valid
        if (action == SHOOT || action == RELOAD || action == PROTECT || action == HEAL || action == DOUBLE) {
            return action
        }

    }

}

/**
 * If you don't have any bullets you cannot shoot, this makes sure that you have enough
 */

fun checkBullets(numBullets: Int ): Boolean {
    if (numBullets != 0) {
        println("You have enough bullets to shoot!".blue())
        return true
    }
    else  {
        println("You don't have enough bullets to shoot!".red())
        return false
    }
}

/**
 * If you don't have a limit on protects in a row you can theoretically protect forever and the game never ends!
 * This makes it so if you choose to PROTECT too much in a row, (3 times) you can't
 */
fun checkProtects(numProtects: Int ): Boolean {

    if (numProtects != 3 ) {
        return true
    }
    else  {
        println("You have used $numProtects PROTECTS in a row! Be more original! ".red())
        return false
    }
}

fun gap() {
    println("\n".repeat(50))
}

fun endTurn() {
    getString("Press any letter to continue:")
}

/**
 * This function takes both of the player's actions and determines which aftermath the players get.
 */
fun showAftermath(playerActions: MutableList<Char>, playerNames: List<String>, playerHealths: MutableList<Int>, aftermath: String) : String {
    //This is a list of every combination of possible outcomes. This function shows the players what happened as a result of their actions.
    if (playerActions[0] == SHOOT && playerActions[1] == PROTECT) {
        val aftermath = (playerNames[0] + " you tried to shoot but " + playerNames[1] + " protected")
        return aftermath
    } else if (playerActions[1] == SHOOT && playerActions[0] == PROTECT) {
        val aftermath = (playerNames[1] + " you tried to shoot but " + playerNames[0] + " protected")
        return aftermath
    } else if (playerActions[0] == RELOAD && playerActions[1] == SHOOT) {
        val aftermath = (playerNames[1] + ", you shot!")
        playerHealths[0]--
        return aftermath
    } else if (playerActions[1] == RELOAD && playerActions[0] == SHOOT) {
        val aftermath = (playerNames[0] + ", you shot!")
        playerHealths[1]--
        return aftermath
    } else if (playerActions[0] == SHOOT && playerActions[1] == SHOOT) {
        val aftermath =
            (playerNames[0] + " and " + playerNames[1] + ", you both shot which means nothing happens other than you both lose a bullet!")
        return aftermath
    } else if (playerActions[1] == PROTECT && playerActions[0] == RELOAD || playerActions[0] == PROTECT && playerActions[1] == RELOAD || playerActions[1] == RELOAD && playerActions[0] == RELOAD || playerActions[0] == PROTECT && playerActions[1] == PROTECT) {
        val aftermath = ("Nothing happened")
        return aftermath

    } else if (playerActions[0] == HEAL && playerActions[1] == SHOOT) {
        val aftermath =
            (playerNames[0] + " you tried to heal but " + playerNames[1] + " shot you losing 2 health instead of 1!!")
        playerHealths[0]--
        return aftermath
    } else if (playerActions[0] == HEAL && playerActions[1] == RELOAD || playerActions[1] == PROTECT) {
        val aftermath = (playerNames[0] + " you healed successfully as " + playerNames[1] + " didn't shoot")
        playerHealths[0]++
        return aftermath
    }
        else if (playerActions[1] == HEAL && playerActions[0] == SHOOT) {
            val aftermath = (playerNames[1] + " you tried to heal but " + playerNames[0] + " shot you losing 2 health instead of 1!!")
            playerHealths[1]--
            return aftermath
        } else if (playerActions[1] == HEAL && playerActions[0] == RELOAD || playerActions[0] == PROTECT) {
            val aftermath = (playerNames[1] + " you healed successfully as " + playerNames[0] + " didn't shoot")
            playerHealths[1]++
            return aftermath
    } else {
        return aftermath
    }
}






