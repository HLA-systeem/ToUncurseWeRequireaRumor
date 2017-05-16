package nl.hr.touncursewerequirearumor.activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.background_processes.GameView;
import nl.hr.touncursewerequirearumor.Player;
import nl.hr.touncursewerequirearumor.enemies.Enemy;

public class GameActivity extends Activity {
    String weather;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Doet schijbaar niets, maar laat staan voor de zekerheid.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //FulLscreen

        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        Constants.TEXT_SPEED = Integer.parseInt(getPrefs.getString("text_speed","150"));

        this.weather = getIntent().getStringExtra("weatherID");
        Player p = Player.getInstance();

        switch (this.weather){
            case "Thunderstorm":
                p.setBoost("Thunderstorm");
                break;
            case "Snow":
                //Affect: The enemy's attack power is decreased.
                Enemy.setNerf("Snow");
                break;
            case "Drizzle":
                //Affect:The enemy's hit rate is decreased.
                Enemy.setNerf("Drizzle");
                break;
            case "Rain":
                //Affect: The enemy's speed is decreased.
                Enemy.setNerf("Rain");
                break;
            case "Atmosphere":
                p.setBoost("Atmosphere");
                break;
        }

        setContentView(new GameView(this));
    }

}
