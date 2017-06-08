package nl.hr.touncursewerequirearumor.scenes;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.scenes.managers.SceneManager;

public class StatsScene implements Scene {
    private SceneManager sceneManager;
    private Boolean levelUp;

    private Paint textPaint;
    private int textHeight;

    StatsScene(SceneManager sceneManager, Boolean levelUp){
        this.sceneManager = sceneManager;
        this.levelUp = levelUp;

        this.textPaint = new Paint();
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(Color.WHITE);
        this.textPaint.setTextSize(26);
        this.textPaint.setTypeface(Typeface.DEFAULT_BOLD);

        this.textHeight = (int)textPaint.getTextSize();
    }

    @Override
    public void update(MotionEvent e) {

    }

    @Override
    public void draw(Canvas canvas) {
        int height = 50;
        for(Constants.STATS status : Constants.STATS.values()){
            String statusString = status.toString();
            canvas.drawText(statusString + ": " + Player.player,  ( (Constants.SCREEN_WIDTH / 3)/2), height + this.textHeight, this.textPaint);
            height += 50;
        }

        if(this.levelUp == true){
            //canvas.drawText("+",  ( (Constants.SCREEN_WIDTH / 3)/2), height + this.textHeight, this.textPaint);
        }
    }

    @Override
    public void switchScene() {

    }
}
