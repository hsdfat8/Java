package com.example.remoteapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;

public class MyResultReceiver extends ResultReceiver {

    private Receiver mReceiver;

    public MyResultReceiver(Handler handler) {
        super(handler);
        // TODO Auto-generated constructor stub
    }

    public interface Receiver {
        public void onReceiveResult(int resultCode, Bundle resultData);

    }

    public void setReceiver(Receiver receiver) {
        mReceiver = receiver;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {

        if (mReceiver != null) {
            Log.d("PHAT","onReceiveResult= " +resultData.toString());
            mReceiver.onReceiveResult(resultCode, resultData);
        }else {
            Toast.makeText((Context) mReceiver, "Can't get Response from Service", Toast.LENGTH_SHORT).show();
        }
    }

}
