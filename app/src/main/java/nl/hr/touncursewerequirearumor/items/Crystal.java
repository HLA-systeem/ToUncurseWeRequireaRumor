package nl.hr.touncursewerequirearumor.items;


import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.Player;

public class Crystal extends GameItem {
    private String name = "crystal with life energy";
    private String nameRes = "crystalenergy";

    public Crystal() {
        super("crystal with life energy", "crystalenergy");
    }

    private void giveEnergy(){
        this.nameRes = "crystal";
        Player.player.hpCurrent = Player.player.getStat(Constants.STATS.HEALTH);
    }

    public String use(){
        this.giveEnergy();
        return "You've absorbed the life energy from the crystal.";
    }

}
