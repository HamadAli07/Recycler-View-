package com.example.recyclerview191071;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<String> cities;

    public RecyclerAdapter(List<String> cities) {
        this.cities = cities;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(cities.get(position));
        holder.textView2.setText(String.valueOf(position));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Deleted: "+cities.get(position), Toast.LENGTH_SHORT).show();
                cities.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,cities.size());
            }
        });
    }

    @Override
    public int getItemCount() {

        return cities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Iv);
            textView1 = itemView.findViewById(R.id.Tv1);
            textView2 = itemView.findViewById(R.id.Tv2);
            button = itemView.findViewById(R.id.btn);
        }
    }
}
