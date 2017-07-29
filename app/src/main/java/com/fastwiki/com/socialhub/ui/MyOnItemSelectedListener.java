package com.fastwiki.com.socialhub.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by rms on 2016.10.11.
 */
public class MyOnItemSelectedListener implements android.widget.AdapterView.OnItemSelectedListener {
    public void onItemSelected(AdapterView<?> parent,
                               View view, int pos, long id) {
       //  Toast.makeText(parent.getContext(), "Item is " +
       //         parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
}
