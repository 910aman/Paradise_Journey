package com.example.paradise_journey.paradise_Journey.second_Page.adapter_Class;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paradise_journey.R;
import com.example.paradise_journey.databinding.AdapterSecondHoldertwoBinding;

import com.example.paradise_journey.paradise_Journey.second_Page.model_Class.Db_page_Model_two;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Db_page_Adapter_two extends RecyclerView.Adapter<Db_page_Adapter_two.ViewHolder> {

    private ArrayList<Db_page_Model_two> list;

    public Db_page_Adapter_two(ArrayList<Db_page_Model_two> nlist){
        this.list = nlist;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterSecondHoldertwoBinding binding = AdapterSecondHoldertwoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Db_page_Model_two  model_two = list.get(position);
        holder.binding.setBeaches(model_two);

        Picasso.get()
                .load(String.valueOf(model_two.getImg()))
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.binding.imgViewBeaches);

        holder.itemView.setOnClickListener(view -> {

            Toast.makeText(view.getContext(), holder.binding.tvDestinationName.getText(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder //implements View.OnClickListener
     {
        public AdapterSecondHoldertwoBinding binding;
        public ViewHolder(@NonNull AdapterSecondHoldertwoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
//        public void setBeaches(Db_page_Model_two nList){
//            list = nList;
//            binding.setBeaches(nList);
//        }
//        @Override
//        public void onClick(View view) {
//
//        }
    }
}
