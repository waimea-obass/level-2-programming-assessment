# Results of Testing

The test results show the actual outcome of the testing, following the [Test Plan](test-plan.md)

---

## Game Setup + All lists (playerNames, playerBullets, playerActions, playerActionNames, playerHealths)

All lists should contain their respected items and be the right type (playerActions is a Char and playerBullets is an Int). The player's should input their name and action and the code should store that information. The bullets should start at 1 each and contain both players bullets. This is the same for the lists of the players' healths and actions too.

### Test Data Used

I will run the code multiple times to test if they contain the right contents and clear when wanted to and don't include/allow any illegal inputs

### Test Result

![List Testing.gif](images/ListTesting.gif)

All lists do their respective functions. It asks for the players names and uses them throughout. The bullet number of the players goes up when reloading and down when shooting. It also clears the lists after the round is over. Each player's healths also go down when being shot successfully. 

---

## Player's taking turns and finishing rounds

Player's take 1 turn each to choose their action. Then, the aftermath of how those actions collide after they choose.

### Test Data Used

The players' turns are in a for loop of (0, 1) (Player 1 and 2) which loops back around when it is the second player's turn and ends once each player has had their turn

### Test Result

![playerTurns.png](images/PlayerTurns.gif)

When taking a turn the first text you see tells the other player to look away, so you can do your action without them seeing. It will ask for the player's action. The player cannot input an illegal action, shooting without a bullet will give the user a warning message saying they do not have enough bullets and will make the user have to input another action instead. Also putting an illegal character that isn't s, r or p will make the user retake their action. When the player successfully does their turn it will ask them to type anything in which prints na massive gap so the other player cannot see their action, and now it is the other player's turn. When that player finishes their turn it goes to the aftermath section of the game.
When the aftermath is over and all players have read what happened and the game continues onto the next round it will ask for a player to input a random character in order to move onto the next round. This is so it won't start the next round until both players have read what happened.

---
## Player's winning and showing aftermath

When one or the other players health is 0, the game ends and the other player should win. Depending on the combination of actions, what the aftermath shows/returns as should be different

## Test Data Used

The player should be able to break out of the loop by winning and not be stuck in a forever loop. I will also test to see how the health dwindles as actions happen. I also tested every combination of aftermath to see if it showed the correct text.


