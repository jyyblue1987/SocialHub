package com.fastwiki.com.socialhub.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fastwiki.com.socialhub.Globals;
import com.fastwiki.com.socialhub.R;

import org.json.JSONException;
import org.json.JSONObject;

public class VehicleIncidentProcess extends Activity implements View.OnClickListener {

    Globals g = Globals.getInstance();

    private EditText editDate,editTime , editPoliceReport , editRepairCompleteDate , editEstimatedRepairCost , editActualRepairCost;
    private EditText editAddress , editCity , editZipcode , editIncidentDetail , editInsurenceResponse, editComments ;
    private Spinner spinVehicleName ,spinIncidentType ,spinSeverityLevel ,spinState ,spinVendor ,spinVendorType;

    private CheckBox chkCanDrive ,chkAnyFatality ,chkAssetTowed ,chkCalledInsurance,chkCitation,chkInjuryTreated,chkPreventable;

    private DatePickerDialog DatePickerDialog;
    private SimpleDateFormat dateFormatter;

    //
    private Button btnSubmit;
    private UpdateIncidentTask uptIncidentTask = null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_incident_process);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();
        setFieldData();
    }


    private void findViewsById() {

        editDate = (EditText) findViewById(R.id.editDate);
        editDate.setInputType(InputType.TYPE_NULL);
        editDate.requestFocus();
        editDate.setOnClickListener(this);

        editTime = (EditText) findViewById(R.id.editTime);
        editTime.setInputType(InputType.TYPE_NULL);
        editTime.setOnClickListener(this);

        editAddress = (EditText)findViewById(R.id.editAddress);
        editCity = (EditText)findViewById(R.id.editCity);
        editZipcode = (EditText)findViewById(R.id.editZipCode);
        editIncidentDetail = (EditText)findViewById(R.id.editDetail);
        editInsurenceResponse = (EditText)findViewById(R.id.editInsurenceResponse);
        editComments = (EditText)findViewById(R.id.editComments);
        editPoliceReport = (EditText)findViewById(R.id.editPoliceReport);
        editRepairCompleteDate = (EditText)findViewById(R.id.editRepairCompleteDate);
        editEstimatedRepairCost = (EditText)findViewById(R.id.editEstimatedRepairCost);
        editActualRepairCost = (EditText)findViewById(R.id.editActualRepairCost);

        spinVehicleName = (Spinner)findViewById(R.id.spinVehicle);
        spinIncidentType = (Spinner)findViewById(R.id.spinIncident);
        spinSeverityLevel = (Spinner)findViewById(R.id.spinServertyLevel);
        spinState = (Spinner)findViewById(R.id.spinState);
        spinVendor = (Spinner)findViewById(R.id.spinVendor);
        spinVendorType = (Spinner)findViewById(R.id.spinVendorType);

        chkCanDrive = (CheckBox)findViewById(R.id.chkCanDrive);
        chkAnyFatality = (CheckBox)findViewById(R.id.chkAnyFatality);
        chkAssetTowed = (CheckBox)findViewById(R.id.chkAssetTowed);
        chkCalledInsurance = (CheckBox)findViewById(R.id.chkCalledInsurance);
        chkCitation = (CheckBox)findViewById(R.id.chkCitation);
        chkInjuryTreated = (CheckBox)findViewById(R.id.chkInjuryTreated);
        chkPreventable = (CheckBox)findViewById(R.id.chkPreventable);

        btnSubmit = (Button) findViewById(R.id.btnIncidentSubmit);
        btnSubmit.setOnClickListener(this);
    }

    private void setFieldData() {

        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


        //private Spinner spinVehicleName ,spinIncidentType ,spinSeverityLevel ,spinState ,spinVendor ,spinVendorType;
        spinVehicleName.setAdapter(new ArrayAdapter(this , R.layout.spinner_item_white,g.vehicle_name));
        spinIncidentType.setAdapter(new ArrayAdapter(this , R.layout.spinner_item_white,g.vehicle_name));
        spinSeverityLevel.setAdapter(new ArrayAdapter(this, R.layout.spinner_item_white, g.level_lbl));
        spinState.setAdapter(new ArrayAdapter(this , R.layout.spinner_item_white,g.state_short_name));
        spinVendor.setAdapter(new ArrayAdapter(this , R.layout.spinner_item_white,g.state_short_name));

    }

    public void onClick(View v)
    {
        if (v == editDate){
            DatePickerDialog.show();
        }
        if (v == btnSubmit){

            // uptIncidentTask = new UpdateIncidentTask();
            // uptIncidentTask.execute();
        }
    }

    public class UpdateIncidentTask extends AsyncTask<Void, Void, String> {

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
                data = "?Incident_Date=" + editDate.getText().toString();
                data += "&Incident_Type=" + spinIncidentType.getSelectedItem().toString();
                data += "&Incident_Time=" + editTime.getText().toString();
                data += "&Severity_Level=" + spinSeverityLevel.getSelectedItem().toString();
                data += "&City=" + editCity.getText().toString();
                data += "&Address=" + editAddress.getText().toString();
                data += "&State="+spinState.getSelectedItem().toString();
                data += "&Zip_Code=" + editZipcode.getText().toString();
                data += "&vechile_incident_details="+editIncidentDetail.getText().toString();

                data += "&Drivable="+chkCanDrive.isChecked();
                data += "&Fatality="+chkAnyFatality.isChecked();
                data += "&Asset_Towed="+chkAssetTowed.isChecked();
                data += "&Called_Insurence="+chkCalledInsurance.isChecked();
                data += "&Creation_issued="+chkCitation.isChecked();
                data += "&Injury_Treated="+chkInjuryTreated.isChecked();
                data += "&Preventable="+chkPreventable.isChecked();
                data += "&Called_Insurence="+chkCalledInsurance.isChecked();

                data += "&Insurence_response="+editInsurenceResponse.getText().toString();
                data += "&Comments="+editComments.getText().toString();
                data += "&Police_Report="+editPoliceReport.getText().toString();
                data += "&Repair_Complete="+editRepairCompleteDate.getText().toString();
                data += "&Ext_Repair="+editEstimatedRepairCost.getText().toString();
                data += "&vendor_type="+spinVendorType.getSelectedItem().toString();
                data += "&Actual_Repair="+editActualRepairCost.getText().toString();
                data += "&vendor="+spinVendor.getSelectedItem().toString();

                data += "&Team_ID="+g.getLoginData().getTeamId();
                data += "&User_ID="+g.getLoginData().getUserId();
                data += "&Asset_ID="+g.getLoginData().getLoginId(); //vehicleName
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
                    Toast.makeText(getApplicationContext() , "success to save" , Toast.LENGTH_SHORT).show();
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