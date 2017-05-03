package nl.hr.touncursewerequirearumor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;

public class SearchScene implements Scene {
    private SceneManager sceneManager;
    private static String searchInfo;
    private Bitmap searchButton;
    private Bitmap statsButton;
    private Bitmap saveButton;
    private BitmapFactory bf;

    public SearchScene(SceneManager sceneManager){
        this.sceneManager = sceneManager;
    }

    public static void addSeachtInfo(String searchInfo){
        SearchScene.searchInfo += searchInfo;
    }

    @Override
    public void update(MotionEvent e) {

    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void terminate() {

    }

    @Override
    public void switchScene() {

    }
}
