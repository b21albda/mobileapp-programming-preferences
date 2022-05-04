package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myPreferenceRef = getSharedPreferences("Main", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        Button btn = findViewById(R.id.btn_save);

        btn.setOnClickListener(View -> {
            EditText input = findViewById(R.id.input);

            myPreferenceEditor.putString("INPUT", input.getText().toString());
            myPreferenceEditor.apply();

            finish();
        });
    }
}