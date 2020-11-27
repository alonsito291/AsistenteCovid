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

public class CentroSalud extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_salud);
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

        LocationManager locationManager = (LocationManager) CentroSalud.this.getSystemService(Context.LOCATION_SERVICE);
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
             // centro de salud tupac amaru
        LatLng tupac = new LatLng(-13.538377, -71.911181);
        mMap.addMarker(new MarkerOptions().position(tupac).title("Centro de Salud Tupac Amaru").
                snippet("No atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
         //  centro de salud class wanchaq
        LatLng clasWa = new LatLng(-13.522444, -71.970620);
        mMap.addMarker(new MarkerOptions().position(clasWa).title("Centro de Salud Clas Wanchaq").
                snippet("No atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
         //       centro de salud santa rosa
        LatLng santaRosa = new LatLng(-13.532795, -71.920496-71.970620);
        mMap.addMarker(new MarkerOptions().position(santaRosa).title("Centro de Salud Santa Rosa").
                snippet("No atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
        // sanidad policia nacional del peru
        LatLng sanidad = new LatLng(-13.533979, -71.911524);
        mMap.addMarker(new MarkerOptions().position(sanidad).title("Centro de Salud Sanidad de la PNP").
                snippet("Atiende Covid a Personal Policial").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
        // centro de salud san sebastian
        LatLng sanSebas = new LatLng( -13.532607, -71.929590);
        mMap.addMarker(new MarkerOptions().position(clasWa).title("Centro de Salud San Sebastian").
                snippet("Atiende a COVID19").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
        //centro de salud san jeronimo
        LatLng sanJero = new LatLng(-13.548971,-71.880135);
        mMap.addMarker(new MarkerOptions().position(sanJero).title("Centro de Salud San Jeronimo").
                snippet("Atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
        //pichhu la rinconada

        LatLng picchu = new LatLng(-13.516273, -71.988841);
        mMap.addMarker(new MarkerOptions().position(picchu).title("Centro de Salud Picchu la Rinconada").
                snippet("No atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
        //     posta simon bolivar
        LatLng simonBolivar = new LatLng(-13.519558, -71.991845);
        mMap.addMarker(new MarkerOptions().position(simonBolivar).title("Centro de Salud Simon Bolivar").
                snippet("No atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
         //centro de salud de belenpampa
        LatLng belen = new LatLng(-13.525325, -71.978829);
        mMap.addMarker(new MarkerOptions().position(belen).title("Centro de Salud Belenpampa").
                snippet("Atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
        //centro de salud de independencia
        LatLng independencia = new LatLng(-13.523981, -71.991803);
        mMap.addMarker(new MarkerOptions().position(independencia).title("Centro de Salud de Independencia").
                snippet("No atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
        //centro metropolitano de essalud
        LatLng metroPolitano = new LatLng(-13.525244, -71.983601);
        mMap.addMarker(new MarkerOptions().position(metroPolitano).title("Centro de Salud Metropolitano de EsSalud").
                snippet("No atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));
        //centro de salud 7 cuartones
        LatLng cuartones = new LatLng(-13.516442, -71.982412);
        mMap.addMarker(new MarkerOptions().position(cuartones).title("Centro de Salud 7 Cuartones").
                snippet("Atiende Covid").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.postaoficial)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cuartones,12));

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