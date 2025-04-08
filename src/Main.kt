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
//    setupHealth(healthList)
    healthList.add(3)
    healthList.add(3)

    getPlayer(playerList)
    setupBullets(bulletsList)


    println()


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
            val action = getAction(currentPlayer)

            when (action) {
                SHOOT -> {
                    //This function checks if you have enough bullets to shoot. If you don't it will return false, and you will have to do it again
                    if (checkBullets(bulletsList[player])) {
                        bulletsList[player]--
                        println("You shot, congrats!")
                        aftermathList.add("SHOOT")
                        //After checking that you have a viable amount of bullets to shoot, you are allowed to shoot
                        println("\n".repeat(20))
                    }
                }

                PROTECT -> {
                    println("You have protected yourself!")
                    aftermathList.add("PROTECT")
                    println("\n".repeat(20))
                }

                RELOAD -> {
                    bulletsList[0]++
                    println("You reloaded, risky!")
                    aftermathList.add("RELOAD")
                    println("\n".repeat(20))
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


            println(playerList[0] + " chose to " + aftermathList[0] + " and " + playerList[1] + " chose to " + aftermathList[1])


        showAftermath(aftermath)
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



fun getAction(playerName: String): Char {
    while(true) {
        val playerAction = getString("$playerName, what do you want to do? Either 'S': Shoot 'R': Reload or 'P': Protect: ")
        val action = playerAction.uppercase().first()
        val aftermathList = mutableListOf<Char>()
        aftermathList.addAll(playerAction.toCharArray().toList())

        if (action == SHOOT || action == RELOAD || action == PROTECT) {
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
fun showAftermath(aftermathList: List<Char>, playerList: List<String>, healthList: MutableList<Int>): String {
    var aftermath = ""
    if (aftermathList[0] == SHOOT && aftermathList[1] == PROTECT) {
        aftermath = (playerList[0] + " you tried to shoot but " + playerList[1] + " protected")
        return aftermath
    }
    else if (aftermathList[1] == SHOOT && aftermathList[0] == PROTECT) {
        aftermath = (playerList[1] + " you tried to shoot but " + playerList[0] + " protected")
        return aftermath
    }
    else if (aftermathList[0] == RELOAD && aftermathList[1] == SHOOT) {
        aftermath = (playerList[1] + ", you shot!")
        healthList[0]--
        return aftermath
    }
    else if (aftermathList[1] == RELOAD && aftermathList[0] == SHOOT) {
        aftermath = (playerList[1] + ", you shot!")
        healthList[1]--
        return aftermath
    }
    else if (aftermathList[0] == SHOOT && aftermathList[1] == SHOOT) {
        aftermath = (playerList[0] + playerList[1] + ", you both shot which means nothing happens other than you both lose a bullet!")
        return aftermath
    }
    else if (aftermathList[1] == PROTECT && aftermathList[0] == RELOAD || aftermathList[0] == PROTECT && aftermathList[1] == RELOAD || aftermathList[1] == RELOAD && aftermathList[0] == RELOAD || aftermathList[0] == PROTECT && aftermathList[1] == PROTECT) {
        aftermath = ("Nothing happened")
        return aftermath

    }
    return aftermath
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


