package nl.hr.touncursewerequirearumor;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

public class Constants{
    public final static String MY_TAG = "Dev's Tag";
    public final static int REQUEST_CODE = 7;
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static Context CURRENT_CONTEXT;
    public static int TEXT_SPEED;

    enum Stats{
        HP,
        ATT,
        SPD,
        HIT
    }

    public final static int getTextWidth(String text, Paint textStyle){
        return (int) textStyle.measureText(text);
    }

    public final static boolean rectPressed(MotionEvent e, Rect box){
        if(((int) e.getX() > box.left && (int) e.getX() < box.right) && ((int) e.getY() > box.top && (int) e.getY() < box.bottom)){
            return true;
        }
        else{
            return false;
        }
    }


}
