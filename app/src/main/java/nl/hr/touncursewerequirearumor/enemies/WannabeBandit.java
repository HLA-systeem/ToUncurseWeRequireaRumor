package nl.hr.touncursewerequirearumor.enemies;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.R;

public class WannabeBandit extends Enemy {
    private String name = "wannabe-bandit";
    private String nameRes = "wannabebandit";
    private int hp = 40;
    private int att = 20;
    private int speed = 40;
    private int hit = 30;

    public WannabeBandit() {
        super("wannabe-bandit", "wannabebandit", 40, 20, 40, 30);
    }

    @Override
    public Bitmap displayCharacter(){
        BitmapFactory bf = new BitmapFactory();
        Bitmap img = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.wannabebandit); //1280x800
        img = Bitmap.createScaledBitmap(img,640,400,true);
        return img;
    }
}
