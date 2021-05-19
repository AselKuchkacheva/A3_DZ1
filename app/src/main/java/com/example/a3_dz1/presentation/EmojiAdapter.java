package com.example.a3_dz1.presentation;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_dz1.R;
import com.example.a3_dz1.domain.Card;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiVH> {

    private final EmojiGame emojiGame;

    public EmojiAdapter(EmojiGame emojiGame) {
        this.emojiGame = emojiGame;
    }

    @NonNull
    @Override
    public EmojiAdapter.EmojiVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new EmojiVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiAdapter.EmojiVH holder, int position) {
        EmojiGame emojiGame = this.emojiGame;
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    public class EmojiVH extends RecyclerView.ViewHolder {

        private final TextView cardTv;

        public EmojiVH(@NonNull View itemView) {
            super(itemView);
            cardTv = itemView.findViewById(R.id.tv_item_card);
        }

        public void onBind(Card<String> card) {

            if (card.isFaceUp()) {
                cardTv.setText(card.getContent());
                cardTv.setBackgroundColor(Color.WHITE);
            } else {
                cardTv.setText("");
                cardTv.setBackgroundColor(Color.MAGENTA);
            }

            cardTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emojiGame.cardClick(card);
                    notifyDataSetChanged();
                }
            });
        }

    }
}
