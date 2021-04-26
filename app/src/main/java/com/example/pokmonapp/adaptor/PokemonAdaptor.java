package com.example.pokmonapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokmonapp.R;
import com.example.pokmonapp.model.Pokemon;

import java.util.ArrayList;

public class PokemonAdaptor extends RecyclerView.Adapter<PokemonAdaptor.ViewHolder> {
    private Context mContext;
    private ArrayList<Pokemon> arrayList = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pokemonImage);
            textView = itemView.findViewById(R.id.pokemonName);

        }
    }

    public Pokemon getPokemonAt(int position) {
        return arrayList.get(position);
    }

    public PokemonAdaptor(Context mContext) {
        this.mContext = mContext;
    }

    public void setList(ArrayList<Pokemon> mList) {
        this.arrayList = mList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        ViewHolder ViewHolder = new ViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Pokemon pokemon = arrayList.get(position);
        holder.textView.setText(pokemon.getName());
        Glide.with(mContext).load(pokemon.getUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}