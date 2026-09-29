package com.example.focusguard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btNewSession;
    private Button btAi;
    private Button btStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btNewSession = findViewById(R.id.bt_new_session);
        btAi = findViewById(R.id.bt_ai);
        btStatistics = findViewById(R.id.bt_statistics);

        btNewSession.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    SubjectActivity.class
            );

            startActivity(intent);
        });

        btAi.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    AIAssistantActivity.class
            );

            startActivity(intent);
        });

        btStatistics.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    StatisticsActivity.class
            );

            startActivity(intent);
        });
    }
}