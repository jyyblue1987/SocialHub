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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomActivity;
import com.fastwiki.com.socialhub.model.NavigateData1;

import java.util.ArrayList;

public class VehicleMaintenance extends CustomActivity {

    ListView listVehicleMaintenance;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_maintenance);

        listVehicleMaintenance = (ListView)findViewById(R.id.listVehicleMaintenance);
        listVehicleMaintenance.setAdapter(new MaintenanceListAdapter());
    }

    private class MaintenanceListAdapter extends BaseAdapter
    {
        private ArrayList<NavigateData1> items;

        public MaintenanceListAdapter()
        {
        }
        public int getCount()
        {
            //return this.items.size();
            return 10;
        }

        public NavigateData1 getItem(int paramInt) {
            return (NavigateData1)this.items.get(paramInt);
        }

        public long getItemId(int paramInt)
        {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            final LayoutInflater inflater = getLayoutInflater();
            View list_item = inflater.inflate(R.layout.vehicle_maintenance_item, paramViewGroup, false);

            ((ImageView)list_item.findViewById(R.id.imgStatus)).setImageResource(R.drawable.ic_tpms_green);
            ((TextView)list_item.findViewById(R.id.lbl1)).setText("203 Jalapa Dr");
            ((TextView)list_item.findViewById(R.id.lbl2)).setText("Kissimmee, FL 34743");
            ((TextView)list_item.findViewById(R.id.lbl3)).setText("Kissimmee, FL 34743");

            if (paramInt % 2 == 0){
                ((LinearLayout)list_item.findViewById(R.id.layoutMaintenanceItem)).setBackgroundResource(R.drawable.tpms_frame_shape1);
                ((TextView)list_item.findViewById(R.id.lbl1)).setTextColor(Color.parseColor("#EAF4DC"));
                ((TextView)list_item.findViewById(R.id.lbl2)).setTextColor(Color.parseColor("#EAF4DC"));
                ((TextView)list_item.findViewById(R.id.lbl3)).setTextColor(Color.parseColor("#EAF4DC"));
            }
            else{
                 ((LinearLayout)list_item.findViewById(R.id.layoutMaintenanceItem)).setBackgroundResource(R.drawable.tpms_frame_shape0);
                ((TextView)list_item.findViewById(R.id.lbl1)).setTextColor(Color.parseColor("#8CC546"));
                ((TextView)list_item.findViewById(R.id.lbl2)).setTextColor(Color.parseColor("#8CC546"));
                ((TextView)list_item.findViewById(R.id.lbl3)).setTextColor(Color.parseColor("#8CC546"));
            }
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

        Intent intent = new Intent(VehicleMaintenance.this , VehicleMaintenanceProcess.class);
        intent.putExtra("mode","add");
        startActivity(intent);
        //if (item.getItemId() == R.id.action_add)
        return super.onOptionsItemSelected(item);
    }
}