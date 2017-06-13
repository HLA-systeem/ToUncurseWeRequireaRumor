## Synopsis
This game is purely  being made in Android Studio, no libGDX or other gaming development application is being used. 
You will need an Android (emulator) in order to run the game as it is.
The part of this repository that concerns the game can be found in the following folder:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/tree/master/app/src/main/java/nl/hr/touncursewerequirearumor

All images in the game were made by me.

Here's a link to a demo-run of the game:
https://youtu.be/tu5wjrGiSKI

## Reccomended way of running the game
1. Use a real Android phone.
2. Open up the Settings on your Android Phone.
3. Scroll down until you see the 'About phone' option (This option should show your Android OS version), and press it.
4. Scroll down until you see the your phones Build Number.
5. Press the Build number 7 times until you enter Developer Mode (Android will tell you when your about to).
6. Developer options should hava appeard under the main settings. Press it, scroll down until you see USB debugging and enable it.
7. Download Android Studio on your computer.
8. Open this project in Android Studio.
9. Connect your computer to your Android by usb cable.
10. Press Shift+F10 or click the green arrow.
11. The title screen of the game wil open, press New Game

## Design-Patterns Used

### Static Utility Method

I will most likely put utility methods under Constants.java. The function getTextWidth() is an example of a static utility method I use.

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/Constants.java

### Interface
All scenes implement the scene interface.

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/tree/master/app/src/main/java/nl/hr/touncursewerequirearumor/scenes

### Strategy 
The Strategy pattern is implemented in the SceneManager.java and BattleManager.java, in order to switch between states. The only difference is that the battle states extend an abstract class instead of an interface. 

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/tree/master/app/src/main/java/nl/hr/touncursewerequirearumor/scenes/managers

### Singleton
The Player.java is a Singleton.

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/Player.java

### Observer
The Anathema is an item the player can pickup. When the player activates the Anathema, all enemies that the player encountered but didn't defeat (by running from the battle) will have there stats halved. 

When the player encounter's an enemy it will start looking for a static ArrayList in Constants, if it has been defeated before with it's cursable method:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/enemies/Enemy.java

If the player hasn't defeated the enemy before it will start watching the Anathema, it will unwatch the Anathema if it had been defeated before. The Anathemma implements the observable method in order fot the enemy to watch it:

https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/items/Observable.java

And the enemy implents the observer method in order to be notified of it's activation:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/items/Observer.java

## UML
!(https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/UML_To_Uncurse_We_Require_a_Rumor.jpg)

## Library Used
https://github.com/vsvankhede/EasyFonts

