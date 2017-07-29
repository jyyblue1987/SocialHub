package com.fastwiki.com.socialhub.ui;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fastwiki.com.socialhub.Globals;
import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SettingsProfile extends CustomActivity {

    Globals g = Globals.getInstance();
    Button btnUpdate;
    ProgressDialog progressUpdate = null;
    UpdateProfileTask uptTask;
    private EditText edFirstName , edLastName , edEmail , edLicense , edMobileNum , edAddress , edCity;
    private Spinner spinState;

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.settings_profile);

        edFirstName = (EditText)findViewById(R.id.edFirstName);
        edLastName  = (EditText)findViewById(R.id.edLastName);
        edEmail     = (EditText)findViewById(R.id.edEmail);
        edLicense   = (EditText)findViewById(R.id.edLicense);
        edMobileNum = (EditText)findViewById(R.id.edMobileNum);
        edAddress   = (EditText)findViewById(R.id.edAddress);
        edCity      = (EditText)findViewById(R.id.edCity);

        spinState = (Spinner)findViewById(R.id.spinState);
        spinState.setAdapter(new ArrayAdapter(this, R.layout.spinner_item_white,g.state_short_name));

        setProfileInfo();

        btnUpdate = (Button)findViewById(R.id.btnSettingsProfileUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //progressUpdate = ProgressDialog.show(getApplicationContext() , "" , "", true);
                uptTask = new UpdateProfileTask();
                uptTask.execute();
            }
        });
    }

    public void setProfileInfo(){

        edFirstName.setText(g.getUserData().getFirstName());
        edLastName.setText(g.getUserData().getLastName());
        edEmail.setText(g.getUserData().getEmail());
        edLicense.setText(g.getUserData().getLicenseNumber());
        edMobileNum.setText(g.getUserData().getMobileNumber());
        edAddress.setText(g.getUserData().getAddress());
        edCity.setText(g.getUserData().getCity());
    }

    public class UpdateProfileTask extends AsyncTask<Void, Void, String> {

        private static final String JSON_ARRAY ="result";

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
                data = "?First_Name=" + edFirstName.getText().toString();
                data += "&Last_Name=" + edLastName.getText().toString();
                data += "&Email_1=" + edEmail.getText().toString();
                data += "&City=" + edCity.getText().toString();
                data += "&Mobile=" + edMobileNum.getText().toString();
                data += "&Country=";
                data += "&State=";
                data += "&Address=" + edAddress.getText().toString();
                data += "&License_Number="+edLicense.getText().toString();
                data += "&User_ID="+g.getLoginData().getUserId();
                data += "&callback";
                link = g.getMySiteUrl()+"/public/UpdateAccount" + data;
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
            try {
                JSONObject jsonObject = new JSONObject(g.getJsonStringByJsonp(result));
                if (jsonObject.getString("sucess").equals("1")){
                    Toast.makeText(getApplicationContext() , "success to update" , Toast.LENGTH_SHORT).show();
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        protected void onCancelled() {}
    }
}