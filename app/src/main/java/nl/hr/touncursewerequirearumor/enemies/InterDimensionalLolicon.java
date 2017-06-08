package nl.hr.touncursewerequirearumor.enemies;

public class InterDimensionalLolicon extends Enemy {
    private String name = "interdimensional Lolicon";
    private String nameRes = "interdimensionallolicon";
    private int hp = 80;
    private int att = 50;
    private int speed = 100;
    private int hit = 100;


    public InterDimensionalLolicon() {
        super("Interdimensional Lolicon", "interdimensionallolicon", 80, 50, 100, 100);
    }


    @Override
    public String showsUpText() {
        return "You've spotted an interdimensional Lolicon !";
    }
}
