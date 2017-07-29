package com.fastwiki.com.socialhub.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fastwiki.com.socialhub.Globals;
import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomActivity;
import com.fastwiki.com.socialhub.model.VehicleData;

import java.util.ArrayList;

public class VehicleIncident extends CustomActivity {

    Globals g = Globals.getInstance();
    ListView listVehicleIncident;
    Spinner spinIncident;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.vehicle_incident);

        spinIncident = (Spinner)findViewById(R.id.spinIncident);
        spinIncident.setAdapter(new ArrayAdapter(this, R.layout.spinner_item_white,g.vehicle_name));
        spinIncident.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listVehicleIncident = (ListView)findViewById(R.id.listVehicleIncident);
        listVehicleIncident.setAdapter(new VehicleIncidentListAdapter(g.getVehicleList()));

        listVehicleIncident.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(VehicleIncident.this , VehicleIncidentProcess.class);
                intent.putExtra("mode","update");
                startActivity(intent);
            }
        });
    }

    private class VehicleIncidentListAdapter extends BaseAdapter
    {
        private ArrayList<VehicleData> items;

        public VehicleIncidentListAdapter(ArrayList arr) {items = arr;}

        public int getCount() {return items.size();}

        public VehicleData getItem(int paramInt) {
            return (VehicleData)this.items.get(paramInt);
        }

        public long getItemId(int paramInt)
        {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            final LayoutInflater inflater = getLayoutInflater();
            View list_item = inflater.inflate(R.layout.vehicle_incident_item, paramViewGroup, false);
            if (paramInt % 2 == 0)
                ((LinearLayout)list_item.findViewById(R.id.layoutIncidentItem)).setBackgroundColor(Color.parseColor("#000000"));
            else
                ((LinearLayout)list_item.findViewById(R.id.layoutIncidentItem)).setBackgroundColor(Color.parseColor("#231F20"));
            ((TextView)list_item.findViewById(R.id.lbl1)).setTextColor(Color.parseColor("#FFFFFF"));
            ((TextView)list_item.findViewById(R.id.lbl1)).setText(items.get(paramInt).getVehicleName());
            return list_item;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vehicle_incident_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(VehicleIncident.this , VehicleIncidentProcess.class);
        intent.putExtra("mode","add");
        startActivity(intent);
        //if (item.getItemId() == R.id.action_add)
        return super.onOptionsItemSelected(item);
    }

}