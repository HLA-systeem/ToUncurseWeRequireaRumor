package nl.hr.touncursewerequirearumor.scenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.vstechlab.easyfonts.EasyFonts;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.R;

public class EndingScene implements Scene {
    private Rect scrollBox;
    private Bitmap scroll;
    private BitmapFactory bf;

    private Paint paint;
    private Paint textPaint;
    private int textHeight;
    private String scrollText = "Thank you.\n\n" +
            "We have had a lot more customers.\n" +
            "All of them are searching for the Atroe\n"+
            "I will hand you you're share next time you stop by.\n\n"+
            "Always a pleasure doing business with you,"+
            "                           - The Church of Url";

    public EndingScene(){

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

    }
}
