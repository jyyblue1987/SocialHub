package com.fastwiki.com.socialhub.custom;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.utils.TouchEffect;

public class CustomActivity extends FragmentActivity  implements View.OnClickListener
{
    public static final TouchEffect TOUCH = new TouchEffect();

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setupActionBar();
    }

    public void onClick(View paramView) {}

    public View setClick(int paramInt)
    {
        View localView = findViewById(paramInt);
        if (localView != null) {
            localView.setOnClickListener(this);
        }
        return localView;
    }

    public View setTouchNClick(int paramInt)
    {
        View localView = setClick(paramInt);
        if (localView != null) {
            localView.setOnTouchListener(TOUCH);
        }
        return localView;
    }

    protected void setupActionBar()
    {
        ActionBar localActionBar = getActionBar();
        localActionBar.setDisplayShowTitleEnabled(true);
        localActionBar.setNavigationMode(0);
        localActionBar.setDisplayUseLogoEnabled(true);
        localActionBar.setLogo(R.drawable.icon);
        localActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));
        localActionBar.setDisplayHomeAsUpEnabled(true);
        localActionBar.setHomeButtonEnabled(true);
    }
}
