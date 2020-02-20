package com.kamilmosz.displaymoviesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kamilmosz.displaymoviesapp.R;
import com.kamilmosz.displaymoviesapp.databinding.MovieListItemBinding;
import com.kamilmosz.displaymoviesapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDataAdapter extends RecyclerView.Adapter<MovieDataAdapter.MovieViewHolder> {

    private ArrayList<Movie> movies;
    private ArrayList<Movie> filteredMovies = new ArrayList<>();
    public int expandedPosition = -1;

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemBinding movieListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.movie_list_item, parent, false);
        return new MovieViewHolder(movieListItemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {
        final boolean isExpanded = position == expandedPosition;
        holder.movieListItemBinding.movieDescription.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandedPosition = isExpanded ? -1 : position;
                notifyItemChanged(position);
            }
        });

        holder.movieListItemBinding.movieFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (holder.movieListItemBinding.getMovie().getFavourite() == false) {
                        holder.movieListItemBinding.getMovie().setFavourite(true);
                        holder.movieListItemBinding.movieFavourite.setImageResource(R.drawable.ic_favorite_24dp);
                    } else if (holder.movieListItemBinding.getMovie().getFavourite() == true) {
                        holder.movieListItemBinding.getMovie().setFavourite(false);
                        holder.movieListItemBinding.movieFavourite.setImageResource(R.drawable.ic_favorite_border_24dp);
                    }
            }
        });

        Movie currentMovie = filteredMovies.get(position);
        holder.movieListItemBinding.setMovie(currentMovie);
    }

    @Override
    public int getItemCount() {
        if (filteredMovies != null) {
            return filteredMovies.size();
        } else {
            return 0;
        }
    }

    public void setMovieList(ArrayList<Movie> movies) {
        this.movies = movies;
        filteredMovies.addAll(movies);
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private MovieListItemBinding movieListItemBinding;

        public MovieViewHolder(@NonNull MovieListItemBinding movietListItemBinding) {
            super(movietListItemBinding.getRoot());
            this.movieListItemBinding = movietListItemBinding;
        }

    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                List<Movie> filteredList = new ArrayList<>();
                if (charString.isEmpty()) {
                    filteredList = movies;
                } else {
                    for (Movie movie : movies) {

                        if (movie.getMovieTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(movie);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredMovies = (ArrayList<Movie>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


}
