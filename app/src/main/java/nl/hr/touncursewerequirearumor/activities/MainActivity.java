package nl.hr.touncursewerequirearumor.activities;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import nl.hr.touncursewerequirearumor.Constants;
import nl.hr.touncursewerequirearumor.background_processes.Internet;
import nl.hr.touncursewerequirearumor.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private GoogleApiClient googleApi;
    private Location aLocLast;
    private LocationRequest aLocReq;
    private String weather;
    private String userLat;
    private String userLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//Doet schijbaar niets, maar laat staan voor de zekerheid.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //FulLscreen
        getSupportActionBar().hide(); //verwijdert de blauwe balk

        setContentView(R.layout.activity_main);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;

        Button newgame = (Button) findViewById(R.id.button_newgame);
        newgame.setOnClickListener(this);

        Button settings = (Button) findViewById(R.id.button_settings);
        settings.setOnClickListener(this);

        this.weather = "Clear";


        if (this.googleApi == null) { //maak het GoogleAPIclient object als deze er niet is.
            this.googleApi = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        this.createLocationRequest();
    }


    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_newgame:
                Intent game = new Intent(this, GameActivity.class);
                game.putExtra("weatherID", this.weather);
                startActivity(game);
                break;
            case R.id.button_settings:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        googleApi.connect();
        if (googleApi.isConnected()) {
            startLocationUpdate();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (googleApi.isConnected()){
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApi, this); //stops location updates
            googleApi.disconnect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (googleApi.isConnected()){
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApi, this);
            googleApi.disconnect();
        }
    }

    private void createLocationRequest() {
        this.aLocReq = new LocationRequest();
        this.aLocReq.setInterval(5500);
        this.aLocReq.setFastestInterval(5000);
        this.aLocReq.setPriority(LocationRequest.PRIORITY_LOW_POWER);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        this.aLocLast = LocationServices.FusedLocationApi.getLastLocation(googleApi);

        if (this.aLocLast != null) {
            Log.d(Constants.MY_TAG, "Locatie is: " + aLocLast.toString());
            this.userLat = String.valueOf(aLocLast.getLatitude());
            this.userLong = String.valueOf(aLocLast.getLongitude());
            Internet getWeather = new Internet(this,this.userLat,this.userLong);
            getWeather.execute();
        }
        else {
            Log.d(Constants.MY_TAG, "Locatie is onbekend");
            startLocationUpdate();
        }
    }

    private void startLocationUpdate() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d(Constants.MY_TAG, "Permission problem in startLocationUpdate");
            return;
        }
        Log.d(Constants.MY_TAG, "Now requesting location..");
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApi, aLocReq, this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(Constants.MY_TAG, "Connection suspended");

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult){
        Log.d(Constants.MY_TAG, "Connection failed");
    }

    @Override
    public void onLocationChanged(Location location) {
        this.aLocLast = location;
        Log.d(Constants.MY_TAG, "Locatie is: " + aLocLast.toString());
        this.userLat = String.valueOf(aLocLast.getLatitude());
        this.userLong = String.valueOf(aLocLast.getLongitude());
        Internet getWeather = new Internet(this,this.userLat,this.userLong);
        getWeather.execute();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        if (requestCode == Constants.REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                this.startLocationUpdate();
            }

            else {
                this.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }
    }

    public void setWeather(String weather){
        this.weather = weather;
        if(this.weather != null){
            TextView ws = (TextView) findViewById(R.id.text_weatherStatus);
            TextView aff = (TextView) findViewById(R.id.text_affect);
            ws.setText("Weather: " + this.weather);
            switch (this.weather){
                case "Thunderstorm":
                    aff.setText("Affect: Your attack power is increased.");
                    break;
                case "Snow":
                    aff.setText("Affect: The enemy's attack power is decreased.");
                    break;
                case "Drizzle":
                    aff.setText("Affect:The enemy's hit rate is decreased.");
                    break;
                case "Rain":
                    aff.setText("Affect: The enemy's speed is decreased.");
                    break;
                case "Atmosphere":
                    aff.setText("Affect: Your run chance is increased.");
                    break;
            }
        }
    }
}

/*
private Switch;
public void saveData{
    Shared prefs = getSharedPreferences(getPackageName()+ "")
}

public void loadData{
    Shared prefs = getSharedPreferences(getPackageName()+ "")
}
 */
