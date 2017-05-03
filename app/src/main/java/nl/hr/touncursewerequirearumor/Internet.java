package nl.hr.touncursewerequirearumor;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class Internet extends AsyncTask<String, Void, String>{ //<dataType die je stuurt in doInBackground,datatType voor verozoeken tussen de connectie door,return>
    private WeakReference<MainActivity> activityRef;
    private String apiCall;

    public Internet(MainActivity mainActivity, String userLat, String userLong){
        this.activityRef = new WeakReference<MainActivity>(mainActivity);
        this.apiCall = "http://api.openweathermap.org/data/2.5/weather?lat="+ userLat +"&lon=" +userLong +"&APPID=9dd7244717aa2ab8d57a4296ad0a45b6";
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "No Result";

        HttpURLConnection con = null;
        Log.d(Constants.MY_TAG,"Internet request gestart");
        try {
            URL url = new URL(this.apiCall);
            con = (HttpURLConnection) url.openConnection();

            con.setReadTimeout(10000 /* milliseconds */);
            con.setConnectTimeout(15000 /* milliseconds */);
            con.setRequestMethod("GET");

            con.setDoInput(true);

            // Start the query
            con.connect();

            // Read results from the query
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "UTF-8"));
            String json= reader.readLine();
            reader.close();

            // Parse to get translated text
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = (JSONArray) jsonObject.get("weather");
            JSONObject innerObj = (JSONObject) array.get(0);
            result = innerObj
                    .getString("main")
                    .replace("&#39;", "'")
                    .replace("&amp;", "&");
        } catch (IOException e) {
            Log.e(Constants.MY_TAG, "IOException", e);
        } catch (JSONException e) {
            Log.e(Constants.MY_TAG, "JSONException", e);
        } catch (Exception e) {
            Log.d(Constants.MY_TAG, "Something went wrong... ", e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }

        Log.d(Constants. MY_TAG, "   -> returned: " + result);

        // verwerk result.

        return result;
    }

    @Override
    protected void onPostExecute(String weather){
        Log.d(Constants.MY_TAG,"Klaar met internet request");
        this.activityRef.get().setWeather(weather);
    }



}
