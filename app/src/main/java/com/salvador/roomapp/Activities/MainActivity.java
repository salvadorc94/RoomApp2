package com.salvador.roomapp.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.salvador.roomapp.Adapter.MoviesAdapter;
import com.salvador.roomapp.Classes.AppDatabase;
import com.salvador.roomapp.Classes.Movie;
import com.salvador.roomapp.R;
import com.salvador.roomapp.Threads.Thread;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    MoviesAdapter adapter;
    List<Movie> movies;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recycle_view);
        adapter = new MoviesAdapter(movies);
        rv.setLayoutManager(new LinearLayoutManager(this));

        AppDatabase db=AppDatabase.getAppDatabase(getApplicationContext());
        movies = db.moviesDAO().getAll();

        new Thread(movies,rv,adapter,db).execute();
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CreateMovieActivity.class));
            }
        });


    }
}
