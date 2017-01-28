package com.example.krnfallex.krnfall;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GpsFall extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String centerLatString, centerLngString, nameFallString;
    private double fallLatADouble, fallLngADouble,
            latADouble = 0, lngADouble = 0,
            distanceADouble;
    private LatLng centerLatLng;
    private LocationManager locationManager;
    private Criteria criteria;
    private boolean aBoolean = true;    // true ==> distance > 500, false ==> distance < 500

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_fall);

        //Setup
        centerLatString = getIntent().getStringExtra("Lat");
        centerLngString = getIntent().getStringExtra("Lng");
        nameFallString = getIntent().getStringExtra("NameFall");
        fallLatADouble = Double.parseDouble(centerLatString);
        fallLngADouble = Double.parseDouble(centerLngString);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);

        Log.d("28janV2", "Name ==> " + nameFallString);
        Log.d("28janV2", "Lat ==> " + centerLatString);
        Log.d("28janV2", "Lng ==> " + centerLngString);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }   // Main Method

    @Override
    protected void onResume() {
        super.onResume();
        afterResume();
    }

    private void afterResume() {

        Location networkLocation = myFindLocation(LocationManager.NETWORK_PROVIDER);
        if (networkLocation != null) {
            latADouble = networkLocation.getLatitude();
            lngADouble = networkLocation.getLongitude();
        }

        Location gpsLocation = myFindLocation(LocationManager.GPS_PROVIDER);
        if (gpsLocation != null) {
            latADouble = gpsLocation.getLatitude();
            lngADouble = gpsLocation.getLongitude();
        }

        Log.d("28janV3", "Lat ==> " + latADouble);
        Log.d("28janV3", "Lng ==> " + lngADouble);


    }   // afterResume

    @Override
    protected void onStop() {
        super.onStop();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(locationListener);
    }

    public Location myFindLocation(String strProvider) {

        Location location = null;

        if (locationManager.isProviderEnabled(strProvider)) {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return null;
            }
            locationManager.requestLocationUpdates(strProvider, 1000, 10, locationListener);
            location = locationManager.getLastKnownLocation(strProvider);
        }

        return location;
    }

    public LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            latADouble = location.getLatitude();
            lngADouble = location.getLongitude();

        }   // onLocationChanged

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Setup Center Map
        centerLatLng = new LatLng(fallLatADouble, fallLngADouble);

        //Create Map
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(centerLatLng, 16));

        //Create All Marker
        createMarker();

        //Loop
        myLoop();

        //Delay 5 sec When Click Marker
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {

                aBoolean = false;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        aBoolean = true;
                        myLoop();
                    }
                }, 5000);

            }
        });

    }   // onMapReady

    private void myLoop() {

        //To Do
        afterResume();

        createMarker();

        //Calculate Distance With User , Fall
        distanceADouble = distance(latADouble, lngADouble, fallLatADouble, fallLngADouble);
        Log.d("28janV4", "distance ==> " + distanceADouble);

        //Check Distance
        if (distanceADouble >= 500.00) {

            //Delay
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (aBoolean) {
                        myLoop();
                    }
                }
            }, 1000);

        } else {
            aBoolean = false;
            myNotification();
        }



    }   // myLoop

    private void myNotification() {

        Intent intent = new Intent(GpsFall.this, AlertNotification.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(GpsFall.this,
                (int) System.currentTimeMillis(), intent, 0);

        Uri uri = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);

        Notification.Builder builder = new Notification.Builder(GpsFall.this);
        builder.setTicker("จวนถึงแว้วว");
        builder.setContentTitle("ใกล้ " + nameFallString);
        builder.setContentText("อีกไม่เกิน 500 เมตร คะ");
        builder.setSmallIcon(R.drawable.build10);
        builder.setSound(uri);
        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, notification);


    }   // myNoti


    //นี่คือ เมทอด ที่หาระยะ ระหว่างจุด
    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1609.344;   // meter


        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }


    private void createMarker() {

        mMap.clear();

        //For Fall
        mMap.addMarker(new MarkerOptions().position(centerLatLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.build10))
                .title(nameFallString));

        //For User
        try {

            LatLng latLng = new LatLng(latADouble, lngADouble);
            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.doremon48)));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }   // createMarker

}   // Main Class
