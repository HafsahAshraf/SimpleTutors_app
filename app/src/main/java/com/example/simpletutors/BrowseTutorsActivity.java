package com.example.simpletutors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;

import java.util.ArrayList;

public class BrowseTutorsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<TutorProfile> profiles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_tutors);
        recyclerView = findViewById(R.id.recyclerViewBrowseTutors);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        // TEMP FOR TESTING
        TutorProfile p = new TutorProfile();
        p.setAvatar(Bitmap.createBitmap(128,128, Bitmap.Config.ARGB_8888));
        p.setName("John Doe");
        p.setDesc(getString(R.string.debug_paragraph));
        p.setPricing("Starting at $20/hr, contact for more info");
        for(int i = 0; i<10; i++) {
            p.setId(i);
            profiles.add(p.copy());
        }
        // END OF TEMP FOR TESTING
        recyclerView.setAdapter(new TutorRecyclerAdapter(profiles));
    }
}