package nl.hr.touncursewerequirearumor.scenes.managers;

import java.util.Random;

import nl.hr.touncursewerequirearumor.items.Anathema;
import nl.hr.touncursewerequirearumor.items.Crystal;
import nl.hr.touncursewerequirearumor.items.GameItem;

public class ItemSelector {
    private GameItem selectedItem;

    public GameItem selectItem(){
        Random random = new Random();
        int outcome = random.nextInt(100) + 1;
        if(outcome <= 80){
            this.selectedItem= new Crystal();
        }
        else{
            this.selectedItem= new Anathema();
        }
        return this.selectedItem;
    }
}
