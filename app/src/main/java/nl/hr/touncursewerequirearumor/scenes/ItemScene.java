package nl.hr.touncursewerequirearumor.scenes;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.R;
import nl.hr.touncursewerequirearumor.items.GameItem;
import nl.hr.touncursewerequirearumor.scenes.managers.DrawVNstyle;
import nl.hr.touncursewerequirearumor.scenes.managers.ItemSelector;
import nl.hr.touncursewerequirearumor.scenes.managers.SceneManager;


public class ItemScene implements Scene {
    private GameItem item;
    private ItemSelector itemSelector;
    private GameItem selectedItem;

    private Rect backgroundBox;

    private Bitmap background;
    private BitmapFactory bf;

    private static String itemInfo;

    public ItemScene(SceneManager sceneManager){
        this.itemSelector = new ItemSelector();
        this.selectedItem = this.itemSelector.selectItem();

        this.backgroundBox = new Rect();
        this.backgroundBox.set(
                0,
                0,
                Constants.SCREEN_WIDTH,
                Constants.SCREEN_HEIGHT);

        this.bf = new BitmapFactory();
        this.background = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.forest);
    }

    @Override
    public void update(MotionEvent e) {
        if(e != null && DrawVNstyle.running == false) {
            if(e.getAction() == MotionEvent.ACTION_UP){
                if(DrawVNstyle.running == false){
                    this.clearBattleInfo();
                    if(this.itemInfo == ""){ //omdat text nog wil verschijnen terwijl de runnable klaar is.

                    }
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void switchScene() {

    }

    public static synchronized void addItemInfo(String searchInfo){
        ItemScene.itemInfo += searchInfo;
    }

    public static synchronized void clearBattleInfo(){
        ItemScene.itemInfo = "";
    }

}
