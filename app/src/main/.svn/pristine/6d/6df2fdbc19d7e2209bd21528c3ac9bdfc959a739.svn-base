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
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomActivity;

import java.util.ArrayList;

public class VehicleInspection extends CustomActivity {

    ListView listVehicleInspection;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.vehicle_inspection);

        listVehicleInspection = (ListView)findViewById(R.id.listVehicleInspection);
        listVehicleInspection.setAdapter(new VehicleInspectionListAdapter());

        listVehicleInspection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(VehicleInspection.this , VehicleInspectionProcess.class);
                intent.putExtra("mode","update");
                startActivity(intent);
            }
        });
    }

    private class VehicleInspectionListAdapter extends BaseAdapter
    {
        private ArrayList<String> items;

        public VehicleInspectionListAdapter() {}

        public int getCount()
        {
            //return this.items.size();
            return 10;
        }

        public String getItem(int paramInt) {
            return (String)this.items.get(paramInt);
        }

        public long getItemId(int paramInt)
        {
            return paramInt;
        }

        public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
            final LayoutInflater inflater = getLayoutInflater();
            View list_item = inflater.inflate(R.layout.vehicle_inspection_item, paramViewGroup, false);

            if (paramInt % 2 == 0)
                ((TextView)list_item.findViewById(R.id.lbl1)).setBackgroundColor(Color.parseColor("#000000"));
            else
                ((TextView)list_item.findViewById(R.id.lbl1)).setBackgroundColor(Color.parseColor("#231F20"));
            ((TextView)list_item.findViewById(R.id.lbl1)).setTextColor(Color.parseColor("#FFFFFF"));
            ((TextView)list_item.findViewById(R.id.lbl1)).setText("203 Jalapa Dr");
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

        Intent intent = new Intent(VehicleInspection.this , VehicleInspectionProcess.class);
        intent.putExtra("mode","add");
        startActivity(intent);
        //if (item.getItemId() == R.id.action_add)
        return super.onOptionsItemSelected(item);
    }
}