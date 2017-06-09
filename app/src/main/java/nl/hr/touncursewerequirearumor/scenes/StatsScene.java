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
        if (e != null) {
            if (e.getAction() == MotionEvent.ACTION_UP &&
                    e.getX() > Constants.SCREEN_WIDTH - 100 ){

                if ((int) e.getY() > (50 + this.textHeight) && (int) e.getY() < (150+ this.textHeight)){ //Ik doe dit omdat een switch constants nodig heeft.
                    Player.player.increaseStat(Constants.STATS.HEALTH);
                    this.switchScene();
                }
                if ((int) e.getY() > (150 + this.textHeight) && (int) e.getY() < (250+ this.textHeight)){
                    Player.player.increaseStat(Constants.STATS.ATTACK);
                    this.switchScene();
                }
                if ((int) e.getY() > (250 + this.textHeight) && (int) e.getY() < (350+ this.textHeight)){
                    Player.player.increaseStat(Constants.STATS.SPEED);
                    this.switchScene();
                }
                if ((int) e.getY() > (350 + this.textHeight) && (int) e.getY() < (450+ this.textHeight)){
                    Player.player.increaseStat(Constants.STATS.ACCURACY);
                    this.switchScene();
                }
            }

            if (e.getAction() == MotionEvent.ACTION_UP &&
                    e.getX() > ( (Constants.SCREEN_WIDTH - 55) - Constants.getTextWidth("RETURN",this.textPaint) ) &&
                    e.getY() > Constants.SCREEN_HEIGHT - 57){
                    this.switchScene();
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        int height = 100;
        for(Constants.STATS status : Constants.STATS.values()){
            String statusString = status.toString();
            canvas.drawText(statusString + ": " + Player.player.getStat(status),  ( (Constants.SCREEN_WIDTH / 3)/2), height + this.textHeight, this.textPaint);

            if(this.levelUp == true){
                canvas.drawText("+",  Constants.SCREEN_WIDTH - 50, height + this.textHeight, this.textPaint);
            }

            height += 100;
        }

        canvas.drawText("RETURN",  (Constants.SCREEN_WIDTH - 5) - Constants.getTextWidth("RETURN",this.textPaint), Constants.SCREEN_HEIGHT - 7, this.textPaint);
    }

    @Override
    public void switchScene() {
        sceneManager.setActiveScene(new SearchScene(this.sceneManager));
    }
}
