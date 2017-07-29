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

public class Trip extends CustomFragment
{
    Button btnExpense , btnAnalysis;
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.trip, null);

        btnExpense = (Button)localView.findViewById(R.id.expense);
        btnExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Trip.this.getActivity(), TripExpense.class);
                Trip.this.startActivity(intent);
            }
        });

        btnAnalysis = (Button)localView.findViewById(R.id.analysis);
        btnAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trip.this.getActivity(), TripAnalysis.class);
                Trip.this.startActivity(intent);
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