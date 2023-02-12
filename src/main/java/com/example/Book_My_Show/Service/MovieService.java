package com.example.Book_My_Show.Service;

import com.example.Book_My_Show.Model.Movie;
import com.example.Book_My_Show.Repository.MovieRepository;
import com.example.Book_My_Show.RequestDto.MovieRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public String addMovie(MovieRequestDto movieRequestDto) {

        //convert dto to entity
        Movie movie = Movie.builder().name(movieRequestDto.getName()).
                duration(movieRequestDto.getDuration()).releaseDate(movieRequestDto.getReleaseDate()).build();

        movieRepository.save(movie);

        return "Movie added Successfully";

    }

    public Movie getMovieByName(String movieName) {

        return movieRepository.findByMovieName(movieName);
    }


}
