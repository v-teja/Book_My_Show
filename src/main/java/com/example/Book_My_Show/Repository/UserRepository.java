package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Model.Movie;
import com.example.Book_My_Show.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    Movie findByMovieName(String movieName);
}
