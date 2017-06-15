## Synopsis
This game is purely  being made in Android Studio, no libGDX or other gaming development application is being used. 
You will need an Android (emulator) in order to run the game as it is.
The part of this repository that concerns the game can be found in the following folder:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/tree/master/app/src/main/java/nl/hr/touncursewerequirearumor

All images in the game were made by me.

Here's a link to a demo-run of the game:
https://youtu.be/tu5wjrGiSKI

## Recommended way of running the game
1. Use a real Android phone.
2. Open up the Settings on your Android Phone.
3. Scroll down until you see the 'About phone' option (This option should show your Android OS version), and press it.
4. Scroll down until you see the your phones Build Number.
5. Press the Build number 7 times until you enter Developer Mode (Android will tell you when you're about to).
6. Developer options should have appeared under the main settings. Press it, scroll down until you see USB debugging and enable it.
7. Download Android Studio on your computer.
8. Open this project in Android Studio.
9. Connect your computer to your Android by usb cable.
10. Press Shift+F10 or click the green arrow.
11. The title screen of the game will open, press New Game


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
The Anathema is an item the player can pick up. When the player activates the Anathema, all enemies that the player encountered but didn't defeat (by running from the battle) will have their stats halved. 
 
When the player encounters an enemy it will start looking for a static ArrayList in Constants, if it has been defeated before with it's cursable method:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/enemies/Enemy.java
 
If the player hasn't defeated the enemy before it will start watching the Anathema, it will unwatch the Anathema if it had been defeated before. The Anathema implements the observable method in order for the enemy to watch it:
 
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/items/Observable.java
 
And the enemy implements the observer method in order to be notified of its activation:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/items/Observer.java


## Where to find examples of...
### Enumerations
The stats of the player are declared as an enum under Constants:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/Constants.java

The player had one big getter/setter for all it's stats, which takes a value of the stats enum as it's parameter:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/app/src/main/java/nl/hr/touncursewerequirearumor/Player.java

### Namespaces 
Can't use Java without it.

### Polymorphism, Composition and Inheritance
Used on many places, take a look at the UML to see which ones were used where.
 


Beoordeling =>

Er is gebruikt gemaakt van en static util method in de constants java class.
Scene interface en de classes die scenes implementeren zitten in scenes folder
Duidelijk gebruikt gemaakt van encapsulation, inheritance, composition
Player class is een singleton in de vorm van =>  public static synchronized Player getInstance() methode
Strategy pattern zit er ook in managers folder in scenes

Ik geef de game een voldoende. Codes waren goed gestructureerd en leesbaar voor mij. Het heeft alle onderdelen toegepast.
Verbeterpunt is om wel wat meer comments te gebruiken om de functie van de classes beter uit te leggen voor mensen die niet zo goed zijn in android.

