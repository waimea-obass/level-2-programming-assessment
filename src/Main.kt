@file:Suppress("NAME_SHADOWING", "UNUSED_CHANGED_VALUE")

/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   OK GUNS
 * Project Author: Ollie Bass
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */


const val SHOOT = 'S'
const val PROTECT = 'P'
const val RELOAD = 'R'
//const val DOUBLE = 'D'
const val EMPTY = 0

fun main() {
    val playerList = mutableListOf<String>()
    val bulletsList = mutableListOf<Int>()
    val healthList = mutableListOf<Int>()
    val aftermathList = mutableListOf<String>()
    val aftermathCharList = mutableListOf<Char>()

//    setupHealth(healthList)
    healthList.add(3)
    healthList.add(3)

    showInstructions()

    getPlayer(playerList)
    setupBullets(bulletsList)

    //Shows players their current bullet count. (This changes as players reload and shoot)
    println(playerList[0] + ", you have " + bulletsList[0] + " bullet/s")
    println(playerList[1] + ", you have " + bulletsList[1] + " bullet/s")


    //Starts game with the while loop
    while (true) {

        // Allow each player to have a turn
        for (player in listOf(0, 1)) {
            val opponent = if (player == 0) 1 else 0

            val currentPlayer = playerList[player]
            val currentOpponent = playerList[opponent]

            //Lets the player choose what they want to do
            println("Look away $currentOpponent!")
            val action = getAction(currentPlayer, aftermathCharList)

            when (action) {
                SHOOT -> {
                    //This function checks if you have enough bullets to shoot. If you don't it will return false, and you will have to do it again
                    if (checkBullets(bulletsList[player])) {
                        bulletsList[player]--
                        println("You shot, congrats!".red())
                        aftermathList.add("SHOOT")
                        println(aftermathList)
                        //After checking that you have a viable amount of bullets to shoot, you are allowed to shoot
                        gap()
                    }
                }

                PROTECT -> {
                    println("You have protected yourself!")
                    aftermathList.add("PROTECT")
                    gap()
                }

                RELOAD -> {
                    bulletsList[0]++
                    println("You reloaded, risky!")
                    aftermathList.add("RELOAD")
                    gap()
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
        println(aftermathList)


            println(playerList[0] + " chose to " + aftermathList[0] + " and " + playerList[1] + " chose to " + aftermathList[1])


        showAftermath(aftermathCharList, playerList, healthList, "")
        println()
        println(playerList[0] + ", you have " + healthList[0] + " health and " + playerList[1] + ",  you have " + healthList[1] + " health.")

        if (healthList[0] == EMPTY) {
            println("Congratulations" + playerList[1] + ", you win!")
            break
        } else if (healthList[1] == EMPTY) {
            println("Congratulations" + playerList[0] + ", you win!")
            break
        } else {
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
//fun setupHealth(healthList: MutableList<Int>) {
//    println("Before we start, how much health should Player 1 and Player 2 have?")
//    val player1HP = getString("How much health should player 1 have? ")
//    val player2HP = getString("How much health should you have? " )
//    healthList.add(player1HP.toInt())
//    healthList.add(player2HP.toInt())
//    print(healthList)
//    while (true) {
//        if (player2HP.isNotBlank()) break
//    }
//}

fun getPlayer(playerList: MutableList<String>) {
    //Gets player

    val player1 = getString("Also, Player 1, what is your name? ")
    val player2 = getString("Player 2, what is your name? ")
    playerList.add(player1)
    playerList.add(player2)
    }
fun setupBullets(bulletsList: MutableList<Int>) {
    bulletsList.add(1)
    bulletsList.add(1)
}



fun getAction(playerName: String, aftermathCharList: MutableList<Char> ): Char {
    while(true) {
        val playerAction = getString("$playerName, what do you want to do? Either 'S': Shoot 'R': Reload or 'P': Protect: ")
        val action = playerAction.uppercase().first()

        if (action == SHOOT || action == RELOAD || action == PROTECT) {
            aftermathCharList.add(action)
            println(aftermathCharList)
            return action
        }

    }

}


fun checkBullets(numBullets: Int): Boolean {

    if (numBullets != EMPTY) {
        println("You have enough bullets to shoot!")
        return true
    }
    else  {
        println("You don't have enough bullets to shoot!")
        return false
    }
}
fun showAftermath(aftermathCharList: MutableList<Char>, playerList: List<String>, healthList: MutableList<Int>, aftermath: String) : String {
    if (aftermathCharList[0] == SHOOT && aftermathCharList[1] == PROTECT) {
        val aftermath = (playerList[0] + " you tried to shoot but " + playerList[1] + " protected")
        return aftermath
    }
    else if (aftermathCharList[1] == SHOOT && aftermathCharList[0] == PROTECT) {
        val aftermath = (playerList[1] + " you tried to shoot but " + playerList[0] + " protected")
        return aftermath
    }
    else if (aftermathCharList[0] == RELOAD && aftermathCharList[1] == SHOOT) {
        val aftermath = (playerList[1] + ", you shot!")
        healthList[0]--
        return aftermath
    }
    else if (aftermathCharList[1] == RELOAD && aftermathCharList[0] == SHOOT) {
        val aftermath = (playerList[1] + ", you shot!")
        healthList[1]--
        return aftermath
    }
    else if (aftermathCharList[0] == SHOOT && aftermathCharList[1] == SHOOT) {
        val aftermath = (playerList[0] + playerList[1] + ", you both shot which means nothing happens other than you both lose a bullet!")
        return aftermath
    }
    else if (aftermathCharList[1] == PROTECT && aftermathCharList[0] == RELOAD || aftermathCharList[0] == PROTECT && aftermathCharList[1] == RELOAD || aftermathCharList[1] == RELOAD && aftermathCharList[0] == RELOAD || aftermathCharList[0] == PROTECT && aftermathCharList[1] == PROTECT) {
        val aftermath = ("Nothing happened")
        return aftermath

    }
    else {
        return aftermath
    }
}






////fun checkIfViable(playerAction: String, p1Bullets: MutableList<Int>): Boolean {
//    while (playerAction = SHOOT) {
//        if p1Bullets[0] = 0 {
//            return " don't have enough"
//        }
//        else {
//            return true
//        }
//    }
//}
// fun p1Reload(playerAction: String, p1Bullets: MutableList<Int>): Char {
//     if (playerAction = RELOAD) {
//         p1Bullets.add(1)
//         print(p1Bullets)
//         println("You reloaded! You now have $bulletList amount of bullets")
//     }
//    return playerAction
// }




















//
//            if p1Bullets[0] == EMPTY {
//                println("You don't have enough bullets!")
//                else if p1Bullets != EMPTY {
//                println("Thank you for your choice!")
//            }
//            }
//        }


