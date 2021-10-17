# CSC207 Project specification


For phase 0:
A tile-based game where the player can move on a board, where the board is represented by a grid of tiles. Certain tiles are non-traversable, so the player cannot move onto these. 

The Human using this system should be able to move the player using their keyboard and should have some sort of graphical view of the board. This graphical view should display the new state of the board as soon as the human moves the player. 


---
Specification that we want to achieve by the end of the project:

Each Game contains a player and set of boards. The player can move across a board onto different tiles, but there are certain tiles that it cannot traverse to. Additionally, certain tiles on a board can have objects (eg: powerup, monster) on them that interact with the player (eg: change health, give item). These objects can be static or move across the board (eg: on a line or following the player). 

When the player reaches the “goal” of a board, it is sent to the next board. The game ends when the player either quits or reaches the ending of the game (completes the last board). 

The Human using this system should be able to move the player using their keyboard and should have some sort of graphical view of the board. This graphical view should display the new state of the board as soon as the human moves the player OR an object moves.  
