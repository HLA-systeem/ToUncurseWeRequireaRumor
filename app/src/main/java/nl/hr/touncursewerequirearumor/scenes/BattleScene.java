package nl.hr.touncursewerequirearumor.scenes;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.scenes.managers.EnemySelector;
import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.R;
import nl.hr.touncursewerequirearumor.scenes.managers.SceneManager;
import nl.hr.touncursewerequirearumor.enemies.Enemy;
import nl.hr.touncursewerequirearumor.scenes.managers.BattleManager;
import nl.hr.touncursewerequirearumor.scenes.managers.DrawVNstyle;
import nl.hr.touncursewerequirearumor.scenes.managers.battle_states.PlayerAttack;
import nl.hr.touncursewerequirearumor.scenes.managers.battle_states.Run;
import nl.hr.touncursewerequirearumor.scenes.managers.battle_states.Setup;


public class BattleScene implements Scene {
    private SceneManager sceneManager;

    private BattleManager battleManager;
    private EnemySelector enemySelector;
    private Enemy enemy;
    private Player player;
    private Rect enemyBox;
    private Rect attBox;
    private Rect runBox;
    private Paint paint;
    private Paint textPaint;
    private int textHeight;
    private static String battleInfo;
    private Bitmap attButton;
    private Bitmap runButton;
    private BitmapFactory bf;
    private Scene switchTo;


    public static synchronized void addBattleInfo(String battleInfo){
        BattleScene.battleInfo += battleInfo;
    }

    public static synchronized void clearBattleInfo(){
        BattleScene.battleInfo = "";
    }

    public BattleScene(SceneManager sceneManager){
        this.sceneManager = sceneManager;
        this.battleManager = new BattleManager();
        this.player = Player.getInstance();

        this.paint = new Paint();

        this.textPaint = new Paint();
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(Color.WHITE);
        this.textPaint.setTextSize(26);
        this.textPaint.setTypeface(Typeface.DEFAULT_BOLD);

        this.enemySelector = new EnemySelector();
        this.enemy = enemySelector.selectEnemy();
        this.enemyBox = new Rect();
        this.enemyBox.set(((Constants.SCREEN_WIDTH/2) - 320),((Constants.SCREEN_HEIGHT/2) - 200),((Constants.SCREEN_WIDTH/2) + 320),((Constants.SCREEN_HEIGHT/2) + 200));

        this.battleManager.setBattleState(new Setup(this.battleManager,this.player,this.enemy,true));

        this.textHeight = (int)textPaint.getTextSize();
        this.attBox = new Rect();
        this.attBox.set(
                ( (Constants.SCREEN_WIDTH / 2) /2) - (Constants.getTextWidth("ATTACK",this.textPaint)/2) -50,
                ( (Constants.SCREEN_HEIGHT - 100) - this.textHeight) - 50,
                ( (Constants.SCREEN_WIDTH / 2) /2) + (Constants.getTextWidth("ATTACK",this.textPaint)/2) +50,
                (Constants.SCREEN_HEIGHT - 100) +50);


        this.runBox = new Rect();
        this.runBox.set(
                ( (Constants.SCREEN_WIDTH /2) + ( (Constants.SCREEN_WIDTH / 2) /2) ) - (Constants.getTextWidth("RUN",this.textPaint)/2) -50,
                ( (Constants.SCREEN_HEIGHT - 100) - this.textHeight) - 50,
                ( (Constants.SCREEN_WIDTH /2) + ( (Constants.SCREEN_WIDTH / 2) /2) ) + (Constants.getTextWidth("ATTACK",this.textPaint)/2) +50,
                (Constants.SCREEN_HEIGHT - 100) +50);


        this.bf = new BitmapFactory();
        this.attButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
        this.runButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
    }

    @Override
    public void update(MotionEvent e){
        if(e != null && DrawVNstyle.running == false) {
            if(this.battleManager.getBattleState().getClass().equals(Setup.class)){
                switch (e.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        if (Constants.rectPressed(e,this.attBox)) {
                            this.attButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonpress);
                        }
                        if (Constants.rectPressed(e,this.runBox)) {
                            this.runButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonpress);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (Constants.rectPressed(e,this.attBox)) {
                            this.attButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
                            this.battleManager.setBattleState(new PlayerAttack(this.battleManager,this.player,this.enemy));
                            this.battleManager.getBattleState().execute();
                        }
                        if (Constants.rectPressed(e,this.runBox)) {
                            this.runButton = this.bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.buttonidle);
                            this.battleManager.setBattleState(new Run(this.battleManager,this.player,this.enemy));

                        }
                        break;
                }
            }
            else{
                if(e.getAction() == MotionEvent.ACTION_UP){
                    if(DrawVNstyle.running == false){
                        this.clearBattleInfo();
                        if(this.battleInfo == ""){ //omdat text nog wil verschijnen terwijl de runnable klaar is.
                            if(this.battleManager.getResult() != "None"){
                                this.decideNextScene();
                            }
                            else{
                                this.battleManager.getBattleState().execute();
                            }
                        }
                    }
                }
            }
        }
    }


    @Override
    public void draw(Canvas canvas) {
        if(this.battleManager.getBattleState().getClass().equals(Setup.class)){
            canvas.drawBitmap(this.attButton, null, this.attBox, this.paint);
            canvas.drawBitmap(this.runButton, null, this.runBox, this.paint);
            canvas.drawText("ATTACK", ((Constants.SCREEN_WIDTH / 2) / 2), (Constants.SCREEN_HEIGHT - 100), this.textPaint);
            canvas.drawText("RUN", ((Constants.SCREEN_WIDTH / 2) + ((Constants.SCREEN_WIDTH / 2) / 2)), (Constants.SCREEN_HEIGHT - 100), this.textPaint);
        }

        canvas.drawBitmap(enemy.displayCharacter(),null,enemyBox,this.paint);
        if(this.battleInfo != null) {
            canvas.drawText(battleInfo, (Constants.SCREEN_WIDTH / 2), ((Constants.SCREEN_HEIGHT / 2) + 250), this.textPaint);
        }
    }

    @Override
    public void switchScene() {
        this.sceneManager.setActiveScene(this.switchTo);
    }

    private void decideNextScene(){
        switch(this.battleManager.getResult()){
            case "Winner":
                this.switchTo = new SearchScene(this.sceneManager); //dit gaat naar de status screen later
                break;
            case "Defeated":
                this.switchTo = new SearchScene(this.sceneManager);//dit gaat naar de gameover screen later
                break;
            case "Escaped":
                this.switchTo = new SearchScene(this.sceneManager);
                break;
        }
        this.switchScene();
    }

}
