package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView contactTitle;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        contactTitle = itemView.findViewById(R.id.item_contact_title);
    }

    void bind(String contact) {
        contactTitle.setText(contact);
    }
}
