package com.example.focusguard;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SessionActivity extends AppCompatActivity {

    private TextView txtCurrentSubject;
    private TextView txtTimer;
    private Button btPause;
    private Button btFinish;

    private Handler handler = new Handler();

    private int remainingSeconds;
    private boolean isPaused = false;

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {

            if (!isPaused && remainingSeconds > 0) {

                remainingSeconds--;

                int minutes = remainingSeconds / 60;
                int seconds = remainingSeconds % 60;

                txtTimer.setText(
                        String.format("%02d:%02d", minutes, seconds)
                );

                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_session);

        txtCurrentSubject = findViewById(R.id.txt_current_subject);
        txtTimer = findViewById(R.id.txt_timer);
        btPause = findViewById(R.id.bt_pause);
        btFinish = findViewById(R.id.bt_finish);

        // Récupérer les données du Bundle
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {

            String subject = bundle.getString("subject");
            int duration = bundle.getInt("duration");

            txtCurrentSubject.setText(subject);

            remainingSeconds = duration * 60;

            int minutes = remainingSeconds / 60;
            int seconds = remainingSeconds % 60;

            txtTimer.setText(
                    String.format("%02d:%02d", minutes, seconds)
            );
        }

        // Bouton Pause
        btPause.setOnClickListener(v -> {

            if (!isPaused) {

                isPaused = true;

                btPause.setText("Reprendre");

                Toast.makeText(
                        SessionActivity.this,
                        "Session en pause",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                isPaused = false;

                btPause.setText("Pause");

                handler.post(timerRunnable);

                Toast.makeText(
                        SessionActivity.this,
                        "Session reprise",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        // Bouton Terminer
        btFinish.setOnClickListener(v -> {

            handler.removeCallbacks(timerRunnable);

            Toast.makeText(
                    SessionActivity.this,
                    "Session terminée",
                    Toast.LENGTH_SHORT
            ).show();

            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!isPaused && remainingSeconds > 0) {
            handler.post(timerRunnable);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        handler.removeCallbacks(timerRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacks(timerRunnable);
    }
}