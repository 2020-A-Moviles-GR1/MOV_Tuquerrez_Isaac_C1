package com.example.examenappmobile

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import java.net.URL

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap

    override fun onStart() {
        super.onStart()
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        solicitarPermiso()
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        establecerConfMapa(mMap)
        establecerListeners(mMap)
        loadPositions(SailsController.getNet(intent.getIntExtra("net",0)))


    }

    private fun solicitarPermiso(){
        val permisoLocation = ContextCompat.checkSelfPermission(this.applicationContext,
            android.Manifest.permission.ACCESS_FINE_LOCATION)
        if(permisoLocation != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }
    }

    private fun establecerConfMapa(mapa: GoogleMap){
        val contexto= this.applicationContext
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(-0.4895505,-78.5707047)))
        with (mapa){
            val permission = ContextCompat.checkSelfPermission(contexto,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
            if(permission == PackageManager.PERMISSION_GRANTED){
                mapa.isMyLocationEnabled=true
            }
            uiSettings.isZoomControlsEnabled=true
            uiSettings.isMyLocationButtonEnabled=true
        }
    }

    private fun loadPositions(net:Net){
        val minLat=-0.518764
        val maxLat=-0.481193
        val minLng=-78.5893157
        val maxLng=-78.5481277
        net.getNodeList().forEach {
            mMap.addMarker(
                MarkerOptions().position(
                    LatLng(it.getLat(minLat,maxLat), it.getLng(minLng, maxLng))
                ).snippet(it.link).icon(getBitmap(it.linkImg))

            )
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-0.495756,-78.5721707), 14F))
    }

    private fun getBitmap(url:String): BitmapDescriptor {
        var bmp = BitmapFactory.decodeStream(URL(url).openConnection().getInputStream())
        bmp = Bitmap.createScaledBitmap(bmp, 100, 100, false)
        return BitmapDescriptorFactory.fromBitmap(bmp)
    }

    fun establecerListeners(map: GoogleMap){
        with(map){
            setOnMarkerClickListener(this@MapsActivity)
        }
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(p0?.snippet))
        startActivity(browserIntent)
        return true
    }


}




