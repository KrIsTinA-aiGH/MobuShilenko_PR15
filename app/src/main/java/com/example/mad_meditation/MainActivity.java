package com.example.mad_meditation;

import android.content.Intent; // 1. Нужно для перехода
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout selectedLayout = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView avatarTop = findViewById(R.id.ivUserAvatar);
        LinearLayout navProfile = findViewById(R.id.navProfile);
        avatarTop.setOnClickListener(v -> openProfile());
        navProfile.setOnClickListener(v -> openProfile());
        int[] feelings = {R.id.feelingCalm, R.id.feelingRelax, R.id.feelingFocus, R.id.feelingExcite};
        for (int id : feelings) {
            LinearLayout layout = findViewById(id);
            layout.setOnClickListener(v -> {
                if (selectedLayout == layout) {
                    // ПРОВЕРКА 1: Если нажали на тот же самый блок, который уже выбран...
                    reset(layout); //снимаем с него выделение
                    selectedLayout = null; //и запоминаем, что теперь ничего не выбрано.
                } else {
                    if (selectedLayout != null) reset(selectedLayout);
                    //ыл ли до этого выбран какой-то другой блок? Если да, то сбрасываем его цвет назад в белый.
                    select(layout); // Выделяем новый нажатый блок
                    selectedLayout = layout; // Запоминаем этот блок как текущий выбранный
                }
            });
        }
    }
    private void openProfile() {
        startActivity(new Intent(this, Profile.class));
    }
    private void select(LinearLayout l) { // Метод для выделения блока
        ImageView img = (ImageView) l.getChildAt(0);
        // Берем первый элемент внутри блока
        img.setBackgroundColor(0xFF7C9A92);
    }
    private void reset(LinearLayout l) { // Метод для сброса выделения
        ImageView img = (ImageView) l.getChildAt(0);
        img.setBackgroundColor(Color.WHITE);
    }
}