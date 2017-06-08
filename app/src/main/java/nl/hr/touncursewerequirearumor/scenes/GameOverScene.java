package nl.hr.touncursewerequirearumor.scenes;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;

import nl.hr.touncursewerequirearumor.Constants;

public class GameOverScene implements Scene {
    private Paint textPaint;

    public GameOverScene(){
        this.textPaint = new Paint();
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(Color.WHITE);
        this.textPaint.setTextSize(26);
        this.textPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override
    public void update(MotionEvent e) {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText("GAME OVER", Constants.SCREEN_WIDTH / 2, Constants.SCREEN_HEIGHT/2, this.textPaint);
    }

    @Override
    public void switchScene() {

    }
}
