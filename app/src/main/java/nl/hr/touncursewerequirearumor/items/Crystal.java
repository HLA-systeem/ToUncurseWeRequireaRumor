package nl.hr.touncursewerequirearumor.items;


public class Crystal extends GameItem {
    private String name = "crystal with life energy";
    private String nameRes = "crystalenergy";

    public Crystal() {
        super("crystal with life energy", "crystalenergy");
    }

    private void giveEnergy(){
        this.nameRes = "crystal";
    }

}
