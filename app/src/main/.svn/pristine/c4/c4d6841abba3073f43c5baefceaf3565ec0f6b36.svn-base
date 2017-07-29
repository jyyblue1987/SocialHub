package com.fastwiki.com.socialhub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomFragment;

public class Navigate extends CustomFragment
{
    Button btnMySchedule , btnNavigate;
    public Navigate(){}

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.navigate, null);
        btnMySchedule = (Button)localView.findViewById(R.id.btnMySchedule);
        btnMySchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Navigate.this.getActivity(), NavigateMySchedule.class);
                Navigate.this.startActivity(intent);
            }
        });
        btnNavigate = (Button)localView.findViewById(R.id.btnNavigate);
        btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navigate.this.getActivity(), NavigateNavigate.class);
                Navigate.this.startActivity(intent);
            }
        });


        setHasOptionsMenu(true);
        return localView;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        return super.onOptionsItemSelected(paramMenuItem);
    }
}