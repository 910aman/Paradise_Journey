package com.example.paradise_journey.paradise_Journey.first_Page.adapter_Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paradise_journey.R;
import com.example.paradise_journey.databinding.AdapterFirstHolderoneBinding;
import com.example.paradise_journey.paradise_Journey.first_Page.model_Class.Model_One;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter_Class_one extends RecyclerView.Adapter<adapter_Class_one.ViewHolder>
{
    private ArrayList<Model_One> list;
    private Context context;
    private ClickInterface clickInterface;

    public interface ClickInterface {
        void onClick(int position);
    }

    public adapter_Class_one(ArrayList<Model_One> list, Context context,ClickInterface clickInterface){
        this.list = list;
        this.context = context;
        this.clickInterface = clickInterface;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AdapterFirstHolderoneBinding binding = AdapterFirstHolderoneBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        ViewHolder viewHolder = new ViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model_One model = list.get(position);
        list.add(model);

        Picasso.get()
                .load(String.valueOf(model.getImg()))
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.binding.dbImgViewHillStation);

        holder.itemView.setOnClickListener(view -> {
            clickInterface.onClick(position);
                   });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterFirstHolderoneBinding binding;
        public ViewHolder(@NonNull AdapterFirstHolderoneBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(view -> {
                if(clickInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        clickInterface.onClick(pos);
                    }
                }
            });


        }
    }
}