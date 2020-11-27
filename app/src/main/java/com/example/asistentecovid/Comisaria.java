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

public class Comisaria extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comisaria);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager()
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

        LocationManager locationManager = (LocationManager) Comisaria.this.getSystemService(Context.LOCATION_SERVICE);
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
        //comisarias policiales, cuartel y bomberos
        //cuartel general
        LatLng cuartel = new LatLng(-13.533159, -71.977374);
        mMap.addMarker(new MarkerOptions().position(cuartel).title("Cuartel del Ejercito Peruano").
                snippet("Brigada de montañas").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.cuarteloficial)));

        //comisaria de wanchar
        LatLng policia = new LatLng(-13.522976, -71.965935);
        mMap.addMarker(new MarkerOptions().position(policia).title("Comandancia de la Policia").
                snippet("Cuartel General de la policia Nacional del Peri").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //policia de turismo
        LatLng politurismo = new LatLng(-13.522590, -71.967166);
        mMap.addMarker(new MarkerOptions().position(politurismo).title("Policia de Turismo").
                snippet("Cuartel general de la Policia de Turismo").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //comisaria cusco
        LatLng comiCusco = new LatLng(-13.514578, -71.981364);
        mMap.addMarker(new MarkerOptions().position(comiCusco).title("Comisaria de Cusco").
                snippet("Comisaria sectorial del distrito de Cusco").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //comisaria de aopyo cusco
        LatLng ComiapoCusco = new LatLng(-13.511709, -71.988067);
        mMap.addMarker(new MarkerOptions().position(ComiapoCusco).title("Puesto de Apoyo").
                snippet("Puesto de apoyo de la zona de Santa Ana").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //comisaria de sipaspucyo
        LatLng sipas = new LatLng(-13.521489, -71.987812);
        mMap.addMarker(new MarkerOptions().position(sipas).title("Comisaria de Sipaspucyo").
                snippet("Comisaria de sipaspucyo, sector de cusco e independencia").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //auxillo rapido
        LatLng auxillo = new LatLng(-13.520687, -71.986916);
        mMap.addMarker(new MarkerOptions().position(auxillo).title("puesto de Auxillo Rapido").
                snippet("Puesto de la zona de cusco").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //comisaria de tio
        LatLng tio = new LatLng(-13.532326, -71.959755);
        mMap.addMarker(new MarkerOptions().position(tio).title("Comisaria de Tio").
                snippet("Cuartel General de Policias de Transito").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //comisaria de san sebastian
        LatLng sansebas = new LatLng(-13.532159, -71.926211);
        mMap.addMarker(new MarkerOptions().position(sansebas).title("Comisaria de San sebastian").
                snippet("Puesto de la zona de San Sebastian").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        // comisaria de san jeronimo
        LatLng sanjero = new LatLng(-13.546201, -71.889449);
        mMap.addMarker(new MarkerOptions().position(sanjero).title("Comisaria de San Jeronimo").
                snippet("Puesto de la zona de San Jeronimo").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //comisaria la familia
        LatLng familia = new LatLng(-13.524201, -71.984359);
        mMap.addMarker(new MarkerOptions().position(familia).title("Comisaria de la Familia").
                snippet("Oficina central de problemas Familiares").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.comisariaoficial)));

        //compania de bomberos cusco
        LatLng bomcusco = new LatLng(-13.522484, -71.970446);
        mMap.addMarker(new MarkerOptions().position(bomcusco).title("Cuartel General de Bomberos").
                snippet("Cuartel general de Bomberos Voluntarios del Peru sede Cusco").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.bomberooficial)));

        //compania de bomberos san jeronimo
        LatLng bomsanje = new LatLng(-13.548808, -71.879747);
        mMap.addMarker(new MarkerOptions().position(bomsanje).title("Cuartel General de Bomberos").
                snippet("Cuartel general de Bomberos Voluntarios del Peru sede San Jeronimo").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.bomberooficial)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(comiCusco,12));

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