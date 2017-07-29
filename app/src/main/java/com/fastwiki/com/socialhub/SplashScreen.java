package com.fastwiki.com.socialhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class SplashScreen extends Activity
{
    private boolean isRunning;

    private void doFinish()
    {
        try
        {
            if (this.isRunning)
            {
                this.isRunning = false;
                Intent localIntent = new Intent(this, Login.class);
                localIntent.putExtra("mode", "login");
                startActivity(localIntent);
                finish();
            }
            return;
        }
        finally
        {
            //localObject = finally;
            //throw ((Throwable)localObject);
        }
    }

    private void startSplash()
    {
        new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(100L);
                    return;
                }
                catch (Exception localException)
                {
                    localException.printStackTrace();
                    return;
                }
                finally
                {
                    SplashScreen.this.runOnUiThread(new Runnable()
                    {
                        public void run()
                        {
                            SplashScreen.this.doFinish();
                        }
                    });
                }
            }
        }).start();
    }

    public void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.splash);
        this.isRunning = true;
        startSplash();
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        if (paramInt == 4)
        {
            this.isRunning = false;
            finish();
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }
}