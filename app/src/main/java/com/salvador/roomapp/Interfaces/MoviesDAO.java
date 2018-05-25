package com.salvador.roomapp.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.salvador.roomapp.Classes.Movie;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by UCA on 23/05/2018.
 */


@Dao
public interface MoviesDAO {

    @Query("SELECT * FROM MOVIE")
    List<Movie> getAll();

    @Insert(onConflict = REPLACE)
    void insertMovie(Movie movie);
}
