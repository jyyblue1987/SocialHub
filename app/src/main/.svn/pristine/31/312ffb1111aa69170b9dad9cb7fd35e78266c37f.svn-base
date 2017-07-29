package com.fastwiki.com.socialhub.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.fastwiki.com.socialhub.Globals;
import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomActivity;
import com.fastwiki.com.socialhub.model.DeviceData;

public class SettingsDevice extends CustomActivity{

    Globals g = Globals.getInstance();

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.settings_device);

        Spinner spinner = (Spinner) findViewById(R.id.spinDevice);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item_white, g.device_name);
        /*{

            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);
                ((TextView) v).setTextSize(16);
                ((TextView) v).setTextColor(getResources().getColorStateList(R.color.white));
                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);
                //v.setBackgroundResource(R.drawable.spinner_bg);
                ((TextView) v).setTextColor(getResources().getColorStateList(R.color.white));
                //((TextView) v).setTypeface(fontStyle);
                //((TextView) v).setGravity(Gravity.CENTER);
                return v;
            }

        };*/
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                setDeviceValue(position);
            }
        });
    }

    public void setDeviceValue(int pos){

        DeviceData m_deviceData = g.getDeviceList().get(pos);

        ((TextView)findViewById(R.id.txtVehicle)).setText(m_deviceData.getVehicle());
        ((TextView)findViewById(R.id.txtDriver)).setText(m_deviceData.getDriver());
        ((TextView)findViewById(R.id.txtDescription)).setText(m_deviceData.getDescription());
        ((TextView)findViewById(R.id.txtSim)).setText(m_deviceData.getSim());
        ((TextView)findViewById(R.id.txtSerial)).setText(m_deviceData.getSerial());
    }

}
