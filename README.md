## Synopsis
This game purely is being made in Android Studio, no libGDX or other gaming development application is being used. 
You will need an Android emulator in order to run the game as it is.
The part of this repository that concerns the game can be found in the following folder:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/tree/master/app/src/main/java/nl/hr/touncursewerequirearumor

### Design-Patterns Used

## Static Utility Method

I will most likely put utility methods under Constants.java. The function getTextWidth() is an example of a static utility method I use.

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/Constants.java

## Interface
All scenes implement the scene interface.

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/tree/master/app/src/main/java/nl/hr/touncursewerequirearumor/scenes

## Strategy 
The Strategy pattern is implemented in the SceneManager.java and BattleManager.java, in order to switch between states. The only difference is that the battle states extend an abstract class instead of an interface. 

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/tree/master/app/src/main/java/nl/hr/touncursewerequirearumor/scenes/managers

## Singleton
The Player.java is a Singleton.

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/Player.java

## Encapsulation, Composition, Inheritance
Used basically everywhere.

