package com.places.foursquare.sherlock;

import android.location.Location;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import br.com.condesales.EasyFoursquare;
import br.com.condesales.criterias.VenuesCriteria;
import br.com.condesales.listeners.AccessTokenRequestListener;
import br.com.condesales.models.Category;
import br.com.condesales.models.Venue;

/**
 * Created by ccc on 29-May-15.
 */
public class FavoritesFragment extends FoursquareFragment implements AccessTokenRequestListener {

    private GPSTracker gps;
    private Location gpsLocation;
    private EasyFoursquare foursquare;
    private ArrayList<Venue> venuesList;

    @Override
    protected void setUpMap() {

        gps = new GPSTracker(this.getActivity());
        // For showing a move to my loction button
        //mMap.setMyLocationEnabled(true);
        // For dropping a marker at a point on the Map


        if (gps.canGetLocation()) {
            gpsLocation = gps.getLocation();

            double lattSofia = 42.6833333; // returns latitude
            double longtSofia = 23.3166667; // returns longitude
            LatLng testPosition = new LatLng(lattSofia,longtSofia);

            foursquare = new EasyFoursquare(this.getActivity());
            foursquare.requestAccess(this);

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(testPosition, 15));
            mMap.addMarker(new MarkerOptions().position(testPosition).title("Here!"));
        }
        //onAccessGrant(null);
    }

    @Override
    public void onAccessGrant(String accessToken) {
        VenuesCriteria criteria = new VenuesCriteria();
        criteria.setLocation(gpsLocation);
        criteria.setRadius(10000);
        criteria.setQuantity(50);
        venuesList = foursquare.getVenuesNearby(criteria);

        for(Venue v: venuesList) {
            ArrayList<Category> cats = v.getCategories();
            mMap.addMarker(new MarkerOptions().position(new LatLng(v.getLocation().getLat(), v.getLocation().getLng())).title(v.getName()));


        }

    }

    @Override
    public void onError(String errorMsg) {
        Toast.makeText(this.getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
    }
}
