package com.example.remoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UnboundActivity  extends AppCompatActivity implements MyResultReceiver.Receiver {
    private EditText editNumA, editNumB;
    public Button Button_Add;
    private  static final String KEY_NUM_A = "A";
    private  static final String KEY_NUM_B = "B";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unbound);

        initView();
    }

    public void initView(){

        editNumA = (EditText) findViewById(R.id.edit_num_a);
        editNumB = (EditText) findViewById(R.id.edit_num_b);
        Button_Add = (Button) findViewById(R.id.buttonAdd);

        Log.println(Log.DEBUG,"PHAT",Button_Add.toString());
        MyResultReceiver mReceiver;
        mReceiver = new MyResultReceiver(new Handler());
        Log.d("PHAT","received result from Service 1= " +this.toString());
        mReceiver.setReceiver(this);

        Button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.remoteservice","com.example.remoteservice.UnboundServices");
                intent.putExtra(KEY_NUM_A,editNumA.getText().toString());
                intent.putExtra(KEY_NUM_B,editNumB.getText().toString());
                intent.putExtra("receiverTag",mReceiver);
                startService(intent);
            }
        });

    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d("PHAT","received result from Service = "+resultData.getString("ServiceTag"));
        String strJson = resultData.getString(WeatherData.KEY_Weather_DATA);
        Log.d("PHAT","strJson = "+ strJson);
    }
}
