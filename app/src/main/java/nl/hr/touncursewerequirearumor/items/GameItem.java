package nl.hr.touncursewerequirearumor.items;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import nl.hr.touncursewerequirearumor.Constants;

public abstract class GameItem {
    protected String name;
    protected String nameRes;

    public GameItem(String name, String nameRes){
        this.name = name;
        this.nameRes = nameRes;
    }

    public Bitmap displayItem(){
        BitmapFactory bf = new BitmapFactory();
        Bitmap img = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(this.nameRes,"drawable", "nl.hr.touncursewerequirearumor"));
        return img;
    }
}
