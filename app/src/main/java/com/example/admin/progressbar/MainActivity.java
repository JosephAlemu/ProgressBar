package com.example.admin.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressbarOne;
    private ProgressBar progressbarTwo;
    private ProgressBar progressbarThree;
    private ProgressBar progressbarFour;
    private int progressStatus = 0;
    private Handler handler ;



    ExecutorService executorService = null;
    private TextView tvFour;
    private TextView tvThree;
    private TextView tvTwo;
    private TextView tvOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler = new Handler(getApplicationContext().getMainLooper());

        progressbarOne = (ProgressBar) findViewById(R.id.progressbarOne);
        progressbarTwo = (ProgressBar) findViewById(R.id.progressbarTwo);
        progressbarThree = (ProgressBar) findViewById(R.id.progressbarThree);
        progressbarFour = (ProgressBar) findViewById(R.id.progressbarFour);
        tvOne = (TextView)findViewById(R.id.tvOne);
        tvTwo = (TextView)findViewById(R.id.tvTwo);
        tvThree = (TextView)findViewById(R.id.tvThree);
        tvFour = (TextView)findViewById(R.id.tvFour);
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



        ExecutorService execService = Executors.newFixedThreadPool(4);

        /*  progress bar  One  */

        execService.execute(new Runnable() {
            int  count =0;
            @Override
            public void run() {

                while(count  <100){
                    try {
                        ++count;
                        progressbarOne.setProgress(count);
                        tvOne.post(new Runnable() {
                            @Override
                            public void run() {
                                tvOne.setText(count+"%");
                            }
                        });

                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

         /*  progress bar  Two  */
        execService.execute(new Runnable() {
            int  count =0;
            @Override
            public void run() {

                while(count  <100){
                    try {
                        ++count ;
                        progressbarTwo.setProgress(count);


                        tvTwo.post(new Runnable() {
                            @Override
                            public void run() {
                                tvTwo.setText(count+"%");
                            }
                        });
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

          /*  progress bar  Three  */
        execService.execute(new Runnable() {

            int  count =0;
            @Override
            public void run() {

                while(count  <100){
                try {
                    ++count ;
                    progressbarThree.setProgress(count);


                    tvThree.post(new Runnable() {
                        @Override
                        public void run() {
                            tvThree.setText(count+"%");
                        }
                    });
                    Thread.sleep(180);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        });

         /*  progress bar  Four  */
        execService.execute(new Runnable() {
            int  count =0;
            @Override
            public void run() {

                while(count  <100){
                    try {
                        ++count;
                        progressbarFour.setProgress(count);
                        tvThree.post(new Runnable() {
                            @Override
                            public void run() {
                                tvFour.setText(count+"%");
                            }
                        });
                        Thread.sleep(110);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });




    }



}

