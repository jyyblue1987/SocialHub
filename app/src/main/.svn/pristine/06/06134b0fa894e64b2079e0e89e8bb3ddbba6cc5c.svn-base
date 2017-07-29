package com.fastwiki.com.socialhub.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fastwiki.com.socialhub.Globals;
import com.fastwiki.com.socialhub.R;

public class VehicleInspectionProcess extends Activity implements OnClickListener {

    Globals g = Globals.getInstance();

    private LinearLayout layoutControl;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_inspection_process);
        layoutControl = (LinearLayout)findViewById(R.id.layout);
        setController();
    }

    public void setController(){

        String[][] chk_lbl = {

                {
                        "Steering"
                        , "Body"
                        ,"Tires,Wheels,Rims"
                        ,"Reflectors"
                        ,"Electric Lines to Trailer"
                        ,"Horn"
                        ,"Clearance & Marker Lights"
                        ,"Ammeter"
                        ,"Coupling Device"
                        ,"Cooling Device"
                        ,"Stop & Turn Lights"
                        ,"Transmission"
                        ,"Leaks"
                        ,"Tail Lights"
                        ,"Service Brakes"
                        ,"Engine"
                        ,"Suspension System"
                        ,"Glass"
                        ,"Exhaust"
                        ,"Other Items"
                        ,"Parking Brakes"
                        ,"Drive Line"
                        ,"Frame and Assembly"
                        ,"Brake Lines to Transfer"
                        ,"Clutch"
                        ,"Speedometer"
                        ,"Rear Vision Mirror"
                        ,"Windshield Wipers"
                        ,"Oil Pressure"
                        ,"Head Lights"
                        ,"Air Pressure Warning Device"
                        ,"Fuel System"
                },

                {
                        "Suspension System"
                        ,"Other Items"
                        ,"Coupling King Pin"
                        ,"Tarpaulin"
                        ,"Roof"
                        ,"Landing Gear"
                        ,"Hitch"
                        ,"Doors"
                        ,"Coupling Devices"
                        ,"Tires"
                        ,"Brakes"
                        ,"Lights - All"
                        ,"Brake Connection"
                        ,"Wheels - Rims"
                },

                {
                        "Tire Chains"
                        ,"Reflective Traingles"
                        ,"Spare Bulbs, Fuses"
                        ,"Fire Extinguisher"
                        ,"Flags, Fusees, Reflectors"
                }
        };

        String[] partTitleList = {"Vehicle/Tractor","Trailer","Emergency Equipment"};


        for (int i = 0 ; i < chk_lbl.length; i++){

            LinearLayout aLayout = new LinearLayout(this);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            aLayout.setLayoutParams(p);
            aLayout.setOrientation(LinearLayout.VERTICAL);

            TextView partTitle = new TextView(this);
            LinearLayout.LayoutParams paramTitle = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 60);
            partTitle.setLayoutParams(paramTitle);
            partTitle.setBackgroundColor(getResources().getColor(R.color.left_nav_press_color));
            partTitle.setTextColor(getResources().getColor(R.color.white));
            partTitle.setText(partTitleList[i]);

            aLayout.addView(partTitle);

            for (int j = 0 ; j < chk_lbl[i].length ; j++){

                LinearLayout layout = new LinearLayout(this , null , R.style.common_layout);

                LinearLayout.LayoutParams paramLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
                layout.setLayoutParams(paramLayout);
                layout.setOrientation(LinearLayout.HORIZONTAL);

                TextView tv = new TextView(this);
                tv.setText(chk_lbl[i][j]);
                tv.setTextAppearance(this , R.style.common_txt);
                tv.setTextColor(Color.parseColor("#FFFFFF"));

                CheckBox chk = new CheckBox(this);
                chk.setTextAppearance(this, R.style.common_checkbox);

                layout.addView(tv);
                layout.addView(chk);

                aLayout.addView(layout);
            }
            layoutControl.addView(aLayout);
        }
    }

    public void onClick(View v) {

    }

}