package com.places.foursquare.sherlock;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SettingsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    TextView tv1;
    Spinner sp;
    Spinner sp2;

    String[] os = {"Cupcake v1.5", "Donut v1.6", "Éclair v2.0/2.1", "Froyo v2.2",
            "Gingerbread v2.2", "Honeycomb v3.0/3.1"};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        sp = (Spinner) view.findViewById(
                R.id.accuracy_spinner);
        sp.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( getActivity(), R.array.acuracy_array , R.layout.spinner_item);
        //adapter.setDropDownViewResource(R.layout.setting_fragment);
        sp.setAdapter(adapter);
        // Now use the above view to populate the spinner.
        return view;
    }



    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
         parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}