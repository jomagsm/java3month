package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + emailTV.getText()));
        intent.setData(Uri.parse("mailto:" + emailTV.getText()));
        intent.putExtra(Intent.EXTRA_SUBJECT, themeTV.getText());
        intent.putExtra(Intent.EXTRA_TEXT, textTV.getText());
        startActivity(Intent.createChooser(intent, "Choose email"));
    }
}