package com.example.paradise_journey.paradise_Journey.first_Page.fragment_Class;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.paradise_journey.R;
import com.example.paradise_journey.databinding.FragmentHomeOneBinding;
import com.example.paradise_journey.paradise_Journey.first_Page.adapter_Class.adapter_Class_one;
import com.example.paradise_journey.paradise_Journey.first_Page.model_Class.Model_One;
import com.example.paradise_journey.paradise_Journey.second_Page.fragment_Dashboard_two.after_home_page_Fragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class home_one_Fragment extends Fragment implements adapter_Class_one.ClickInterface {

    private FragmentHomeOneBinding binding;

    //For Recycler View One
    private ArrayList<Model_One> list_one;
    private adapter_Class_one adapter_one;
    Model_One model_one;
    DatabaseReference databaseReference_One;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeOneBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //For Recycler View One
        databaseReference_One = FirebaseDatabase.getInstance().getReference("category").child("hillstation_img");
        list_one = new ArrayList<>();
        binding.RVFirstPageFirstRV.setHasFixedSize(true);
        binding.RVFirstPageFirstRV.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        refreshAdapter_One();
        databaseReference_One.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    for(DataSnapshot childSnapshot : snapshot.getChildren())
                    {
                        model_one = childSnapshot.getValue(Model_One.class);
                        list_one.add(model_one);
                        Log.i("hill",model_one.toString());
                    }
                }
                refreshAdapter_One();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Failure occur!!", Toast.LENGTH_SHORT).show();
                Log.i("err_hill",model_one.toString());
            }
        });

    }

    //For Recycler View One
    private void refreshAdapter_One() {
        adapter_one = new adapter_Class_one(list_one,getContext(),this);
        binding.RVFirstPageFirstRV.setAdapter(adapter_one);
    }

    @Override
    public void onClick(int position) {


            Model_One model_one = list_one.get(position);

            Bundle bundle = new Bundle();
            bundle.putParcelable("data", model_one);

            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_Fragment,new after_home_page_Fragment())
                    .commit();
            Toast.makeText(getContext(), list_one.get(position).getName(), Toast.LENGTH_SHORT).show();

    }
}