# CSC 207 Group Project 1190 Design Document for Phase 2

## Updated Specification






## A description of any major design decisions your group has made (along with brief explanations of why you made them).

A tile-based game where the player can move on a 2D board, where the board is represented by a grid of tiles. The player moves across the board using inputs from the user’s keyboard. 

Additionally, on the board there are objects (moving/non-moving) that can interact with the player (eg: take away points/make the player win the game). 

The player can switch between playing and editing modes. Editing mode allows them to place/delete elements on the board, while play mode allows them to test the levels that they made. 

____
Changes: 
Before, in Phase 1, this specification was primarily focused on a fixed board that has pre-placed elements. We realized that we had achieved our specification, and decided to extend it to include the ability to customize the board iteself.


## A brief description of how your project adheres to Clean Architecture (if you notice a violation and aren't sure how to fix it, talk about that too!)
![](https://i.imgur.com/a8sEskW.png)

### In our game: 
- Classes in `graphics` are generally Controllers or Presenters. When a request is sent from the view, a class in `graphics.controller` processes the request for the Use Cases. When the request is relevant to the Use Cases. When the Use Case responds, the `GraphicsLoader` and `RenderPane` classes update the View accordingly.
    - Of note are events from pop-up dialogs, which use classes in `graphics.dialog` as Controllers, and `DialogPresenter` as the Presenter.
- Game, GameMaker, ObjectManager, Board and Player are Use Cases.
- PlayerState, and the classes that are subclasses of element are Entities.  
- We have some utility classes defined in the utils folder, these are simply datatypes that we created for our convenience. 

**UML DIAGRAM:** 
https://drive.google.com/file/d/1jF-r_ai6wCz80jP8dh7I22M9hBb2iRX2/view?usp=sharing (Whole diagram cannot fit in this document.)
 
**Scenario walkthrough:** 

*Example 1* (Placing an element on the board): 
For the example, assume the user has selected an element. 

1. For the first step, the user clicks on the board. The click is registered by an event listener and the event is caught and handled in the RenderPane, which is a controller.

2. The RenderPane first calls the `checkOverlap()` method from a controller (`Game`). This method then asks the use case (`ObjectManager`), to check whether there are any elements at the position that the user wants to place an element in. The `ObjectManager` checks the `Elements` (Entities) that it stores, for their position and returns whether any one of them overlaps. In the case that there is an overlap, nothing is done. Otherwise, we move forward to step 3. 

3. The `RenderPane` then calls the appropriate method from one of our controllers (`GameSeeder`) to add the element at the board on the tile that was clicked.

5. The `GameSeeder` then calls upon another controller (`Game`). Then `Game` uses the use case `ObjectManager` and calls the appropriate add method inside it, passing in the tile position that was clicked. 

6. The `ObjectManager` then generates an entity (`<T extends Element>`) at that position and stores it. We have now added an element at the mouseclick tile.


*Example 2* (Moving the player): 

1. For the first step, the user presses one of the movement keys WASD. This keypress event is caught by the `RenderPane`, which is a controller.

2. Then the `RenderPane` tells another controller (`Game`) to check whether that tile is traversable. 

3. `Game` then passes the function down to one of the use cases it stores (`Board`). 

4. The board use case stores a list of entities (`Tile`), in a 2D arraylist. The board checks the tile at the position that the player wants to move to and checks whether it is traversable. This method returns whether the tile is traversable in the form of a boolean. 

5. Now we head back up to the `RenderPane`, which now has a boolean that tells us whether the place we want to move the player to is actually traversable. In the case that is isn't, there is nothing to be done. 

6. In the case that the tile we want to move to is traversable, we then call a method from `Game` to change the player position. 

7. `Game` then calls upon a use case that it stores (`Player`), to change the player position. The `Player` calls a setter method to manipulate the entity (`PlayerState`), which stores the current player position along with other things related to the player (e.g. Points). Now the player has changed positions!



<h3>How our project adheres to Clean Architecture:</h3>
    
    
- Our project does a pretty good job of separating cleanly into individual components, each with their own purpose. The GUI-related classes (in the `graphics` package), have a single point of contact with the Game itself, which is through the Renderpane. 
    - The `RenderPane` connects to the primary controllers `Game` (used for handling game logic) and `GameSeeder` (works with `Game`, used for placing elements on the board). This is the boundary between the external interfaces and the controller layer
    - The controller `Game` works with our use cases - `Player`, `Board` and `ObjectManager`. 
        - ObjectManager handles the individual elements on the board and how they move. These Elements are entities.
        - Player handles the methods to interact with the player's state itself, stored in the PlayerState entity.
        - Finally, board holds a list of non-traversable and traversable tiles, which define the edges of where the player can go. These Tiles are entities. 

The game primarily runs off `RenderPane`, `Editor`, or other JavaFX controllers reading in user clicks and keypresses, passing the information down to the `Game` controller (either directly or through the `GameSeeder` class). The `Game` controller then tells the use cases to manipulate the required entities or return certain information from them.  

## A brief description of how your project is consistent with the SOLID design principles (if you notice a violation and aren't sure how to fix it, talk about that too!)


- **Single Responsiblity**
    - Most elements in the `elements` package, if not all of them, followed this principle. All the elements are primarily concerned with either moving themselves or interacting with the player. The exception to this is the `Generator` class, but this one is only concerned with generating elements on certain frame ticks. Therefore it still follows SRP closely. 
    - The `Player` use case follows this principle pretty well too, as it's only really concerned with changing the player position/player state. The same goes for `Board`, as board is only concerned with checking whether a tile is traversable or not. 
    - On the other hand, `ObjectManager` is a blatant violation of this principle. It has the role of adding/deleting/updating/modifying the elements, and has a large number of functions. The reason we needed to do this is because all the elements on the board are stored inside of an arraylist inside of `ObjectManager`, so all the interactions needed to be ultimately defined inside of `ObjectManager`. 
    - The other relevant classes (`Game`, `RenderPane`), also have a decent amount of methods, but are mostly focused on their tasks. `Game` serves as a passageway to the other use cases, while also occasionally combining information from two use cases for some purpose. Renderpane simply facilitates user input and game state changes. 


- **Open-Closed**
    - The only part of our project that deals significantly with the Open-Closed Principle are the classes in the `elements` package, which we structured as an inheritance hierarchy with the root class `Element`. 
    - We defined some general interfaces for our Elements to use, such as Interactable. This interface has a method which returns a Modifier (something that modifies the player state). 
    - Making new interactable elements with these tools was very easy. Since the object manager would store anything that subclasses `Element`, we could define our own Elements which implement `Interactable`, and have the playerstate be modified in various distinct ways (eg: increasing points, changing the player position) by defining our own Modifiers. Most of the new Elements we made that interact with the player required no modifications to the `ObjectManager`, just new classes.
    - Additionally, in order to make new elements with different speeds or maybe even some unique behaviors, we mostly just subclass existing classes and added interfaces. ObjectManager needed no change because it relied on these interfaces.
    - On the other hand, as our project expanded and we added more files, we had to go back and add a lot of composition ("Has-A") relationships to older classes. Since the core of OCP is being closed to modification, we suspect this behaviour violates the principle.
- **Liskov Substitution** 
    - As stated above, all the classes in the `elements` package are part of an inheritance hierarchy with the root class `Element`, which represents anything that is stored in a `Board`. This follows Liskov substitution, since child classes have more features than parent classes, so in classes like `ObjectManager` where we store `Element` instances, we can swap out an instance of `Element` with any of its subclasses and vice versa through polymorphism.
- **Interface Segregation** 
    - We don't have many interfaces in our project, but the ones we do have are very minimal, so client classes aren't forced to implement unnecessary features. For instance, the `Movable` interface only defines a single method, `move()`, and any class that needs to move around on the board only needs to implement that method. The same applies to `Resettable` and `Interactable`.
- **Dependency Inversion**
    - The Entities in our design (`PlayerState` and various elements), are self-contained classes that do not rely on concrete instances of the outer layers.  
    - The Use Cases, including `Game`, `GameMaker`, `ObjectManager`, `Board`, and `Player` classes utilize the Entities but do not rely on concrete instances of any outer layers. 
    - Similarly, `Serializer` does not rely on concrete instances from the GUI layer.
    - Overall, our design conforms with Dependency Inversion, as no inner classes depend on concrete instances of outer layer classes.  



## A brief description of which packaging strategies you considered, which you decided to use, and why. (see slide 7 from the packages slides)

For the purposes of our game, we thought of packaging either by layer or by component. We ended up using a slight mix of both. We currently have four packages: `game`, `elements`, `graphics`, and `utils`. Our UI components are in the `graphics` package; everything in game is a use case (except for playerState, which is an entity, and `Game`, which is a controller); and the `Element` entitites by are stored in the elements package. The utils package is the only exception, storing useful datatypes that any class can use.

Alternatively, the `graphics` package can be thought of as a "UI component" that is responsible for rendering all of the game components graphically. The rest of the packages (game, elements) can be thought of as components that are required to run the core game itself. Additionally, we split the graphics package into subpackages of `controller` for FXML controllers, and `dialog` for user pop-up dialogs.

Therefore, our current packaging strategy is primarily a by component packaging strategy, but we do incorporate a little bit of the by layer  strategy.


## A summary of any design patterns your group has implemented (or plans to implement).


- Factory Pattern: For our generator class, we used a Factory design pattern. The `Generator` class defines an abstract method called generateElement and a function that generates moving elements and places them on the board. In our current game, the `AlligatorDen` class, a child of the `Generator`, implements this abstract method and generates `Alligator`s. Therefore, this is an application of the Factory Pattern.


 
## Use of github features throughout the project


We mostly kept track of issues interally on discord.

Pull requests:
- We used pull requests between phase 1 and 2. Our main strategy was to split up features into pull request. Here are a few examples:
    - https://github.com/CSC207-UofT/course-project-1190/pull/4 (changing from strings for sprites to Enums)
    - https://github.com/CSC207-UofT/course-project-1190/pull/5 (Teleporter element)
    - https://github.com/CSC207-UofT/course-project-1190/pull/13 (Edit and play mode). The other pull requests made for this branch were faulty and I (Aditya) messed up on those and needed to revert those pull requests. The linked pull request is the right one to look at.
    - https://github.com/CSC207-UofT/course-project-1190/pull/9 (Adding modifiers)

Github Merge interface:
- The github website's merge conflict interface that lets you resolve the conflicts directly on the pull request was very useful. While normally you can do `git merge` and then resolve the conflicts locally, this tool proved to be very convinient as often merge conflicts were for things that are trivial to solve. Eg: Whitespace or mismatched docstrings. 

Branches:
- We used branches for individual features and merged them into the main branch when they were complete, generally deleting the old branch afterward.

## Testing

Despite our best efforts, we could not get TestFX to work properly with our project, so any class using JavaFX (i.e. classes in `graphics`) **could not be tested with unittests**. Among the issues we experienced while attempting to integrate TestFX were:
- Poor and outdated documentation:
    - TestFX used older versions of certain libraries and deprecated services (e.g. `jcenter`), and we sometimes had to modify the example code that was provided.
- Supposed incompatibilities with FXML:
    - Using FXML to build our GUIs made the process of obtaining references to elements of our scene graph, which were needed for the testing bot to function, more complicated.
- New imports and dependencies created strange conflicts with our `module-info.java` file, which resulted in a workaround "hack" of creating a wrapper for our main class and deleting said file.
    - This workaround is not "clean" and always produced an error message on runtime.

(Note that some of the issues above we tried resolving with the help of Jason from the TextGameEngine group (https://github.com/kdports/TextGameEngine).)

We primarily tested our project with unit testing using JUnit 4.

## Refactoring

- We continued refactoring as we refined our underlying game logic and the GUI interface: 
    - With the GUI, there were at least two large changes in code structure:
        - Another time was from changing the loading method of `Scene` instances to use `FXMLLoader`. This mostly affected the scene controllers.
(https://github.com/CSC207-UofT/course-project-1190/pull/14). This made the logic much clearer and the code cleaner. 
- On advice from our TA, we created an enum class (https://github.com/CSC207-UofT/course-project-1190/pull/4) to replace the previous string-based version for element sprites.
- We moved information about the modification of the PlayerState out of the individual elements and into modifier classes, and we moved the location of modification from `ObjectManager` to `Game` for cleaner architecture (https://github.com/CSC207-UofT/course-project-1190/pull/9).
- Gave the Element class an `isPermanent` instance variable. This instance variable denotes whether that element should be deleted when switching from edit to play mode. Some elements remain on the screen and some elements are deleted when you switch modes. 
-----
Sources:
- Source of assets for the game: http://rltiles.sourceforge.net/
- Source of editor icons: http://www.famfamfam.com/