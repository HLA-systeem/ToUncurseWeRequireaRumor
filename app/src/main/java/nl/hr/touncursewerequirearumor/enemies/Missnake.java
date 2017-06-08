package nl.hr.touncursewerequirearumor.enemies;

public class Missnake extends Enemy {
    private String name = "Missnake";
    private String nameRes = "missnake";
    private int hp = 70;
    private int att = 60;
    private int speed = 80;
    private int hit = 80;

    public Missnake(){
        super("Missnake", "missnake", 70, 60, 80, 80);
    }
}
