package com.ricardooandree.movie_review_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ricardooandree.movie_review_api.models.Review;
import java.util.List;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

    @Transactional(readOnly = true)
    Review findByMovie(String movie);

    @Transactional(readOnly = true)
    List<Review> findByScore(int score);

    @Transactional(readOnly = true)
    List<Review> findByUser_Id(Long userId);
    
}
