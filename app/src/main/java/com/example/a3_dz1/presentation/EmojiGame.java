package com.example.a3_dz1.presentation;

import android.app.AlertDialog;
import android.content.Context;

import com.example.a3_dz1.R;
import com.example.a3_dz1.domain.Card;
import com.example.a3_dz1.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiGame {

    private final Game<String> game;
    private final Context context;

    public EmojiGame(Context context) {
        this.context = context;
        List<String> cardContent = new ArrayList<>();
        cardContent.add("\uD83C\uDF83");
        cardContent.add("\uD83D\uDC79");
        cardContent.add("\uD83D\uDC7B");
        game = new Game<String>(cardContent);
    }

    public void cardClick(Card<String> card) {
        game.cardClick(card);
        gameOver();
    }

    public void gameOver() {
        if (game.isGameOver()) {
            message();
        }
    }

    private void message() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.message).show();
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}
