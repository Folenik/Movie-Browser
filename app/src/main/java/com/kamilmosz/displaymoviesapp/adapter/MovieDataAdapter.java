package com.kamilmosz.displaymoviesapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kamilmosz.displaymoviesapp.R;
import com.kamilmosz.displaymoviesapp.databinding.MovieLayoutBinding;
import com.kamilmosz.displaymoviesapp.model.Movie;

import java.util.ArrayList;

public class MovieDataAdapter extends RecyclerView.Adapter<MovieDataAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies;

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieLayoutBinding movieLayoutBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.movie_layout, parent, false);
        return new MovieViewHolder(movieLayoutBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovie = movies.get(position);
        holder.movieLayoutBinding.setMovie(currentMovie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovieList(ArrayList<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieLayoutBinding movieLayoutBinding;

        public MovieViewHolder(@NonNull MovieLayoutBinding movietLayoutBinding) {
            super(movietLayoutBinding.getRoot());
            this.movieLayoutBinding = movietLayoutBinding;
        }

    }
}
