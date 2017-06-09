package nl.hr.touncursewerequirearumor.items;

import java.util.ArrayList;

import nl.hr.touncursewerequirearumor.enemies.Enemy;

public class Anathema extends GameItem implements Observable {
    private String name = "Anathema";
    private String nameRes = "anathema";
    private ArrayList<Enemy> victims = new ArrayList<>();

    public Anathema() {
        super("Anathema", "anathema");
    }

    public String use(){
        this.notifyWatchers();
        return "You've activated the curse stored in the Anathema.";
    }

    @Override
    public void watch(Enemy enemy){
        this.victims.add(enemy);
    }

    @Override
    public void unWatch(Enemy enemy) {
        this.victims.remove(enemy);
    }

    @Override
    public void notifyWatchers() {
        for(Enemy enemy : this.victims){
            enemy.curse();
        }
    }
}
