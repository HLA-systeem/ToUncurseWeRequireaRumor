package nl.hr.touncursewerequirearumor.scenes;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Scene{ //defining what a object can do = use an interface, defining what makes the object use a class.
    public void update(MotionEvent e);
    public void draw(Canvas canvas);
    public void switchScene();

}
