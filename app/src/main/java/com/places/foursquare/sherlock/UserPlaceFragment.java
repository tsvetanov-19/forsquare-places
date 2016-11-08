package com.places.foursquare.sherlock;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by ccc on 29-May-15.
 */
public class UserPlaceFragment extends FoursquareFragment{

    private GPSTracker gps;
    @Override
    protected void setUpMap() {
        gps = new GPSTracker(this.getActivity());

        if (gps.canGetLocation()) {

//            double lattSofia = 42.6833333; // returns latitude
//            double longtSofia = 23.3166667; // returns longitude
//            LatLng testPosition = new LatLng(lattSofia, longtSofia);
            LatLng gpsPosition = new LatLng(gps.getLatitude(),gps.getLongitude());
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gpsPosition, 15));
            mMap.addMarker(new MarkerOptions().position(gpsPosition).title("You are here!"));
        }
    }
}