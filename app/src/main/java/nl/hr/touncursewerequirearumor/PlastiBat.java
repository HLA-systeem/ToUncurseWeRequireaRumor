package nl.hr.touncursewerequirearumor;

import nl.hr.touncursewerequirearumor.nl.hr.touncursewerequirearumor.enemies.Enemy;

public class PlastiBat extends Enemy {
    private String name = "Plastibat";
    private String nameRes = "plastibat";
    private int hp = 50;
    private int att = 15;
    private int speed = 90;
    private int hit = 80;

    public PlastiBat(){
        super("Plastibat", "plastibat", 50, 15, 90, 80);
    }

    @Override
    public String showsUpText(){
        return "The Plasticat bacame a Plastibat !";
    }
}
