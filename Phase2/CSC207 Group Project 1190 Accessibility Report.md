# CSC207 Group Project 1190 Accessibility Report

## Principle 1: Equitable Use
- Our game can be played/edited by everyone very easily. The logic of the game is easy to understand, and the game editor also can be used very intuitively. The user can edit the game board after they pause the game. For example, every user are allowed to "add" and "remove" all objects on the board. In addition, the users can save the board that they played/editted and load the board whenever they want. All of the mentions functions can be ran by the user within few clicks in GUI.
## Principle 2: Flexibility in Use
- Our game lets the user choose the board size, which the user may wish to alter based on their screen size. Additionally, since the game is designed by the user, they can choose what to place on the board. For example, they can choose not to put any Chasing elements on the board if they prefer a slower paced game. The difficulty of the game can be changed at will, through the placement of more or fewer game elements.
- In the future, it would be helpful to give the user options to change the game speed. Current all of the elements you can place on the board have a set velocity and tick rate. If we give the user the ability to change the tick rate of individual elements/the entire game, that can make the game harder/easier, therefore more flexible. 
## Principle 3: Simple and Intuitive Use
- We tried our best to make the game as simple and clear as possible from a visual standpoint. The sprites we chose are pretty distinct from each other, and do a decent job at communicating the effect that they'll have on the player. 
- Additionally, a small but useful change is the yellow box that appears around the tile that the user is currently hovering, rather than the user needing to eyeball pixel-perfect clicks on the tile they want. 
- We also made our UI as simple as possible to use. Using minmal buttons with informative icons to show their purpose. 
## Principle 4: Perceptible Information
- The images used in the game are different enough that they are not easily confused, with the exception of the `AlligatorDens`, which is why arrows were placed on them to differentiate them. Additionally, tooltips can be placed on the images to describe what each element does. The elements are all different colours and shapes, so that colour-blind people can still distinguish them.
- A nice feature to add would be a colorblind mode, which would alter the color of all the sprites on the board. 
## Principle 5: Tolerance for Error
- The game is designed so that every move requires another press of a button, meaning that the user will not accidentally move further than desired by holding down a key for too long. The pause button allows one to pause the game at any time and change the elements on the board if a mistake has been made.

## Principle 6: Low Physical Effort
- The game has been designed to prompt the user to use just the mouse to make the map and the keyboard keys 'W, A, S, D' and that way the user can maintain a comfortable seating position while playing the game.
- However, regarding the keypresses, we also violate this principle in some ways. Since we only process one keypress at a time (holding down a key counts only as one keypress), the user needs to repeatedly press their movement keys to move around. This is quite streunuous.
## Principle 7: Size and Space for Approach and Use
- This doesn't quite apply to our program, as we're bounded by the hardware (the computer of choice), which we don't have control over. 
- In order to adhere to this principle, we could make our game function with accessible peripherals. Eg: Eye tracking tools, voice controls. This would mean that people could swap the keyboard for whatever controller they want. Making the game easier to play for anyone that has assistive devices and/or needs to stand/sit away from the keyboard. 

## Questions
1. Our program is a game maker that lets the user create their own levels. Generally, this game could be marketed towards people who like hard games. People try and can design levels to be as hard as they can possibly make it, but still possible to beat with enough effort. These people can compete to make the hardest levels they can. On the other hand, people who seek difficult challenges can play those hard levels and try and be the first to beat them.


2. Our program is hard for people with visual impairment to play. We don't really have sound effects, so visual cues is the only method of percieving the game, and without it the game becomes very hard to play. Additionally, our game gets quite intense when the user creates a very hard level. Individuals who cannot press the arrow keys very fast to avoid the alligator dens/chasing elements will have a hard time reaching the goal for difficult levels. 

