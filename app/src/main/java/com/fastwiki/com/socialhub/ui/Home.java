package com.fastwiki.com.socialhub.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.fastwiki.com.socialhub.Login;
import com.fastwiki.com.socialhub.MainActivity;
import com.fastwiki.com.socialhub.R;
import com.fastwiki.com.socialhub.custom.CustomFragment;

public class Home extends CustomFragment
{
    private int btnHomeList[] = {
            R.id.btnHomeStatus, R.id.btnHomeSettings, R.id.btnHomeVehicle,
            R.id.btnHomeTrip, R.id.btnHomeAlert, R.id.btnHomeEobr,
            R.id.btnHomeTpms, R.id.btnHomePol, R.id.btnHomeNavigate,
            R.id.btnHomeMap, R.id.btnHomeFuellog, R.id.btnHomeLogout};

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
        final View localView = paramLayoutInflater.inflate(R.layout.home, null);

        for (int i = 0; i < btnHomeList.length ; i++) {
            ImageView btn = (ImageView)localView.findViewById(btnHomeList[i]);
            final int sel = i;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    String str = "";
                    Object localObject = null;
                    switch (sel)
                    {
                        case 0:  str = "Status";       localObject = new Status();     break;
                        case 1:  str = "Settings";     localObject = new Settings();   break;
                        case 2:  str = "Vehicle";      localObject = new Vehicle();    break;
                        case 3:  str = "Trip";         localObject = new Trip();       break;
                        case 4:  str = "Alert";        localObject = new Eobr();       break;
                        case 5:  str = "EOBR";         localObject = new Eobr();       break;
                        case 6:  str = "TPMS";         localObject = new Tpms();       break;
                        case 7:  str = "POI";          localObject = new Poi();        break;
                        case 8:  str = "NAVIGATE";     localObject = new Navigate();   break;
                        case 9:  str = "MAP";          localObject = new Map();        break;
                        case 10: str = "FuelLog";      localObject = new Map();        break;
                        case 11:
                            Intent intent = new Intent(getActivity() , Login.class);
                            intent.putExtra("mode", "logout");
                            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            break;
                    }
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, (Fragment)localObject).addToBackStack(str).commit();

                    //MainActivity.leftAdapter.setSelection(sel+1);
                }
            });
        }
        setHasOptionsMenu(true);
        return localView;
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        return super.onOptionsItemSelected(paramMenuItem);
    }
}
