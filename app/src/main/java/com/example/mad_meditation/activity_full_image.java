package com.example.mad_meditation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class activity_full_image extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_full_image);

        ImageView fullImageView = findViewById(R.id.fullImageView);
        Button btnClose = findViewById(R.id.btnClose);

        int imageResId = getIntent().getIntExtra("IMAGE_ID", 0);
        fullImageView.setImageResource(imageResId);

        btnClose.setOnClickListener(v -> finish());

    }
}