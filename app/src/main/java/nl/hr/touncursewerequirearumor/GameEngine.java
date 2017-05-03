package nl.hr.touncursewerequirearumor;

import android.graphics.Canvas;

import android.view.MotionEvent;



public class GameEngine{
    private SceneManager sceneManager;


    public GameEngine(){
        this.sceneManager = new SceneManager();
    }

    public void update(MotionEvent e){
        this.sceneManager.update(e);
    }

    public void draw(Canvas canvas){
        this.sceneManager.draw(canvas);
    }

    public void recieveTouch(MotionEvent e){
        this.update(e);
    }
}
