package com.ricardooandree.movie_review_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ricardooandree.movie_review_api.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Transactional(readOnly = true)
    User findByUsername(String username);

}
