package com.fastwiki.com.socialhub.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fastwiki.com.socialhub.Globals;
import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomFragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Status extends CustomFragment
{
    Globals g = Globals.getInstance();
    private int btnStatusList[] = {R.id.btnDriving, R.id.btnOnDudy, R.id.btnOffDudy, R.id.btnSleeper};
    private String statusList[] = {"driving","on_duty","off_duty","sleeper"};
    private UpdateStatusTask uptTask;
    ProgressDialog progressUpdate = null;

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        final View localView = paramLayoutInflater.inflate(R.layout.status, null);

        for (int i = 0; i < btnStatusList.length ; i++) {
            Button btn = (Button)localView.findViewById(btnStatusList[i]);
            final int sel = i;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Button btn = null;
                    for (int k = 0; k < btnStatusList.length; k++){
                        btn = (Button)(localView.findViewById(btnStatusList[k]));
                        if (k == sel)btn.setBackgroundColor(Color.parseColor("#466F05"));
                        else btn.setBackgroundColor(Color.parseColor("#92C83E"));
                    }
                    if (!statusList[sel].equals(g.getStatus()))
                    {
                        g.setStatus(statusList[sel]);
                        // update status
                        progressUpdate = ProgressDialog.show(getContext(), "", "", true);
                        uptTask = new UpdateStatusTask();
                        uptTask.execute();
                    }
                }
            });
        }

        Button btnSubStatus = (Button)localView.findViewById(R.id.btnSubStatus);
        btnSubStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Substatus.class));
            }
        });

        setHasOptionsMenu(true);
        return localView;
    }

    public class UpdateStatusTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            String link , data , result;
            BufferedReader bufferedReader;
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //return false;
            }
            try {
                data = "?User_ID=" + g.getLoginData().getLoginId();
                data += "&Start_DateTime=" + g.getCurrentTime();
                data += "&Status=" + g.getStatus();
                data += "&Sub_Status=";
                data += "&callback";
                link = g.getMySiteUrl()+"/public/UpdateStatus" + data;
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
            // TODO: register the new account here.
        }

        @Override
        // final Boolean success
        protected void onPostExecute(String result) {

            progressUpdate.dismiss();
            if (result.equals("yes")){

            }
        }
        @Override
        protected void onCancelled() {}
    }
}