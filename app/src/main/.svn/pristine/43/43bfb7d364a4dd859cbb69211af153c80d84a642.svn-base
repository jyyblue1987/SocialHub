package com.fastwiki.com.socialhub.ui;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomFragment;

public class Eobr extends CustomFragment
{
    ProgressBar progBar;
    private Handler mHandler = new Handler();
    private int mProgressStatus=0;
    private TextView text;

    public Eobr(){}

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.eobr, null);

        text = (TextView)localView.findViewById(R.id.textView1);

        progBar = (ProgressBar) localView.findViewById(R.id.performance_progress_bar);


        dosomething();

        setHasOptionsMenu(true);
        return localView;
    }

    public void dosomething() {

        new Thread(new Runnable() {
            public void run() {
                final int presentage=0;
                while (mProgressStatus < 100) {
                    mProgressStatus += 1;
                    if (mProgressStatus == 99) mProgressStatus = 0;
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            progBar.setProgress(mProgressStatus);
                            text.setText(""+mProgressStatus+"%");

                        }
                    });
                    try {

                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        return super.onOptionsItemSelected(paramMenuItem);
    }
}