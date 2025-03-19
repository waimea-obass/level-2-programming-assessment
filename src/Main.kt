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
const val EMPTY = 0

fun main() {
    val actions = mutableListOf<String>()
    val playerList = mutableListOf<String>()
    val player1HP = mutableListOf<Int>()
    val player2HP = mutableListOf<Int>()
    val p1Bullets = mutableListOf<Int>()
    getPlayer(playerList)
    println()
    //Shows how many bullets P1 has
    println(showP1Bullets("P1 you have $p1Bullets amount of bullets"))

    getActionP1(playerList[0])


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

fun getActionP1(p1Bullets: String): String {
    var playerAction = getString("Player 1, what do you want to do? Either 'S': Shoot " +
            "'R': Reload or 'P': Protect")
    if (playerAction.isNotBlank()) {
        println("Thank you for choosing an option")
    }
    return  playerAction

}




















//
//            if p1Bullets[0] == EMPTY {
//                println("You don't have enough bullets!")
//                else if p1Bullets != EMPTY {
//                println("Thank you for your choice!")
//            }
//            }
//        }


