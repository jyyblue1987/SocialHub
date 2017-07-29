package com.fastwiki.com.socialhub.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomActivity;
import com.fastwiki.com.socialhub.model.NavigateData1;

import java.util.ArrayList;

public class NavigateNavigate extends CustomActivity
{
    ListView listMySchedule;

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.navigate_navigate);
        listMySchedule = (ListView)findViewById(R.id.listNavigate);

        listMySchedule.setAdapter(new NavigateListAdapter1());
    }


    private class NavigateListAdapter1 extends BaseAdapter
    {
        private ArrayList<NavigateData1> items;

        public NavigateListAdapter1()
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
            View list_item = inflater.inflate(R.layout.navigate_navigate_item, paramViewGroup, false);

            ((TextView)list_item.findViewById(R.id.lbl1)).setText("203 Jalapa Dr");
            ((TextView)list_item.findViewById(R.id.lbl2)).setText("Kissimmee, FL 34743");

            return list_item;
        }
    }
}