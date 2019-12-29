package com.github.tenx.tecnoesis20.ui.main.schedule;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.data.models.MarkerDetailBody;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class ScheduleFragment extends Fragment implements OnMapReadyCallback {



    private Toolbar toolbarBotSheetMap;

    private RecyclerView recyclerBotSheetMap;
    private ImageView ivBottomSheetImage;

    private ScheduleViewModel mViewModel;


    private BottomSheetRecyclerAdapter adapter;

    private List<MarkerDetailBody> markerDetails;

    private HashMap<String , Integer> markerRecord;

    private GoogleMap map;
    private BottomSheetDialog dialog;

    public static ScheduleFragment newInstance() {
        return new ScheduleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_schedule, container, false);

        ButterKnife.bind(this, v);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ScheduleViewModel.class);
        // TODO: Use the ViewModel
        markerDetails = mViewModel.getMarkerDetails();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        markerRecord = new HashMap<>();
        initMap(googleMap);

        initBottomSheet(getActivity());



    }

    private void initMap(GoogleMap map) {

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = map.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            getActivity(), R.raw.style_json));

            if (!success) {
                Timber.e("Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Timber.e("Can't find style. Error:");
        }

        LatLng nitCords = new LatLng(24.7577, 92.7923);

        MarkerOptions marker = new MarkerOptions().position(nitCords).title("NIT Silchar");
        marker.icon(getBitmap(R.drawable.ic_marker_purple));
        markerRecord.put( map.addMarker(marker).getId(), -1);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(nitCords, 17.0f));

        for (int i=0 ; i< markerDetails.size() ; i++) {
            MarkerDetailBody data = markerDetails.get(i);
            LatLng cords = new LatLng(Double.parseDouble(data.getLat()), Double.parseDouble(data.getLng()));

            MarkerOptions opts = new MarkerOptions().position(cords).title(data.getName());
            opts.icon(getBitmap(R.drawable.ic_marker_purple));
            Marker tempMarker = map.addMarker(opts);
            markerRecord.put(tempMarker.getId(), i);

        }

        map.setOnMarkerClickListener(marker1 -> {
            try {

                if(markerRecord.get(marker1.getId()) == -1){
//                if main NIT Silchar marker dont show anything for now
                    initBottomSheetData(new MarkerDetailBody("", "", "NIT Silchar") , getActivity());
                    return true;
                }

                initBottomSheetData(markerDetails.get(markerRecord.get(marker1.getId())) , getActivity());
                return true;
            }catch (NullPointerException e){
                Timber.e("Null error occured");
            }

            return false;
        });
    }


    private BitmapDescriptor getBitmap(int id) {
        int height = 100;
        int width = 100;
        Bitmap b = BitmapFactory.decodeResource(getResources(), id);
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        BitmapDescriptor smallMarkerIcon = BitmapDescriptorFactory.fromBitmap(smallMarker);

        return smallMarkerIcon;
    }


    private void initBottomSheet(Context context) {
        View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet_location_details, null);
        toolbarBotSheetMap = dialogView.findViewById(R.id.toolbar_bot_sheet_map);
        recyclerBotSheetMap = dialogView.findViewById(R.id.recycler_bot_sheet_map);
        ivBottomSheetImage = dialogView.findViewById(R.id.iv_bottom_sheet_image_loc);
        toolbarBotSheetMap.setTitleTextColor(getResources().getColor(R.color.md_white_1000));
        toolbarBotSheetMap.setNavigationIcon(getResources().getDrawable(R.drawable.ic_close));
        toolbarBotSheetMap.setNavigationOnClickListener(v -> dialog.dismiss());
        dialog = new BottomSheetDialog(context);
        dialog.setContentView(dialogView);
        adapter = new BottomSheetRecyclerAdapter();
    }

    private void initBottomSheetData(MarkerDetailBody data, Context context) {
        toolbarBotSheetMap.setTitle(data.getName());
        adapter.setEventList(data.getEvents());
        Glide.with(context).load("https://picsum.photos/300").into(ivBottomSheetImage);

        recyclerBotSheetMap.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerBotSheetMap.setAdapter(adapter);
        dialog.show();


    }


}
