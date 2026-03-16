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
        // Находим элементы
        ImageView fullImageView = findViewById(R.id.fullImageView);
        Button btnClose = findViewById(R.id.btnClose);
        Button btnDelete = findViewById(R.id.btnDelete);

        // Получаем ID картинки, которую передали из профиля
        int imageResId = getIntent().getIntExtra("IMAGE_ID", 0);
        fullImageView.setImageResource(imageResId);

        // Логика кнопки ЗАКРЫТЬ
        btnClose.setOnClickListener(v -> {
            finish(); // Просто закрываем это окно и возвращаемся назад
        });

        // Логика кнопки УДАЛИТЬ (по вашему требованию - не должна работать)
        // Мы просто оставляем её пустой или добавляем заглушку, если нужно
        btnDelete.setOnClickListener(v -> {
            // Ничего не делаем, кнопка неактивна функционально
            // Можно добавить Toast, если хотите сообщить пользователю:
            // Toast.makeText(this, "Функция удаления отключена", Toast.LENGTH_SHORT).show();
        });
    }
}