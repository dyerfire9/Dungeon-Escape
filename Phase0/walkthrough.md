# CSC207 project walkthrough


--- 


- First a GameRunner is made that instantiates a Game object, and the GameRunner begins the game by using the Game.runGame method.
    
- A Board is generated and stored in Game, where the board stores a set of Tiles where some are traversable and some are non-traversable. 

- Then a Player instance is created and stored in the Game and is added onto the board at a certain position.

- While the game is running, the GameRunner will prompt user to provide an input ('a' and 'd' ideally) and interpret the user input using SystemInOut and move the Player left or right. Then update the position of player, and render board again using the Renderer.

- If the user makes a move and Board identifies that the Tile is non-traversable, the player cannot overcome it and player's position remains the same and the board is re-rendered from the Renderer. 
    
- The game engine prompts user once again. If the user enters 'quit', game will end and termination message is displayed.