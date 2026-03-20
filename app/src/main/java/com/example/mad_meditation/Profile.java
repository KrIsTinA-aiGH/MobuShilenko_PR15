package com.example.mad_meditation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;


public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        TextView tvExit = findViewById(R.id.tvExit);
        tvExit.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        int[] photoIds = {R.id.cardPhoto1, R.id.cardPhoto2, R.id.cardPhoto3, R.id.cardPhoto4};
        // Создаем массив всех четырех карточек с фото
        int[] drawables = {R.drawable._2556223_paisagem15, R.drawable.unknown_6, R.drawable.sunset_d863fdd4, R.drawable.unknown_7};
        // Создаем второй массив самих картинок, которые должны открыться

        for (int i = 0; i < photoIds.length; i++) {
            MaterialCardView card = findViewById(photoIds[i]);
            int finalI = i;
            // Создаем копию номера i, Эта копия "приклеивается" к этой конкретной карточке навсегда.
            card.setOnClickListener(v -> openFullImage(drawables[finalI]));
        }
    }
    private void openFullImage(int imageId) {
        Intent intent = new Intent(this, activity_full_image.class);
        intent.putExtra("IMAGE_ID", imageId); //Метод putExtra кладет данные внутрь конверта
        startActivity(intent);
    }
}