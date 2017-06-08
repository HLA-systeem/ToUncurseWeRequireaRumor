package nl.hr.touncursewerequirearumor.scenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;

import com.vstechlab.easyfonts.EasyFonts;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.R;
import nl.hr.touncursewerequirearumor.scenes.managers.DrawVNstyle;
import nl.hr.touncursewerequirearumor.scenes.managers.SceneManager;
import nl.hr.touncursewerequirearumor.scenes.managers.SearchResultSeletor;


public class SearchScene implements Scene {
    private SceneManager sceneManager;
    private SearchResultSeletor selector;
    private Scene searchResult;
    private Scene switchTo;

    private Paint paint;
    private Paint textPaint;
    private int textHeight;

    private Rect backgroundBox;
    private Rect searchBox;
    private Rect statsBox;
    private Rect saveBox;

    private Bitmap background;
    private Bitmap searchButton;
    private Bitmap statsButton;
    private Bitmap saveButton;
    private BitmapFactory bf;


    public SearchScene(SceneManager sceneManager){
        this.sceneManager = sceneManager;
        this.selector = new SearchResultSeletor(this.sceneManager);
        this.searchResult = selector.selectSearchResult();

        this.paint = new Paint();

        this.textPaint = new Paint();
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(Color.WHITE);
        this.textPaint.setTextSize(26);
        this.textPaint.setTypeface(EasyFonts.greenAvocado(Constants.CURRENT_CONTEXT));

        this.textHeight = (int)textPaint.getTextSize();


        this.backgroundBox = new Rect();
        this.backgroundBox.set(
                0,
                0,
                Constants.SCREEN_WIDTH,
                Constants.SCREEN_HEIGHT);


        this.searchBox = new Rect();
        this.searchBox.set(
                ( (Constants.SCREEN_WIDTH / 3)/2)  - (Constants.getTextWidth("SEARCH",this.textPaint)/2) -50,
                ( (Constants.SCREEN_HEIGHT - 100) - this.textHeight) - 50,
                ( (Constants.SCREEN_WIDTH / 3)/2) + (Constants.getTextWidth("SEARCH",this.textPaint)/2) +50,
                (Constants.SCREEN_HEIGHT - 100) +50);


        this.statsBox = new Rect();
        this.statsBox.set(
                (Constants.SCREEN_WIDTH /2) - (Constants.getTextWidth("STATS",this.textPaint)/2) -50,
                ( (Constants.SCREEN_HEIGHT - 100) - this.textHeight) - 50,
                (Constants.SCREEN_WIDTH /2) + (Constants.getTextWidth("STATS",this.textPaint)/2) +50,
                (Constants.SCREEN_HEIGHT - 100) +50);


        this.bf = new BitmapFactory();
        this.background = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.forest);
        this.searchButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
        this.statsButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
        this.saveButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
    }

    @Override
    public void update(MotionEvent e) {
        if (e != null && DrawVNstyle.running == false) {
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (Constants.rectPressed(e,this.searchBox)) {
                        this.searchButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonpress);
                    }
                    if (Constants.rectPressed(e,this.statsBox)) {
                        this.statsButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonpress);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (Constants.rectPressed(e,this.searchBox)) {
                        this.searchButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
                        this.switchScene();
                    }
                    if (Constants.rectPressed(e,this.searchBox)) {
                        this.statsButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
                        this.switchScene();
                    }
                    break;
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.background, null, this.backgroundBox, this.paint);
        canvas.drawBitmap(this.searchButton, null, this.searchBox, this.paint);
        canvas.drawBitmap(this.statsButton, null, this.statsBox, this.paint);
        canvas.drawText("SEARCH",  ( (Constants.SCREEN_WIDTH / 3)/2), (Constants.SCREEN_HEIGHT - 100), this.textPaint);
    }

    @Override
    public void switchScene() {
        sceneManager.setActiveScene(this.searchResult);
    }

    public void displayForestBackground(){
        BitmapFactory bf = new BitmapFactory();
        Bitmap img = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier("forest","drawable", "nl.hr.touncursewerequirearumor"));
        this.background = img;
    }
}
