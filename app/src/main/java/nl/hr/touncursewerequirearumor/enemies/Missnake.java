package nl.hr.touncursewerequirearumor.enemies;

import nl.hr.touncursewerequirearumor.items.Anathema;

public class Missnake extends Enemy {
    private String name = "Missnake";
    private String nameRes = "missnake";
    private int hp = 70;
    private int att = 60;
    private int speed = 80;
    private int hit = 80;
    protected static boolean defeatedBefore = false;

    public Missnake(){
        super("Missnake", "missnake", 70, 60, 80, 80);
        Anathema anathema = new Anathema();
        if(Missnake.defeatedBefore == false){
            anathema.watch(this);
        }
    }
}
