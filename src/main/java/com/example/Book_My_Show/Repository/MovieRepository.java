package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findByMovieName(String movieName);
}
