# Megaholic
A game application that allows you to have fun with Megaman. 

## Member
1. Kulisara Wiangin 6410545410
2. Siripa Maneein 6410545614
3. Jindaporn Sookying 6410546106
4. Nartnatta Krivichian 6410545509

## How To Run
1. Download the ZIP file provided or from the following GitHub repository:
   https://github.com/jindasy/Megaholic.git

2. Open the downloaded folder in IntelliJ IDEA
3. Setup SDK
4. Run the game from ```MenuPanel``` file.


## How To Play
There are 2 modes that you can choose.
- 1-Player mode: Play on your own to get the highest score
- 2-Player mode: Have fun with your friends on the same computer to beat each other

While the Megaman is running, you can choose to jump over or slide under the obstacles.
- 1-Player mode: Press UP Key to jump and DOWN key to slide
- 2-Player mode: 
  - Press UP Key to jump and DOWN key to slide for Player 1 (at the bottom)
  - Press W Key to jump and S key to slide for Player 2 (at the top)

```
There's only one rule. Don't collide with the obstacles!!!
```

## Design patterns used
1. **Object pool pattern** is used to generate Obstacle from ObstaclesPool.
2. **Singleton pattern** is used to get the instance of ObstaclesPool to make sure that it is created only once.
3. **State pattern** is used to change the behaviour of Player according to its state (e.g. jumping, and sliding).
4. **Observer pattern** allows OnePlayerModeLogic to notify any changes to OnePlayerModeUI as well as allows 
TwoPlayerModeLogic to notify any changes to TwoPlayerModeUI so that they updates accordingly.  