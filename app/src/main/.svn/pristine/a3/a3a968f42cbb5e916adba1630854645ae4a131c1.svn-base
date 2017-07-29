package com.fastwiki.com.socialhub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomFragment;

public class Tpms extends CustomFragment
{
    LinearLayout layoutLeft , layoutRight;

    public Tpms(){}

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.tpms, null);
        layoutLeft = (LinearLayout)localView.findViewById(R.id.layoutLeft);
        layoutRight = (LinearLayout)localView.findViewById(R.id.layoutRight);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT , 1f);

        LinearLayout.LayoutParams imgLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT , 1f);

        for (int i = 0 ; i < 7 ; i++){

            LinearLayout layout = new LinearLayout(this.getActivity());
            layout.setLayoutParams(layoutParams);
            ImageView m_circle1 = new ImageView(this.getActivity());
            ImageView m_circle2 = new ImageView(this.getActivity());

            m_circle1.setLayoutParams(imgLayoutParams);
            if (i != 0 && i != 3) m_circle1.setImageResource(R.drawable.ic_tpms_green);
            else m_circle1.setBackgroundResource(R.color.black);
            m_circle2.setLayoutParams(imgLayoutParams);
            if (i != 3) m_circle2.setImageResource(R.drawable.ic_tpms_green);
            else m_circle2.setBackgroundResource(R.color.black);
            layout.addView(m_circle1);
            layout.addView(m_circle2);
            layoutLeft.addView(layout);
        }

        for (int i = 0 ; i < 7 ; i++){

            LinearLayout layout = new LinearLayout(this.getActivity());
            layout.setLayoutParams(layoutParams);
            ImageView m_circle1 = new ImageView(this.getActivity());
            ImageView m_circle2 = new ImageView(this.getActivity());

            m_circle1.setLayoutParams(imgLayoutParams);
            if (i != 3) m_circle1.setImageResource(R.drawable.ic_tpms_green);
            else m_circle1.setBackgroundResource(R.color.black);
            m_circle2.setLayoutParams(imgLayoutParams);
            if (i != 0 && i != 3) m_circle2.setImageResource(R.drawable.ic_tpms_green);
            else m_circle2.setBackgroundResource(R.color.black);
            layout.addView(m_circle1);
            layout.addView(m_circle2);
            layoutRight.addView(layout);
        }





        setHasOptionsMenu(true);
        return localView;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        return super.onOptionsItemSelected(paramMenuItem);
    }
}