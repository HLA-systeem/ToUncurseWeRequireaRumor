package nl.hr.touncursewerequirearumor.enemies;


public class Atroe extends Enemy {
    private String name = "Atroe";
    private String nameRes = "atroe";
    private int hp = 100;
    private int att = 70;
    private int speed = 10;
    private int hit = 100;

    public Atroe() {
        super("Atroe", "atroe", 100, 70, 10, 100);
    }


    @Override
    public String showsUpText(){
        return "It's the Atroe !\n The creature you've been searching for !";
    }

    @Override
    public void curse(){}

}
