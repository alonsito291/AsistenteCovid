package com.example.asistentecovid;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Clinica extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener  {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinica);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getLocalizacion();
    }

    private void getLocalizacion() {
        int permiso = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permiso == PackageManager.PERMISSION_DENIED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
        }
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
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        LocationManager locationManager = (LocationManager) Clinica.this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                LatLng miUbicacion = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(miUbicacion).
                        title("ubicacion actual").
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
               /* mMap.moveCamera(CameraUpdateFactory.newLatLng(miUbicacion));
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(miUbicacion)
                        .zoom(14)
                        .bearing(90)
                        .tilt(45)
                        .build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));*/

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);

        // Add a marker in Sydney and move the camera
        //CLINICAS CUSCO
        //CLINICA PARDO
        LatLng pardo = new LatLng(-13.521569, -71.965639);
        mMap.addMarker(new MarkerOptions().position(pardo).title("Clinica Pardo").
                snippet("Atencion Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitaloficial)));

        //CLINICA PAREDES
        LatLng paredes = new LatLng(-13.522920, -71.978481);
        mMap.addMarker(new MarkerOptions().position(paredes).title("Clinica Paredes").
                snippet("Atencion Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitaloficial)));

        //CLINICA MAC SALUD
        LatLng macsalud = new LatLng(-13.524888, -71.955348);
        mMap.addMarker(new MarkerOptions().position(macsalud).title("Clinica Mac Salud").
                snippet("Atencion medica, no Covid19").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitaloficial)));

        //CLINICA SAN JOSE
        LatLng sanjose = new LatLng(-13.525309, -71.955628);
        mMap.addMarker(new MarkerOptions().position(sanjose).title("Clinica San Jose").
                snippet("Atencion medica, no Covid19").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitaloficial)));

        //CLINICA O2 MEDICAL NETWORK
        LatLng o2 = new LatLng(-13.534129, -71.974078);
        mMap.addMarker(new MarkerOptions().position(o2).title("Clinica O2 Medical Network").
                snippet("Atencion Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitaloficial)));

        //CLINICA PERUANO SIUZA
        LatLng peruanosuiza = new LatLng(-13.525860, -71.945595);
        mMap.addMarker(new MarkerOptions().position(peruanosuiza).title("Clinica Peruano Suiza").
                snippet("Atencion medica, no Covid19").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitaloficial)));

        //CLINICA CIMA
        LatLng cima = new LatLng(-13.524881, -71.973964);
        mMap.addMarker(new MarkerOptions().position(cima).title("Clinica Cima").
                snippet("Atencion Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.hospitaloficial)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(macsalud,12));

        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.equals(mMap)){
            String lat,lon;
            lat=Double.toString(marker.getPosition().latitude);
            lon=Double.toString(marker.getPosition().longitude);

            Toast.makeText(this,lat+" , "+lon,Toast.LENGTH_LONG).show();
        }
        return false;
    }
}