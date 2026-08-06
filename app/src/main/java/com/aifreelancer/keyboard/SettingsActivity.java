package com.aifreelancer.keyboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private EditText etApiKey;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        etApiKey = findViewById(R.id.etApiKey);
        btnSave = findViewById(R.id.btnSave);

        SharedPreferences prefs = getSharedPreferences("KeyboardPrefs", MODE_PRIVATE);
        etApiKey.setText(prefs.getString("api_key", ""));

        btnSave.setOnClickListener(v -> {
            String apiKey = etApiKey.getText().toString().trim();
            prefs.edit().putString("api_key", apiKey).apply();
            Toast.makeText(this, "API Key Saved Successfully!", Toast.LENGTH_SHORT).show();
        });
    }
}
