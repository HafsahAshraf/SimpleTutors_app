package com.example.simpletutors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TutorRecyclerAdapter extends RecyclerView.Adapter<TutorViewHolder> {
    private final ArrayList<TutorProfile> profiles;
    public TutorRecyclerAdapter(ArrayList<TutorProfile> profiles) {
        this.profiles = profiles;
    }
    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.browse_tutor_card_layout, parent, false);
        return new TutorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder holder, int position) {
        TutorProfile tutor = profiles.get(position);
        holder.avatar.setImageBitmap(tutor.getAvatar());
        holder.name.setText(tutor.getName());
        holder.desc.setText(tutor.getDesc());
        holder.id.setText(String.valueOf(tutor.getId()));
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }
}
