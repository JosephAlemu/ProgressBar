package com.example.admin.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private static int progress;
    private ProgressBar progressbarOne;
    private ProgressBar progressbarTwo;
    private ProgressBar progressbarThree;
    private ProgressBar progressbarFour;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    ExecutorService executorService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = 0;
        progressbarOne = (ProgressBar) findViewById(R.id.progressbarOne);
        progressbarTwo = (ProgressBar) findViewById(R.id.progressbarTwo);
        progressbarThree = (ProgressBar) findViewById(R.id.progressbarThree);
        progressbarFour = (ProgressBar) findViewById(R.id.progressbarFour);
        /*The first Progress Bar*/
        progressbarOne.setVisibility(View.VISIBLE);
        progressbarOne.setProgress(0);
        progressbarOne.setMax(100);

        /*The second Progress Bar*/
        progressbarTwo.setVisibility(View.VISIBLE);
        progressbarTwo.setProgress(0);
        progressbarTwo.setMax(100);

        /*The Third Progress Bar*/
        progressbarThree.setVisibility(View.VISIBLE);
        progressbarThree.setProgress(0);
        progressbarThree.setMax(100);

        /*The fourth Progress Bar*/
        progressbarFour.setVisibility(View.VISIBLE);
        progressbarFour.setProgress(0);
        progressbarFour.setMax(100);
        MyTask myTask1 = new MyTask( 500);
        MyTask myTask2 = new MyTask( 300);
        MyTask myTask3 = new MyTask( 100);
        MyTask myTask4 = new MyTask( 200);
        executorService = Executors.newFixedThreadPool(4);
        executorService.execute(myTask1);
        executorService.execute(myTask2);
        executorService.execute(myTask3);
        executorService.execute(myTask4);


        executorService.shutdown();
    }
}
