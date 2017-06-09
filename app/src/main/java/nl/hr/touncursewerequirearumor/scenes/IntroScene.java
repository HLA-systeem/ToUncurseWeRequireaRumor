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
import nl.hr.touncursewerequirearumor.scenes.managers.SceneManager;

public class IntroScene implements Scene {
    private SceneManager sceneManager;

    private Rect scrollBox;
    private Bitmap scroll;
    private BitmapFactory bf;

    private Paint paint;
    private Paint textPaint;
    private int textHeight;
    private String scrollText = "There is a rumor that an extremely rare creature is sighted\n" +
            "in the forest near our church.\n\n " +
            "This creature’s name is Atroe\n " +
            "and its poison can be used to develop all sorts of potions.\n\n" +
            "Many heroes are requested to look for this creature because of\n" +
            "this, which is good for our business.\n\n" +
            "Please capture the Atroe before anyone else does,\n" +
            "We want to keep attracting more heroes and \n" +
            "have them searching in the area for a while.\n" +
            "                           - You know who";

    public IntroScene(SceneManager sceneManager){
        this.sceneManager = sceneManager;

        this.paint = new Paint();
        this.textPaint = new Paint();
        this.textPaint.setTextAlign(Paint.Align.LEFT);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(Color.WHITE);
        this.textPaint.setTextSize(40);
        this.textPaint.setTypeface(EasyFonts.windSong(Constants.CURRENT_CONTEXT));

        this.textHeight = (int)textPaint.getTextSize();
        this.scrollBox = new Rect();
        this.scrollBox.set(
                ((Constants.SCREEN_WIDTH/2) - 960),
                54,
                ((Constants.SCREEN_WIDTH/2) + 960),
                Constants.SCREEN_HEIGHT - 54);

        this.bf = new BitmapFactory(); //scale
        this.scroll = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.scroll);
    }

    @Override
    public void update(MotionEvent e) {
        try {
            Thread.sleep(10);
        }

        catch (Exception ex){

        }
        if(e != null){
            if(e.getAction() == MotionEvent.ACTION_UP){ //make the current thread sleep before this
                this.switchScene();
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.scroll, null, this.scrollBox, this.paint);

        int x = 40;
        int y = 162 + this.textHeight;
        for (String line: scrollText.split("\n")){
            canvas.drawText(line, x, y, this.textPaint);
            y += this.textPaint.descent() - this.textPaint.ascent();
        }
    }

    @Override
    public void switchScene() {
        sceneManager.setActiveScene(new SearchScene(sceneManager));
    }
}
