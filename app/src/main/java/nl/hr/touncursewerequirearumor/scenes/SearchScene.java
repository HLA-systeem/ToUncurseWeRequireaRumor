package nl.hr.touncursewerequirearumor.scenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.R;
import nl.hr.touncursewerequirearumor.scenes.managers.DrawVNstyle;
import nl.hr.touncursewerequirearumor.scenes.managers.SceneManager;


public class SearchScene implements Scene {
    private static String searchInfo;
    private SceneManager sceneManager;

    private Paint paint;
    private Paint textPaint;
    private int textHeight;

    private Rect searchBox;
    private Rect statsBox;
    private Rect saveBox;

    private Bitmap searchButton;
    private Bitmap statsButton;
    private Bitmap saveButton;
    private BitmapFactory bf;



    public SearchScene(SceneManager sceneManager){
        this.sceneManager = sceneManager;

        this.paint = new Paint();

        this.textPaint = new Paint();
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(Color.WHITE);
        this.textPaint.setTextSize(26);
        this.textPaint.setTypeface(Typeface.DEFAULT_BOLD);

        this.textHeight = (int)textPaint.getTextSize();
        this.searchBox = new Rect();
        this.searchBox.set(
                ( (Constants.SCREEN_WIDTH / 3)/2)  - (Constants.getTextWidth("SEARCH",this.textPaint)/2) -50,
                ( (Constants.SCREEN_HEIGHT - 100) - this.textHeight) - 50,
                ( (Constants.SCREEN_WIDTH / 3)/2) + (Constants.getTextWidth("SEARCH",this.textPaint)/2) +50,
                (Constants.SCREEN_HEIGHT - 100) +50);


        this.statsBox = new Rect();
        this.statsBox.set(
                ( (Constants.SCREEN_WIDTH /2) + ( (Constants.SCREEN_WIDTH / 2) /2) ) - (Constants.getTextWidth("RUN",this.textPaint)/2) -50,
                ( (Constants.SCREEN_HEIGHT - 100) - this.textHeight) - 50,
                ( (Constants.SCREEN_WIDTH /2) + ( (Constants.SCREEN_WIDTH / 2) /2) ) + (Constants.getTextWidth("ATTACK",this.textPaint)/2) +50,
                (Constants.SCREEN_HEIGHT - 100) +50);

        this.saveBox = new Rect();
        this.saveBox.set(
                ( (Constants.SCREEN_WIDTH /2) + ( (Constants.SCREEN_WIDTH / 2) /2) ) - (Constants.getTextWidth("RUN",this.textPaint)/2) -50,
                ( (Constants.SCREEN_HEIGHT - 100) - this.textHeight) - 50,
                ( (Constants.SCREEN_WIDTH /2) + ( (Constants.SCREEN_WIDTH / 2) /2) ) + (Constants.getTextWidth("ATTACK",this.textPaint)/2) +50,
                (Constants.SCREEN_HEIGHT - 100) +50);


        this.bf = new BitmapFactory();
        this.searchButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
        this.statsButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
        this.saveButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
    }

    public static void addSeachtInfo(String searchInfo){
        SearchScene.searchInfo += searchInfo;
    }

    @Override
    public void update(MotionEvent e) {
        if (e != null && DrawVNstyle.running == false) {
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (((int) e.getX() > searchBox.left && (int) e.getX() < searchBox.right) && ((int) e.getY() > searchBox.top && (int) e.getY() < searchBox.bottom)) {
                        this.searchButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonpress);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (((int) e.getX() > searchBox.left && (int) e.getX() < searchBox.right) && ((int) e.getY() > searchBox.top && (int) e.getY() < searchBox.bottom)) {
                        this.searchButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
                        this.switchScene();
                    }
                    break;
            }

        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.searchButton, null, this.searchBox, this.paint);
        //canvas.drawBitmap(this.statsButton, null, this.statsBox, this.paint);
        canvas.drawText("SEARCH",  ( (Constants.SCREEN_WIDTH / 3)/2), (Constants.SCREEN_HEIGHT - 100), this.textPaint);
        //canvas.drawText("RUN", ((Constants.SCREEN_WIDTH / 2) + ((Constants.SCREEN_WIDTH / 2) / 2)), (Constants.SCREEN_HEIGHT - 100), this.textPaint);
    }

    @Override
    public void switchScene() {
        sceneManager.setActiveScene(new BattleScene(sceneManager));
    }
}
