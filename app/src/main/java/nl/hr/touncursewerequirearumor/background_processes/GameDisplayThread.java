package nl.hr.touncursewerequirearumor.background_processes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.GameEngine;

public class GameDisplayThread extends Thread{
    private final int MAX_FPS = 30;
    private int frameCount = 0;
    private long startTime;
    private long sleepTime;
    private long totalTime = 0;
    private long targetTime = 1000/MAX_FPS;
    private long millisTime = targetTime;


    private SurfaceHolder surfaceHolder;
    private GameEngine engine;
    private Paint backgroundPaint;
    private boolean running;


    public void setRunning(boolean running){
        this.running = running;
    }

    public boolean getRunning(){
        return this.running;
    }

    public GameEngine getEngine(){
        return this.engine;
    }

    public GameDisplayThread(SurfaceHolder surfaceHolder, Context context){
        this.surfaceHolder = surfaceHolder;
        this.engine = new GameEngine();

        //black painter below to clear the screen before the game is rendered
        backgroundPaint = new Paint();
        backgroundPaint.setARGB(255, 0, 0, 0); //Zwart
        this.running = true;
    }


    @Override
    public void run(){
        while(running){
            this.startTime = System.nanoTime();

            Canvas canvas = this.surfaceHolder.lockCanvas(null); //Maak de canvas onbruikbaar.\

            if (canvas != null){
                //Clears the screen with black paint and draws object on the canvas
                synchronized(surfaceHolder){
                    canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
                    this.engine.update(null);
                    this.engine.draw(canvas);
                }

                this.surfaceHolder.unlockCanvasAndPost(canvas);
            }

            //reguleer tijd tussen refreshes
            this.millisTime = (System.nanoTime() - this.startTime)/1000000; //delen door 1miljoen omdat we van nano naar millisec gaan
            this.sleepTime = this.targetTime - this.millisTime;
            try {
                if(this.sleepTime > 0) {
                    Thread.sleep(this.sleepTime);
                }
            }

            catch (Exception e){
                Log.d(Constants.MY_TAG,"Failed to delay time between refreshes.");
                e.printStackTrace();
            }

            this.totalTime = System.nanoTime() - this.startTime;
            this.frameCount +=1;
            if(this.frameCount >= this.MAX_FPS){
                this.frameCount = 0;
                this.totalTime = 0;
            }

        }
    }

    public void stopThread(Thread thread){
        boolean retry = true;
        while (retry == true){
            try{
                thread.join();
                retry = false;
            }
            catch(Exception e){
                Log.d(Constants.MY_TAG,"Failed to top the GameThread.");
                e.printStackTrace();
            }
        }
    }

}

