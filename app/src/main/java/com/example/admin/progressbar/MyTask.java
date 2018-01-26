package com.example.admin.progressbar;

import android.util.Log;

/**
 * Created by Admin on 1/25/2018.
 */

public class MyTask implements Runnable {

    private static final String TAG = "MyTask";
    private int sleepTime = 0;
    private int count = 0;
    private static int idCount = 0;
    private  int id = 0;

    private int percent = 100;

    MyTask(int sleepTime) {
        this.sleepTime = sleepTime;
        this.id = ++idCount;
    }


    @Override
    public void run() {

        Log.d(TAG, "ID: "+ id +" *******  Started ****** ");
        for (int i = 0; i <percent; i++) {
            try {
                count++;
                Log.d(TAG, "ID: "+ id +" count: "+count);
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                Log.e(TAG + " :" + id, "error: " + ex);

            }
        }
        Log.d(TAG, "ID: "+ id +" *******  Finished ****** ");
    }
}
