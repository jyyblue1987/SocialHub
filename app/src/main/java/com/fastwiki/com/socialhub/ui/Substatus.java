package com.fastwiki.com.socialhub.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fastwiki.com.socialhub.Globals;
import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomActivity;

public class Substatus extends CustomActivity {

    Globals g = Globals.getInstance();
    private int btnSubStatusList[] = {R.id.btnFuelStation, R.id.btnRestArea, R.id.btnWeighStation, R.id.btnOthers};
    private String subStatusList[] = {"Fuel_Station","rest area","weight station","others"};

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.substatus);

        for (int i = 0; i < btnSubStatusList.length ; i++) {
            Button btn = (Button)findViewById(btnSubStatusList[i]);
            final int sel = i;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Button btn = null;
                    for (int k = 0; k < btnSubStatusList.length; k++){
                        btn = (Button)findViewById(btnSubStatusList[k]);
                        if (k == sel)btn.setBackgroundColor(Color.parseColor("#466F05"));
                        else btn.setBackgroundColor(Color.parseColor("#92C83E"));
                    }
                    if (!subStatusList[sel].equals(g.getSubStatus()))
                    {
                        g.setSubStatus(subStatusList[sel]);
                    }
                }
            });
        }
    }
}