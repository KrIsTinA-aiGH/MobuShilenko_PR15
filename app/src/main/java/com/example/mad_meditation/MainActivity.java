package com.example.mad_meditation;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private LinearLayout selectedLayout = null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Настройка отступов экрана
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            var systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Массив ID всех блоков с ощущениями
        int[] feelings = {R.id.feelingCalm, R.id.feelingRelax, R.id.feelingFocus, R.id.feelingExcite};

        for (int id : feelings) {
            LinearLayout layout = findViewById(id);
            layout.setOnClickListener(v -> {
                // Если нажали на уже выбранный - снимаем выделение
                if (selectedLayout == layout) {
                    reset(layout);
                    selectedLayout = null;
                } else {
                    // Сбрасываем предыдущий выбор и выделяем новый
                    if (selectedLayout != null) reset(selectedLayout);
                    select(layout);
                    selectedLayout = layout;
                }
            });
        }
    }

    // Короткие методы для смены цвета
    private void select(LinearLayout l) {
        ImageView img = (ImageView) l.getChildAt(0);
        // Ваш grayish_green_shade
        int COLOR_SELECTED = 0xFF7C9A92;
        img.setBackgroundColor(COLOR_SELECTED);
        img.setScaleX(1.1f); img.setScaleY(1.1f);
    }

    private void reset(LinearLayout l) {
        ImageView img = (ImageView) l.getChildAt(0);
        int COLOR_DEFAULT = Color.WHITE;
        img.setBackgroundColor(COLOR_DEFAULT);
        img.setScaleX(1f); img.setScaleY(1f);
    }
}