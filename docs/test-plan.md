# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Lists of players and player's bullets

Both lists should contain their respected items. The player's should input their name and the code should store that information. The bullets should start at 0 and the list should contain both players bullets

### Test Data To Use

I will run the code multiple times to test if this works and will put in prints to see if the lists are correct, then take those out later.

### Expected Test Result

The playerList should store both players names and the bulletsList should store each players bullets, and change when the number in either the player 1 or two slot is altered. 

---

## Selecting and receiving the correct aftermath (consequences/rewards) for their actions
Players should either use S, P or R to then Shoot, Protect or Reload. 


### Test Data To Use

I will test if the players input works, how the character recognition works, and how the players decision gets treated when faced by the other players decision.

### Expected Test Result

This should output the correct action on both players and then use the correct effect of those actions, such as shooting a reloading player results in their health diminishing by 1 or shooting makes you lose a bullet even if protected.

--- 

## Player's taking turns

Player's take 1 turn each to choose their action. Then, the aftermath of how those actions collide after they choose.

### Test Data To Use

I will put the players' turns are in a for loop of (0, 1) (Player 1 and 2) which loops back around when it is the second player's turn and ends once each player has had their turn. I will do multiple testing to see if this works.

### Expected Test Result

Player 1 and 2's actions should be separate, and they should have an order of their turns. The aftermath of those actions should happen AFTER the player shave chosen their actions.

---

## Player's winning and showing aftermath

When one or the other players health is 0, the game ends and the other player should win. Depending on the combination of actions, what the aftermath shows/returns as should be different

## Test Data Used

I should be able to break out of the loop by winning and not be stuck in a forever loop. I will also test to see how the health dwindles as actions happen and test every combination of aftermath to see if it showed the correct text.


### Expected Test Result

The game should keep looping until this condition is met. Then it should give congratulations to the winning player after the other player's health hits 0. The aftermath it shows should be the correct one that corresponds to the players' actions.

---




