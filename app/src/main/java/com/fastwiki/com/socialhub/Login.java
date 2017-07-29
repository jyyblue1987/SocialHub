package com.fastwiki.com.socialhub;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fastwiki.com.socialhub.model.DeviceData;
import com.fastwiki.com.socialhub.model.IncidentTypeData;
import com.fastwiki.com.socialhub.model.LoginData;
import com.fastwiki.com.socialhub.model.StateData;
import com.fastwiki.com.socialhub.model.UserData;
import com.fastwiki.com.socialhub.model.VehicleData;
import com.fastwiki.com.socialhub.model.VendorData;
import com.fastwiki.com.socialhub.model.VendorTypeData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Login extends Activity implements View.OnClickListener{

    private Button btnLogin;
    private EditText inputUserId;
    private EditText inputUserPassword;

    private UserLoginTask c_userLoginTask = null;

    ProgressDialog progressLogin = null;
    SharedPreferences mySharedPreferences ;

    Globals g = Globals.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mySharedPreferences=getSharedPreferences("myPreference_regent",getApplicationContext().MODE_PRIVATE);

        if (getIntent().getStringExtra("mode").equals("logout")){
            SharedPreferences.Editor editor= mySharedPreferences.edit();
            editor.putString("myid","");
            editor.putString("mypass","");
            editor.commit();
        }

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        inputUserId = (EditText)findViewById(R.id.inputUsername);
        inputUserId.setText(mySharedPreferences.getString("myid",""));

        inputUserPassword = (EditText)findViewById(R.id.inputPassword);
        inputUserPassword.setText(mySharedPreferences.getString("mypass",""));
    }

    public void onClick(View v)
    {
        // login
        if (v == btnLogin){

            //g.setMyIMEI(this);
            attemptLogin();
        }
        // register
        /*
        if (v == btnRegister){

        }
        */
    }

    public void attemptLogin(){

        String strUserId = inputUserId.getText().toString();
        String strUserPassword = inputUserPassword.getText().toString();

        boolean cancel = false;

        if (strUserId.isEmpty() || !isEmailValid(strUserId)){
            //inputUserId.setError("");
            inputUserId.setText("");
            inputUserId.requestFocus();
            cancel = true;
        }

        if (strUserPassword.isEmpty() || !isPasswordValid(strUserPassword)){
            //inputUserPassword.setError("");
            inputUserPassword.setText("");
            inputUserPassword.requestFocus();
            cancel = true;
        }

//        if (!cancel){
//            progressLogin = ProgressDialog.show(this , "" , "", true);
//            c_userLoginTask = new UserLoginTask(strUserId , strUserPassword);
//            c_userLoginTask.execute();
//        }

        startActivity(new Intent(Login.this , MainActivity.class));

    }

    private boolean isEmailValid(String p_email) {
        //TODO: Replace this with your own logic
        //return p_email.contains("@");
        return true;
    }

    private boolean isPasswordValid(String p_password) {
        //TODO: Replace this with your own logic
        return p_password.length() > 0;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public class UserLoginTask extends AsyncTask<Void, Void, String> {

        // control value
        private final String c_userId;
        private final String c_userPassword;
        private GetDeviceTask myDeviceTask;

        UserLoginTask(String email, String password) {
            c_userId = email;
            c_userPassword = password;
        }

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
            // confirm user login
            try {
                data = "?email=" + URLEncoder.encode(c_userId, "UTF-8");
                data += "&password=" + URLEncoder.encode(c_userPassword, "UTF-8");
                data += "&callback";
                link = g.getMySiteUrl()+"/public/login" + data;
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
                if (g.getJsonStringByJsonp(result).equals("{\"sucess\":};")){

                    inputUserId.setText("");
                    inputUserId.requestFocus();
                }
                else{
                    JSONObject jsonObject = new JSONObject(g.getJsonStringByJsonp(result));

                    JSONObject groupDetails  = jsonObject.getJSONObject("Group_Details");

                    // get user data
                    JSONObject userDetails      = jsonObject.getJSONObject("User_Details");
                    String first_name1          = userDetails.getString("First_Name");
                    String last_name1           = userDetails.getString("Last_Name");
                    String address1             = userDetails.getString("Address");
                    String city1                = userDetails.getString("City");
                    String email1               = userDetails.getString("Email_1");
                    String mobile1              = userDetails.getString("Mobile");
                    String license_number1      = userDetails.getString("License_Number");

                    g.setUserData(new UserData(first_name1,last_name1,email1,license_number1,mobile1,address1,city1));

                    // get login data
                    JSONObject loginDetails  = jsonObject.getJSONObject("sucess");

                    String user_id2    = loginDetails.getString("User_ID");
                    String login_id2   = loginDetails.getString("Login_ID");
                    String login_pass2 = loginDetails.getString("Login_Pass");
                    String isActive2   = loginDetails.getString("IsActive");
                    String isDeleted2   = loginDetails.getString("IsDeleted");
                    String team_id2    = loginDetails.getString("Team_ID");
                    String group_id2   = loginDetails.getString("Group_ID");

                    g.setLoginData(new LoginData(user_id2,login_id2,login_pass2,isActive2,isDeleted2,team_id2,group_id2));

                    SharedPreferences.Editor editor= mySharedPreferences.edit();
                    editor.putString("myid",inputUserId.getText().toString());
                    editor.putString("mypass",inputUserPassword.getText().toString());
                    editor.commit();

                    myDeviceTask = new GetDeviceTask();
                    myDeviceTask.execute();
                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            c_userLoginTask = null;
        }
        @Override
        protected void onCancelled() {}
    }

    public class GetDeviceTask extends AsyncTask<Void, Void, String> {

        ArrayList getList = new ArrayList();
        private JSONArray retList = null;
        private GetStateTask getStateTask = null;
        @Override
        protected String doInBackground(Void... params) {

            String link , result;
            BufferedReader bufferedReader;
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //return false;
            }
            try {
                String data = "?Team_ID="+g.getLoginData().getTeamId();
                data += "&callback";
                link = g.getMySiteUrl()+"/public/DeviceDetails"+data;
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        // final Boolean success
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            try {
                result = result.replace(")","");
                result = result.replace("(","");
                JSONObject jsonObject = new JSONObject(result);
                retList = jsonObject.getJSONArray("sucess");
                JSONObject oneObj;
                getList.clear();
                for (int i = 0; i < retList.length(); i++)
                {
                    oneObj = retList.getJSONObject(i);
                    String device_id  = oneObj.getString("Device_ID");
                    String vehicle = oneObj.getString("Vehicle_ID");
                    String driver = oneObj.getString("Device_Name");
                    String description  = oneObj.getString("Device_Description");
                    String sim = oneObj.getString("Device_SIM_Number");
                    String serial = oneObj.getString("Device_Serial_Number");
                    getList.add(new DeviceData(device_id ,vehicle ,driver , description , sim , serial));
                }
                g.setDeivceList(getList);
                getStateTask = new GetStateTask();
                getStateTask.execute();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        protected void onCancelled() {}
    }

    public class GetStateTask extends AsyncTask<Void, Void, String> {

        ArrayList getList = new ArrayList();
        private JSONArray retList = null;
        private GetVehicleTask getVehicleTask = null;

        @Override
        protected String doInBackground(Void... params) {

            String link , result;
            BufferedReader bufferedReader;
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //return false;
            }
            try {
                String data = "?Team_ID="+g.getLoginData().getTeamId();
                data += "&callback";
                link = g.getMySiteUrl()+"/public/State"+data;
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        // final Boolean success
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            try {
                result = result.replace(")","");
                result = result.replace("(","");
                JSONObject jsonObject = new JSONObject(result);
                retList = jsonObject.getJSONArray("sucess");
                JSONObject oneObj;
                getList.clear();
                for (int i = 0; i < retList.length(); i++)
                {
                    oneObj = retList.getJSONObject(i);
                    String name_short = oneObj.getString("name_short");
                    String name_long  = oneObj.getString("name_long");
                    getList.add(new StateData(name_short ,name_long));
                }
                g.setStateList(getList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            getVehicleTask = new GetVehicleTask();
            getVehicleTask.execute();
        }
        @Override
        protected void onCancelled() {}
    }

    public class GetVehicleTask extends AsyncTask<Void, Void, String> {

        ArrayList getList = new ArrayList();
        private JSONArray retList = null;
        private GetIncidentTypeTask getIncidentTypeTask = null;
        @Override
        protected String doInBackground(Void... params) {

            String link , result;
            BufferedReader bufferedReader;
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //return false;
            }
            try {
                String data = "?Team_ID="+g.getLoginData().getTeamId();
                data += "&callback";
                link = g.getMySiteUrl()+"/public/GetVechileDetails"+data;
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        // final Boolean success
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            try {
                result = result.replace(")","");
                result = result.replace("(","");
                JSONObject jsonObject = new JSONObject(result);
                retList = jsonObject.getJSONArray("sucess");
                JSONObject oneObj;
                getList.clear();
                for (int i = 0; i < retList.length(); i++)
                {
                    oneObj = retList.getJSONObject(i);
                    String vehicle_id   = oneObj.getString("Vehicle_ID");
                    String vehicle_name = oneObj.getString("Vehicle_Name");
                    getList.add(new VehicleData(vehicle_id,vehicle_name));
                }
                g.setVehicleList(getList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            getIncidentTypeTask = new GetIncidentTypeTask();
            getIncidentTypeTask.execute();
        }
        @Override
        protected void onCancelled() {}
    }

    public class GetIncidentTypeTask extends AsyncTask<Void, Void, String> {

        ArrayList getList = new ArrayList();
        private JSONArray retList = null;
        private GetVendorTask getVendorTask = null;
        @Override
        protected String doInBackground(Void... params) {

            String link , result;
            BufferedReader bufferedReader;
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //return false;
            }
            try {
                String data = "?Team_ID="+g.getLoginData().getTeamId();
                data += "&callback";
                link = g.getMySiteUrl()+"/public/getIncidentType"+data;
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        // final Boolean success
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            try {
                result = result.replace(")","");
                result = result.replace("(","");
                JSONObject jsonObject = new JSONObject(result);
                retList = jsonObject.getJSONArray("sucess");
                JSONObject oneObj;
                getList.clear();
                for (int i = 0; i < retList.length(); i++)
                {
                    oneObj = retList.getJSONObject(i);
                    String incident_type_id = oneObj.getString("Incident_Type_ID");
                    getList.add(new IncidentTypeData(incident_type_id));
                }
                g.setIncidentTypeList(getList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            getVendorTask = new GetVendorTask();
            getVendorTask.execute();
        }
        @Override
        protected void onCancelled() {}
    }

    public class GetVendorTask extends AsyncTask<Void, Void, String> {

        ArrayList getList = new ArrayList();
        private JSONArray retList = null;
        private GetVendorTypeTask getVendorTypeTask = null;
        @Override
        protected String doInBackground(Void... params) {

            String link , result;
            BufferedReader bufferedReader;
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //return false;
            }
            try {
                String data = "?Team_ID="+g.getLoginData().getTeamId();
                data += "&callback";
                link = g.getMySiteUrl()+"/public/Vendor"+data;
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        // final Boolean success
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            try {
                result = result.replace(")","");
                result = result.replace("(","");
                JSONObject jsonObject = new JSONObject(result);
                retList = jsonObject.getJSONArray("sucess");
                JSONObject oneObj;
                getList.clear();
                for (int i = 0; i < retList.length(); i++)
                {
                    oneObj = retList.getJSONObject(i);
                    String vendor_id = oneObj.getString("Vendor_ID");
                    getList.add(new VendorData(vendor_id));
                }
                g.setVendorList(getList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            getVendorTypeTask = new GetVendorTypeTask();
            getVendorTypeTask.execute();
        }
        @Override
        protected void onCancelled() {}
    }

    public class GetVendorTypeTask extends AsyncTask<Void, Void, String> {

        ArrayList getList = new ArrayList();
        private JSONArray retList = null;
        @Override
        protected String doInBackground(Void... params) {

            String link , result;
            BufferedReader bufferedReader;
            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                //return false;
            }
            try {
                String data = "?Team_ID="+g.getLoginData().getTeamId();
                data += "&callback";
                link = g.getMySiteUrl()+"/public/VendorType"+data;
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                result = bufferedReader.readLine();
                return result;
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        // final Boolean success
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            try {
                result = result.replace(")","");
                result = result.replace("(","");
                JSONObject jsonObject = new JSONObject(result);
                retList = jsonObject.getJSONArray("sucess");
                JSONObject oneObj;
                getList.clear();
                for (int i = 0; i < retList.length(); i++)
                {
                    oneObj = retList.getJSONObject(i);
                    String vendor_type_id = oneObj.getString("Vendor_Type_ID");
                    getList.add(new VendorTypeData(vendor_type_id));
                }
                g.setVendorTypeList(getList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            startActivity(new Intent(Login.this , MainActivity.class));
            finish();
            progressLogin.dismiss();
        }
        @Override
        protected void onCancelled() {}
    }
}
