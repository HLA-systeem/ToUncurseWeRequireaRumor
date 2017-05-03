package nl.hr.touncursewerequirearumor;


import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GameView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder surfaceHolder;
    private Context context;
    private GameDisplayThread gdThread;
    private GameEngine engine;

    public GameView(Context context){
        super(context);
        this.context = context;

        this.surfaceHolder = getHolder();
        this.surfaceHolder.addCallback(this);

        Constants.CURRENT_CONTEXT = context;

        this.gdThread = new GameDisplayThread(this.surfaceHolder, this.context);
        this.engine = this.gdThread.getEngine();
        setFocusable(true); //wat doet dit?
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        //Starts the display thread
        if(this.gdThread.getRunning() == false){
            this.gdThread = new GameDisplayThread(this.surfaceHolder, this.context);
            this.gdThread.start();
        }
        else{
            this.gdThread.start();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height){
	   //Inerface required, but I'm not using it.
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder){
        boolean retry = true;
        while(retry == true) {
            try {
                this.gdThread.setRunning(false);
                this.gdThread.stopThread(this.gdThread);
                retry = false;
                }

            catch(Exception e){
                Log.d(Constants.MY_TAG,"Failed to destroy the GameSurface.");
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if(this.engine != null){
            engine.recieveTouch(e);
        }

        return true;
    }

}
