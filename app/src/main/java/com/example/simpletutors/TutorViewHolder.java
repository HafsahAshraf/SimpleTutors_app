package com.example.simpletutors;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TutorViewHolder extends RecyclerView.ViewHolder {
    public ImageView avatar;
    public TextView name;
    public TextView desc;
    public TextView id;

    public TutorViewHolder(View view) {
        super(view);
        avatar = view.findViewById(R.id.avatar);
        name = view.findViewById(R.id.tutor_name);
        desc = view.findViewById(R.id.tutor_desc);
        id = view.findViewById(R.id.tutor_id);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start ViewTutorProfileActivity, passing along id of tutor profile
                Intent intent = new Intent(view.getContext(), ViewTutorProfileActivity.class);
                intent.putExtra("id", Integer.parseInt(id.getText().toString()));
                view.getContext().startActivity(intent);
            }
        });
    }
}
