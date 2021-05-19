package com.example.a3_dz1.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a3_dz1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_cards);
        EmojiAdapter emojiAdapter = new EmojiAdapter(new EmojiGame(this));
        recyclerView.setAdapter(emojiAdapter);
    }
}