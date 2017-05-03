package nl.hr.touncursewerequirearumor;

import android.content.Context;
import android.graphics.Paint;

public class Constants{
    public final static String MY_TAG = "Dev's Tag";
    public final static int REQUEST_CODE = 7;
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static Context CURRENT_CONTEXT;
    public static int TEXT_SPEED;

    public final static int getTextWidth(String text, Paint textStyle){
        return (int) textStyle.measureText(text);
    }
}
