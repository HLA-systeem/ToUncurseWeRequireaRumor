package nl.hr.touncursewerequirearumor.items;

import nl.hr.touncursewerequirearumor.enemies.Enemy;

public interface Observable{
    public void watch(Enemy enemy);
    public void unWatch(Enemy enemy);
    public void notifyWatchers();
}
