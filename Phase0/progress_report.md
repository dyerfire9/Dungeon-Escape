# CSC 207 project report

#### Gwen, Aditya, Abdul, Jamie, Shmuel, Henry

---- 


## Summaries: 

### Specification:
A tile-based game where the player can move between tiles stored on a board, though there are certain tiles they cannot traverse to. A renderer is responsible for displaying the board's state to the player. 

**Future**
- Each board can also have moving and non-moving objects that interact with the player (eg: remove health). 
- There are multiple boards, each with their own setups of tiles and objects
- Each board has a Goal, when the player reaches the goal, they move onto the next board (next level). The game ends when the player beats the final board (basically the final level)

### CRC Model:
Made virtual CRC cards for 3 entities (Player, Tile, Board), 3 Use Cases (Renderer, SystemIn, Game), and 1 controller (GameRunner) based on the Specification. Included where attributes are stored, getters and setters, the methods that the program uses, and short descriptions for non-self-explanatory methods.

### Scenario walk-through:

When the game session begins, we generate a 1D board and the player is prompted to make a move. The player uses the keyboard to move their player around on the board. When they make a move, a representation of the board with the new player position is returned. The game ends when the user quits the game.

### Skeleton Program:

The skeleton program implements all of the classes outlined in the CRC cards. When the user runs the Main.java file, our controller (GameRunner) initializes a Game instance and begins running it. The user will get a few instructions in the terminal on how to play, and then be prompted for inputs. The user is able to enter "a" and "d" for left and right respectively. After each action, the user will see a 1D board string representation in the terminal (this comes from the renderer class). Once the user types "quit", the program exits. We also have unit tests for our toString methods for both Tile and Board classes. 

## Open questions that we're struggling with:
- We are still trying to clearly delineate the functions of each entity/layer and comform to Clean Architecture to the extent we can, but our model is still somewhat in flux as our expectation for what each component is/is to do keeps evolving.

- We have had trouble figuring out how to divide up tasks so that we don't accidentally overwrite each other's work.

- We had a Github issue when multiple members were working on one branch simultaneously.

## What has worked well with our design so far:
- Our design keeps the renderer separate from the game itself. This means that the logic for changing the game state is disjoint from the rendering operation. So we can update the board as we want, and the renderer can simply be called afterwards. This means as we add more features, the renderer will not need to change. 

- Our design strives to keep all instance variables private, with corresponding public setters and getters. This ensures that the instance variables are safe from unintended external access or change. 


## Individual updates: 

### Abdul: 
- I have created the CRC cards and finalized it.
- Wrote the senario walkthrough.
- I plan to provide for feedback for new implementations and aid more in the coding aspect for the next phase such as inplement a seeder for the board and introduce moving obstacles.


### Henry:
- I've created CRC card based on our overall model.
- I'm currently working on SystemIn TODOs. There will be some changes user input. 
- I provided some suggestions for others code refactoring.
- Personally, I want to make some changes on the structure of Board.java's structure, but it should be discussed with team members first.

### Aditya: 

- I've been primarily working on the programming side of the game. I setup the logic regarding: 
    - How the player moves on the board. 
    - How the board is constructed
    - How the graphical view of the game is made 
    - Assigning TODOs

- The first thing I plan on doing next is finding a suitable canvas library in java that allows us easily to render sprites of players and tiles on a canvas. After this, I will adapt the renderer to render the graphical view of the board.

### Gwen:

- I helped with brainstorming the overall model and Clean Architecture layers. I also contributed to the coding where needed and to the drafting of the required documents. 

- I plan to make the game more interactive and game-like in the next Phase. More specifically: the game will ask the user to choose the size of the board; the game board will be randomly seeded with obstacles or bonuses; and the user will be able to determine the difficulty level of the game. 

### Shmuel:

- I've been working on the game model (interaction between the classes), Specification, CRC cards, and editing the code. 
- In the next phase, I plan on helping out more with the coding and bug fixes, as well as continuing to brainstorm the best expansions to the game.

### Jamie:

- I helped in setting up the initial project and getting the first working version running. I also write various misc. commits like changing a certain implementation or restructuring the Main class.
- I drafted a CRC model during the brainstorming phase of the project.
- In the next phase, I am planning to help in transitioning the game to 2D, as well as making the code more robust and modular (e.g. adding interfaces/abstractions, reducing coupling and unnecessary dependencies).
