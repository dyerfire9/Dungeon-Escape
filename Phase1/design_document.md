# CSC 207 Group Project 1190 Design Document for Phase 1

## Updated Specification

A tile-based game where the player can move on a 2D board, where the board is represented by a grid of tiles. The player moves across the board using inputs from the user's keyboard. Additionally, on the board there are objects movingthat can interact with the player (eg: take away points/make the player win the game). Note that these objects can move around the board as well.   


Before, in phase0 this specification was primarily concerned with the player moving around on the board. Now, we have added functionality for objects that can interact with the player.

- In this iteration of our tile-based two-dimensional board game, we added the following functionalities to our Phase 0 design: 
    - We tried adding a **game-making mode** before the play mode, during which the human user uses a graphical user interface (GUI) to choose the size of the board and plant a variety of interactive elements. This is still a work in progress. 
    - We successfully added **a GUI** to the play mode. 
    - Instead of reading a typed input from the console, the game now **reads keyboard presses** in real time. 
    - We refined the behavior of **interactive elements**. 
    - We added a serialization feature to our game, whereby the user can choose to save the game data, such as player and element positions and the player's points. The user can then choose to use this saved data when beginning the game, allowing the **continuation of the previous game**.




## A description of any major design decisions your group has made (along with brief explanations of why you made them).

- We decided to instantiate every element on the board with a string representation, and map the string to an image only during the rendering stage. This helped us keep the GUI layer as separate from the underlying entities as possible. Also, this means that we didn't need to import JavaFX in any of the game logic layers.
- In addition to moving elements, we added generators of moving elements, which would spawn moving elements in a given direction at a given pace. This increased the variety of interactive elements on the board.  
- We decided to extract many rendering operations from GraphicsMain and put them into a separate class called RenderPane. This was to keep the main class as slim as possible. 
- We decided to extract Player's status into a separate class called "PlayerState", which can be changed by interactive elements Player encountered on its path. This was guided by the Single Responsibility Principle, and helped separate Player's location on the board and its internal state. 
- We also heavily refactored how individual objects work on the board. We introduced a class called ObjectStateManager, which is responsible containing the Elements on the board and facilitating their movement and interaction with the board itself.  


