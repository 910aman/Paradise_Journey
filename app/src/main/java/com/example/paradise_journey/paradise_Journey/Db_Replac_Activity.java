package com.example.paradise_journey.paradise_Journey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.paradise_journey.R;
import com.example.paradise_journey.databinding.ActivityDbReplacingBinding;
import com.example.paradise_journey.paradise_Journey.first_Page.fragment_Class.home_one_Fragment;
import com.example.paradise_journey.paradise_Journey.second_Page.fragment_Dashboard_two.after_Category_pageFragment;
import com.example.paradise_journey.paradise_Journey.second_Page.fragment_Dashboard_two.after_home_page_Fragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Db_Replac_Activity extends AppCompatActivity {

    private ActivityDbReplacingBinding binding;
    ViewPager2 viewPager_Db;
    TabLayout tabLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDbReplacingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_Fragment,new home_one_Fragment())
                .commit();

        viewPager_Db = findViewById(R.id.ViewPager_dB);
        toolbar = findViewById(R.id.tB_Dashboard);
        tabLayout = findViewById(R.id.tL_Dashboard);

        setSupportActionBar(toolbar);

        binding.tLDashboard.addTab(binding.tLDashboard.newTab().setText("Home"));
        binding.tLDashboard.addTab(binding.tLDashboard.newTab().setText("Category"));
//        binding.tLDashboard.addTab(binding.tLDashboard.newTab().setText("Forest"));
//        binding.tLDashboard.addTab(binding.tLDashboard.newTab().setText("Hill Station"));
//        binding.tLDashboard.addTab(binding.tLDashboard.newTab().setText("Temples"));
//        binding.tLDashboard.addTab(binding.tLDashboard.newTab().setText("Historical"));
//        binding.tLDashboard.addTab(binding.tLDashboard.newTab().setText("Beaches"));


//        binding.navDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == R.id.menu1) {
//                    Toast.makeText(Db_Replac_Activity.this, "This is Menu 1", Toast.LENGTH_SHORT).show();
//                }
//                if (item.getItemId() == R.id.menu2) {
//                    Toast.makeText(Db_Replac_Activity.this, "This is Menu 2", Toast.LENGTH_SHORT).show();
//                }
//                if (item.getItemId() == R.id.menu3) {
//                    Toast.makeText(Db_Replac_Activity.this, "This is Menu 3", Toast.LENGTH_SHORT).show();
//                }
//                if (item.getItemId() == R.id.menu4) {
//                    Toast.makeText(Db_Replac_Activity.this, "This is Menu 4", Toast.LENGTH_SHORT).show();
//                }
//
//                return false;
//            }
//        });

        binding.ViewPagerDB.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position){
                super.onPageSelected(position);
                binding.tLDashboard.selectTab(binding.tLDashboard.getTabAt(position));
            }
        });

//        View view = binding.navDrawer.getHeaderView(0);
//        ImageView imageView = view.findViewById(R.id.imageView3);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Db_Replac_Activity.this, "This is Image", Toast.LENGTH_LONG).show();
//            }
//        });

        MyPager pager = new MyPager(getSupportFragmentManager(), getLifecycle());
        binding.ViewPagerDB.setAdapter(pager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.ViewPagerDB.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private class MyPager extends FragmentStateAdapter {
        public MyPager(FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:

                    return new home_one_Fragment();
                case 1:
                    return new after_Category_pageFragment();
//                case 2:
//                    return new after_home_page_Fragment();


            }
            return new after_home_page_Fragment();
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}