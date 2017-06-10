## Synopsis
This game is purely  being made in Android Studio, no libGDX or other gaming development application is being used. 
You will need an Android (emulator) in order to run the game as it is.
The part of this repository that concerns the game can be found in the following folder:
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/tree/master/app/src/main/java/nl/hr/touncursewerequirearumor

All images currently in the game are 100% made by me.

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

### Encapsulation, Composition, Inheritance
Used basically everywhere.

## UML
https://github.com/HLA-systeem/ToUncurseWeRequireaRumor/blob/master/UML_To_Uncurse_We_Require_a_Rumor.pdf

Beoordeling =>

Er is gebruikt gemaakt van en static util method in de constants java class.
Scene interface en de classes die scenes implementeren zitten in scenes folder
Duidelijk gebruikt gemaakt van encapsulation, inheritance, composition
Player class is een singleton in de vorm van =>  public static synchronized Player getInstance() methode
Strategy pattern zit er ook in managers folder in scenes

Ik geef de game een voldoende. Codes waren goed gestructureerd en leesbaar voor mij. Het heeft alle onderdelen toegepast.
Verbeterpunt is om wel wat meer comments te gebruiken om de functie van de classes beter uit te leggen voor mensen die niet zo goed zijn in android.

