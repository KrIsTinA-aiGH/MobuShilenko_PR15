package com.example.mad_meditation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.card.MaterialCardView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        // Настройка отступов для системных баров
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- НАСТРОЙКА КЛИКОВ ПО ФОТОГРАФИЯМ ---

        // Фото 1
        MaterialCardView cardPhoto1 = findViewById(R.id.cardPhoto1);
        cardPhoto1.setOnClickListener(v -> openFullImage(R.drawable._2556223_paisagem15));

        // Фото 2
        MaterialCardView cardPhoto2 = findViewById(R.id.cardPhoto2);
        cardPhoto2.setOnClickListener(v -> openFullImage(R.drawable.unknown_6));

        // Фото 3
        MaterialCardView cardPhoto3 = findViewById(R.id.cardPhoto3);
        cardPhoto3.setOnClickListener(v -> openFullImage(R.drawable.sunset_d863fdd4));

        // Фото 4
        MaterialCardView cardPhoto4 = findViewById(R.id.cardPhoto4);
        cardPhoto4.setOnClickListener(v -> openFullImage(R.drawable.unknown_7));
    }

    // Метод для открытия полного изображения
    private void openFullImage(int imageId) {
        Intent intent = new Intent(Profile.this, activity_full_image.class);
        intent.putExtra("IMAGE_ID", imageId); // Передаем ID картинки
        startActivity(intent);
    }
}