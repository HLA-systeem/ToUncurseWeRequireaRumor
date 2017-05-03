package nl.hr.touncursewerequirearumor;


import android.os.Handler;
import android.os.Looper;

public class DrawVNstyle implements Runnable {
    private String text;
    private Handler handler;
    private int i;
    static boolean running = false;

    public DrawVNstyle(String text){
        this.text = text;
        this.handler = new Handler(Looper.myLooper());
        this.i = 0;
    }

    @Override
    public void run(){
        DrawVNstyle.running = true;
        String letter = Character.toString(this.text.charAt(i));
        BattleScene.addBattleInfo(letter);
        if (this.i < (this.text.length() - 1)) {
            this.i += 1;
            handler.postDelayed(this, Constants.TEXT_SPEED);
        }
        else{
            DrawVNstyle.running = false;
        }

    }
}
