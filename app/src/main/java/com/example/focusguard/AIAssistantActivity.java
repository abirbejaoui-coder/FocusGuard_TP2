package com.example.focusguard;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AIAssistantActivity extends AppCompatActivity {

    private EditText edtAiQuestion;
    private Button btAskAi;
    private TextView txtAiMessage;
    private Button btBackAi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_aiassistant);

        edtAiQuestion = findViewById(R.id.edt_ai_question);
        btAskAi = findViewById(R.id.bt_ask_ai);
        txtAiMessage = findViewById(R.id.txt_ai_message);

        btAskAi.setOnClickListener(v -> {

            String question = edtAiQuestion.getText().toString().trim();

            if (question.isEmpty()) {

                Toast.makeText(
                        AIAssistantActivity.this,
                        "Écris une question d'abord",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                txtAiMessage.setText(
                        "Question reçue : " + question
                );

            }
        });
        btBackAi = findViewById(R.id.bt_back_ai);

        btBackAi.setOnClickListener(v -> {
            finish();
        });
    }
}