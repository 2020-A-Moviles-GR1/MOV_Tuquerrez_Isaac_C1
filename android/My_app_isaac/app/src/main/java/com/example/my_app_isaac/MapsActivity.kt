    package com.example.my_app_isaac

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_recycler.*

    class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps2)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        solicitarPermiso()


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        establecerConfMapa(mMap)

        val machachi= LatLng(-0.500141,-78.5700665)
        val zoom=14f
        val titulo = "Machachi"
        addMArcardor(machachi, titulo)
        moverCamaraZoom(machachi,zoom)
        //mMap.addMarker(MarkerOptions().position(machachi).title("Marker in Machachi"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(machachi))
    }
    fun moverCamaraZoom(lating:LatLng, zoom:Float){
        mMap.moveCamera(
            CameraUpdateFactory.newLatLngZoom(lating,zoom)
        )
    }

    fun addMArcardor(lating:LatLng, titlo:String){
        mMap.addMarker(MarkerOptions().position(lating).title(titlo))
    }

    fun solicitarPermiso(){
        val permisoLocation = ContextCompat.checkSelfPermission(this.applicationContext,
        android.Manifest.permission.ACCESS_FINE_LOCATION)
        if(permisoLocation == PackageManager.PERMISSION_GRANTED){

        }else{
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }
    }

    fun establecerConfMapa(mapa: GoogleMap){
        val contexto= this.applicationContext
        with (mapa){
            val permission = ContextCompat.checkSelfPermission(contexto,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
            if(permission == PackageManager.PERMISSION_GRANTED){
                mapa.isMyLocationEnabled=true
            }
            //es lo mismo que this.uiSettings.isZoomControlsEnabled=true
            uiSettings.isZoomControlsEnabled=true
            uiSettings.isMyLocationButtonEnabled=true
        }

    }


}