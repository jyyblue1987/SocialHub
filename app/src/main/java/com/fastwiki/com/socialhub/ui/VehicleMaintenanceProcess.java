package com.fastwiki.com.socialhub.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.fastwiki.com.socialhub.Globals;
import com.fastwiki.com.socialhub.R;

public class VehicleMaintenanceProcess extends Activity implements OnClickListener {

    Globals g = Globals.getInstance();

    private LinearLayout layoutControl;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_maintenance_process1);
    }

    public void onClick(View v) {

    }
}