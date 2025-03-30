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
const val DOUBLE = 'D'
const val EMPTY = 0

fun main() {
    val playerList = mutableListOf<String>()
    val bulletsList = mutableListOf<Int>()


    getPlayer(playerList)
    setupBullets(bulletsList)

    println()


        //Shows players their current bullet count. (This changes as players reload and shoot)
        println(playerList[0] + ", you have " + bulletsList[0] + " amount of bullets")
        println(playerList[1] + ", you have " + bulletsList[1] + " amount of bullets")
    //Starts game with the while loop
    while (true) {
        // Player 1
        while (true) {
            //Lets the player choose what they want to do
            val action = getActionP1(playerList[0])

            when (action) {
                SHOOT -> {
                    if (checkBullets(bulletsList[0]) == true) {
                        bulletsList[0]--
                        println("You shot, congrats!")
                        // etc...

                        break
                    }
                }

                PROTECT -> {
                    println("You have protected yourself!")
                    break
                }

                RELOAD -> {
                    bulletsList[0]++
                    println("You reloaded, risky!")
                    break
                }
            }
        }
        //
//        doAction(playerList[0])
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

fun getPlayer(playerList: MutableList<String>) {
    //Gets player

    val player1 = getString("Player 1, what is your name? ")
    val player2 = getString("Player 2, what is your name? ")
    playerList.add(player1)
    playerList.add(player2)
    while (true) {
        if (player1.isNotBlank()) break
        if (player2.isNotBlank()) break
    }
}
fun setupBullets(bulletsList: MutableList<Int>) {
    bulletsList.add(0)
    bulletsList.add(0)
}

fun getActionP1(playerName: String): Char {
    while(true) {
        val playerAction =
            getString(" $playerName, what do you want to do? Either 'S': Shoot 'R': Reload or 'P': Protect: ")
        val action = playerAction.uppercase().first()

        println(action)

        if (action == SHOOT || action == RELOAD || action == PROTECT) {
            return action
        }

    }

}

//fun doReload(action: Char): Int {
//        p1Bullets++
//        println("You reloaded! You now have" + p1Bullets + "amount of bullets")
//     }
//    return p1Bullets
//}

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


