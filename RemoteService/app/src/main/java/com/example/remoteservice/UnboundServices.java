package com.example.remoteservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;


import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class UnboundServices extends Service{
    private  static final String KEY_NUM_A = "A";
    private  static final String KEY_NUM_B = "B";

    public Context context = this;
    public Handler handler = null;
    public static Runnable runnable = null;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){


        Toast.makeText(this, "Service created!", Toast.LENGTH_LONG).show();
        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                Toast.makeText(context, "Service is still running", Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable, 10000);
            }
        };
        handler.postDelayed(runnable, 15000);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ResultReceiver rec = intent.getParcelableExtra("receiverTag");
        String numA = intent.getStringExtra(KEY_NUM_A);
        String numB = intent.getStringExtra(KEY_NUM_B);
        int result = Integer.parseInt(numA) + Integer.parseInt(numB);

        //Weather
        WeatherData.Coord coord = new WeatherData.Coord(145,-16);
        WeatherData.Clouds clouds = new WeatherData.Clouds(75);
        WeatherData.Weather weatherElment = new WeatherData.Weather(803,"Clouds","broken clouds", "04n");
        List<WeatherData.Weather> weather = new ArrayList<WeatherData.Weather>();
        weather.add(weatherElment);
        WeatherData.Wind wind = new WeatherData.Wind(10.01,22,5.21);
        WeatherData.Main main = new WeatherData.Main(301.12,304.87,301.12,302.1,1006,78);
        WeatherData.Sys sys = new WeatherData.Sys(1,9490,"AU",1636572930,1636619188);
        WeatherData weatherData = new WeatherData(coord,weather,"stations",main,10000,wind,clouds,1636620807,sys,36000,2172797,"Cairn",200);
        Gson gson = new Gson();
        String strGson = gson.toJson(weatherData);

        Toast.makeText(this, "Result: " + result, Toast.LENGTH_SHORT).show();
        Bundle b = new Bundle();
        b.putString(WeatherData.KEY_Weather_DATA,strGson);
        b.putString("ServiceTag","Done");
        rec.send(0,b);
        return START_REDELIVER_INTENT;
    }
}