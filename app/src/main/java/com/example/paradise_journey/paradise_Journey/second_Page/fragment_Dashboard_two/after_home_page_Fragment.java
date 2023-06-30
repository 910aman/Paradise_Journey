package com.example.paradise_journey.paradise_Journey.second_Page.fragment_Dashboard_two;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.paradise_journey.R;
import com.example.paradise_journey.databinding.FragmentDbPageBinding;
import com.example.paradise_journey.paradise_Journey.first_Page.model_Class.Model_One;
import com.example.paradise_journey.paradise_Journey.second_Page.model_Class.Db_page_Model_one;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class after_home_page_Fragment extends Fragment  {

    private FragmentDbPageBinding binding;
//    for Recycler View One
    private ArrayList<Db_page_Model_one> list_one;
//    private Db_page_Adapter_one adapter_one;
    Db_page_Model_one secondPageModel;
    DatabaseReference databaseReference_one;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDbPageBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //For Recycler View One
        databaseReference_one = FirebaseDatabase.getInstance().getReference("category").child("hillstation");
        list_one = new ArrayList<>();
        Bundle bundle = getArguments();
        Model_One one = bundle.getParcelable("data");

        Db_page_Model_one modelOne = new Db_page_Model_one(one);

        Picasso.get()
                .load(String.valueOf(modelOne.getImg()))
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.ImgViewHillStation);

        Log.i("data", modelOne.toString());

        databaseReference_one.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists())
                {
                    for (DataSnapshot childSnapShot : snapshot.getChildren())
                    {
                        secondPageModel = childSnapShot.getValue(Db_page_Model_one.class);

                        if(modelOne.getName().equals(secondPageModel.getName()) && modelOne.getImg().equals(secondPageModel.getImg())){

                            binding.setHill(secondPageModel);
                        }


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(getContext(), "U failed !!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}