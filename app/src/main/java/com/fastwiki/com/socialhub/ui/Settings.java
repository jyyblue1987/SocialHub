package com.fastwiki.com.socialhub.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fastwiki.com.socialhub.MainActivity;
import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomFragment;

public class Settings extends CustomFragment
{
    Button btnprofile,btndevice ,btntpms ;

    public Settings(){}
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        View localView = paramLayoutInflater.inflate(R.layout.settings, null);

        btnprofile = (Button)localView.findViewById(R.id.btnSettingsProfile);
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setActionBarTitle("Status");
                Intent intent = new Intent(Settings.this.getActivity(), SettingsProfile.class);
                Settings.this.startActivity(intent);

            }
        });
        btndevice = (Button)localView.findViewById(R.id.btnSettingsDevice);
        btndevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setActionBarTitle("Device");
                Intent intent = new Intent(Settings.this.getActivity(), SettingsDevice.class);
                Settings.this.startActivity(intent);
            }
        });
        btntpms = (Button)localView.findViewById(R.id.btnSettingsTpms);
        btntpms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setActionBarTitle("TPMS");
                Intent intent = new Intent(Settings.this.getActivity(), SettingsTpms.class);
                Settings.this.startActivity(intent);
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

