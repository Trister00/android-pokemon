package com.example.tppokemon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tppokemon.R;

import java.util.ArrayList;

public class PokemonEvolutionsAdapter extends RecyclerView.Adapter<PokemonEvolutionsAdapter.ViewHolder> {

    private ArrayList<String> evolutionUrls = new ArrayList<>();
    private Context mContext;
    private ItemClickListener listner;

    public PokemonEvolutionsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_evolution_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).load(evolutionUrls.get(position).toString())
                .into(holder.evolutionImage);

    }

    @Override
    public int getItemCount() {
        return evolutionUrls.size();
    }

    public void setEvolutionUrls(ArrayList<String> imageUrls){
        this.evolutionUrls = imageUrls;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView evolutionImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            evolutionImage = itemView.findViewById(R.id.evolution_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(listner != null) listner.onItemClick(v,getAdapterPosition());
        }
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
