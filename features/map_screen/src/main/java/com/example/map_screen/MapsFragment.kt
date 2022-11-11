package com.example.map_screen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.common.constants.Constants.LOCATION_REQUEST_CODE
import com.example.map_screen.databinding.FragmentMapsBinding
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(), GoogleMap.OnMarkerClickListener {

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = checkNotNull(_binding)

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    private lateinit var locationRequest: LocationRequest
    private lateinit var mMap: GoogleMap

    private val callback = OnMapReadyCallback { googleMap ->
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.setOnMarkerClickListener(this)
        val zihuatanejo = LatLng(17.64, -101.55)
        val moscow = LatLng(55.75, 37.62)
        val nw = LatLng(40.73, -73.98)
        val spb = LatLng(59.92, 30.35)
        googleMap.addMarker(MarkerOptions().position(zihuatanejo).title("Marker in Zihuatanejo"))
        googleMap.addMarker(MarkerOptions().position(moscow).title("Marker in Moscow"))
        googleMap.addMarker(MarkerOptions().position(nw).title("Marker in New York"))
        googleMap.addMarker(MarkerOptions().position(spb).title("Marker in Saint-Petersburg"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(zihuatanejo))
        googleMap.uiSettings.isMyLocationButtonEnabled = true
        binding.buttonFindMe.setOnClickListener {
            checkGPS(googleMap)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun checkGPS(googleMap: GoogleMap) {
        if (checkGPSEnabled()) {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_REQUEST_CODE
                )
                return
            }
            googleMap.isMyLocationEnabled = true
            fusedLocationProviderClient.lastLocation.addOnSuccessListener {
                if (it != null) {
                    lastLocation = it
                    val currentLatLong = LatLng(it.latitude, it.longitude)
                    placeMarkerOnMap(currentLatLong, googleMap)
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 12f))
                }
            }

        } else {
            locationRequest = LocationRequest.create().apply {
                interval = 10000
                fastestInterval = 5000
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            }
            val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest)
                .setAlwaysShow(true)
            LocationServices.getSettingsClient(requireActivity().applicationContext)
                .checkLocationSettings(builder.build())
                .addOnFailureListener {
                    if (it is ResolvableApiException) {
                        try {
                            it.startResolutionForResult(
                                requireActivity(),
                                LOCATION_REQUEST_CODE
                            )
                        } catch (e: ApiException) {
                            e.printStackTrace()
                        }
                    }
                }
        }
    }

    override fun onMarkerClick(p0: Marker): Boolean = false

    private fun checkGPSEnabled(): Boolean {
        val locationManager =
            requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    private fun placeMarkerOnMap(currentLatLong: LatLng, googleMap: GoogleMap) {
        val markerOptions = MarkerOptions().position(currentLatLong)
        markerOptions.title("$currentLatLong")
        googleMap.addMarker(markerOptions)
    }

    companion object {
        fun newInstance() = MapsFragment()
    }
}