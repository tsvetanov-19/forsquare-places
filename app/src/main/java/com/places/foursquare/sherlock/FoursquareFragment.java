package com.places.foursquare.sherlock;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by ccc on 29-May-15.
 */
public abstract class FoursquareFragment extends SupportMapFragment implements OnMapReadyCallback{

    protected static View view;
    /**
     * Note that this may be null if the Google Play services APK is not
     * available.
     */

    protected static GoogleMap mMap;
    protected static Double latitude, longitude;

    protected abstract void setUpMap();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        getMapAsync(this);
        return  super.onCreateView(inflater,container,savedInstanceState);
    }



    /**** The mapfragment's id must be removed from the FragmentManager
     **** or else if the same it is passed on the next time then
     **** app will crash ****/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        if (mMap != null) {
//            MainActivity.sFragmentManager.beginTransaction()
//                    .remove(MainActivity.sFragmentManager.findFragmentById(R.id.map)).commit();
//            mMap = null;
//        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setUpMap();
    }
}
