package com.example.my_app_isaac

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnCameraMoveStartedListener,
    GoogleMap.OnCameraMoveListener,    GoogleMap.OnCameraIdleListener,
    GoogleMap.OnPolygonClickListener, GoogleMap.OnPolylineClickListener{

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

        val macara= LatLng(-4.3790576,-79.9445153)
        val zoom=14f
        val titulo = "Macara"
        addMArcardor(macara, titulo)
        moverCamaraZoom(macara,zoom)





        val pp1=LatLng(-4.3697173,-79.9425335)
        val pp2=LatLng(-4.3787944,-79.9447135)
        val pp3=LatLng(-4.3753792,-79.9598022)
        val pp4=LatLng(-4.3765687,-79.9488832)

    /*        val poliLiena = googleMap.addPolyline(
            PolylineOptions().add(pp1,pp2,pp3,pp4)
        )
    */
        val poligono = googleMap.addPolygon(
            PolygonOptions().add(pp1,pp2,pp3,pp4).clickable(true)
        )
        establecerLiseners(mMap)



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

    fun establecerLiseners(map:GoogleMap){
        with(map){
            setOnCameraIdleListener( this@MapsActivity )
            setOnCameraMoveListener( this@MapsActivity )
            setOnCameraMoveStartedListener( this@MapsActivity )
            setOnPolygonClickListener( this@MapsActivity )
            setOnPolylineClickListener( this@MapsActivity )
        }
    }
    override fun onCameraMoveStarted(p0: Int) {
        Log.i("mapa", "Emepzando a mover")
    }

    override fun onCameraMove() {
        Log.i("mapa", "Camara Moviendo")
    }

    override fun onCameraIdle() {
        Log.i("mapa", "Camara Idle")
    }

    override fun onPolygonClick(p0: Polygon?) {
        Log.i("mapa", "Poligono")
    }

    override fun onPolylineClick(p0: Polyline?) {
        Log.i("mapa", "Linea")
    }


    }