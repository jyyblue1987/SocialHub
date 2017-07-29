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

public class Poi extends CustomFragment
{
    Button btnGoHome , btnFavorite , btnRecentSelection , btnCustomPoi;
    public Poi(){}

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.poi, null);


        btnGoHome = (Button)localView.findViewById(R.id.btnGoHome);
        btnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Poi.this.getActivity(), NavigateMySchedule.class);
                Poi.this.startActivity(intent);
            }
        });
        btnFavorite = (Button)localView.findViewById(R.id.btnFavorite);
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Poi.this.getActivity(), NavigateNavigate.class);
                Poi.this.startActivity(intent);
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