package nl.hr.touncursewerequirearumor.scenes.managers;


import android.os.Handler;
import android.os.Looper;

import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.scenes.ItemScene;

public class DrawVNstyle implements Runnable {
    private String text;
    private String target;
    private Handler handler;
    private int i;

    public static boolean running = false;

    public DrawVNstyle(String text,String target){
        this.text = text;
        this.target = target;
        this.handler = new Handler(Looper.myLooper());
        this.i = 0;
    }

    @Override
    public void run(){
        DrawVNstyle.running = true;
        String letter = Character.toString(this.text.charAt(i));
        if(this.target == "battleText") {
            BattleScene.addBattleInfo(letter);
        }
        if(this.target == "itemText") {
            ItemScene.addItemInfo(letter);
        }
        if (this.i < (this.text.length() - 1)) {
            this.i += 1;
            handler.postDelayed(this, Constants.TEXT_SPEED);
        }
        else{
            DrawVNstyle.running = false;
        }

    }
}
