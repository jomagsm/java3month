package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> contactList;
    private ContactAdapter adapter;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_contacts);
        loadData();
        adapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(adapter);

    }

    private void loadData() {
        contactList = new ArrayList<String>();
        contactList.add("Beka");
        contactList.add("Jeka");
        contactList.add("Tegran");
        contactList.add("Viktoriya");
        contactList.add("Oroz");
        contactList.add("Koroz");
        contactList.add("Altinay");
    }
}