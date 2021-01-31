package com.sample.samplelocation;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity implements LocationListener {
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1; // 10 meters
    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1; // 1 minute
    private static final String CHANNEL_ID = "123456";
    // flag for GPS status
    public boolean isGPSEnabled = false;
    // Declaring a Location Manager
    protected LocationManager locationManager;
    // flag for network status
    boolean isNetworkEnabled = false;
    // flag for GPS status
    boolean canGetLocation = false;
    Location location; // location
    double latitude; // latitude
    double longitude; // longitude
    int PERMISSION_ID = 44;

    Button btnlocation;
    boolean handleLocationUpdates = true;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.util.Log.d(TAG, "onCreate: First Time calling getLocation() ");
        getLocation();

        btnlocation = findViewById(R.id.location);
        btnlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (handleLocationUpdates) {
                    handleLocationUpdates = false;
                    locationManager.removeUpdates(MainActivity.this);
                    btnlocation.setText("Enable Get Location");
                    handleGps("Your GPS seems to be enabled, do you want to disable it?");
                } else {
                    handleLocationUpdates = true;
                    getLocation();
                    btnlocation.setText("Disable Get Location");

                }


            }
        });
    }

    public void getLocation() {
        android.util.Log.d(TAG, "getLocation: inside  getLocation checking the permission ");
        if (checkPermissions()) {
            Log.d(TAG, "getLocation: permission are granted ");
            try {
                locationManager = (LocationManager) this
                        .getSystemService(Context.LOCATION_SERVICE);
                // getting GPS status
                isGPSEnabled = locationManager
                        .isProviderEnabled(LocationManager.GPS_PROVIDER);

                Log.v("isGPSEnabled", "=" + isGPSEnabled);

                // getting network status
                isNetworkEnabled = locationManager
                        .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

                Log.v("isNetworkEnabled", "=" + isNetworkEnabled);

                if (!isGPSEnabled && !isNetworkEnabled) {
                    // no network provider is enabled
                  handleGps("Your GPS seems to be disabled, do you want to enable it?");
                } else {
                    this.canGetLocation = true;
                    if (isNetworkEnabled) {
                        location = null;
                        if (checkPermissions()) {
                            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                locationManager.requestLocationUpdates(
                                        LocationManager.NETWORK_PROVIDER,
                                        MIN_TIME_BW_UPDATES,
                                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                                Log.d("Network", "Network");
                                if (locationManager != null) {
                                    location = locationManager
                                            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                                    if (location != null) {
                                        latitude = location.getLatitude();
                                        longitude = location.getLongitude();
                                    }
                                }
                            }
                            // if GPS Enabled get lat/long using GPS Services
                            if (isGPSEnabled) {
                                location = null;
                                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                                        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                                    locationManager.requestLocationUpdates(
                                            LocationManager.GPS_PROVIDER,
                                            MIN_TIME_BW_UPDATES,
                                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                                    Log.d("GPS Enabled", "GPS Enabled");
                                    if (locationManager != null) {
                                        location = locationManager
                                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                        if (location != null) {
                                            latitude = location.getLatitude();
                                            longitude = location.getLongitude();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.d(TAG, "getLocation: permissions are not granted so requesting permissions");
            requestPermissions();
        }

    }

    /** Method to turn on GPS **/
    public void handleGps(String msg){
        Log.d(TAG, "handleGps: Creating Alert to show the message");
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(msg)
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            dialog.cancel();
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();

    }


    @Override
    public void onLocationChanged(Location location) {
       Log.d(TAG, "onLocationChanged: " + location.getLatitude() + " " + location.getLongitude());

        Toast.makeText(this, "Latitude : " + location.getLatitude() + "--Longitude : " + location.getLongitude(), Toast.LENGTH_SHORT).show();

//        showLocationNotification("Location is Enabled ");
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }


    private boolean checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    private void requestPermissions() {
        Log.d(TAG, "requestPermissions: ");
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID
        );
    }

    public void showLocationNotification(String msg) {

        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("Alert")
                .setContentText(msg)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(102, builder.build());

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        android.util.Log.d(TAG, "onRequestPermissionsResult: Location Setting has changed ");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            }
        }
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
    }
}
