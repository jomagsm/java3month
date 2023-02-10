package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView emailTV, themeTV, textTV;
    private View sentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listenerInit();
    }

    private void init() {
        emailTV = findViewById(R.id.editTextEmail);
        themeTV = findViewById(R.id.editTextTheme);
        textTV = findViewById(R.id.editTextText);
        sentBtn = findViewById(R.id.sentBtn);
    }

    private void listenerInit() {
        sentBtn.setOnClickListener(v -> sentEmail());
    }

    private void sentEmail() {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTV.getText().toString()});
        email.putExtra(Intent.EXTRA_SUBJECT, themeTV.getText().toString());
        email.putExtra(Intent.EXTRA_TEXT, textTV.getText().toString());
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}