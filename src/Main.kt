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
    val p1Bullets = mutableListOf<Int>()
    val p2Bullets = mutableListOf<Int>()
    var player1HP = 3
    var player2HP = 3
    getPlayer(playerList)
    println()
    p1Bullets.add(EMPTY)
    p2Bullets.add(EMPTY)

    //Starts game with the while loop
    while (true) {
        //Shows players their current bullet count. (This changes as players reload and shoot)
        showP1Bullets(playerList[0] + ", you have $p1Bullets amount of bullets")
        showP2Bullets(playerList[1] + ", you have $p2Bullets amount of bullets")

        //Lets the player choose what they want to do
        getActionP1(playerList[0])
    //check(checkIfViable())
        //getActionP2(playerList[1])
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
fun showP1Bullets(p1Bullets: String): Int {

    return p1Bullets.count()
}
fun showP2Bullets(p2Bullets: String): Int {

    return p2Bullets.count()
}

fun getActionP1(playerAction: String): String {
    val playerAction = getString("Player 1, what do you want to do? Either 'S': [Shoot] " +
            "'R': Reload or 'P': Protect")
    if (playerAction.isNotBlank()) {
        println("Thank you for choosing an option")
    }
            return  playerAction
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
 fun p1Reload(playerAction: String, p1Bullets: MutableList<Int>): Boolean {
     if (playerAction == RELOAD) {
         p1Bullets.add(1)
     }
 }




















//
//            if p1Bullets[0] == EMPTY {
//                println("You don't have enough bullets!")
//                else if p1Bullets != EMPTY {
//                println("Thank you for your choice!")
//            }
//            }
//        }


