# Progress Report


## What everyone has been working on since phase 1A progress report
## A brief summary of what each group member has been working on since phase 1

####  Aditya:
- Worked on merging pull requests from other branches to main. 
- Worked with jamie to implement the edit and play mode's interaction with the game itself. (https://github.com/CSC207-UofT/course-project-1190/pull/13). This pull request was core to making edit and play mode function, as now elements (and the player) would reset to some base state once you switch to edit mode.  This feature was easy to implement, but the merge conflict was very large, as there were large differences between the main branch and this branch, so the merge required a lot of refactoring work.
- Worked on refactoring code and making the ObjectManager work

#### Hyungsoo (Henry):
- Important Note: I implemented pushableElement that works properly. However, we removed pushableElement because of too many bugs with our lastest version. If you want to check the pushableElement properly then Check : (https://github.com/CSC207-UofT/course-project-1190/pull/7). Finally I found the reason why it doesn't work, we didn't have enough time to finish this. This is the reason why our program doesn't contain pushableElement unfortunately.
- Implemented pushableElement
- Revised the pushableElement to follow observer pattern. (Gwen helped me revising the object.)
    - There were too many arithmatical bugs with the pushableElement. I fixed the bugs several times.
- Final version of the revised pushable element (https://github.com/CSC207-UofT/course-project-1190/pull/17) is the final version. (I had few pull requests before the pull request but we didn't merge some of them because of bugs because pushableElement interacts with player's movement.) Pushable element can be pushed by player's move and the player cannot push 2 pushable element at once. The element will give the player non-linear game playing experience since the player can change the board while the game is running.
    - Other pushable pull requests
    - https://github.com/CSC207-UofT/course-project-1190/pull/7 (The first version of pushableElement that is not following obsever pattern, and it fully functions)
    - https://github.com/CSC207-UofT/course-project-1190/pull/14 (Gwen's fix based on my first pull request.)
- Implemented more methods for utils(Point2D).
- Refactoring other codes.
- Accessibility Report.
- Wrote test cases.

#### Jamie:
- Added pop-up dialogs before the beginning of the game, transitioned away from console-based user interaction
- Implemented level editor interface (https://github.com/CSC207-UofT/course-project-1190/pull/15)
    - Sketched out FXML templates, wrote code for GUI event handling
    - Implemented add/delete functionality
    - Implemented scrolling panel for selecting elements, which can accommodate an arbitrary amount of selections

#### Shmuel:
- Changed String setup for sprites to Enums, demonstrating Github features in a shift of communication methods.
- Pulled all of the modification details out of the elements, had them extend an abstract modifier class, changed Interactable Interface, moved the location of modification from ObjectManager up to Game for cleaner architecture. Significantly changed game logic. - https://github.com/CSC207-UofT/course-project-1190/pull/9.
- Worked on Refactoring, Testing, Accessibility Report, IntelliJ generated javadoc file

#### Gwen
- In Phase 2, I created a new type of MovableEment called "[ChasingElement](https://github.com/CSC207-UofT/course-project-1190/pull/6)," which chases after the Player at a high speed and nimbly changes its moving direction as the Player makes its move on the board. Player loses points upon meeting a ChasingElement. 
- This is the first type in our elements collection that needs to be aware of Player's position and/or change in Player's position. This forced us to reconsider Clean Architecture and how different components interact and pass messages to each other. After this, we were able to implement other types of element that act upon Player's (change in) position with ease. 
- Worked on Refactoring, JavaDocs.

#### Abdul:
- During this phase, I had created and implemented the [Portal and Rock Elements](https://github.com/CSC207-UofT/course-project-1190/pull/5) which is a teleporter which when stepped on by the player, will move the player to the location of the Rock element. If multiple teleporters are placed on the board, all of them will teleport to the Rock element and if no Rock element is placed, the teleporter(s) will not function. 
    - The Portal and Rock element is one of the unique five types interactable elements and changes up the gameplay experience for the user.
- Worked on some of the Accessibility Report, IntelliJ Javadocs, and Test Cases
- Created UML Diagram

