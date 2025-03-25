@file:Suppress("NAME_SHADOWING")

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
    val bulletsList = mutableListOf<String>()

    showBullets(bulletsList)
    var player1HP = 3
    var player2HP = 3
    getPlayer(playerList)
    println()


        //Shows players their current bullet count. (This changes as players reload and shoot)
        println(playerList[0] + ", you have " + bulletsList[0] + " amount of bullets")
        println(playerList[1] + ", you have " + bulletsList[1] + " amount of bullets")
    //Starts game with the while loop
    while (true) {
        //Lets the player choose what they want to do
        getActionP1(playerList[0])
        if (action == SHOOT) {
            if (bulletList[0] == 0) {
                println("You don't have any bullets!")
            }
            else if (bulletList[0] != 0) {
                print("You have bullets!")
                val kill = 1
            }
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

fun getPlayer(playerList: MutableList<String>) {
    //Gets player

    val player1 = getString("Player 1, what is your name? ")
    val player2 = getString("Player 2, what is your name? ")
    playerList.add(player1)
    playerList.add(player2)
    while (true) {
        print(playerList)
        if (player1.isNotBlank()) break
        if (player2.isNotBlank()) break
    }
}
fun showBullets(bulletsList: MutableList<String>): String {

    var player1Bullets = 0
    var player2Bullets = 0
    bulletsList.add(player1Bullets.toString())
    bulletsList.add(player2Bullets.toString())
    println(bulletsList.size)
    return ("$bulletsList")

}

fun getActionP1(playerList: String): Char {
    while(true) {
        val playerAction =
            getString("Hey Big " + playerList[0] + ", what do you want to do? Either 'S': Shoot 'R': Reload or 'P': Protect: ")
        val action = playerAction.uppercase().first()

        if (action == SHOOT || action == RELOAD || action == PROTECT) {
            return action
        }
    }

}
fun checkP1Shoot(action: Char, bulletsList: MutableList<String>) {
    if (action == SHOOT)
        if (bulletList[1] != 0) {
            println("You have enough bullets to shoot!")
        }
        else {
            println("You don't have enough bullets to shoot!")
            getActionP1(action)
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


