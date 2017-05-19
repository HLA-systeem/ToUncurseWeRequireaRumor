package nl.hr.touncursewerequirearumor.scenes.managers;

import android.graphics.Canvas;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;

import nl.hr.touncursewerequirearumor.scenes.BattleScene;
import nl.hr.touncursewerequirearumor.scenes.IntroScene;
import nl.hr.touncursewerequirearumor.scenes.Scene;

public class SceneManager {
    private Scene activeScene;

    public SceneManager(){
        this.activeScene = new IntroScene(this);
    }

    public void setActiveScene(Scene activeScene){
        this.activeScene = activeScene;
    }

    public void update(MotionEvent e) {
        this.activeScene.update(e);
    }

    public void draw(Canvas canvas){
        this.activeScene.draw(canvas);
    }
}
