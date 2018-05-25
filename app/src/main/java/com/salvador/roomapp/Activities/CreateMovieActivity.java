package com.salvador.roomapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.salvador.roomapp.Classes.AppDatabase;
import com.salvador.roomapp.Classes.Movie;
import com.salvador.roomapp.R;

import java.util.List;

public class CreateMovieActivity extends AppCompatActivity {

    EditText name, studio, category;
    Button btn;
    List<Movie> movies;
    String sname,sstudio,cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        btn = findViewById(R.id.btn_add_movie);
        name = findViewById(R.id.edit_text_name);
        studio = findViewById(R.id.edit_text_studio);
        category = findViewById(R.id.edit_text_category);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname = name.getText().toString();
                sstudio = studio.getText().toString();
                cat = category.getText().toString();
                AppDatabase db = AppDatabase.getAppDatabase(getApplicationContext());
                db.moviesDAO().insertMovie(new Movie(sname,sstudio,cat));
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
