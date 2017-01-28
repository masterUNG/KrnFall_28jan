package com.example.krnfallex.krnfall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMarkerClickListener,OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng thailand = new LatLng(14.479800, 98.848916);
        mMap.addMarker(new MarkerOptions()
                .position(thailand)
                .title("จังหวัดกาญจนบุรี")
                .snippet("อำเภอเมือง")
                .snippet(getString(R.string.app_name))
        );
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(14.479800, 98.848916), 14));


       // GoogleMap mMap = ((SupportMapFragment) getSupportFragmentManager()
        //        .findFragmentById(R.id.map)).getMap();

        GoogleMap mMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();


        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(15.30034, 98.44858))
                .title("น้ำตกตะเคียนทอง")
                .snippet("อำเภอสังขละบุรี")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.98318, 98.62522))
                .title("น้ำตกไดช่องถ่อง")
                .snippet("อำเภอสังขละบุรี")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.98160, 98.63283))
                .title("น้ำตกเกริงกระเวีย")
                .snippet("อำเภอสังขละบุรี")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.67236, 98.60069))
                .title("น้ำตกเขาใหญ่")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(15.35751, 98.68011))
                .title("น้ำตกคลีตี้")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(15.023064, 98.597783))
                .title("น้ำตกกระเต็งเจ็ง")
                .snippet("อำเภอสังขละบุรี")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.68614, 98.38082))
                .title("น้ำตกจ๊อกกระดิ่น")
                .snippet("อำเภอทองผาภูมิ")

                );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.63808, 98.98662))
                .title("น้ำตกห้วยแม่ขมิ้น")
                .snippet("อำเภอศรีสวัสดิ์")

        );

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.66461, 98.38507))
                .title("น้ำตกผาแป")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.533612, 98.655967))
                .title("น้ำตกโป่งกระดังงา")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.69191, 98.40564))
                .title("น้ำตกดิบใหญ่")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.90583, 98.72114))
                .title("น้ำตกทุ่งนางครวญ")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.67623, 98.37843))
                .title("น้ำตกปิเต็ง")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.667999, 99.287217))
                .title("น้ำตกไตรตรึงษ์")
                .snippet("อำเภอศรีสวัสดิ์")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.23972, 99.34012))
                .title("น้ำตกผาลาด")
                .snippet("อำเภอเมือง")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.65151, 98.77558))
                .title("น้ำตกผาตาด")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.67118, 99.28865))
                .title("น้ำตกธารเงิน-ธารทอง")
                .snippet("อำเภอศรีสวัสดิ์")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.36864, 99.14397))
                .title("น้ำตกเอราวัณ")
                .snippet("อำเภอศรีสวัสดิ์")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.43859, 98.85107))
                .title("น้ำตกไทรโยคใหญ่")
                .snippet("อำเภอไทรโยค")

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.23912, 99.05742))
                .title("น้ำตกไทรโยคน้อย")
                .snippet("อำเภอไทรโยค")
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.iconmap))

        );
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(14.75921, 98.75492))
                .title("น้ำตกผาสวรรค์")
                .snippet("อำเภอทองผาภูมิ")

        );
        mMap.setOnMarkerClickListener(this);
    }
    @Override
    public boolean onMarkerClick(final Marker marker) {

        String name= marker.getTitle();
        if (name.equalsIgnoreCase("น้ำตกไทรโยคน้อย"))
        {
            startActivity(new Intent(MapsActivity.this,page6Activity.class));
        }
        return false;
    }

    }
