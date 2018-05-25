package com.salvador.roomapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salvador.roomapp.Classes.Movie;
import com.salvador.roomapp.R;

import java.util.List;

/**
 * Created by UCA on 23/05/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>{
    private List<Movie> movie;

    public MoviesAdapter(List<Movie> movie) {
        this.movie = movie;
    }

    public static class MoviesViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView studio;
        TextView category;

        public MoviesViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            studio = itemView.findViewById(R.id.txt_studio);
            category = itemView.findViewById(R.id.txt_category);


        }

    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return (new MoviesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        holder.name.setText(movie.get(position).getNomMovie());
        holder.studio.setText(movie.get(position).getNomEstudio());
        holder.category.setText(movie.get(position).getNomCategory());
    }

    @Override
    public int getItemCount() {
        return movie.size();
    }
}