## A brief description of how your project adheres to Clean Architecture (if you notice a violation and aren't sure how to fix it, talk about that too!)
![](https://i.imgur.com/a8sEskW.png)

### In our game: 
- The GUI components (GraphicsMain, RenderPane, GraphicsLoader) constitute the UI layer. 
- Serializer and PlayerButtonControllers are Controllers. 
- Game, GameMaker, ObjectManager, Board and Player are Use Cases.
- PlayerState, and the classes that are subclasses of element are Entities.  
- We have some utility classes defined in the utils folder, these are simply datatypes that we created for our convenience. 

Our project adheres to Clean Architecture because the entire graphics section (the GUI) is separate from the rest of the code, allowing us to code anything in the lower layers and just render it afterwards. Within the three lower layers, our entities (PlayerState, Element and its subclasses, the utils) do not reach up to the use cases (Game, GameMaker, ObjectManager, Board and Player) and are self sufficient. Similarly, the use cases do not use any of the controllers (Serializer and PlayerButtonControllers); the controllers interact with and the use cases. Thus our code follows the dependency rule.

Scenario Walk-through: In the terminal, the user is prompted to either load a saved game or begin a new one. If a new game is chosen, the user will be asked to choose a board size. The graphics suite will then begin a new game. The game will include a player, a board of the size specified, and some interactive elements. The user can then use the keyboard (through the renderer) to manipulate the player around the board. The player interacts with elements, which currently are all alligators (except generators which do not affect the player, and the goal). The user can also click Save, which will cause the Serializer to save the game data, which can be recalled at the beginning of the game.



## A brief description of how your project is consistent with the SOLID design principles (if you notice a violation and aren't sure how to fix it, talk about that too!)


- **Single Responsiblity**
    - In our project, we define a single actor to be either the team members working on core game logic (usually Gwen, Henry, Shmuel, Abdul) or the members working on graphics (usually Aditya, Jamie).
    - Most of our classes "belong" to a single actor, with the exception of the `util` package, which is used everywhere. We think this is our most blatant violation of SRP, but they only contain some simple math objects and shouldn't be of much consequence.
- **Open-Closed**
    - The only part of our project that deals significantly with the Open-Closed Principle are the classes in the `elements` package, which we structured as an inheritance hierarchy with the root class `Element`. Instances of `Element` are the most basic representation of anything that is stored on a `Board`, and its subclasses extend those features, following the OCP. 
    - On the other hand, as our project expanded and we added more files, we had to go back and add a lot of composition ("Has-A") relationships to older classes. Since the core of OCP is being closed to modification, we suspect this behaviour violates the principle.
- **Liskov Substitution** 
    - As stated above, all the classes in the `elements` package are part of an inheritance hierarchy with the root class `Element`, which represents anything that is stored in a `Board`. This follows Liskov substitution, since child classes have more features than parent classes, so in classes like `Board` where we store `Element` instances, we can swap out an instance of `Element` with any of its subclasses and vice versa through polymorphism.
- **Interface Segregation** 
    - We don't have many interfaces in our project, but the ones we do have are very minimal, so client classes aren't forced to implement unnecessary features. For instance, the `Movable` interface only defines a single method, `move()`, and any class that needs to move around on the board only needs to implement that method.
- **Dependency Inversion**
    - The Entities in our design (PlayerState and various elements), are self-contained classes that do not rely on concrete instances of the outer layers.  
    - The Use Cases, including Game, GameMaker, ObjectManager, Board, and Player classes utilize the Entities but do not rely on concrete instances of any outer layers. 
    - Similarly, Serializer and PlayerButtonControllers do not rely on concrete instances from the GUI layer.
    - Overall, our design conforms with Dependency Inversion, as no inner classes depend on concrete instances of outer layer classes.  



## A brief description of which packaging strategies you considered, which you decided to use, and why. (see slide 7 from the packages slides)

For the purposes of our game, we thought of packaging either by layer or by component. We ended up using a slight mix of both. We currently have four packages, "game, elements, graphics, utils". Most of our UI components are in the graphics package; the use cases are all stored in game (except for playerState, which is an entity); and most of the entitites are stored in the elements package. 

Alternatively, the graphics package can be thought of as a "UI component" that is responsible for rendering all of the game components graphically. The rest of the packages (game, elements) can be thought of as components that are required to run the core game itself. 

Therefore, our current packaging strategy is primarily a by layer packaging strategy, but we do incorporate a little bit of the for component strategy.

The utils package is just an extra package storing useful datatypes.


## A summary of any design patterns your group has implemented (or plans to implement).


For our generator class, we used a Factory design pattern. The Generator class defines an abstract method called generateElement and a function that generates moving elements and places them on the board. In our current game, the AlligatorDen class, a child of the Generator, implements this abstract method and generates Alligators. Therefore, this is an application of the Factory Pattern.


Going forwards, we want to try adding more concrete factories, such as generators that can create different types of elements. Another idea is to have an abstract factory that can switch between generating different types of elements. 

Additionally, we want to try and implement observers for the game itself. For example, if the player reaches one end of the board, an element on the opposite end will react. Or, an encounter with an element on the board changes the status of other elements on the board. 


## A progress report

### Open questions your group is struggling with
- We are still trying to implement a GUI for the game-making mode, whereby the human user can drag-and-drop elements to plant them on the board. 
- We need to learn to use TestFX for writing tests on the JavaFX components. 
- We need to decide on and implement a set of mechanisms to resolve collisions between moving elements. For example, can two moving elements move onto the same tile simultaneously? Can Player move onto a tile where a stationary element resides? 
- We need to implement an object that is "pushable". Player can push the object to the next tile if the object is "pushable".

### What has worked well so far with your design
- Having the GUI separate from the rest of the code allowed us to ignore the graphics while coding - we even split into two groups, one working on graphics and the other working on the game, with each team not knowing what the other was doing.
- Our packaging strategy has helped our design conform to Clean Architecture.
- The use of the Factory Pattern and interfaces has simplied the creation of new element types.

### A summary of what each group member has been working on and plans to work on next
- Jamie:
    - Worked on user input and integrating UI with the project
    - Plans are to continue on UI, and getting the "Edit Mode" portion working

- Shmuel: 
    - Wrote code for serialization and deserialization
    - Added tests and Javadocs
    - Plan to work on new types of elements and expanding the save function

- Hyungsoo (Henry):
    - Implemented ObjectManager
    - Implementing "pushable" object
    - Implementing new moving algorithm

- Gwen: 
    - Contributed to refactoring of the game model; added tests and JavaDocs where needed.
    - I plan to resolve collision mechanisms between interactive elements, and apply TestFX to testing GUI elements.

- Aditya: 
    - Connected the JavaFX renderer directly to the game logic. This was done by refactoring a significant amount of code from phase 0. 
    -  Implemented the logic behind elements
    -  Implemented the ObjectManager
    - I plan on figuring out on how to implement more dynamic objects. Eg: Objects can manipulate each other (using observers), objects that are pushable, objects that can stop the player from moving...

-----
Sources:
- Source of assets for the game: http://rltiles.sourceforge.net/