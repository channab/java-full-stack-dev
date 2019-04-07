package com.javafullstackdev.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javafullstackdev.demo.entity.User;

@Repository
public interface UserReposiotry extends JpaRepository<User, Long>{

}
