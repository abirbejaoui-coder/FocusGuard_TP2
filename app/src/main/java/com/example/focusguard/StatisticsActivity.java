package com.example.focusguard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StatisticsActivity extends AppCompatActivity {

    private TextView txtTotalTime;
    private TextView txtTotalSessions;
    private TextView txtSubject;
    private Button btReset;
    private Button btBackStatistics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_statistics);

        txtTotalTime = findViewById(R.id.txt_total_time);
        txtTotalSessions = findViewById(R.id.txt_total_sessions);
        txtSubject = findViewById(R.id.txt_subject);
        btReset = findViewById(R.id.bt_reset);
        btBackStatistics = findViewById(R.id.bt_back_statistics);


        btReset.setOnClickListener(v -> {

            txtTotalTime.setText("Temps total étudié : 0 minutes");
            txtTotalSessions.setText("Sessions terminées : 0");
            txtSubject.setText("Matière principale : aucune");

            Toast.makeText(
                    StatisticsActivity.this,
                    "Statistiques réinitialisées",
                    Toast.LENGTH_SHORT
            ).show();
        });

        btBackStatistics.setOnClickListener(v -> {
            finish();
        });

    }
}