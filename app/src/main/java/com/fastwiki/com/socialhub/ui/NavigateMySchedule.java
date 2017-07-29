package com.fastwiki.com.socialhub.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomActivity;
import com.fastwiki.com.socialhub.model.NavigateData1;
import android.widget.Gallery;

import java.util.ArrayList;

public class NavigateMySchedule extends CustomActivity
{
    ListView listMySchedule;
    Gallery galleryPhoto;

    Integer[] imageIDs = {
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6,
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6,
            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6
    };

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.navigate_myschedule);

        listMySchedule = (ListView)findViewById(R.id.listMySchedule);
        listMySchedule.setAdapter(new NavigateListAdapter1());

        galleryPhoto = (Gallery)findViewById(R.id.galleryPhoto);
        galleryPhoto.setAdapter(new ImageAdapter(this));

    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;
            // sets a grey background; wraps around the images
            TypedArray a =obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }
        // returns the number of images
        public int getCount() {
            return imageIDs.length;
        }
        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }
        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }
        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(200, 200));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
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
            View list_item = inflater.inflate(R.layout.navigate_myschedule_item, paramViewGroup, false);

            ((TextView)list_item.findViewById(R.id.lbl1)).setText("203 Jalapa Dr");
            ((TextView)list_item.findViewById(R.id.lbl2)).setText("Kissimmee, FL 34743");

            return list_item;
        }
    }
}