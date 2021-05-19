package com.example.a3_dz1.domain;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();

    private boolean isGameOver = false;

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public Game(List<CardContent> cardContents) {
        for (int i = 0; i < cardContents.size(); i++) {
            cards.add(new Card<>(i * 2 + 1, false, false, cardContents.get(i)));
            cards.add(new Card<>((i * 2), false, false, cardContents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void cardClick(Card<CardContent> card) {
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()) {
            checkPairs(card);
        }
        gameOver();
    }

    private void gameOver() {
        if (cards.isEmpty()) {
            setGameOver(true);
        }
    }

    private void checkPairs(Card<CardContent> card) {
        for (Card<CardContent> anotherCard : cards) {
            if (card.isFaceUp() && anotherCard.isFaceUp()) {
                if (card.getContent().equals(anotherCard.getContent())
                        && card.getId() != anotherCard.getId()) {
                    card.setMatched(true);
                    anotherCard.setMatched(true);
                    Log.d("tag", "MATCH!");
                } else if (!card.equals(anotherCard)) {
                    card.setFaceUp(false);
                    anotherCard.setFaceUp(false);
                    Log.d("tag", "NOT MATCH!");
                }
            }
        }
        remove();
    }

    private void remove() {
        List<Card<CardContent>> resultCards = new ArrayList<>(cards);
        for (Card<CardContent> c : cards) {
            if (c.isMatched()) {
                resultCards.remove(c);
            }
        }
        cards.clear();
        cards.addAll(resultCards);
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }
}
