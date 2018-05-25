package com.salvador.roomapp.Threads;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.salvador.roomapp.Adapter.MoviesAdapter;
import com.salvador.roomapp.Classes.AppDatabase;
import com.salvador.roomapp.Classes.Movie;

import java.util.List;

/**
 * Created by UCA on 23/05/2018.
 */

public class Thread extends AsyncTask {
    private List<Movie> movies;
    private RecyclerView rv;
    private MoviesAdapter adapter;
    private AppDatabase db;

    public Thread(List<Movie> movies, RecyclerView rv, MoviesAdapter adapter, AppDatabase db) {
        this.movies = movies;
        this.rv = rv;
        this.adapter = adapter;
        this.db = db;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        addMovie(movies);
        adapter = new MoviesAdapter(movies);
        rv.setAdapter(adapter);
        return null;
    }

    private void addMovie(List<Movie> movies) {
        movies.add(new Movie("Star Wars","Sci-fi", "LucasFilm"));
        movies.add(new Movie("Mama Mia","Drama", "IDR"));
    }
}
