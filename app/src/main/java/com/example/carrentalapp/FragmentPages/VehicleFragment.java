package com.example.carrentalapp.FragmentPages;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.carrentalapp.ActivityPages.VehicleInfoActivity;
import com.example.carrentalapp.Adapter.VehicleAdapter;
import com.example.carrentalapp.Database.Project_Database;
import com.example.carrentalapp.Database.VehicleDao;
import com.example.carrentalapp.Model.Vehicle;
import com.example.carrentalapp.R;

import java.util.ArrayList;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class VehicleFragment extends Fragment implements VehicleAdapter.onVehicleListener{

    private ArrayList<Vehicle> list;
    private VehicleAdapter adapter;

    public VehicleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicle, container, false);
        initComponents(view);
        
        return view;
    }

    private void initComponents(View view) {

        assert getArguments() != null;
        String selectVehicleCategory = getArguments().getString("CATEGORY");

        VehicleDao vehicleDao = Room.databaseBuilder(Objects.requireNonNull(getContext()), Project_Database.class, "car_rental_db").allowMainThreadQueries()
                .build()
                .vehicleDao();


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = (ArrayList<Vehicle>) vehicleDao.getCategoryVehicle(selectVehicleCategory);
        adapter = new VehicleAdapter(getContext(), list,this);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onClick(int position) {
        Intent vehicleInfoPage = new Intent(getActivity(), VehicleInfoActivity.class);
        vehicleInfoPage.putExtra("VEHICLE",list.get(position));
        startActivity(vehicleInfoPage);
    }

}
