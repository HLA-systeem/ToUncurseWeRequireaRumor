package nl.hr.touncursewerequirearumor;

import android.graphics.Canvas;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private Map <String,Scene> scenes = new HashMap<String,Scene>();
    public String activeScene = "Intro";

    public SceneManager(){
        IntroScene introScene = new IntroScene(this);
        scenes.put(introScene.SCENE_NAME, introScene);

        BattleScene battleScene = new BattleScene(this);
        scenes.put(battleScene.SCENE_NAME, battleScene);
    }

    public void setActiveScene(String activeScene){
        this.activeScene = activeScene;
    }

    public void update(MotionEvent e) {
        scenes.get(activeScene).update(e);
    }

    public void draw(Canvas canvas){
        scenes.get(activeScene).draw(canvas);
    }
}
