package com.example.ruslan.manaschatter;

import android.location.Location;
import android.os.Bundle;
import android.app.Activity;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.api.IMapController;
import org.osmdroid.views.overlay.mylocation.IMyLocationConsumer;
import org.osmdroid.views.overlay.mylocation.IMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class MapActivity extends Activity implements IMyLocationProvider {

    private MapView mMapView;
    private IMapController mMapController;
    private MyLocationNewOverlay myLocationNewOverlay = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mMapView = (MapView) findViewById(R.id.mapview);

        // здесь задается поставщик картинки карты
        // можно выбрать подходящий вариант, подробнее см. в документации
        mMapView.setTileSource(TileSourceFactory.MAPNIK);

        // здесь задается отображение масштаба карты
        mMapView.setBuiltInZoomControls(true);
        // Используется для управления картой, в том числе указания
        // местоположения и уровня масштаба
        mMapController = mMapView.getController();
        mMapController.setZoom(14);
        myLocationNewOverlay  = new MyLocationNewOverlay(this,mMapView);
        mMapView.getOverlays().add(myLocationNewOverlay);
        myLocationNewOverlay.enableMyLocation();



        // / задаем координаты центра карты
        GeoPoint gPt = new GeoPoint((int) (64.4741 * 1E6),
                (int) (40.6334 * 1E6));
        mMapController.setCenter(gPt);

    }


    @Override
    public boolean startLocationProvider(IMyLocationConsumer myLocationConsumer) {
        return false;
    }

    @Override
    public void stopLocationProvider() {

    }

    @Override
    public Location getLastKnownLocation() {
        return null;
    }
}
