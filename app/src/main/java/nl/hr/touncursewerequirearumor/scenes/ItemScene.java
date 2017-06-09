package nl.hr.touncursewerequirearumor.scenes;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;


import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.R;
import nl.hr.touncursewerequirearumor.items.GameItem;
import nl.hr.touncursewerequirearumor.scenes.managers.DrawVNstyle;
import nl.hr.touncursewerequirearumor.scenes.managers.ItemSelector;
import nl.hr.touncursewerequirearumor.scenes.managers.SceneManager;


public class ItemScene implements Scene {
    private SceneManager sceneManager;

    private GameItem item;
    private ItemSelector itemSelector;
    private boolean itemUsed;

    private Rect backgroundBox;
    private Rect itemBox;

    private Bitmap background;
    private BitmapFactory bf;

    private Paint paint;
    private Paint textPaint;

    private static String itemInfo;

    public ItemScene(SceneManager sceneManager){
        this.sceneManager = sceneManager;



        this.itemSelector = new ItemSelector();
        this.item = this.itemSelector.selectItem();
        this.addText(this.item.findingText());
        this.itemBox = new Rect();
        this.itemBox.set(((Constants.SCREEN_WIDTH/2) - 320),((Constants.SCREEN_HEIGHT/2) - 200),((Constants.SCREEN_WIDTH/2) + 320),((Constants.SCREEN_HEIGHT/2) + 200));

        this.itemUsed = false;

        this.paint = new Paint();

        this.textPaint = new Paint();
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(Color.WHITE);
        this.textPaint.setTextSize(26);
        this.textPaint.setTypeface(Typeface.DEFAULT_BOLD);

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
        if(e != null && DrawVNstyle.running == false){
            if(e.getAction() == MotionEvent.ACTION_UP){
                if(DrawVNstyle.running == false){
                    this.clearItemInfo();
                    if(this.itemInfo == ""){ //omdat text nog wil verschijnen terwijl de runnable klaar is.
                        if(itemUsed == false) {
                            this.addText(item.use());
                            itemUsed = true;
                        }
                        else{
                            this.switchScene();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.background, null, this.backgroundBox, this.paint);
        canvas.drawBitmap(item.displayItem(),null,itemBox,this.paint);
        if(this.itemInfo != null) {
            canvas.drawText(this.itemInfo, (Constants.SCREEN_WIDTH / 2), ((Constants.SCREEN_HEIGHT / 2) + 250), this.textPaint);
        }
    }

    @Override
    public void switchScene() {
        sceneManager.setActiveScene(new SearchScene(this.sceneManager));
    }

    public static synchronized void addItemInfo(String searchInfo){
        ItemScene.itemInfo += searchInfo;
    }

    public static synchronized void clearItemInfo(){
        ItemScene.itemInfo = "";
    }

    private void addText(String text){
        ItemScene.clearItemInfo();
        Runnable delayText = new DrawVNstyle(text,"itemText");
        Thread t = new Thread(delayText);
        t.start();
    }

}
