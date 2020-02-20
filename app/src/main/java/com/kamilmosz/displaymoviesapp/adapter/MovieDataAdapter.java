package com.kamilmosz.displaymoviesapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kamilmosz.displaymoviesapp.R;
import com.kamilmosz.displaymoviesapp.databinding.MovieListItemBinding;
import com.kamilmosz.displaymoviesapp.model.Movie;

import java.util.ArrayList;

public class MovieDataAdapter extends RecyclerView.Adapter<MovieDataAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies;

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding movieListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.movie_list_item, parent, false);
        return new MovieViewHolder(movieListItemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovie = movies.get(position);
        holder.movieListItemBinding.setMovie(currentMovie);

    }

    @Override
    public int getItemCount() {
        if(movies != null) {
            return movies.size();
        }
        else {
            return 0;
        }
    }

    public void setMovieList(ArrayList<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieListItemBinding movieListItemBinding;

        public MovieViewHolder(@NonNull MovieListItemBinding movietListItemBinding) {
            super(movietListItemBinding.getRoot());
            this.movieListItemBinding = movietListItemBinding;
        }

    }
}
