package com.example.tppokemon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.bumptech.glide.Glide;
import com.example.tppokemon.R;
import com.example.tppokemon.model.Pokemon;


import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private ArrayList<Pokemon> mList = new ArrayList<>();
    private Context mContext;
    private RecyclerViewClickListner listner;

    public PokemonAdapter(Context mContext, RecyclerViewClickListner listner) {
        this.mContext = mContext;
        this.listner = listner;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.pokemonName.setText(mList.get(position).getName());

        Glide.with(mContext).load(mList.get(position).getUrl())
                .into(holder.pokemonImage);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(ArrayList<Pokemon> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    public Pokemon getPokemonAt(int position){
        return mList.get(position);
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView pokemonImage;
        private TextView pokemonName;
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonImage = itemView.findViewById(R.id.pokemon_image);
            pokemonName = itemView.findViewById(R.id.pokemon_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listner.onClick(v, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListner {
        void onClick(View v, int position);
    }
}
