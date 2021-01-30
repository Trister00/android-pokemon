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
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tppokemon.DataTransfer;
import com.example.tppokemon.R;
import com.example.tppokemon.model.Generation;

import java.util.ArrayList;

public class GenerationAdapter extends RecyclerView.Adapter<GenerationAdapter.ViewHolder> {

    public ArrayList<Generation> generationballs = new ArrayList<Generation>();
    public Context context;
    public DataTransfer datatransfer;
    public GenerationAdapter (DataTransfer datatransfer, Context context){
        this.context = context;
        this.datatransfer = datatransfer;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.generationballs, parent,false);

        return new ViewHolder(contactView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Generation generationBall = this.generationballs.get(position);
        Glide.with(context).load("https://pngimg.com/uploads/pokeball/pokeball_PNG21.png").centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ball);
        holder.nom.setText(generationBall.getName());
        holder.ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positionButton = holder.getAdapterPosition();
                int offset = getOffsetAndLimit(generationballs.get(positionButton).getName())[0];
                int limit = getOffsetAndLimit(generationballs.get(positionButton).getName())[1];
                datatransfer.onSetValues(offset,limit);

            }
        });

    }

    @Override
    public int getItemCount() {
        return generationballs.size();
    }

    public void setGenerationballs(ArrayList<Generation> list){
        this.generationballs = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ball ;
        TextView nom;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ball = (ImageView) itemView.findViewById(R.id.picture);
            nom = (TextView) itemView.findViewById(R.id.nom);

        }
    }


    private int[] getOffsetAndLimit(String name){
        switch(name) {
            case "Gen 1": return new int[]{0, 151};
            case "Gen 2" : return new int[]{151, 100};
            case "Gen 3" : return  new int[]{251, 135};
            case "Gen 4" : return  new int[]{386, 107};
            case "Gen 5" : return new int[]{493, 156};
            case "Gen 6" : return new int[]{649, 72};
            case "Gen 7" : return  new int[]{721, 86};
            case "Gen 8" : return new int[]{807, 90};
            default: return null;
        }
    }
}
