How to run:

1. Clone this project
2. In intellij, right click on build.gradle and click on Link gradle project

Note: Any time you are prompted to enter a board size, enter 20. We still need to fix some bugs with a dynamic board size. 


2. Run GraphicsMain.java. 


How to play our game. 

Controls: Simply use WASD to move around the board. There are no other keyboard controls, so stick to these.

Starting the game: When you start the game, you’ll begin in play mode. Press on the game board with the mouse in order to begin. You should see a blank canvas and be able to move the player around the screen. Keep in mind that the torches are the bounds of the screen, so you cannot move or place elements on these.

Switching to edit mode: Click on the “Pause” button, this should switch the game into edit mode. You will now see a set of buttons to choose from on the left side of the screen. Click on the green (+) symbol, to go into add mode (your are in add mode by default, so you don’t NEED to switch into add mode when you hop into edit mode). Now, you can click on any of the elements and place them on tiles the board. We’ve provided a summary of what they do below:

The caves: These spawn alligators in a certain direction (denoted by the arrow). The alligators will make the player lose a point if they touch it.

The red demon with wings: This chases the player around on the board. It will make the player lose 5 points if it catches it, and another 5 points every second that they are on the same tile.

The grey "eyed" triangle: This is the goal.

The player sprite: This changes the player’s default position.

The blue portal: To use this, first place a portal; this portal is unlinked. Once you place a black square rock, all "unlinked" teleporters will link to the rock. The player will teleport to the rock once they step on the teleporter. You cannot place a rock if there are no unlinked teleporters.

If you want to delete anything you placed inside of Edit mode, simply click the garbage bin to switch to delete mode and click on the tile you want to remove the element from. You will need to switch to add mode if you want to add anything.

While in edit mode, you can save your game, close the game and then rerun GraphicsMain.java. You will be prompted to restore your save state. 



Note: Whenever the player runs out of points or reaches the goal in play mode, the game will restart from the base state (objects will be reset and so will the playerstate).

Note: If the game is unresponsive, click on the game board with the mouse.
