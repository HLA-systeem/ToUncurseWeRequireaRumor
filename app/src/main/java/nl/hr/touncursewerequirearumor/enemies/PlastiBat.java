package nl.hr.touncursewerequirearumor.enemies;

public class PlastiBat extends Enemy {
    private String name = "Plastibat";
    private String nameRes = "plastibat";
    private int hp = 50;
    private int att = 15;
    private int speed = 90;
    private int hit = 80;
    protected static boolean defeatedBefore;

    public PlastiBat(){
        super("Plastibat", "plastibat", 50, 15, 90, 80);
    }

    @Override
    public String showsUpText(){
        return "The Plasticat bacame a Plastibat !";
    }
}
