package com.example.focusguard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubjectActivity extends AppCompatActivity {

    private EditText edtSubject;
    private EditText edtDuration;
    private Button btStartSession;
    private Button btBackSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_subject);

        edtSubject = findViewById(R.id.edt_subject);
        edtDuration = findViewById(R.id.edt_duration);
        btStartSession = findViewById(R.id.bt_start_session);
        btBackSubject = findViewById(R.id.bt_back_subject);



        btStartSession.setOnClickListener(v -> {

            String subject = edtSubject.getText().toString().trim();
            String durationText = edtDuration.getText().toString().trim();

            // Vérifier la matière
            if (subject.isEmpty()) {

                Toast.makeText(
                        SubjectActivity.this,
                        "Entre une matière",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Vérifier la durée
            if (durationText.isEmpty()) {

                Toast.makeText(
                        SubjectActivity.this,
                        "Entre une durée",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            int duration = Integer.parseInt(durationText);

            Bundle bundle = new Bundle();

            bundle.putString("subject", subject);
            bundle.putInt("duration", duration);


            Intent intent = new Intent(
                    SubjectActivity.this,
                    SessionActivity.class
            );

            // Ajouter le Bundle à l'Intent
            intent.putExtras(bundle);


            startActivity(intent);
        });
        btBackSubject.setOnClickListener(v -> {
            finish();
        });
    }
}